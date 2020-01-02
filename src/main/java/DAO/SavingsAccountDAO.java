package DAO;

import java.sql.SQLException;
import java.util.List;

import models.SavingsAccount;

public interface SavingsAccountDAO {
	
//	public void addAccount(SavingsAccount account) throws SQLException;
//	
	public SavingsAccount getAccount(int accountID) throws SQLException;
//	
//	public void removeAccount(int accountID) throws SQLException;
//	
//	public void updateBalance(SavingsAccount account) throws SQLException;
//	
//	public List<SavingsAccount> getAccountList() throws SQLException;
}
