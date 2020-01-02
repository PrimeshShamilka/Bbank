package models;

public class SavingsAccount extends Account{
	private SavingsAccountType savingsAccountType;
	
	public SavingsAccount(int accountNo, float accountBalance, Customer customer, SavingsAccountType accType) {
		super(accountNo, accountBalance, customer);
		this.savingsAccountType = accType;
	}

	public SavingsAccountType getSavingsAccountType() {
		return savingsAccountType;
	}

	public void setSavingsAccountType(SavingsAccountType savingsAccountType) {
		this.savingsAccountType = savingsAccountType;
	}
	
}
