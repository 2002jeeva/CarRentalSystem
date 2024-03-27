package com.hexaware.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hexaware.dao.LeaseDao;

/**
 * The LeaseTest class contains unit tests for the LeaseDao class. It tests the
 * functionality of the findLeaseById method.
 */
public class LeaseTest {
	LeaseDao leaseDao;

	/**
	 * This method is executed before each test case. It initializes the LeaseDao
	 * instance.
	 */
	@Before
	public void setUp() {
		System.out.println("From Setup() LeaseDao");
		leaseDao = new LeaseDao();
	}

	/**
	 * This test case verifies if a lease with the specified ID exists.
	 */
	@Test
	public void testFindLeaseById() {
		System.out.println("Lease Exists :)");
		assertTrue("Lease Exist :)", leaseDao.findLeaseById(1));
	}

	/**
	 * This test case verifies if a lease with the specified ID does not exist.
	 */
	@Test
	public void testFindLeaseByIdNotExist() {
		System.out.println("Lease NOT Exists :(");
		assertFalse("Lease DOESNT  Exist :)", leaseDao.findLeaseById(21));
	}

	/**
	 * This method is executed after each test case. It performs cleanup activities.
	 */

	@After
	public void tearDown() {
		System.out.println("From tearDown() LeaseDao");
		leaseDao = null;
	}
}
