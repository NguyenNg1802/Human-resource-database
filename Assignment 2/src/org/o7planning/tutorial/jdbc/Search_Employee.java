package org.o7planning.tutorial.jdbc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.border.EmptyBorder;
import javax.swing.table.*;

import java.awt.Color;
import java.awt.ScrollPane;
import java.awt.Scrollbar;

import javax.swing.JList;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Search_Employee extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search_Employee frame = new Search_Employee();
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
	public Search_Employee() throws ClassNotFoundException, SQLException {
		final Connection connection = ConnectionUtils.getMyConnection();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 584, 222);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"employee_id", "first_name", "last_name", "email", "phone_number", "hire_date", "job_id", "salary", "commision_pct", "manager_id", "department_id"}));
		comboBox.setBounds(138, 118, 125, 20);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String selection = (String)comboBox.getSelectedItem();
				String sql = "select *from employees where '"+selection+"'=? ";
				try {
					PreparedStatement pst = connection.prepareStatement(sql);
					pst.setString(1,textField.getText());
					ResultSet rs = pst.executeQuery();
			
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
			}
			@Override
			public void keyPressed(KeyEvent arg0) {
				String selection = (String)comboBox.getSelectedItem();
				String sql = "select *from where '"+selection+"'=? ";
				try {
					PreparedStatement pst = connection.prepareStatement(sql);
					pst.setString(1,textField.getText());
					ResultSet rs = pst.executeQuery();
			
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		textField.setBounds(292, 118, 140, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblSearchInEmployee = new JLabel("Search in Employee table");
		lblSearchInEmployee.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSearchInEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchInEmployee.setBounds(177, 11, 208, 35);
		contentPane.add(lblSearchInEmployee);
	}

}
