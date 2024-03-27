package com.hexaware.controller;

import java.util.ArrayList;
import java.util.List;

import com.hexaware.exception.CarNotFoundException;

/**
 * The IcarRepository interface defines methods for interacting with the car
 * repository.
 */
public interface IcarRepository {
	/**
	 * Adds a car to the repository.
	 */
	public void addCar();

	/**
	 * Removes a car from the repository.
	 */
	public void removeCar();

	/**
	 * Lists all available cars in the repository.
	 */
	public void listAvailableCars();

	/**
	 * Lists all rented cars in the repository.
	 */
	public void listRentedCars();

	/**
	 * Finds a car by its ID.
	 */
	public void findCarById();

	/**
	 * Adds a customer to the repository.
	 */
	public void addCustomer();

	/**
	 * Removes a customer from the repository.
	 */
	public void removeCustomer();

	/**
	 * Lists all customers in the repository.
	 */
	public void listCustomer();

	/**
	 * Finds a customer by their ID.
	 */
	public void findCustomerById();

	/**
	 * Finds a lease by its ID.
	 */
	public void findLeaseById();

	/**
	 * Lists all active leases in the repository.
	 */
	public void listActiveLeases();

	/**
	 * Creates a new lease in the repository.
	 */
	public void createLease();

	/**
	 * Lists the lease history.
	 */
	public void listLeaseHistory();

	/**
	 * Creates a payment entry.
	 */
	public void createPayment();

	/**
	 * Lists payment details.
	 */
	public void listPaymentDetails();

}
