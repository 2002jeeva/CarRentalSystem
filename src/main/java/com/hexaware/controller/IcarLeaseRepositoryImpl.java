package com.hexaware.controller;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hexaware.dao.CustomerDao;
import com.hexaware.dao.LeaseDao;
import com.hexaware.dao.PaymentDao;
import com.hexaware.dao.VehicleDao;
import com.hexaware.exception.CarNotFoundException;
import com.hexaware.model.Customer;
import com.hexaware.model.Lease;
import com.hexaware.model.Payment;
import com.hexaware.model.Vehicle;

/**
 * The IcarLeaseRepositoryImpl class implements the IcarRepository interface
 * providing methods to interact with the car lease repository.
 */
public class IcarLeaseRepositoryImpl implements IcarRepository {
	Vehicle vehicle;
	Customer customer;
	Lease lease;
	Payment payment;
	List<Vehicle> vehicleList = new ArrayList<Vehicle>();
	List<Customer> customerList = new ArrayList<Customer>();
	List<Lease> leaseList = new ArrayList<Lease>();
	List<Payment> paymentList = new ArrayList<Payment>();
	Scanner sc = new Scanner(System.in);
	VehicleDao vehicleDao = new VehicleDao();
	CustomerDao customerDao = new CustomerDao();
	LeaseDao leaseDao = new LeaseDao();
	PaymentDao paymentDao = new PaymentDao();

	/**
	 * Adds a car to the repository.
	 */
	@Override
	public void addCar() {
		vehicle = new Vehicle();
		System.out.println("Enter The Vehicle Id");
		int vehileId = sc.nextInt();
		vehicle.setVehicleId(vehileId);
		System.out.println("Enter the make");
		String make = sc.next();
		vehicle.setMake(make);
		System.out.println("Enter the model");
		String model = sc.next();
		vehicle.setModel(model);
		System.out.println("Enter the Year");
		int year = sc.nextInt();
		vehicle.setYear(year);
		System.out.println("Enter the Daily Rate");
		double dailyRate = sc.nextDouble();
		vehicle.setDailyRate(dailyRate);
		System.out.println("Enter the Status");
		String status = sc.next();
		vehicle.setStatus(status);
		System.out.println("Enter the passenger Capacity");
		int passengerCapacity = sc.nextInt();
		vehicle.setPassengerCapacity(passengerCapacity);
		System.out.println("Enter the engine Capacity");
		int engineCapacity = sc.nextInt();
		vehicle.setEngineCapacity(engineCapacity);
		vehicleDao.addCar(vehicle);
		vehicleList.add(vehicle);
		System.out.println("Vehicle " + vehicle.getVehicleId() + " " + "sucessfully added");

	}

	/**
	 * Removes a car from the repository.
	 */
	@Override
	public void removeCar() {
		vehicle = new Vehicle();
		System.out.println("Enter car Id to remove");
		int vehicleId = sc.nextInt();
		vehicle.setVehicleId(vehicleId);
		vehicleDao.removeCar(vehicle);
	}

	/**
	 * Lists all available cars in the repository.
	 */
	@Override
	public void listAvailableCars() {
		// TODO Auto-generated method stub
		vehicleDao.listAvailableCar(vehicle);
	}

	/**
	 * Lists all rented cars in the repository.
	 */
	@Override
	public void listRentedCars() {
		vehicleDao.listRentedCar(vehicle);

	}

	/**
	 * Finds a car by its ID.
	 */
	@Override
	public void findCarById() {
		System.out.println("Enter vehicle id");
		int vehicleId = sc.nextInt();

		boolean vehicleAvailable = vehicleDao.findVehicleById(vehicleId);
		if (vehicleAvailable) {
			System.out.println("Vehicle " + vehicleId + " exists !!!");
		} else {
			System.out.println("Vehicle " + vehicleId + " doesn't exist :(");
		}
	}

	/**
	 * Adds a customer to the repository.
	 */
	@Override
	public void addCustomer() {
		customer = new Customer();
		System.out.println("Enter Customer Id");
		int customerId = sc.nextInt();
		customer.setCustomerId(customerId);
		System.out.println("Enter First Name");
		String firstName = sc.next();
		customer.setFirstName(firstName);
		System.out.println("Enter the last Name");
		String lastName = sc.next();
		customer.setLastName(lastName);
		System.out.println("Enter the email");
		String email = sc.next();
		customer.setEmail(email);
		System.out.println("Enter the phone Number");
		String phoneNumber = sc.next();
		customer.setPhoneNumber(phoneNumber);
		customerDao.addCustomer(customer);
		customerList.add(customer);
		System.out.println("Customer " + customer.getCustomerId() + " " + "sucessfully added");
	}

