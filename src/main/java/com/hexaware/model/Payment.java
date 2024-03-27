package com.hexaware.model;

import java.time.LocalDate;

/**
 * The Payment class represents a payment entity.
 */
public class Payment {
	private int paymentId; // Unique identifier for the payment
	private int leaseId; // Identifier for the associated lease
	private LocalDate paymentDate; // Date of the payment
	private double amount; // Amount of the payment

	/**
	 * Constructs a new Payment object with default values.
	 */
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructs a new Payment object with the specified attributes.
	 * 
	 * @param paymentId   The unique identifier for the payment.
	 * @param leaseId     The identifier for the associated lease.
	 * @param paymentDate The date of the payment.
	 * @param amount      The amount of the payment.
	 */
	public Payment(int paymentId, int leaseId, LocalDate paymentDate, double amount) {
		super();
		this.paymentId = paymentId;
		this.leaseId = leaseId;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}

	/**
	 * Retrieves the payment's unique identifier.
	 * 
	 * @return The unique identifier of the payment.
	 */
	public int getPaymentId() {
		return paymentId;
	}

	/**
	 * Sets the payment's unique identifier.
	 * 
	 * @param paymentId The unique identifier to set.
	 */
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	/**
	 * Retrieves the identifier of the associated lease.
	 * 
	 * @return The identifier of the associated lease.
	 */
	public int getLeaseId() {
		return leaseId;
	}

	/**
	 * Sets the identifier of the associated lease.
	 * 
	 * @param leaseId The identifier to set.
	 */
	public void setLeaseId(int leaseId) {
		this.leaseId = leaseId;
	}

	/**
	 * Retrieves the date of the payment.
	 * 
	 * @return The date of the payment.
	 */
	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	/**
	 * Sets the date of the payment.
	 * 
	 * @param paymentDate The date to set.
	 */
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	/**
	 * Retrieves the amount of the payment.
	 * 
	 * @return The amount of the payment.
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * Sets the amount of the payment.
	 * 
	 * @param amount The amount to set.
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * Returns a string representation of the Payment object.
	 * 
	 * @return A string representation of the Payment object.
	 */
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", leaseId=" + leaseId + ", paymentDate=" + paymentDate + ", amount="
				+ amount + "]";
	}

}
