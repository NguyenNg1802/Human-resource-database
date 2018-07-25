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



public class Update_CountryTable extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update_CountryTable frame = new Update_CountryTable();
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
	public Update_CountryTable() throws ClassNotFoundException, SQLException {
		final Connection connection = ConnectionUtils.getMyConnection();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 755, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUpdateInCountryTable = new JLabel("Update in Country table");
		lblUpdateInCountryTable.setBounds(252, 11, 219, 45);
		lblUpdateInCountryTable.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUpdateInCountryTable.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblUpdateInCountryTable);
		
		JLabel lblNewLabel = new JLabel("Country ID");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(80, 149, 83, 20);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(173, 149, 138, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCountryName = new JLabel("Country Name");
		lblCountryName.setBounds(345, 149, 96, 20);
		lblCountryName.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblCountryName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(451, 149, 138, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSave = new JButton("Update");
		btnSave.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				try {
				     
					  //Statement statement = connection.createStatement();

					  String sql = "Update countries set country_name=?,region_id=?"+"where country_id=?";
				      PreparedStatement pst = connection.prepareStatement(sql);
				      
				      pst.setString(3,textField.getText());
				      pst.setString(1,textField_1.getText());
				      pst.setString(2,textField_2.getText());
				      
				      if ( textField.getText().isEmpty() ) {
				    	  JOptionPane.showMessageDialog(null, "Error! Country ID can't be NULL");
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
		textField_2.setBounds(173, 216, 138, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblRegionId = new JLabel("Region ID");
		lblRegionId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRegionId.setBounds(102, 219, 61, 14);
		contentPane.add(lblRegionId);
	}
}
