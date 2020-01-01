package com.primesh.BbankMaven;

import java.sql.Timestamp;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.primesh.BbankMaven.AuthenticationServer.JsonTokenNeeded;

import controllers.TransactionResponse;
import models.Transaction;

@Path("transaction")
public class TransactionResource {
	
	TransactionResponse transactionResponse = new TransactionResponse();
	
	@POST
	@Path("savingsaccdep")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response savingsAccountDeposit(Transaction transaction) {
		int transactionID = transaction.getTransactionID();
		String transactionType = transaction.getTransactionType();
		int mobileAgentID = transaction.getMobileAgentID();
		int customerID = transaction.getCustomerID();
		float transactionAmount = transaction.getTransactionAmount();
		String transactionPriority = transaction.getTransactionPriority();
		Timestamp time = transaction.getTime();
		int accountNo = transaction.getAccountNo();
		
		transactionResponse.savingsAccountDeposit(transactionID, 
													transactionType, 
													mobileAgentID, 
													customerID, 
													transactionAmount, 
													transactionPriority, 
													time, 
													accountNo);
		
		return Response.status(201).entity(transaction).build();
		
	}
}