	/**
	 * Removes a customer from the repository.
	 */
	@Override
	public void removeCustomer() {
		customer = new Customer();
		System.out.println("Enter Customer Id to remove");
		int customerId = sc.nextInt();
		customer.setCustomerId(customerId);
		customerDao.removeCustomer(customer);

	}

	/**
	 * Lists all customers in the repository.
	 */
	@Override
	public void listCustomer() {
		// TODO Auto-generated method stub
		List<Customer> c = new ArrayList<>();
		c.addAll(customerDao.customerList(customer));
		System.out.println(c);
	}

	/**
	 * Finds a customer by their ID.
	 */
	@Override
	public void findCustomerById() {
		System.out.println("Enter Customer id");
		int customerId = sc.nextInt();

		boolean customerAvailable = customerDao.findCustomerById(customerId);
		if (customerAvailable) {
			System.out.println("Vehicle " + customerId + " exists !!!");
		} else {
			System.out.println("Vehicle " + customerId + " doesn't exist :(");
		}

	}

	/**
	 * Creates a new lease in the repository.
	 */
	@Override
	public void createLease() {
		lease = new Lease();
		System.out.println("Enter the Lease Id");
		int leaseId = sc.nextInt();
		lease.setLeaseId(leaseId);
		System.out.println("Enter the vehicle Id");
		int VehicleId = sc.nextInt();
		lease.setVehicleId(VehicleId);
		System.out.println("Enter the Customer Id");
		int customerId = sc.nextInt();
		lease.setCustomerId(customerId);
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		sc.nextLine();
		System.out.println("Enter start date (yyyy-MM-dd):");
		String startDateStr = sc.nextLine();
		LocalDate startDate = LocalDate.parse(startDateStr, dateFormatter);
		lease.setStartDate(startDate);
		System.out.println("Enter end date (yyyy-MM-dd):");
		String endDateStr = sc.nextLine();
		LocalDate endDate = LocalDate.parse(endDateStr, dateFormatter);
		lease.setEndDate(endDate);
		System.out.println("Enter the Type");
		String leasetype = sc.next();
		lease.setType(leasetype);
		leaseDao.createLease(lease);

		leaseList.add(lease);
		int vehicleId=lease.getLeaseId();
		vehicleDao.updateVehicle(VehicleId);
		System.out.println("Lease " + lease.getLeaseId() + " " + "sucessfully added");

	}

	/**
	 * Finds a lease by its ID.
	 */
	@Override
	public void findLeaseById() {
		System.out.println("Enter Lease id");
		int LeaseId = sc.nextInt();

		boolean LeaseAvailable = leaseDao.findLeaseById(LeaseId);
		if (LeaseAvailable) {
			System.out.println("Vehicle " + LeaseId + " exists !!!");
		} else {
			System.out.println("Vehicle " + LeaseId + " doesn't exist :(");
		}

	}

	/**
	 * Lists all active leases in the repository.
	 */
	@Override
	public void listActiveLeases() {
		// TODO Auto-generated method stub
		leaseDao.listActiveLeaseHistory(lease);
	}

	/**
	 * Lists the lease history.
	 */
	@Override
	public void listLeaseHistory() {
		leaseDao.listLeaseHistory(lease);
	}

	/**
	 * Creates a payment entry.
	 */
	@Override
	public void createPayment() {
		payment = new Payment();
		System.out.println("Enter the Payment Id");
		int paymentId = sc.nextInt();
		payment.setPaymentId(paymentId);
		System.out.println("Enter the Lease Id");
		int leaseId = sc.nextInt();
		payment.setLeaseId(leaseId);
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		sc.nextLine();
		System.out.println("Enter the Transaction Date (yyyy-MM-dd):");
		String str = sc.nextLine();
		LocalDate transactionDate = LocalDate.parse(str, dateFormatter);
		payment.setPaymentDate(transactionDate);
		System.out.println("Enter the amount");
		double amount = sc.nextDouble();
		payment.setAmount(amount);
		paymentList.add(payment);
		paymentDao.addPayment(payment);
		System.out.println("Payment " + payment.getPaymentId() + " " + "sucessfully added");
	}

	/**
	 * Lists payment details.
	 */
	@Override
	public void listPaymentDetails() {
		paymentDao.paymentList(payment);

	}

}
