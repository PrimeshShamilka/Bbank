package models;

public class Customer {
	private String firstName;
	private String lastName;
	private int customerID;
	private int NIC;
	private int pinNo;
	private String password;
	private int mobileNo;
	private MobileAgent mobileAgent;
	
	public Customer() {
		
	}
	
	public Customer(int customerID) {
		this.customerID = customerID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public int getNIC() {
		return NIC;
	}
	public void setNIC(int nIC) {
		NIC = nIC;
	}
	public int getPinNo() {
		return pinNo;
	}
	public void setPinNo(int pinNo) {
		this.pinNo = pinNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}
	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", customerID=" + customerID + ", NIC="
				+ NIC + ", pinNo=" + pinNo + ", password=" + password + ", mobileNo="
				+ mobileNo + "]";
	}
	public MobileAgent getMobileAgent() {
		return mobileAgent;
	}
	public void setMobileAgent(MobileAgent mobileAgent) {
		this.mobileAgent = mobileAgent;
	}
	
}
