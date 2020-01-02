package models;

import java.sql.Timestamp;

// mobile deposit
public class Deposit {

	private int DepositID;
	private int mobileAgentID;
	private int customerID;
	private float amount;
	private int priority;
	private Timestamp time;
	private int accountNo;
	
	public int getDepositID() {
		return DepositID;
	}
	public void setDepositID(int depositID) {
		DepositID = depositID;
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
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
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
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
}
