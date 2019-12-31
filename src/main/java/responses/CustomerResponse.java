package responses;
import models.ModelCentralServer;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import java.sql.ResultSet;
import DAO_imp.Customer;

public class CustomerResponse {
	
	ModelCentralServer customerRepo = ModelCentralServer.getInstance();
	
	public List<Customer> getCustomers()
	{
		List<Customer> customers = new ArrayList<>();
		String sql = "select * from customers";
		try {
			Statement st = customerRepo.getConnection().createStatement();
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

}
