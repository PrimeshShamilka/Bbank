package DAO;

import java.sql.SQLException;
import java.util.List;

import models.Deposit;

public interface DepositDAO {
	
	public void addDeposit(Deposit deposit) throws SQLException;
	
//	public Deposit getDeposit (int deposit_ID) throws SQLException;
//	
//	public void removeDeposit(int deposit_ID) throws SQLException;
//	
//	public void updateBalance(Deposit deposit) throws SQLException;
//	
//	public List<Deposit > getDepositList() throws SQLException;
}
