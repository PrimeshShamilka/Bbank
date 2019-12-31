package com.primesh.BbankMaven;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import responses.CustomerResponse;	
import DAO_imp.Customer;


@Path("customers")
public class CustomerResource {
	
	CustomerResponse customerResponse = new CustomerResponse();
	
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
	public List<Customer> getCustomers() 
	{
		return customerResponse.getCustomers();
	}
}

//@Path("customers")
//public class CustomerResource {
//	
//	//	@GET
////	public List<Customer> getCustomers() 
////	{
////		return customerResponse.getCustomers();
////	}
//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    public String getIt() {
//        return "Got it!";
//    }
//	
////	@GET
////	@Path("customer/{customerID}")
////	public Customer getCustomer(@PathParam("customerID") int customerID) 
////	{
////		return customerRepo.getCustomer(customerID);
////	}	
////	
////	
////	@POST
////	@Path("customer")
////	public Customer addCustomer(Customer c) 
////	{
////		System.out.println(c);
////		customerRepo.addCustomer(c);
////		return c;
////	}
//}



