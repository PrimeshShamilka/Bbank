package DAO_imp;

public class MobileAgent {
	private int AgentID;
	private int DeviceID;
	private String DevicePassword;
	private int AgentMobileNo;
	private Customer customer;
	
	public int getAgentID() {
		return AgentID;
	}
	public void setAgentID(int agentID) {
		AgentID = agentID;
	}
	public int getDeviceID() {
		return DeviceID;
	}
	public void setDeviceID(int deviceID) {
		DeviceID = deviceID;
	}
	public String getDevicePassword() {
		return DevicePassword;
	}
	public void setDevicePassword(String devicePassword) {
		DevicePassword = devicePassword;
	}
	public int getAgentMobileNo() {
		return AgentMobileNo;
	}
	public void setAgentMobileNo(int agentMobileNo) {
		AgentMobileNo = agentMobileNo;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
