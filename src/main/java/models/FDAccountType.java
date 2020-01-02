package models;

public class FDAccountType {
	private int FDTypeID;
	private float interestRate;
	private int timeDurationInMonth;
	
	public int getFDTypeID() {
		return FDTypeID;
	}
	public void setFDTypeID(int fDTypeID) {
		FDTypeID = fDTypeID;
	}
	public float getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}
	public int getTimeDurationInMonth() {
		return timeDurationInMonth;
	}
	public void setTimeDurationInMonth(int timeDurationInMonth) {
		this.timeDurationInMonth = timeDurationInMonth;
	}

	
	
}
