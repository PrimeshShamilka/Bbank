package com.primesh.BbankMaven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
		
	Connection con;
	
	public CustomerRepository() {
		
		String url = "jdbc:mysql://localhost:3306/test";
		String username = "root";
		String password = "password";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) 
		{
			System.out.println(e);
		}
	}
	
	public List<Customer> getCustomers()
	{
		List<Customer> customers = new ArrayList<>();
		String sql = "select * from customers";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) 
			{
				System.out.println("in");
				Customer c = new Customer();
				c.setCustomerID(rs.getInt(1));
				
				customers.add(c);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return customers;
	}
	
//	public Customer getCustomer(int customerID) 
//	{
//		for (Customer c: customers) {
//			if(c.getCustomerID()==customerID) {
//				return c;
//			}
//		}
//		
//		return null;
//	}
//
//	public void addCustomer(Customer c)
//	{
//		customers.add(c);
//	}
}
