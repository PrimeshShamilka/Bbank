package databaseConnection;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CentralServer {
	
	private static CentralServer centralServerDB;
	private Connection connection;
	private String url = "jdbc:mysql://localhost:3306/centralfinal";
//	private String url = "jdbc:mysql://localhost:3306/final2";
	private String username = "root";
	private String password = "password";
	
	private CentralServer() throws SQLException
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

    public static CentralServer getInstance(){
    	try {
            if (centralServerDB == null) {
            	centralServerDB = new CentralServer();
            } else if (centralServerDB.getConnection().isClosed()) {
            	centralServerDB = new CentralServer();
            }

            return centralServerDB;
    	}catch(SQLException e) {
    		System.out.println("Database Error!..");
    		return centralServerDB;
    	}
    }
}
