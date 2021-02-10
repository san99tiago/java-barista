package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class CheckConnectionToDB {

	public static void main(String[] args) {
		testMySQL();
	}

	public static void testMySQL() {
		// Info to connect to MySQL database in MySQL workbench
//		String jdbcUrl = "jdbc:mysql://localhost:3306/spring_projects?useSSL=false";
		String jdbcUrl = "jdbc:mysql://localhost:3306/spring_projects";
		String user = "root";
		String pass = "1234";
		String driverMySQL = "com.mysql.cj.jdbc.Driver";

		try {
			System.out.println("\n\n...connecting to MySQL database --> " + jdbcUrl + " ...\n");

			Class.forName(driverMySQL); // Add MySQL driver for finding service
			Connection connector = DriverManager.getConnection(jdbcUrl, user, pass);

			System.out.println("... Connector for DB created: " + connector + " ...\n");
			System.out.println("...connection successful to MySQL database --> " + jdbcUrl + " ...\n\n");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
