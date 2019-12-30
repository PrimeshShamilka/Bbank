package com.primesh.BbankMaven;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("customers")
public class CustomerResource {
	
	CustomerRepository customerRepo = new CustomerRepository();
	
	@GET
	public List<Customer> getCustomers() 
	{
		return customerRepo.getCustomers();
	}	
	
//	@GET
//	@Path("customer/{customerID}")
//	public Customer getCustomer(@PathParam("customerID") int customerID) 
//	{
//		return customerRepo.getCustomer(customerID);
//	}	
//	
//	
//	@POST
//	@Path("customer")
//	public Customer addCustomer(Customer c) 
//	{
//		System.out.println(c);
//		customerRepo.addCustomer(c);
//		return c;
//	}
}
