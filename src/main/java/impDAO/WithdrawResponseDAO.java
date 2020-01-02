package impDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.WithdrawDAO;
import databaseConnection.CentralServer;
import models.Withdraw;

public class WithdrawResponseDAO implements WithdrawDAO{
	CentralServer customerRepo = CentralServer.getInstance();
	private PreparedStatement st = null;
	private ResultSet resultSet = null;

	@Override
	public void addWithdrawl(Withdraw withdraw) throws SQLException {
		// TODO Auto-generated method stub		
//		String queryString = "insert into withdrawmoney values(?,?,?,?,?,current_time)";
		
		String sql = "call withdrawMoneyN(?,current_timestamp,?,?,?,?)";
		
		st = customerRepo.getConnection().prepareStatement(sql);
		
		st.setFloat(1, withdraw.getAmount());
		st.setInt(2, withdraw.getMobileAgentID());
		st.setInt(3, withdraw.getCustomerID());
		st.setInt(4, withdraw.getPriority());
		st.setInt(5, withdraw.getAccountNo());
		
		st.executeUpdate();
		System.out.println("Withdrawl Added Successfully for customer: ");
		
	}
	
}
