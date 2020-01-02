package DAO;

import java.sql.SQLException;
import java.util.List;

import models.Withdraw;

public interface WithdrawDAO {
	
	public void addWithdrawl(Withdraw withdraw) throws SQLException;
	
//	public Withdraw getWithdrawl (int withdrawl_ID) throws SQLException;
//	
//	public void removeWithdrawl(int withdrawl_ID) throws SQLException;
//	
//	public void updateBalance(Withdraw withdrawl) throws SQLException;
//	
//	public List<Withdraw > getWithdrawlList() throws SQLException;
}
