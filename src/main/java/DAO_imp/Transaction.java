package DAO_imp;

import java.sql.Timestamp;

public class Transaction {
	private int transactionID;
	private String transactionType;
	private MobileAgent mobileAgent;
	private Customer customer;
	private float transactionAmount;
	private String transactionPriority;
	private Timestamp time;
	private Account account;
	
	public int getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public MobileAgent getMobileAgent() {
		return mobileAgent;
	}
	public void setMobileAgent(MobileAgent mobileAgent) {
		this.mobileAgent = mobileAgent;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public float getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(float transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getTransactionPriority() {
		return transactionPriority;
	}
	public void setTransactionPriority(String transactionPriority) {
		this.transactionPriority = transactionPriority;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
}
