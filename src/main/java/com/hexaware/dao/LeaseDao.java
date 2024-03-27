package com.hexaware.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hexaware.model.Lease;
import com.hexaware.util.DbUtil;

/**
 * The LeaseDao class provides methods to interact with the lease database
 * table.
 */
public class LeaseDao {
	Connection con;
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;

	/**
	 * Creates a new lease record in the lease database table.
	 * 
	 * @param lease The Lease object representing the lease to be created.
	 */
	public void createLease(Lease lease) {
		try {
			con = DbUtil.getDBConn();
			ps = con.prepareStatement(
					"insert into lease(lease_id,vehicle_id,customer_id,lease_startdate,lease_enddate,lease_type) values(?,?,?,?,?,?)");
			ps.setInt(1, lease.getLeaseId());
			ps.setInt(2, lease.getVehicleId());
			ps.setInt(3, lease.getCustomerId());
			ps.setDate(4, Date.valueOf(lease.getStartDate()));
			ps.setDate(5, Date.valueOf(lease.getEndDate()));
			ps.setString(6, lease.getType());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " inserted Successfully in DB");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Checks if a lease with the given lease ID exists in the database.
	 * 
	 * @param leaseId The lease ID to check.
	 * @return true if the lease exists, false otherwise.
	 */
	public boolean findLeaseById(int LeaseId) {
		boolean available = false;
		con = DbUtil.getDBConn();

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from lease where lease_id =" + LeaseId);
			if (rs.next()) {
				available = true;
				System.out.print("LeaseId :" + rs.getInt(1));
				System.out.print(" VehicleId :" + rs.getInt(2));
				System.out.print(" CustomerId :" + rs.getInt(3));
				System.out.print(" StartDate :" + rs.getDate(4));
				System.out.print(" EndDate :" + rs.getDate(5));
				System.out.println(" Type :" + rs.getString(6));

			} else {
				available = false;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return available;

	}

	/**
	 * Lists all lease records from the lease database table.
	 * 
	 * @param lease A dummy Lease object (not used).
	 */
	public void listLeaseHistory(Lease lease) {
		con = DbUtil.getDBConn();

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from lease");
			while (rs.next()) {

				System.out.print("LeaseId :" + rs.getInt(1));
				System.out.print(" VehicleId :" + rs.getInt(2));
				System.out.print(" CustomerId :" + rs.getInt(3));
				System.out.print(" StartDate :" + rs.getDate(4));
				System.out.print(" EndDate :" + rs.getDate(5));
				System.out.println(" Type :" + rs.getString(6));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/**
	 * Lists active lease records from the lease database table.
	 * 
	 * @param lease A dummy Lease object (not used).
	 */
	public void listActiveLeaseHistory(Lease lease) {
		con = DbUtil.getDBConn();

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT l.*" + "FROM lease l " + "JOIN payment p ON l.lease_id = p.lease_id "
					+ "WHERE l.lease_startdate <= CURDATE() " + "AND l.lease_enddate >= CURDATE() "
					+ "AND p.transactionDate > DATE_SUB(CURDATE(), INTERVAL 1 MONTH) " + "GROUP BY l.lease_id "
					+ "HAVING SUM(p.amount) > 0");
			while (rs.next()) {

				System.out.print("LeaseId :" + rs.getInt(1));
				System.out.print(" VehicleId :" + rs.getInt(2));
				System.out.print(" CustomerId :" + rs.getInt(3));
				System.out.print(" StartDate :" + rs.getDate(4));
				System.out.print(" EndDate :" + rs.getDate(5));
				System.out.println(" Type :" + rs.getString(6));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
