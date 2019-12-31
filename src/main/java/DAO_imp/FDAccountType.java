package DAO_imp;

public class FDAccountType {
	private int FDTypeID;
	private float interestRate;
	private int timeDurationInYears;
	
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
	public int getTimeDurationInYears() {
		return timeDurationInYears;
	}
	public void setTimeDurationInYears(int timeDurationInYears) {
		this.timeDurationInYears = timeDurationInYears;
	}
	
	
}
