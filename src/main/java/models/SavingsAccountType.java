package models;

public class SavingsAccountType {
	private int typeID;
	private float minAccountBalance;
	private float interestRate;
	private int timeDurationInYears;
	
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
	public int getTimeDurationInYears() {
		return timeDurationInYears;
	}
	public void setTimeDurationInYears(int timeDurationInYears) {
		this.timeDurationInYears = timeDurationInYears;
	}
	
	
}
