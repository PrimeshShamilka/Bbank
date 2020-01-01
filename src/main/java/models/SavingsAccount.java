package models;

public class SavingsAccount extends Account{
	private SavingsAccountType savingsAccountType;

	public SavingsAccountType getSavingsAccountType() {
		return savingsAccountType;
	}

	public void setSavingsAccountType(SavingsAccountType savingsAccountType) {
		this.savingsAccountType = savingsAccountType;
	}
	
}
