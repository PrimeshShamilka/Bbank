package DAO;
import java.sql.SQLException;
import java.util.List;

import models.Customer;

public interface CustomerDAO {
	
//	public void addCustomer(Customer customer) throws SQLException;
	
//	public Customer getCustomer(int customerID) throws SQLException;
	
//	public void removeCustomer(int customerID) throws SQLException;
	
//	public void updateCustomer(Customer customer) throws SQLException;
	
	public List<Customer> getCustomerList() throws SQLException;
}
