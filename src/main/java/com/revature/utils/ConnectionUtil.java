package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	public static Connection getConnection() throws SQLException {
		
		//For compatibility with other technologies/frameworks, we'll need to register our PostgreSQL driver
		//This process makes the application aware of what Driver class we're using
		try {
			Class.forName("org.postgresql.Driver"); //searching for the postgres driver, which we have as a dependency
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); //This tells in the console us what went wrong
			System.out.println("problem occurred locating driver");
		}
		
		
		//Use our database credentials to establish a database connection
		//Hardcoded for now... BAD! we'll change this later to hide them in the Environment Variables
		
		//I'm going to put the credentials in Strings, and use those strings in a method that gets connections
		String url = "";
		String username = "";
		String password = "";
		
		//This return statement is what returns out actual database Connection object
		//Note how this getConnection() method has a return type of Connection
		return DriverManager.getConnection(url, username, password);
	}
}
