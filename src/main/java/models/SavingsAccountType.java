package models;

public class SavingsAccountType {
	private int typeID;
	private float minAccountBalance;
	private float interestRate;
	
	public SavingsAccountType(int typeID,float minAccountBalance, float interestRate) {
		this.typeID = typeID;
		this.interestRate = interestRate;
		this.minAccountBalance = minAccountBalance;
	}
	
	public int getTypeID() {
		return typeID;
	}
	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}
	public float getMinAccountBalance() {
		return minAccountBalance;
	}
	public void setMinAccountBalance(float minAccountBalance) {
		this.minAccountBalance = minAccountBalance;
	}
	public float getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}
}
