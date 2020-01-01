package com.primesh.BbankMaven;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.primesh.BbankMaven.AuthenticationServer.JsonTokenNeeded;

import controllers.CustomerResponse;
import models.Customer;


@Path("customers")
public class CustomerResource {
	
	CustomerResponse customerResponse = new CustomerResponse();
	@JsonTokenNeeded
    @GET
	public List<Customer> getCustomers() 
	{
		return customerResponse.getCustomers();
	}
}



