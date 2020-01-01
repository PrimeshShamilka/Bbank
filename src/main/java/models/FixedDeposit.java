package models;

import java.sql.Timestamp;

public class FixedDeposit extends Account{
	private Timestamp openingDate;
	private FDAccountType FDType;
	
	public Timestamp getOpeningDate() {
		return openingDate;
	}
	public void setOpeningDate(Timestamp openingDate) {
		this.openingDate = openingDate;
	}
	public FDAccountType getFDType() {
		return FDType;
	}
	public void setFDType(FDAccountType fDType) {
		FDType = fDType;
	}
	
}
