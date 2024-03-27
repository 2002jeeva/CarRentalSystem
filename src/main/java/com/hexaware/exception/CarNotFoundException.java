package com.hexaware.exception;

/**
 * Custom exception class for indicating that a car is not found.
 */
public class CarNotFoundException extends Exception {

	/**
	 * Constructs a new CarNotFoundException with no detail message.
	 */
	public CarNotFoundException() {
		super("Car not found."); // Call superclass constructor
	}

	/**
	 * Returns a string representation of this exception.
	 * 
	 * @return A string representation of this exception.
	 */
	@Override
	public String toString() {
		return "CarNotFoundException: Car not found.";
	}
}
