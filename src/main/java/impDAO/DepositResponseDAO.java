package impDAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import DAO.DepositDAO;
import databaseConnection.CentralServer;
import models.Deposit;

public class DepositResponseDAO implements DepositDAO{
	
	CentralServer customerRepo = CentralServer.getInstance();

	public void addDeposit(Deposit deposit) throws SQLException
	{
		System.out.println("deposit to savings account");
		
//		String queryDeposit = "INSERT INTO depositmoney VALUES (?,?,?,?,?,current_date)";	
		String sql = "call depositMoneyN(?,current_timestamp,?,?,?,?)";

		PreparedStatement st = customerRepo.getConnection().prepareStatement(sql);
		st.setFloat(1,deposit.getAmount());
		st.setInt(2,deposit.getMobileAgentID());
		st.setInt(3,deposit.getCustomerID());
		st.setInt(4,deposit.getPriority());
		st.setInt(5,deposit.getAccountNo());	
		
		st.executeUpdate();
		st.close();
			


		
	}
}
