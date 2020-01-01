package models;

import java.sql.Timestamp;

public class Transaction {
	private int transactionID;
	private String transactionType;
	private int mobileAgentID;
	private int customerID;
	private float transactionAmount;
	private String transactionPriority;
	private Timestamp time;
	private int accountNo;
	
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
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public int getMobileAgentID() {
		return mobileAgentID;
	}
	public void setMobileAgentID(int mobileAgentID) {
		this.mobileAgentID = mobileAgentID;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
}
