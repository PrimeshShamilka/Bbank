package DAO;

import java.sql.SQLException;
import java.util.List;

import models.SavingsAccountType;

public interface SavingsAccountTypeDAO {

//	public void addAccountType(SavingsAccountType accType) throws SQLException;
	
	public SavingsAccountType getAccountType (int accTypeID) throws SQLException;
	
//	public void removeAccountType(int accTypeID) throws SQLException;
//	
//	public void updateAccountType(SavingsAccountType accType) throws SQLException;
//	
//	public List<SavingsAccountType> getAccountTypeList() throws SQLException;
}
