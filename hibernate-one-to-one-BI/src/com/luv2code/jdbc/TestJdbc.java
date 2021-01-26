package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {

	public static void main(String[] args) {

		String jdbcURL = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
		//String jdbcURL =   "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?autoReconnect=true&useSSL=false";
		String user = "sqluser";
		String pass = "sql123";
			
			try {
				
				System.out.println("Connection to the database: "+jdbcURL);
				Connection myConn = DriverManager.getConnection(jdbcURL, user, pass);				
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			System.out.println("connection success");

	}

}
