package com.base.spring.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
	
	private static String JDBC_URL = "jdbc:mysql://localhost:3306/centraldb?useSSL=false&serverTimezone=UTC";
	private static String USER = "admin";
	private static String PASSWORD = "admin";
	
	public static void main(String[] args) {
		try {
			System.out.println("The URL is: " + JDBC_URL);
			Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
			System.out.println("Connection Successful!!! " + conn.getCatalog());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
