package com.primesh.BbankMaven;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
	
	List<Customer> customers;
	
	public CustomerRepository() {
		customers = new ArrayList<>();
		
		Customer c = new Customer();
		c.setFirstName("test");
		c.setCustomerID(1);
		
		Customer c1 = new Customer();
		c1.setFirstName("test1");
		
		customers.add(c);
		customers.add(c1);
		
	}
	
	public List<Customer> getCustomers()
	{
		return customers;
	}
	
	public Customer getCustomer(int customerID) 
	{
		for (Customer c: customers) {
			if(c.getCustomerID()==customerID) {
				return c;
			}
		}
		
		return null;
	}

	public void addCustomer(Customer c)
	{
		customers.add(c);
	}
}
