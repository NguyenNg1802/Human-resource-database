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



public class Insert_EmployeeTable extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblNewLabel_1;
	private JTextField textField_4;
	private JLabel lblHireDate;
	private JTextField textField_5;
	private JLabel lblJobId;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JLabel lblNewLabel_2;
	private JLabel lblCommissionPct;
	private JLabel lblManagerId;
	private JLabel lblDepartmentId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insert_EmployeeTable frame = new Insert_EmployeeTable();
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
	public Insert_EmployeeTable() throws ClassNotFoundException, SQLException {
		final Connection connection = ConnectionUtils.getMyConnection();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 755, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInsertInEmployee = new JLabel("Insert in Employee table");
		lblInsertInEmployee.setBounds(257, 11, 200, 45);
		lblInsertInEmployee.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblInsertInEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblInsertInEmployee);
		
		JLabel lblNewLabel = new JLabel("Employee ID");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(5, 85, 83, 20);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(98, 85, 138, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(5, 149, 83, 20);
		lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblFirstName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(98, 149, 138, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(5, 221, 83, 14);
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblLastName);
		
		textField_2 = new JTextField();
		textField_2.setBounds(98, 218, 138, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(5, 283, 83, 20);
		contentPane.add(lblEmail);
		
		textField_3 = new JTextField();
		textField_3.setBounds(98, 283, 138, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Phone Number");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(257, 286, 78, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(345, 283, 138, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		lblHireDate = new JLabel("Hire Date");
		lblHireDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHireDate.setBounds(252, 85, 83, 20);
		contentPane.add(lblHireDate);
		
		textField_5 = new JTextField();
		textField_5.setBounds(345, 85, 138, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		lblJobId = new JLabel("Job ID");
		lblJobId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJobId.setBounds(252, 149, 83, 20);
		contentPane.add(lblJobId);
		
		textField_6 = new JTextField();
		textField_6.setBounds(345, 149, 138, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(591, 149, 138, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(345, 218, 138, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(591, 218, 138, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(591, 85, 138, 20);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Salary");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(498, 152, 83, 14);
		contentPane.add(lblNewLabel_2);
		
		lblCommissionPct = new JLabel("Commission PCT");
		lblCommissionPct.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCommissionPct.setBounds(252, 221, 83, 14);
		contentPane.add(lblCommissionPct);
		
		lblManagerId = new JLabel("Manager ID");
		lblManagerId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblManagerId.setBounds(498, 221, 83, 14);
		contentPane.add(lblManagerId);
		
		lblDepartmentId = new JLabel("Department ID");
		lblDepartmentId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDepartmentId.setBounds(498, 88, 83, 14);
		contentPane.add(lblDepartmentId);
		
		JButton btnSave = new JButton("Insert");
		btnSave.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				try {
				     
					  //Statement statement = connection.createStatement();

				      String sql = "insert into employees (employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id) values (?,?,?,?,?,?,?,?,?,?,?)";
				      PreparedStatement pst = connection.prepareStatement(sql);
				      
				      pst.setString(1,textField.getText());
				      pst.setString(2,textField_1.getText());
				      pst.setString(3,textField_2.getText());
				      pst.setString(4,textField_3.getText());
				      pst.setString(5,textField_4.getText());
				      pst.setDate(6, java.sql.Date.valueOf(textField_5.getText()));
				      pst.setString(7,textField_6.getText());
				      pst.setString(8,textField_7.getText());
				      pst.setString(9,textField_8.getText());
				      pst.setString(10,textField_9.getText());
				      pst.setString(11,textField_10.getText());
				      
				      
				      if ( textField.getText().isEmpty() ) {
				    	  JOptionPane.showMessageDialog(null, "Error! Employee ID can't be NULL");
				      }
				      if ( textField_2.getText().isEmpty() ) {
				    	  JOptionPane.showMessageDialog(null, "Error! Last Name can't be NULL");
				      }
				      if ( textField_3.getText().isEmpty() ) {
				    	  JOptionPane.showMessageDialog(null, "Error! Email can't be NULL");
				      }
				    
				      if ( textField_6.getText().isEmpty() ) {
				    	  JOptionPane.showMessageDialog(null, "Error! Job ID Employee ID can't be NULL");
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
		btnSave.setBounds(318, 359, 89, 23);
		contentPane.add(btnSave);
	}
}
