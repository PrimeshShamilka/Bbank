package models;

public class Account {
	private int accountNo;
	private float accountBalance;
	private Customer customer;
	
	public Account(int accountNo, float accountBalance, Customer customer) {
		this.accountNo = accountNo;
		this.accountBalance = accountBalance;
		this.customer = customer;
	}
	
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public float getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(float accountBalance) {
		this.accountBalance = accountBalance;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	

}
