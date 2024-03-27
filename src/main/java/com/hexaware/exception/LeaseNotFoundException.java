package com.hexaware.exception;

/**
 * Custom exception class for indicating that a lease is not found.
 */
public class LeaseNotFoundException extends Exception {

	/**
	 * Constructs a new LeaseNotFoundException with no detail message.
	 */
	public LeaseNotFoundException() {
		super("Lease not found."); // Call superclass constructor
	}

	/**
	 * Returns a string representation of this exception.
	 * 
	 * @return A string representation of this exception.
	 */
	@Override
	public String toString() {
		return "LeaseNotFoundException: Lease not found.";
	}
}
