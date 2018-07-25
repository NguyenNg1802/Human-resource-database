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



public class Insert_JobTable extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insert_JobTable frame = new Insert_JobTable();
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
	public Insert_JobTable() throws ClassNotFoundException, SQLException {
		final Connection connection = ConnectionUtils.getMyConnection();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 755, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInsertInJobTable = new JLabel("Insert in Job table");
		lblInsertInJobTable.setBounds(252, 11, 219, 45);
		lblInsertInJobTable.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblInsertInJobTable.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblInsertInJobTable);
		
		JLabel lblNewLabel = new JLabel("Job ID");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(80, 149, 83, 20);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(173, 149, 138, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblJobTitle = new JLabel("Job Title");
		lblJobTitle.setBounds(345, 149, 96, 20);
		lblJobTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblJobTitle);
		
		textField_1 = new JTextField();
		textField_1.setBounds(451, 149, 138, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSave = new JButton("Insert");
		btnSave.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				try {
				     
					  //Statement statement = connection.createStatement();

				      String sql = "insert into jobs (job_id, job_title, min_salary, max_salary) values (?,?,?,?)";
				      PreparedStatement pst = connection.prepareStatement(sql);
				      
				      pst.setString(1,textField.getText());
				      pst.setString(2,textField_1.getText());
				      pst.setString(3,textField_2.getText());
				      pst.setString(4,textField_3.getText());

				      if ( textField.getText().isEmpty() ) {
				    	  JOptionPane.showMessageDialog(null, "Error! Job ID can't be NULL");
				      }
				      
				      if ( textField_1.getText().isEmpty() ) {
				    	  JOptionPane.showMessageDialog(null, "Error! Job title can't be NULL");
				      }
				      
				      pst.executeUpdate();
				      JOptionPane.showMessageDialog(null, "Data inserted");
				      pst.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnSave.setBounds(301, 359, 121, 23);
		contentPane.add(btnSave);
		
		textField_2 = new JTextField();
		textField_2.setBounds(173, 219, 138, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblMinSalary = new JLabel("Min Salary");
		lblMinSalary.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMinSalary.setBounds(102, 222, 61, 14);
		contentPane.add(lblMinSalary);
		
		JLabel lblMaxSalary = new JLabel("Max Salary");
		lblMaxSalary.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaxSalary.setBounds(380, 222, 61, 14);
		contentPane.add(lblMaxSalary);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(451, 219, 138, 20);
		contentPane.add(textField_3);
	}
}
