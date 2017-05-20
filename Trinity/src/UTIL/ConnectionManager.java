package UTIL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String uid = "hong";
	private static String password = "hong";
	
	public ConnectionManager(){
		
	}
	
	static{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url,uid,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}