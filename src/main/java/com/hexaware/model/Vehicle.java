package com.hexaware.model;

import java.time.Year;

/**
 * The Vehicle class represents a vehicle entity.
 */
public class Vehicle {
	private int vehicleId; // Unique identifier for the vehicle
	private String make; // Make of the vehicle (e.g., Toyota, Honda)
	private String model; // Model of the vehicle (e.g., Camry, Civic)
	private int year; // Year of the vehicle
	private double dailyRate; // Daily rental rate of the vehicle
	private String status; // Status of the vehicle (e.g., Available, Not Available)
	private int passengerCapacity; // Passenger capacity of the vehicle
	private int engineCapacity; // Engine capacity of the vehicle

	/**
	 * Constructs a new Vehicle object with default values.
	 */
	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructs a new Vehicle object with the specified attributes.
	 * 
	 * @param vehicleId         The unique identifier for the vehicle.
	 * @param make              The make of the vehicle.
	 * @param model             The model of the vehicle.
	 * @param year              The year of the vehicle.
	 * @param dailyRate         The daily rental rate of the vehicle.
	 * @param status            The status of the vehicle.
	 * @param passengerCapacity The passenger capacity of the vehicle.
	 * @param engineCapacity    The engine capacity of the vehicle.
	 */
	public Vehicle(int vehicleId, String make, String model, int year, double dailyRate, String status,
			int passengerCapacity, int engineCapacity) {
		super();
		this.vehicleId = vehicleId;
		this.make = make;
		this.model = model;
		this.year = year;
		this.dailyRate = dailyRate;
		this.status = status;
		this.passengerCapacity = passengerCapacity;
		this.engineCapacity = engineCapacity;
	}

	/**
	 * Retrieves the vehicle's unique identifier.
	 * 
	 * @return The unique identifier of the vehicle.
	 */

	public int getVehicleId() {
		return vehicleId;
	}

	/**
	 * Sets the vehicle's unique identifier.
	 * 
	 * @param vehicleId The unique identifier to set.
	 */
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	/**
	 * Retrieves the make of the vehicle.
	 * 
	 * @return The make of the vehicle.
	 */
	public String getMake() {
		return make;
	}

	/**
	 * Sets the make of the vehicle.
	 * 
	 * @param make The make to set.
	 */

	public void setMake(String make) {
		this.make = make;
	}

	/**
	 * Retrieves the model of the vehicle.
	 * 
	 * @return The model of the vehicle.
	 */
	public String getModel() {
		return model;
	}

	/**
	 * Sets the model of the vehicle.
	 * 
	 * @param model The model to set.
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * Retrieves the year of the vehicle.
	 * 
	 * @return The year of the vehicle.
	 */

	public int getYear() {
		return year;
	}

	/**
	 * Sets the year of the vehicle.
	 * 
	 * @param year The year to set.
	 */

	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * Retrieves the daily rental rate of the vehicle.
	 * 
	 * @return The daily rental rate of the vehicle.
	 */

	public double getDailyRate() {
		return dailyRate;
	}

	/**
	 * Sets the daily rental rate of the vehicle.
	 * 
	 * @param dailyRate The daily rental rate to set.
	 */
	public void setDailyRate(double dailyRate) {
		this.dailyRate = dailyRate;
	}

	/**
	 * Retrieves the status of the vehicle.
	 * 
	 * @return The status of the vehicle.
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status of the vehicle.
	 * 
	 * @param status The status to set.
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Retrieves the passenger capacity of the vehicle.
	 * 
	 * @return The passenger capacity of the vehicle.
	 */
	public int getPassengerCapacity() {
		return passengerCapacity;
	}

	/**
	 * Sets the passenger capacity of the vehicle.
	 * 
	 * @param passengerCapacity The passenger capacity to set.
	 */
	public void setPassengerCapacity(int passengerCapacity) {
		this.passengerCapacity = passengerCapacity;
	}

	/**
	 * Retrieves the engine capacity of the vehicle.
	 * 
	 * @return The engine capacity of the vehicle.
	 */
	public int getEngineCapacity() {
		return engineCapacity;
	}

	/**
	 * Sets the engine capacity of the vehicle.
	 * 
	 * @param engineCapacity The engine capacity to set.
	 */
	public void setEngineCapacity(int engineCapacity) {
		this.engineCapacity = engineCapacity;
	}

	/**
	 * Returns a string representation of the Vehicle object.
	 * 
	 * @return A string representation of the Vehicle object.
	 */
	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", make=" + make + ", model=" + model + ", year=" + year
				+ ", dailyRate=" + dailyRate + ", status=" + status + ", passengerCapacity=" + passengerCapacity
				+ ", engineCapacity=" + engineCapacity + "]";
	}

}
