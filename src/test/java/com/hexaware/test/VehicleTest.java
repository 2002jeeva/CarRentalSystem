package com.hexaware.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hexaware.dao.VehicleDao;
import com.hexaware.exception.CarNotFoundException;

/**
 * The VehicleTest class contains unit tests for the VehicleDao class. It tests
 * the functionality of the findVehicleById method.
 */
public class VehicleTest {
	VehicleDao vehicleDao;

	/**
	 * This method is executed before each test case. It initializes the VehicleDao
	 * instance.
	 */
	@Before
	public void setUp() {
		System.out.println("From Setup() vehicledao");
		vehicleDao = new VehicleDao();
	}

	/**
	 * This test case verifies if a vehicle with the specified ID exists.
	 */
	@Test
	public void testFindVehicleById() {
		System.out.println("Vehicle Exists :)");
		assertTrue("Vehicle Exist :)", vehicleDao.findVehicleById(1));
	}

	/**
	 * This test case verifies if a vehicle with the specified ID does not exist.
	 */
	@Test
	public void testFindVehicleByIdNotExist() {
		System.out.println("Vehicle NOT Exists :(");
		assertFalse("Vehicle DOESNT  Exist :)", vehicleDao.findVehicleById(11));
	}

	/**
	 * This method is executed after each test case. It performs cleanup activities.
	 */
	@After
	public void tearDown() {
		System.out.println("From tearDown() vehicledao");
		vehicleDao = null;
	}
}
