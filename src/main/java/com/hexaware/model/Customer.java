package com.hexaware.model;

/**
 * The Customer class represents a customer entity.
 */
public class Customer {
	private int customerId; // Unique identifier for the customer
	private String firstName; // First name of the customer
	private String lastName; // Last name of the customer
	private String email; // Email address of the customer
	private String phoneNumber; // Phone number of the customer

	/**
	 * Constructs a new Customer object with the specified attributes.
	 * 
	 * @param customerId  The unique identifier for the customer.
	 * @param firstName   The first name of the customer.
	 * @param lastName    The last name of the customer.
	 * @param email       The email address of the customer.
	 * @param phoneNumber The phone number of the customer.
	 */
	public Customer(int customerId, String firstName, String lastName, String email, String phoneNumber) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Constructs a new Customer object with default values.
	 */
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Retrieves the customer's unique identifier.
	 * 
	 * @return The unique identifier of the customer.
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * Sets the customer's unique identifier.
	 * 
	 * @param customerId The unique identifier to set.
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	/**
	 * Retrieves the customer's first name.
	 * 
	 * @return The first name of the customer.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the customer's first name.
	 * 
	 * @param firstName The first name to set.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Retrieves the customer's last name.
	 * 
	 * @return The last name of the customer.
	 */

	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the customer's last name.
	 * 
	 * @param lastName The last name to set.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Retrieves the customer's email address.
	 * 
	 * @return The email address of the customer.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the customer's email address.
	 * 
	 * @param email The email address to set.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Retrieves the customer's phone number.
	 * 
	 * @return The phone number of the customer.
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets the customer's phone number.
	 * 
	 * @param phoneNumber The phone number to set.
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Returns a string representation of the Customer object.
	 * 
	 * @return A string representation of the Customer object.
	 */
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", phoneNumber=" + phoneNumber + "]";
	}

}
