package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.model.Customer;
import com.hexaware.model.Vehicle;
import com.hexaware.util.DbUtil;

/**
 * This class provides methods to interact with the database for customer-related operations.
 */
public class CustomerDao {
	Connection con;
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;
	/**
     * Default constructor for the CustomerDao class.
     * This constructor initializes the CustomerDao object.
     */
    public CustomerDao() {
        // Default constructor
    }
	/**
	 * Adds a customer record to the customer database table.
	 * 
	 * @param customer The Customer object representing the customer to be added.
	 */

	public void addCustomer(Customer customer) {
		try {
			con = DbUtil.getDBConn();
			ps = con.prepareStatement(
					"insert into customer(customer_id,customer_firstname,customer_lastname,customer_email,customer_phonenumber) values(?,?,?,?,?)");
			ps.setInt(1, customer.getCustomerId());
			ps.setString(2, customer.getFirstName());
			ps.setString(3, customer.getLastName());
			ps.setString(4, customer.getEmail());
			ps.setString(5, customer.getPhoneNumber());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " inserted Successfully in DB");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Removes a customer record from the customer database table.
	 * 
	 * @param customer The Customer object representing the customer to be removed.
	 */
	public void removeCustomer(Customer customer) {
		try {
			con = DbUtil.getDBConn();
			ps = con.prepareStatement("Delete from customer  where customer_id=?");
			ps.setInt(1, customer.getCustomerId());
			int norows = ps.executeUpdate();
			System.out.println(norows + " Deleted Successfully in DB");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retrieves a list of all customers from the customer database table.
	 * 
	 * @param cust A dummy Customer object (not used).
	 * @return A list of Customer objects representing the customers in the
	 *         database.
	 */
	public List customerList(Customer cust) {
		List<Customer> c = new ArrayList<>();
		try {
			con = DbUtil.getDBConn();
			ps = con.prepareStatement("Select * from customer");
			rs = ps.executeQuery();
			while (rs.next()) {
				int customerId = rs.getInt(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String email = rs.getString(4);
				String phoneNumber = rs.getString(5);
				Customer customer = new Customer(customerId, firstName, lastName, email, phoneNumber);
				c.add(customer);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	/**
	 * Checks if a customer with the given customer ID exists in the database.
	 * 
	 * @param customerId The customer ID to check.
	 * @return true if the customer exists, false otherwise.
	 */
	public boolean findCustomerById(int customerId) {
		boolean available = false;
		con = DbUtil.getDBConn();

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from customer where customer_id =" + customerId);
			if (rs.next()) {
				available = true;
				System.out.print("CustomerId :" + rs.getInt(1));
				System.out.print(" CustomerFirstName :" + rs.getString(2));
				System.out.print(" CustomerLastName :" + rs.getString(3));
				System.out.print(" CustomerEmail :" + rs.getString(4));
				System.out.println(" CustomerPhoneNumber :" + rs.getString(5));
			} else {
				available = false;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return available;

	}

}
