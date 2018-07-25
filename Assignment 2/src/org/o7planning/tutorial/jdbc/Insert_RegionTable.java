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



public class Insert_RegionTable extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insert_RegionTable frame = new Insert_RegionTable();
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
	public Insert_RegionTable() throws ClassNotFoundException, SQLException {
		final Connection connection = ConnectionUtils.getMyConnection();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 755, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInsertInRegionTable = new JLabel("Insert in Region table");
		lblInsertInRegionTable.setBounds(252, 11, 219, 45);
		lblInsertInRegionTable.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblInsertInRegionTable.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblInsertInRegionTable);
		
		JLabel lblNewLabel = new JLabel("Region ID");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(80, 149, 83, 20);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(173, 149, 138, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblRegionName = new JLabel("Region Name");
		lblRegionName.setBounds(345, 149, 96, 20);
		lblRegionName.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblRegionName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(451, 149, 138, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSave = new JButton("Insert");
		btnSave.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				try {
				     
					  //Statement statement = connection.createStatement();

				      String sql = "insert into regions (region_id, region_name) values (?,?)";
				      PreparedStatement pst = connection.prepareStatement(sql);
				      
				      pst.setString(1,textField.getText());
				      pst.setString(2,textField_1.getText());
				     
				      
				      if ( textField.getText().isEmpty() ) {
				    	  JOptionPane.showMessageDialog(null, "Error! Region ID can't be NULL");
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
	}
}
