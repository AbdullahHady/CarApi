package com.skillstorm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static final String url="jdbc:mysql://localhost:3306/testdb";
	private static final String username="root";
	private static final String password="root";
	
	private static Connection conn;
	public static Connection getConnection() throws ClassNotFoundException
	{
		 Class.forName("com.mysql.cj.jdbc.Driver");
		
		try {
			conn=DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

}
