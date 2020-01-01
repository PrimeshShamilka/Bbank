package controllers;

import java.sql.Timestamp;

import databaseConnection.CentralServer;

public class TransactionResponse {
	CentralServer customerRepo = CentralServer.getInstance();
	
	public void savingsAccountDeposit(int transactionID, 
										String transactionType, 
										int mobileAgentID, 
										int customerID, 
										float transactionAmount, 
										String transactionPriority,
										Timestamp time,
										int accountNo
										) 
	{
		System.out.println("deposit to savings account");
	}
}
