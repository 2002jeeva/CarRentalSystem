package com.hexaware.model;

import java.sql.Date;
import java.time.LocalDate;
/**
 * The Lease class represents a Lease entity.
 */
public class Lease {
	private int leaseId; // Unique identifier for the lease
	private int vehicleId; // Identifier for the leased vehicle
	private int customerId; // Identifier for the customer leasing the vehicle
	private LocalDate startDate; // Start date of the lease
	private LocalDate endDate; // End date of the lease
	private String type; // Type of the lease (e.g., Monthly, Daily)

	/**
	 * Constructs a new Lease object with default values.
	 */
	public Lease() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructs a new Lease object with the specified attributes.
	 * 
	 * @param leaseId    The unique identifier for the lease.
	 * @param vehicleId  The identifier for the leased vehicle.
	 * @param customerId The identifier for the customer leasing the vehicle.
	 * @param startDate  The start date of the lease.
	 * @param endDate    The end date of the lease.
	 * @param type       The type of the lease (e.g., short-term, long-term).
	 */
	public Lease(int leaseId, int vehicleId, int customerId, LocalDate startDate, LocalDate endDate, String type) {
		super();
		this.leaseId = leaseId;
		this.vehicleId = vehicleId;
		this.customerId = customerId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.type = type;
	}

	/**
	 * Retrieves the lease's unique identifier.
	 *
	 * @return The unique identifier of the lease.
	 */
	public int getLeaseId() {
		return leaseId;
	}

	/**
	 * Sets the lease's unique identifier.
	 *
	 * @param leaseId The unique identifier to set.
	 */
	public void setLeaseId(int leaseId) {
		this.leaseId = leaseId;
	}

	/**
	 * Retrieves the identifier of the leased vehicle.
	 *
	 * @return The identifier of the leased vehicle.
	 */
	public int getVehicleId() {
		return vehicleId;
	}

	/**
	 * Sets the identifier of the leased vehicle.
	 *
	 * @param vehicleId The identifier to set.
	 */
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	/**
	 * Retrieves the identifier of the customer leasing the vehicle.
	 *
	 * @return The identifier of the customer leasing the vehicle.
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * Sets the identifier of the customer leasing the vehicle.
	 *
	 * @param customerId The identifier to set.
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	/**
	 * Retrieves the start date of the lease.
	 *
	 * @return The start date of the lease.
	 */
	public LocalDate getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date of the lease.
	 *
	 * @param startDate The start date to set.
	 */
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	/**
	 * Retrieves the end date of the lease.
	 *
	 * @return The end date of the lease.
	 */
	public LocalDate getEndDate() {
		return endDate;
	}

	/**
	 * Sets the end date of the lease.
	 *
	 * @param endDate The end date to set.
	 */
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	/**
	 * Retrieves the type of the lease.
	 *
	 * @return The type of the lease.
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type of the lease.
	 *
	 * @param type The type to set.
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Returns a string representation of the Lease object.
	 *
	 * @return A string representation of the Lease object.
	 */
	@Override
	public String toString() {
		return "Lease [leaseId=" + leaseId + ", vehicleId=" + vehicleId + ", customerId=" + customerId + ", startDate="
				+ startDate + ", endDate=" + endDate + ", type=" + type + "]";
	}

}
