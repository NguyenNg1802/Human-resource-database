package org.o7planning.tutorial.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class OracleConnUtils {
 
 public static Connection getOracleConnection() throws SQLException,
         ClassNotFoundException {
     String hostName = "localhost";
     String sid = "orcl";
     String userName = "SYS as SYSDBA";
     String password = "123456789";
 
     return getOracleConnection(hostName, sid, userName, password);
 }
 
 public static Connection getOracleConnection(String hostName, String sid,
         String userName, String password) throws ClassNotFoundException,
         SQLException {
 
 
     Class.forName("oracle.jdbc.driver.OracleDriver");
 

     String connectionURL = "jdbc:oracle:thin:@" + hostName + ":1521:" + sid;
 
     Connection conn = DriverManager.getConnection(connectionURL, userName,
             password);
     return conn;
 }
}
