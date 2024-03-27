package com.hexaware.view;

import java.util.Scanner;
import com.hexaware.controller.IcarLeaseRepositoryImpl;
import com.hexaware.controller.IcarRepository;
import com.hexaware.exception.CarNotFoundException;

/**
 * This class contains the main method to start the Car Rental System application.
 */
public class CarRentalMain {
	
	/**
     * Default constructor for the CarRentalMain class.
     * This constructor is provided by default.
     * It initializes the CarRentalMain object.
     */
    public CarRentalMain() {
        // Constructor code
    }
    /**
     * Main method to start the Car Rental System application.
     * 
     * @param args The command-line arguments passed to the application.
     */
	public static void main(String[] args) {
		// Instantiate the car lease repository
		IcarRepository Rc = new IcarLeaseRepositoryImpl();
		String ch = null;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("1.Car");
			System.out.println("2.Customer");
			System.out.println("3.Lease");
			System.out.println("4.Payment");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("1.Add car");
				System.out.println("2.Remove car");
				System.out.println("3.List Available cars");
				System.out.println("4.List Rentended cars");
				System.out.println("5.Find a car by carId");
				int c = sc.nextInt();
				switch (c) {
				case 1: {
					Rc.addCar();
					break;
				}
				case 2: {
					Rc.removeCar();
					break;
				}
				case 3: {
					Rc.listAvailableCars();
					break;
				}
				case 4: {
					Rc.listRentedCars();
					break;
				}
				case 5: {
					Rc.findCarById();
					break;
				}
				default: {
					System.out.println("Enter the right choice. ");
				}
				}
				break;
			}
			case 2: {
				System.out.println("1.Add Customer");
				System.out.println("2.Remove Customer");
				System.out.println("3.List Customer");
				System.out.println("4.Find a customer by CustomerId");
				int c = sc.nextInt();
				switch (c) {
				case 1: {
					Rc.addCustomer();
					break;
				}
				case 2: {
					Rc.removeCustomer();
					break;
				}
				case 3: {
					Rc.listCustomer();
					break;
				}
				case 4: {
					Rc.findCustomerById();
					break;
				}
				default: {
					System.out.println("Enter the right choice. ");
				}
				}
				break;
			}
			case 3: {
				System.out.println("1.Create Lease");
				System.out.println("2.Find a Lease by LeaseId");
				System.out.println("3.List Active Lease");
				System.out.println("4.List lease History");
				int c = sc.nextInt();
				switch (c) {
				case 1: {
					Rc.createLease();
					break;
				}
				case 2: {
					Rc.findLeaseById();
					break;
				}
				case 3: {
					Rc.listActiveLeases();
					break;
				}
				case 4: {
					Rc.listLeaseHistory();
					break;
				}
				default: {
					System.out.println("Enter the right choice. ");
				}
				}
				break;
			}
			case 4: {
				System.out.println("1.Add Payment ");
				System.out.println("2.payment Details");
				int c = sc.nextInt();
				switch (c) {
				case 1: {
					Rc.createPayment();
					break;
				}
				case 2: {
					Rc.listPaymentDetails();
					break;
				}
				default: {
					System.out.println("Enter the right choice. ");
				}
				}
				break;
			}
			default: {
				System.out.println("Enter the right choice. ");
			}
			}
			System.out.println("Do you want to continue? Y or y");
			ch = sc.next();
		} while (ch.equals("Y") || ch.equals("y"));
		System.out.println("Thanks for using our system !!!");
		System.exit(0);
	}

}
