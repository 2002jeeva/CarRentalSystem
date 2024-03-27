package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hexaware.exception.CarNotFoundException;
import com.hexaware.model.Vehicle;
import com.hexaware.util.DbUtil;


/**
 * The VehicleDao class provides methods to interact with the vehicle database
 * table.
 */
public class VehicleDao {
	Connection con;
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;

	/**
	 * Adds a car record to the vehicle database table.
	 * 
	 * @param vehicle The Vehicle object representing the car to be added.
	 */
	public void addCar(Vehicle vehicle) {
		try {
			con = DbUtil.getDBConn();
			ps = con.prepareStatement(
					"insert into vehicle(vehicle_id,vehicle_make,vehicle_model,vehicle_year,vehicle_dailyrate,vehicle_status,vehicle_passengercapacity,vehicle_enginecapacity) values(?,?,?,?,?,?,?,?)");
			ps.setInt(1, vehicle.getVehicleId());
			ps.setString(2, vehicle.getMake());
			ps.setString(3, vehicle.getModel());
			ps.setInt(4, vehicle.getYear());
			ps.setDouble(5, vehicle.getDailyRate());
			ps.setString(6, vehicle.getStatus());
			ps.setInt(7, vehicle.getPassengerCapacity());
			ps.setInt(8, vehicle.getEngineCapacity());
			;
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " inserted Successfully in DB");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Removes a car record from the vehicle database table.
	 * 
	 * @param vehicle The Vehicle object representing the car to be removed.
	 */
	public void removeCar(Vehicle vehicle) {
		try {
			con = DbUtil.getDBConn();
			ps = con.prepareStatement("Delete from vehicle  where vehicle_id=?");
			ps.setInt(1, vehicle.getVehicleId());
			int norows = ps.executeUpdate();
			System.out.println(norows + " Deleted Successfully in DB");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Lists all available car records from the vehicle database table.
	 * 
	 * @param vehicle A dummy Vehicle object (not used).
	 */
	public void listAvailableCar(Vehicle vehicle) {
		try {
			con = DbUtil.getDBConn();
			ps = con.prepareStatement("Select * from vehicle  where vehicle_status=1");
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.print("VehilcleId :" + rs.getInt(1));
				System.out.print(" VehicleMake :" + rs.getString(2));
				System.out.print(" VehicleModel :" + rs.getString(3));
				System.out.print(" VehicleYear :" + rs.getInt(4));
				System.out.print(" VehicleDailyRate :" + rs.getDouble(5));
				System.out.print(" VehicleStatus :" + rs.getString(6));
				System.out.print(" VehiclePassengerCapacity :" + rs.getInt(7));
				System.out.println(" VehicleEngineCapacity :" + rs.getInt(8));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Lists all rented car records from the vehicle database table.
	 * 
	 * @param vehicle A dummy Vehicle object (not used).
	 */
	public void listRentedCar(Vehicle vehicle) {
		try {
			con = DbUtil.getDBConn();
			ps = con.prepareStatement("Select * from vehicle  where vehicle_status=0");
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.print("VehilcleId :" + rs.getInt(1));
				System.out.print(" VehicleMake :" + rs.getString(2));
				System.out.print(" VehicleModel :" + rs.getString(3));
				System.out.print(" VehicleYear :" + rs.getInt(4));
				System.out.print(" VehicleDailyRate :" + rs.getDouble(5));
				System.out.print(" VehicleStatus :" + rs.getString(6));
				System.out.print(" VehiclePassengerCapacity :" + rs.getInt(7));
				System.out.println(" VehicleEngineCapacity :" + rs.getInt(8));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Checks if a vehicle with the given vehicle ID exists in the database.
	 * 
	 * @param vehicleId The vehicle ID to check.
	 * @return true if the vehicle exists, false otherwise.
	 */
	public boolean findVehicleById(int vehicleId) {
		boolean available = false;
		con = DbUtil.getDBConn();

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from vehicle where vehicle_id =" + vehicleId);
			if (rs.next()) {
				available = true;
				System.out.print("VehilcleId :" + rs.getInt(1));
				System.out.print(" VehicleMake :" + rs.getString(2));
				System.out.print(" VehicleModel :" + rs.getString(3));
				System.out.print(" VehicleYear :" + rs.getInt(4));
				System.out.print(" VehicleDailyRate :" + rs.getDouble(5));
				System.out.print(" VehicleStatus :" + rs.getString(6));
				System.out.print(" VehiclePassengerCapacity :" + rs.getInt(7));
				System.out.println(" VehicleEngineCapacity :" + rs.getInt(8));
			} else {
				available = false;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return available;

	}
	
	public void updateVehicle(int vehicleId) {
		// TODO Auto-generated method stub
		try {
			con = DbUtil.getDBConn();
			ps=con.prepareStatement("Update vehicle set vehicle_status='0' where vehicle_id= "+vehicleId);
			int norows=ps.executeUpdate();
			System.out.println(norows + " Updated Successfully in DB");
			}
			 catch (SQLException e) {	
					e.printStackTrace();
				}
	}
}
