package org.o7planning.tutorial.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
import org.o7planning.tutorial.jdbc.ConnectionUtils;
 
public class justtesting{
 
  public static void main(String[] args) throws ClassNotFoundException,
          SQLException {
 
      Connection connection = ConnectionUtils.getMyConnection();
 
      Statement statement = connection.createStatement();

      String sql = "Select * from employees";
 
      ResultSet rs = statement.executeQuery(sql);
 
      while (rs.next()) {
          System.out.println(rs.getString(1)+"    "+rs.getString(2)+"    "+rs.getString(3)+"    "+rs.getString(4));
      }
      connection.close();
  }
 
}
