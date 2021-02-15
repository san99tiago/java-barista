package com.main.mvc;

import java.sql.Connection;
import java.sql.DriverManager;

public class OldWayToTestJDBC {

	public static void main(String[] args) {
		// Info to connect to MySQL database in MySQL workbench
//		String jdbcUrl = "jdbc:mysql://localhost:3306/spring_projects?useSSL=false";
		String jdbcUrl = "jdbc:mysql://localhost:3306/spring_projects";
		String user = "root";
		String pass = "1234";

		try {
			System.out.println("\n\n...connecting to MySQL database --> " + jdbcUrl + " ...");

			Class.forName("com.mysql.cj.jdbc.Driver"); // Add MySQL driver for finding service
			Connection connector = DriverManager.getConnection(jdbcUrl, user, pass);

			System.out.println(connector);

			System.out.println("...connection successful to MySQL database --> " + jdbcUrl + " ...\n\n");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
