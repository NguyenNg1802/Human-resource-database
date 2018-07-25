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



public class Update_LocationTable extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update_LocationTable frame = new Update_LocationTable();
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
	public Update_LocationTable() throws ClassNotFoundException, SQLException {
		final Connection connection = ConnectionUtils.getMyConnection();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 755, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUpdateInLocationTable = new JLabel("Update in Location table");
		lblUpdateInLocationTable.setBounds(252, 11, 219, 45);
		lblUpdateInLocationTable.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUpdateInLocationTable.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblUpdateInLocationTable);
		
		JLabel lblNewLabel = new JLabel("Location ID");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(80, 149, 83, 20);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(173, 149, 138, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblStreetAddress = new JLabel("Street Address");
		lblStreetAddress.setBounds(345, 149, 96, 20);
		lblStreetAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblStreetAddress);
		
		textField_1 = new JTextField();
		textField_1.setBounds(451, 149, 138, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSave = new JButton("Update");
		btnSave.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				try {
				     
					  //Statement statement = connection.createStatement();

					  String sql = "Update locations set street_address=?,postal_code=?,city=?,state_province=?,country_id=?"+"where location_id=?";
				      PreparedStatement pst = connection.prepareStatement(sql);
				      
				      pst.setString(6,textField.getText());
				      pst.setString(1,textField_1.getText());
				      pst.setString(2,textField_2.getText());
				      pst.setString(3,textField_3.getText());
				      pst.setString(4,textField_4.getText());
				      pst.setString(5,textField_5.getText());
				      
				      if ( textField.getText().isEmpty() ) {
				    	  JOptionPane.showMessageDialog(null, "Error! Location ID can't be NULL");
				      }
				      
				      if ( textField_3.getText().isEmpty() ) {
				    	  JOptionPane.showMessageDialog(null, "Error! City can't be NULL");
				      }
				      
				      pst.executeUpdate();
				      JOptionPane.showMessageDialog(null, "Data updated");
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
		
		JLabel lblPostalCode = new JLabel("Postal Code");
		lblPostalCode.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPostalCode.setBounds(102, 222, 61, 14);
		contentPane.add(lblPostalCode);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCity.setBounds(380, 222, 61, 14);
		contentPane.add(lblCity);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(451, 219, 138, 20);
		contentPane.add(textField_3);
		
		JLabel lblStateProvince = new JLabel("State Province");
		lblStateProvince.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStateProvince.setBounds(80, 290, 83, 20);
		contentPane.add(lblStateProvince);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(173, 290, 138, 20);
		contentPane.add(textField_4);
		
		JLabel lblCountryId = new JLabel("Country ID");
		lblCountryId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCountryId.setBounds(358, 293, 83, 20);
		contentPane.add(lblCountryId);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(451, 290, 138, 20);
		contentPane.add(textField_5);
	}
}
