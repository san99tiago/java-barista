package com.db;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class CheckDB to test correct MySQL db connection
 */
@WebServlet("/CheckDB")
public class CheckConnectionToDB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckConnectionToDB() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		testMySQL(request, response);
		testMongo(request, response);
	}

	public void testMySQL(HttpServletRequest request, HttpServletResponse response) {
		// Info to connect to MySQL database in MySQL workbench
//		String jdbcUrl = "jdbc:mysql://localhost:3306/spring_projects?useSSL=false";
		String jdbcUrl = "jdbc:mysql://localhost:3306/spring_projects";
		String user = "root";
		String pass = "1234";
		String driverMySQL = "com.mysql.cj.jdbc.Driver";

		try {
			System.out.println("\n\n...connecting to MySQL database --> " + jdbcUrl + " ...\n");

			PrintWriter outWriter = response.getWriter();
			outWriter.println("--> Connecting to database: " + jdbcUrl);

			Class.forName(driverMySQL); // Add MySQL driver for finding service
			Connection connector = DriverManager.getConnection(jdbcUrl, user, pass);

			outWriter.println("--> Connection successful to database: " + jdbcUrl);
			System.out.println("... Connector for DB created: " + connector + " ...\n");
			System.out.println("...connection successful to MySQL database --> " + jdbcUrl + " ...\n\n");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testMongo(HttpServletRequest request, HttpServletResponse response) {
//		// Info to connect to MongoDB
//		String jdbcUrl = "jdbc:mongo://localhost:27017/clientphotos";
//		String user = "";
//		String pass = "";
//		String driverMongo = "com.mongodb.MongoClient";
//		
//		try {
//			Class.forName(driverMongo); // Add MySQL driver for finding service
//			Connection connector = DriverManager.getConnection(jdbcUrl, user, pass);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}

	}
}
