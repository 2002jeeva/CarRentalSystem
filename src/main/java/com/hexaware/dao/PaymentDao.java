package com.hexaware.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hexaware.model.Payment;
import com.hexaware.util.DbUtil;

/**
 * The PaymentDao class provides methods to interact with the payment database
 * table.
 */
public class PaymentDao {
	Connection con;
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;
	/**
     * Default constructor for the PaymentDao class.
     * This constructor initializes the PaymentDao object.
     */
    public PaymentDao() {
        // Default constructor
    }
	/**
	 * Adds a payment record to the payment database table.
	 * 
	 * @param payment The Payment object representing the payment to be added.
	 */
	public void addPayment(Payment payment) {
		try {
			con = DbUtil.getDBConn();
			ps = con.prepareStatement(
					"insert into payment(payment_id,lease_id,transactionDate,amount) values(?,?,?,?)");
			ps.setInt(1, payment.getPaymentId());
			ps.setInt(2, payment.getLeaseId());
			ps.setDate(3, Date.valueOf(payment.getPaymentDate()));
			ps.setDouble(4, payment.getAmount());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " inserted Successfully in DB");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retrieves a list of all payments from the payment database table and prints
	 * them to the console.
	 * 
	 * @param payment The Payment object representing the payment for which the list
	 *                is to be retrieved.
	 */
	public void paymentList(Payment payment) {
		try {
			con = DbUtil.getDBConn();
			ps = con.prepareStatement("Select * from  payment");
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.print("PaymentId :" + rs.getInt(1));
				System.out.print(" LeaseId :" + rs.getInt(2));
				System.out.print(" TransactionDate :" + rs.getDate(3));
				System.out.println(" Amount :" + rs.getDouble(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
