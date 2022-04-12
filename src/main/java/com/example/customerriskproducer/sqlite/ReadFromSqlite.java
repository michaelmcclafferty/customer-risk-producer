package com.example.customerriskproducer.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.customerriskproducer.models.CustomerRisk;


public class ReadFromSqlite {

	private Connection c = null;
	private Statement stmt = null;
	private List<CustomerRisk> customerRiskList = new ArrayList<CustomerRisk>();
	
	public List<CustomerRisk> openConnectionFromSqlLite() {
		   try {
			      Class.forName("org.sqlite.JDBC");
			      c = DriverManager.getConnection("jdbc:sqlite:C:/sqlite/dbConnection/customer.db");
			      c.setAutoCommit(false);
			      System.out.println("Opened database successfully");
			     
					stmt = c.createStatement();
				      ResultSet rs = stmt.executeQuery( "SELECT * FROM marketing;" );
				      while ( rs.next() ) {
				          int id = rs.getInt("id");
				          boolean crypto = rs.getBoolean("Crypto");
				          boolean gambling = rs.getBoolean("Gambling");
				          boolean atRisk = rs.getBoolean("AtRisk");
				          CustomerRisk customer = new CustomerRisk(id, crypto, gambling, atRisk);
				          customerRiskList.add(customer);
				       }
				      
				       rs.close();
				       stmt.close();
				       c.close();
				       return customerRiskList;
			   } catch ( Exception e ) {
			      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			      System.exit(0);
			   }
		return customerRiskList;
	}
}
