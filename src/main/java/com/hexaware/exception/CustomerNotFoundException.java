package com.hexaware.exception;

/**
 * Custom exception class for indicating that a customer is not found.
 */
public class CustomerNotFoundException extends Exception {

	/**
	 * Constructs a new CustomerNotFoundException with no detail message.
	 */
	public CustomerNotFoundException() {
		super("Customer not found."); // Call superclass constructor
	}

	/**
	 * Returns a string representation of this exception.
	 * 
	 * @return A string representation of this exception.
	 */
	@Override
	public String toString() {
		return "CustomerNotFoundException: Customer not found.";
	}
}
