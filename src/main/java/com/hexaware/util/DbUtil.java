package com.hexaware.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The DbUtil class provides utility methods for interacting with the database.
 */
public class DbUtil {
	static Connection con; // Static variable representing the database connection.

	/**
	 * Retrieves a database connection.
	 * 
	 * @return The database connection.
	 */
	public static Connection getDBConn() {

		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/car_rental_coding", "root", "root");
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return con;
	}

	/**
	 * A main method for testing the database connection.
	 * 
	 * @param args Command line arguments (not used).
	 */
	public static void main(String[] args) {
		System.out.println(getDBConn());
	}
}
