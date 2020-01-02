package impDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.SavingsAccountDAO;
import DAO.SavingsAccountTypeDAO;
import databaseConnection.CentralServer;
import models.Customer;
import models.SavingsAccount;
import models.SavingsAccountType;

public class SavingsAccountResponseDAO implements SavingsAccountDAO{
	CentralServer customerRepo = CentralServer.getInstance();
	private PreparedStatement st = null;
	private PreparedStatement st2 = null;
	private ResultSet resultSet = null;
	private ResultSet customerResultSet = null;
	
	public SavingsAccount getAccount(int accountID) throws SQLException {
		
		// First get the account balance, account type from account table
		String queryString = "SELECT * FROM savingsaccount where SAccountNo=?";
		st = customerRepo.getConnection().prepareStatement(queryString);
		st.setInt(1, accountID);
		resultSet = st.executeQuery();
		resultSet.first();
		float balance = resultSet.getFloat("Balance");
		int accountTypeID = resultSet.getInt("SATypeID");
		
		
		// Second get the owner of the account from holds table
		String userqueryString = "SELECT * FROM holds WHERE SAccountNo = ?";
		st2 = customerRepo.getConnection().prepareStatement(userqueryString);
		st2.setInt(1, accountID);
		customerResultSet = st2.executeQuery();
		customerResultSet.first();
		int customerID = customerResultSet.getInt("userID");
		Customer c = new Customer(customerID);
		
		
		// Third get the account type information
		SavingsAccountTypeDAO atd = new SavingsAccountTypeResponseDAO();
		SavingsAccountType at =  atd.getAccountType(accountTypeID);
		
		SavingsAccount account = new SavingsAccount(accountID,balance, c, at );
		return account;
	}

}
