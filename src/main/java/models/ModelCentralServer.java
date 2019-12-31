package models;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ModelCentralServer {
	
	private static ModelCentralServer centralServerDB;
	private Connection connection;
	private String url = "jdbc:mysql://localhost:3306/test2";
	private String username = "root";
	private String password = "password";
	
	private ModelCentralServer() throws SQLException
	{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Database Connection Creation Failed : " + e.getMessage());
        }
	}
	
    public Connection getConnection() {
        return connection;
    }

    public static ModelCentralServer getInstance(){
    	try {
            if (centralServerDB == null) {
            	centralServerDB = new ModelCentralServer();
            } else if (centralServerDB.getConnection().isClosed()) {
            	centralServerDB = new ModelCentralServer();
            }

            return centralServerDB;
    	}catch(SQLException e) {
    		System.out.println("Database Error!..");
    		return centralServerDB;
    	}
    }
		
	
//	public List<Customer> getCustomers()
//	{
//		List<Customer> customers = new ArrayList<>();
//		String sql = "select * from customers";
//		try {
//			Statement st = con.createStatement();
//			ResultSet rs = st.executeQuery(sql);
//			while(rs.next()) 
//			{
//				System.out.println("in");
//				Customer c = new Customer();
//				c.setCustomerID(rs.getInt(1));
//				
//				customers.add(c);
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		
//		return customers;
//	}
	
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
