package com.primesh.BbankMaven;
import java.sql.SQLException;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.primesh.BbankMaven.AuthenticationServer.JsonTokenNeeded;

import DAO.SavingsAccountDAO;
import impDAO.CustomerResponseDAO;
import impDAO.DepositResponseDAO;
import impDAO.SavingsAccountResponseDAO;
import impDAO.WithdrawResponseDAO;
import models.Customer;
import models.Deposit;
import models.SavingsAccount;
import models.Withdraw;


@Path("apiService")
public class APIService extends BaseApiService{
	
	CustomerResponseDAO customerResponse = new CustomerResponseDAO();
	@JsonTokenNeeded
    @GET
	public List<Customer> getCustomers() 
	{
		return customerResponse.getCustomerList();
	}
	
	@JsonTokenNeeded
	@POST
	@Path("mDeposit")	
	@Consumes(MediaType.APPLICATION_JSON)
	public Response savingsAccountDeposit(Deposit deposit) {
		DepositResponseDAO depositResponse = new DepositResponseDAO();
		JSONObject obj = new JSONObject();
	

	try {
		System.out.println("in");
		depositResponse.addDeposit(deposit);
		SavingsAccountDAO savingsAccountResponseDAO = new SavingsAccountResponseDAO();
		SavingsAccount account = savingsAccountResponseDAO.getAccount(deposit.getAccountNo());
	    float balance = account.getAccountBalance(); 
	    System.out.println(balance);

	     try {
	    	 obj.put("status", "successful transaction");
	    	 obj.put("accountID", Integer.toString(deposit.getAccountNo()));
	    	 obj.put("balance", Float.toString(balance));
	    	 System.out.println(obj);
	      
	     }catch (JSONException e) {
			
	      	// TODO Auto-generated catch block
	      	 e.printStackTrace();
	     }
		
	    
	}
	catch (SQLException e1) {
		e1.printStackTrace();
	     try {
	    	 obj.put("status", "unsuccessful transaction. please try again");
	
	     }catch (JSONException e) {
	    	 System.out.println("qqq");
	      	 e.printStackTrace();
	     }
	}
	System.out.println(obj);
	
	return Response.ok(obj.toString(), MediaType.APPLICATION_JSON).build();
	

}

		@JsonTokenNeeded
		@POST	
		@Path("mWithdraw")	
		@Consumes(MediaType.APPLICATION_JSON)
		public Response savingsAccountWithdraw(Withdraw withdraw) {
			
			WithdrawResponseDAO withdrawResponse = new WithdrawResponseDAO();
			JSONObject obj = new JSONObject();

			
			try {
				
				withdrawResponse.addWithdrawl(withdraw);
				SavingsAccountDAO savingsAccountResponseDAO = new SavingsAccountResponseDAO();
				SavingsAccount account = savingsAccountResponseDAO.getAccount(withdraw.getAccountNo());
			    float balance = account.getAccountBalance(); 
			    

			     try {
			    	 System.out.println("s");
			    	 obj.put("status", "successful transaction");
			    	 obj.put("accountID", Integer.toString(withdraw.getAccountNo()));
			    	 obj.put("balance", Float.toString(balance));
			    	 
			      
			     }catch (JSONException e) {
			    	 System.out.println("1");
			      	// TODO Auto-generated catch block
			      	 e.printStackTrace();
			     }
				
			    
			}
			catch (SQLException e1) {
			     try {
			    	 obj.put("status", "unsuccessful transaction. please try again");
			
			     }catch (JSONException e) {
			      	 e.printStackTrace();
			     }
			}
			
			return Response.ok(obj.toString(), MediaType.APPLICATION_JSON).build();

				
		}

}



