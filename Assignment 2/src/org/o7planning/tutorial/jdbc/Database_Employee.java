package org.o7planning.tutorial.jdbc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JOptionPane;

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

public class Database_Employee {

	private JFrame frame;
	public  JTable table;
	private JButton btnInsertATuple;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JLabel lblEmployeeTable;
	private JTextField textFieldSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Database_Employee window = new Database_Employee();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Database_Employee() throws ClassNotFoundException,
    SQLException {
		initialize() ;
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static DefaultTableModel buildTableModel(ResultSet rs)
	        throws SQLException {

	    ResultSetMetaData metaData = rs.getMetaData();

	    // names of columns
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 1; column <= columnCount; column++) {
	        columnNames.add(metaData.getColumnName(column));
	    }

	    // data of the table
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (rs.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	            vector.add(rs.getObject(columnIndex));
	        }
	        data.add(vector);
	    }

	    return new DefaultTableModel(data, columnNames);

	}
	
	
	private void initialize() throws  SQLException, ClassNotFoundException {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setForeground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 1350, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    final Connection connection = ConnectionUtils.getMyConnection();
		frame.getContentPane().setLayout(null);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 144, 1314, 228);
		frame.getContentPane().add(scrollPane_2);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_2.setViewportView(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		scrollPane.setToolTipText("");
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		Scrollbar scrollbar = new Scrollbar();
		scrollPane.setColumnHeaderView(scrollbar);
		
		final JComboBox comboBoxTable = new JComboBox();
		comboBoxTable.setModel(new DefaultComboBoxModel(new String[] {"Employees", "Departments", "Regions", "Countries", "Jobs", "Locations", "Job History"}));
		comboBoxTable.setBounds(41, 439, 138, 20);
		frame.getContentPane().add(comboBoxTable);
		
		final JComboBox comboBoxSearch = new JComboBox();
		comboBoxSearch.setModel(new DefaultComboBoxModel(new String[] {"employee_id (Employee)", "first_name(Employee)", "last_name(Employee)", "email(Employee)", "phone_number(Employee)", "hire_date(Employee)", "job_id(Employee)", "salary(Employee)", "commision_pct(Employee)", "manager_id(Employee)", "department_id(Employee)", "region_id(Regions)", "region_name(Regions)", "country_id(Country)", "country_name(Country)", "region_id(Country)", "job_id(Jobs)", "job_title(Jobs)", "min_salary(Jobs)", "max_salary(Jobs)", "location_id(Locations)", "street_address(Locations)", "postal_code(Locations)", "city(Locations)", "state_province(Locations)", "country_id(Locations)", "department_id(Departments)", "department_name(Departments)", "manager_id(Departments)", "location_id(Departments)", "employee_id(Job History)", "start_date(Job History)", "end_date(Job History)", "job_id(Job History)", "department_id(Job History)"}));
		comboBoxSearch.setBounds(898, 113, 213, 20);
		frame.getContentPane().add(comboBoxSearch);
		
		JButton btnNewButton = new JButton("Load");
		btnNewButton.setBounds(335, 438, 138, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				      String selection = (String)comboBoxTable.getSelectedItem();
				
				      
				      if ( selection.equals("Employees") ) {
				    	  Statement statement = connection.createStatement();

					      String sql = "Select * from employees";
					 
					      ResultSet rs = statement.executeQuery(sql);
					 
					      
					      table.setModel(buildTableModel(rs));
					      rs.close();
				      }
				      else if ( selection.equals("Departments") ) {
				    	  Statement statement = connection.createStatement();

					      String sql = "Select * from departments";
					 
					      ResultSet rs = statement.executeQuery(sql);
					 
					      
					      table.setModel(buildTableModel(rs));
					      rs.close();
				      }
				      else if ( selection.equals("Regions") ) {
				    	  Statement statement = connection.createStatement();

					      String sql = "Select * from regions";
					 
					      ResultSet rs = statement.executeQuery(sql);
					 
					      
					      table.setModel(buildTableModel(rs));
					      rs.close();
				      }
				      else if ( selection.equals("Countries") ) {
				    	  Statement statement = connection.createStatement();

					      String sql = "Select * from countries";
					 
					      ResultSet rs = statement.executeQuery(sql);
					 
					      
					      table.setModel(buildTableModel(rs));
					      rs.close();
				      }
				      else if ( selection.equals("Jobs") ) {
				    	  Statement statement = connection.createStatement();

					      String sql = "Select * from jobs";
					 
					      ResultSet rs = statement.executeQuery(sql);
					 
					      
					      table.setModel(buildTableModel(rs));
					      rs.close();
				      }
				      else if ( selection.equals("Job History") ) {
				    	  Statement statement = connection.createStatement();

					      String sql = "Select * from job_history";
					 
					      ResultSet rs = statement.executeQuery(sql);
					 
					      
					      table.setModel(buildTableModel(rs));
					      rs.close();
				      }
				      else if ( selection.equals("Locations") ) {
				    	  Statement statement = connection.createStatement();

					      String sql = "Select * from locations";
					 
					      ResultSet rs = statement.executeQuery(sql);
					 
					      
					      table.setModel(buildTableModel(rs));
					      rs.close();
				      }

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		btnInsertATuple = new JButton("Insert");						// INSERT
		btnInsertATuple.setBounds(614, 438, 138, 23);
		btnInsertATuple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				      String selection = (String)comboBoxTable.getSelectedItem();
				      
				      if ( selection.equals("Employees") ) {
				    	  Insert_EmployeeTable insert_employee = new Insert_EmployeeTable();
				    	  insert_employee.setVisible(true);
				      }
				      else if ( selection.equals("Departments") ) {
				    	  Insert_DepartmentTable insert_department = new Insert_DepartmentTable();
				    	  insert_department.setVisible(true);
				      }
				      else if ( selection.equals("Regions") ) {
				    	  Insert_RegionTable insert_region = new Insert_RegionTable();
				    	  insert_region.setVisible(true);
				      }
				      else if ( selection.equals("Countries") ) {
				    	  Insert_CountryTable insert_country = new Insert_CountryTable();
				    	  insert_country.setVisible(true);
				      }
				      else if ( selection.equals("Jobs") ) {
				    	  Insert_JobTable insert_job = new Insert_JobTable();
				    	  insert_job.setVisible(true);
				      }
				      else if ( selection.equals("Job History") ) {
				    	  Insert_JobHistoryTable insert_history = new Insert_JobHistoryTable();
				    	  insert_history.setVisible(true);
				      }
				      else if ( selection.equals("Locations") ) {
				    	  Insert_LocationTable insert_location = new Insert_LocationTable();
				    	  insert_location.setVisible(true);
				      }

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		});
		frame.getContentPane().add(btnInsertATuple);
		
		lblEmployeeTable = new JLabel("Choose of the table in the list");
		lblEmployeeTable.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmployeeTable.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployeeTable.setBounds(41, 404, 170, 23);
		frame.getContentPane().add(lblEmployeeTable);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			//UPDATE
				try {
				      String selection = (String)comboBoxTable.getSelectedItem();
				      
				      if ( selection.equals("Employees") ) {
				    	  Update_EmployeeTable update_employee = new Update_EmployeeTable();
				    	  update_employee.setVisible(true);
				      }
				      else if ( selection.equals("Departments") ) {
				    	  Update_DepartmentTable update_department = new Update_DepartmentTable();
				    	  update_department.setVisible(true);
				      }
				      else if ( selection.equals("Regions") ) {
				    	  Update_RegionTable update_region = new Update_RegionTable();
				    	  update_region.setVisible(true);
				      }
				      else if ( selection.equals("Countries") ) {
				    	  Update_CountryTable update_country = new Update_CountryTable();
				    	  update_country.setVisible(true);
				      }
				      else if ( selection.equals("Jobs") ) {
				    	  Update_JobTable update_job = new Update_JobTable();
				    	  update_job.setVisible(true);
				      }
				      else if ( selection.equals("Job History") ) {
				    	  Update_JobHistoryTable update_history = new Update_JobHistoryTable();
				    	  update_history.setVisible(true);
				      }
				      else if ( selection.equals("Locations") ) {
				    	  Update_LocationTable update_location = new Update_LocationTable();
				    	  update_location.setVisible(true);
				      }

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(876, 438, 138, 23);
		frame.getContentPane().add(btnUpdate);
		
		JLabel lblHumanResourceDatabase = new JLabel("HUMAN RESOURCE DATABASE");
		lblHumanResourceDatabase.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblHumanResourceDatabase.setHorizontalAlignment(SwingConstants.CENTER);
		lblHumanResourceDatabase.setBounds(383, 31, 533, 76);
		frame.getContentPane().add(lblHumanResourceDatabase);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				//DELETE
				try {
				      String selection = (String)comboBoxTable.getSelectedItem();
				      
				      if ( selection.equals("Employees") ) {
				    	  Delete_EmployeeTable delete_employee = new Delete_EmployeeTable();
				    	  delete_employee.setVisible(true);
				      }
				      else if ( selection.equals("Departments") ) {
				    	  Delete_DepartmentTable delete_department = new Delete_DepartmentTable();
				    	  delete_department.setVisible(true);
				      }
				      else if ( selection.equals("Regions") ) {
				    	  Delete_RegionTable delete_region = new Delete_RegionTable();
				    	  delete_region.setVisible(true);
				      }
				      else if ( selection.equals("Countries") ) {
				    	  Delete_CountryTable delete_country = new Delete_CountryTable();
				    	  delete_country.setVisible(true);
				      }
				      else if ( selection.equals("Jobs") ) {
				    	  Delete_JobTable delete_job = new Delete_JobTable();
				    	  delete_job.setVisible(true);
				      }
				      else if ( selection.equals("Job History") ) {
				    	  Delete_JobHistoryTable delete_history = new Delete_JobHistoryTable();
				    	  delete_history.setVisible(true);
				      }
				      else if ( selection.equals("Locations") ) {
				    	  Delete_LocationTable delete_location = new Delete_LocationTable();
				    	  delete_location.setVisible(true);
				      }

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(1148, 438, 138, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		textFieldSearch = new JTextField();
		textFieldSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {				//SEARCH
				try {
				      String selection = (String)comboBoxSearch.getSelectedItem();
				
				      
				      if ( selection.equals("employee_id (Employee)") ) {

					      String sql = "Select * from employees where employee_id = ?";
					      PreparedStatement pst = connection.prepareStatement(sql);
					      pst.setString(1,textFieldSearch.getText());
					      ResultSet rs = pst.executeQuery();
					      table.setModel(buildTableModel(rs));
					      pst.close();
				      }
				      else if ( selection.equals("first_name(Employee)") ) {
				    	  String sql = "Select * from employees where first_name = ?";
					      PreparedStatement pst = connection.prepareStatement(sql);
					      pst.setString(1,textFieldSearch.getText());
					      ResultSet rs = pst.executeQuery();
					      table.setModel(buildTableModel(rs));
					      pst.close();
				      }
				      else if ( selection.equals("last_name(Employee)") ) {
				    	  String sql = "Select * from employees where last_name = ?";
					      PreparedStatement pst = connection.prepareStatement(sql);
					      pst.setString(1,textFieldSearch.getText());
					      ResultSet rs = pst.executeQuery();
					      table.setModel(buildTableModel(rs));
					      pst.close();
				      }
				      else if ( selection.equals("email(Employee)") ) {
				    	  String sql = "Select * from employees where email = ?";
					      PreparedStatement pst = connection.prepareStatement(sql);
					      pst.setString(1,textFieldSearch.getText());
					      ResultSet rs = pst.executeQuery();
					      table.setModel(buildTableModel(rs));
					      pst.close();
				      }
				      else if ( selection.equals("phone_number(Employee)") ) {
				    	  String sql = "Select * from employees where phone_number = ?";
					      PreparedStatement pst = connection.prepareStatement(sql);
					      pst.setString(1,textFieldSearch.getText());
					      ResultSet rs = pst.executeQuery();
					      table.setModel(buildTableModel(rs));
					      pst.close();
				      }
				      else if ( selection.equals("hire_date(Employee)") ) {
				    	  String sql = "Select * from employees where hire_date = ?";
					      PreparedStatement pst = connection.prepareStatement(sql);
					      pst.setString(1,textFieldSearch.getText());
					      ResultSet rs = pst.executeQuery();
					      table.setModel(buildTableModel(rs));
					      pst.close();
				      }
				      else if ( selection.equals("job_id(Employee)") ) {
				    	  String sql = "Select * from employees where job_id = ?";
					      PreparedStatement pst = connection.prepareStatement(sql);
					      pst.setString(1,textFieldSearch.getText());
					      ResultSet rs = pst.executeQuery();
					      table.setModel(buildTableModel(rs));
					      pst.close();
				      }
				      else if ( selection.equals("salary(Employee)") ) {
				    	  String sql = "Select * from employees where salary = ?";
					      PreparedStatement pst = connection.prepareStatement(sql);
					      pst.setString(1,textFieldSearch.getText());
					      ResultSet rs = pst.executeQuery();
					      table.setModel(buildTableModel(rs));
					      pst.close();
				      }
				      else if ( selection.equals("commision_pct(Employee))") ) {
				    	  String sql = "Select * from employees where commision_pct = ?";
					      PreparedStatement pst = connection.prepareStatement(sql);
					      pst.setString(1,textFieldSearch.getText());
					      ResultSet rs = pst.executeQuery();
					      table.setModel(buildTableModel(rs));
					      pst.close();
				      }
				      else if ( selection.equals("manager_id(Employee)") ) {
				    	  String sql = "Select * from employees where manager_id = ?";
					      PreparedStatement pst = connection.prepareStatement(sql);
					      pst.setString(1,textFieldSearch.getText());
					      ResultSet rs = pst.executeQuery();
					      table.setModel(buildTableModel(rs));
					      pst.close();
				      }
				      else if ( selection.equals("department_id(Employee))") ) {
				    	  String sql = "Select * from employees where department_id = ?";
					      PreparedStatement pst = connection.prepareStatement(sql);
					      pst.setString(1,textFieldSearch.getText());
					      ResultSet rs = pst.executeQuery();
					      table.setModel(buildTableModel(rs));
					      pst.close();
				      }
				      else if ( selection.equals("region_id(Regions)") ) {
				    	  String sql = "Select * from regions where region_id = ?";
					      PreparedStatement pst = connection.prepareStatement(sql);
					      pst.setString(1,textFieldSearch.getText());
					      ResultSet rs = pst.executeQuery();
					      table.setModel(buildTableModel(rs));
					      pst.close();
				      }
				      else if ( selection.equals("region_name(Regions)") ) {
				    	  String sql = "Select * from regions where region_name = ?";
					      PreparedStatement pst = connection.prepareStatement(sql);
					      pst.setString(1,textFieldSearch.getText());
					      ResultSet rs = pst.executeQuery();
					      table.setModel(buildTableModel(rs));
					      pst.close();
				      }
				      else if ( selection.equals("country_id(Country)") ) {
				    	  String sql = "Select * from countries where country_id = ?";
					      PreparedStatement pst = connection.prepareStatement(sql);
					      pst.setString(1,textFieldSearch.getText());
					      ResultSet rs = pst.executeQuery();
					      table.setModel(buildTableModel(rs));
					      pst.close();
				      }
				      else if ( selection.equals("country_name(Country)") ) {
				    	  String sql = "Select * from countries where country_name = ?";
					      PreparedStatement pst = connection.prepareStatement(sql);
					      pst.setString(1,textFieldSearch.getText());
					      ResultSet rs = pst.executeQuery();
					      table.setModel(buildTableModel(rs));
					      pst.close();
				      }
				      else if ( selection.equals("region_id(Country)") ) {
				    	  String sql = "Select * from countries where region_id = ?";
					      PreparedStatement pst = connection.prepareStatement(sql);
					      pst.setString(1,textFieldSearch.getText());
					      ResultSet rs = pst.executeQuery();
					      table.setModel(buildTableModel(rs));
					      pst.close();
				      }
				      else if ( selection.equals("job_id(Jobs)") ) {
				    	  String sql = "Select * from jobs where job_id = ?";
					      PreparedStatement pst = connection.prepareStatement(sql);
					      pst.setString(1,textFieldSearch.getText());
					      ResultSet rs = pst.executeQuery();
					      table.setModel(buildTableModel(rs));
					      pst.close();
				      }
				      else if ( selection.equals("job_title(Jobs)") ) {
				    	  String sql = "Select * from jobs where job_title = ?";
					      PreparedStatement pst = connection.prepareStatement(sql);
					      pst.setString(1,textFieldSearch.getText());
					      ResultSet rs = pst.executeQuery();
					      table.setModel(buildTableModel(rs));
					      pst.close();
				      }
				      else if ( selection.equals("min_salary(Jobs)") ) {
				    	  String sql = "Select * from jobs where min_salary = ?";
					      PreparedStatement pst = connection.prepareStatement(sql);
					      pst.setString(1,textFieldSearch.getText());
					      ResultSet rs = pst.executeQuery();
					      table.setModel(buildTableModel(rs));
					      pst.close();
				      }
				      else if ( selection.equals("max_salary(Jobs)") ) {
				    	  String sql = "Select * from jobs where max_salary = ?";
					      PreparedStatement pst = connection.prepareStatement(sql);
					      pst.setString(1,textFieldSearch.getText());
					      ResultSet rs = pst.executeQuery();
					      table.setModel(buildTableModel(rs));
					      pst.close();
				      }
				      else if ( selection.equals("location_id(Locations)") ) {
				    	  String sql = "Select * from locations where location_id = ?";
					      PreparedStatement pst = connection.prepareStatement(sql);
					      pst.setString(1,textFieldSearch.getText());
					      ResultSet rs = pst.executeQuery();
					      table.setModel(buildTableModel(rs));
					      pst.close();
				      }
				      else if ( selection.equals("street_address(Locations)") ) {
				    	  String sql = "Select * from locations where street_address = ?";
					      PreparedStatement pst = connection.prepareStatement(sql);
					      pst.setString(1,textFieldSearch.getText());
					      ResultSet rs = pst.executeQuery();
					      table.setModel(buildTableModel(rs));
					      pst.close();
				      }
				      else if ( selection.equals("postal_code(Locations)") ) {
				    	  String sql = "Select * from locations where postal_code = ?";
					      PreparedStatement pst = connection.prepareStatement(sql);
					      pst.setString(1,textFieldSearch.getText());
					      ResultSet rs = pst.executeQuery();
					      table.setModel(buildTableModel(rs));
					      pst.close();
				      }
				      else if ( selection.equals("city(Locations)") ) {
				    	  String sql = "Select * from locations where city = ?";
					      PreparedStatement pst = connection.prepareStatement(sql);
					      pst.setString(1,textFieldSearch.getText());
					      ResultSet rs = pst.executeQuery();
					      table.setModel(buildTableModel(rs));
					      pst.close();
				      }
				      else if ( selection.equals("state_province(Locations)") ) {
				    	  String sql = "Select * from locations where state_province = ?";
					      PreparedStatement pst = connection.prepareStatement(sql);
					      pst.setString(1,textFieldSearch.getText());
					      ResultSet rs = pst.executeQuery();
					      table.setModel(buildTableModel(rs));
					      pst.close();
				      }
				      else if ( selection.equals("country_id(Locations)") ) {
				    	  String sql = "Select * from locations where country_id = ?";
					      PreparedStatement pst = connection.prepareStatement(sql);
					      pst.setString(1,textFieldSearch.getText());
					      ResultSet rs = pst.executeQuery();
					      table.setModel(buildTableModel(rs));
					      pst.close();
				      }
				      else if ( selection.equals("department_id(Departments)") ) {
				    	  String sql = "Select * from departments where department_id = ?";
					      PreparedStatement pst = connection.prepareStatement(sql);
					      pst.setString(1,textFieldSearch.getText());
					      ResultSet rs = pst.executeQuery();
					      table.setModel(buildTableModel(rs));
					      pst.close();
				      }
				      else if ( selection.equals("department_name(Departments)") ) {
				    	  String sql = "Select * from departments where department_name = ?";
					      PreparedStatement pst = connection.prepareStatement(sql);
					      pst.setString(1,textFieldSearch.getText());
					      ResultSet rs = pst.executeQuery();
					      table.setModel(buildTableModel(rs));
					      pst.close();
				      }
				      else if ( selection.equals("manager_id(Departments)") ) {
				    	  String sql = "Select * from departments where manager_id = ?";
					      PreparedStatement pst = connection.prepareStatement(sql);
					      pst.setString(1,textFieldSearch.getText());
					      ResultSet rs = pst.executeQuery();
					      table.setModel(buildTableModel(rs));
					      pst.close();
				      }
				      else if ( selection.equals("location_id(Departments)") ) {
				    	  String sql = "Select * from departments where location_id = ?";
					      PreparedStatement pst = connection.prepareStatement(sql);
					      pst.setString(1,textFieldSearch.getText());
					      ResultSet rs = pst.executeQuery();
					      table.setModel(buildTableModel(rs));
					      pst.close();
				      }
				      else if ( selection.equals("employee_id(Job History)") ) {
				    	  String sql = "Select * from job_history where employee_id = ?";
					      PreparedStatement pst = connection.prepareStatement(sql);
					      pst.setString(1,textFieldSearch.getText());
					      ResultSet rs = pst.executeQuery();
					      table.setModel(buildTableModel(rs));
					      pst.close();
				      }
				      else if ( selection.equals("start_date(Job History)") ) {
				    	  String sql = "Select * from job_history where start_date = ?";
					      PreparedStatement pst = connection.prepareStatement(sql);
					      pst.setString(1,textFieldSearch.getText());
					      ResultSet rs = pst.executeQuery();
					      table.setModel(buildTableModel(rs));
					      pst.close();
				      }
				      else if ( selection.equals("end_date(Job History)") ) {
				    	  String sql = "Select * from job_history where end_date = ?";
					      PreparedStatement pst = connection.prepareStatement(sql);
					      pst.setString(1,textFieldSearch.getText());
					      ResultSet rs = pst.executeQuery();
					      table.setModel(buildTableModel(rs));
					      pst.close();
				      }
				      else if ( selection.equals("job_id(Job History)") ) {
				    	  String sql = "Select * from job_history where job_id = ?";
					      PreparedStatement pst = connection.prepareStatement(sql);
					      pst.setString(1,textFieldSearch.getText());
					      ResultSet rs = pst.executeQuery();
					      table.setModel(buildTableModel(rs));
					      pst.close();
				      }
				      else if ( selection.equals("department_id(Job History)") ) {
				    	  String sql = "Select * from job_history where department_id = ?";
					      PreparedStatement pst = connection.prepareStatement(sql);
					      pst.setString(1,textFieldSearch.getText());
					      ResultSet rs = pst.executeQuery();
					      table.setModel(buildTableModel(rs));
					      pst.close();
				      }
				      
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		textFieldSearch.setBounds(1121, 113, 165, 20);
		frame.getContentPane().add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setBounds(842, 119, 46, 14);
		frame.getContentPane().add(lblSearch);
		
		
	}
}
