package com.hexaware.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hexaware.dao.CustomerDao;
import com.hexaware.dao.VehicleDao;

/**
 * The CustomerTest class contains unit tests for the CustomerDao class. It
 * tests the functionality of the findCustomerById method.
 */
public class CustomerTest {
	CustomerDao customerDao;

	/**
	 * This method is executed before each test case. It initializes the CustomerDao
	 * instance.
	 */
	@Before
	public void setUp() {
		System.out.println("From Setup() CustomerDao");
		customerDao = new CustomerDao();
	}

	/**
	 * This test case verifies if a customer with the specified ID exists.
	 */
	@Test
	public void testFindCustomerById() {
		System.out.println("Customer Exists :)");
		assertTrue("Customer Exist :)", customerDao.findCustomerById(1));
	}

	/**
	 * This test case verifies if a customer with the specified ID does not exist.
	 */
	@Test
	public void testFindCustomerByIdNotExist() {
		System.out.println("Customer NOT Exists :(");
		assertFalse("Customer DOESNT  Exist :)", customerDao.findCustomerById(11));
	}

	/**
	 * This method is executed after each test case. It performs cleanup activities.
	 */
	@After
	public void tearDown() {
		System.out.println("From tearDown() CustomerDao");
		customerDao = null;
	}
}
