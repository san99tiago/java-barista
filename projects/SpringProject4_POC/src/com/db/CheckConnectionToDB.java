package com.db;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

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
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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

}
