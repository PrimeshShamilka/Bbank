package impDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.SavingsAccountTypeDAO;
import databaseConnection.CentralServer;
import models.SavingsAccountType;

public class SavingsAccountTypeResponseDAO implements SavingsAccountTypeDAO{
	CentralServer customerRepo = CentralServer.getInstance();
	private PreparedStatement st = null;
	private ResultSet resultSet = null;
	
	@Override
	public SavingsAccountType getAccountType(int accTypeID) throws SQLException {
		// TODO Auto-generated method stub
		String queryString = "SELECT * FROM savingsaccounttype where TypeID=?";
		
		st = customerRepo.getConnection().prepareStatement(queryString);
		st.setInt(1, accTypeID);
		resultSet = st.executeQuery();
		resultSet.first();
		
		// need to parse account type properly
		SavingsAccountType accountType = new SavingsAccountType(accTypeID, resultSet.getInt("MinimumBalance"),resultSet.getInt("InterestRate"));
		return accountType;
	}

}

