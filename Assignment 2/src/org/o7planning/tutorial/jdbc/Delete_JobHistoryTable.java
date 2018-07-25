package org.o7planning.tutorial.jdbc;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JTextField;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.table.*;

import java.awt.Color;


public class Delete_JobHistoryTable extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete_JobHistoryTable frame = new Delete_JobHistoryTable();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Delete_JobHistoryTable() throws ClassNotFoundException, SQLException {
		final Connection connection = ConnectionUtils.getMyConnection();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 614, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDeleteATuple = new JLabel("Delete a tuple in Job History Table");
		lblDeleteATuple.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDeleteATuple.setBounds(92, 11, 424, 22);
		lblDeleteATuple.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblDeleteATuple);
		
		JLabel lblJobID = new JLabel("Employee ID");
		lblJobID.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJobID.setBounds(150, 181, 97, 20);
		contentPane.add(lblJobID);
		
		textField = new JTextField();
		textField.setBounds(257, 181, 153, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				     
					  //Statement statement = connection.createStatement();
					  
					  String sql = "delete job_history where employee_id=?";
					  PreparedStatement pst = connection.prepareStatement(sql);
				      
					  pst.setString(1, textField.getText());
					  
				      pst.executeUpdate();
				      JOptionPane.showMessageDialog(null, "Tuple deleted");
				      pst.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnDelete.setBounds(257, 325, 89, 23);
		contentPane.add(btnDelete);
	}
}
