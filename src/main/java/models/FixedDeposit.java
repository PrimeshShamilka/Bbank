package models;

import java.sql.Timestamp;

public class FixedDeposit extends Account{
	
	public FixedDeposit(int accountNo, float accountBalance, Customer customer) {
		super(accountNo, accountBalance, customer);
		// TODO Auto-generated constructor stub
	}
	
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
