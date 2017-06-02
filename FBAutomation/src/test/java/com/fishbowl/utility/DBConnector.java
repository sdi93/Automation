package com.fishbowl.utility;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

	public static int dbCheck(String dbUrl,String username, String password, String query) throws ClassNotFoundException, SQLException, Throwable
	{
		int campaign_status= 0;
		try
		{	
  	 		
    	    Class.forName("com.mysql.jdbc.Driver");					
    	    Connection con = DriverManager.getConnection(dbUrl,username,password);	
    	    Statement stmt = con.createStatement();					
    	    ResultSet rs= stmt.executeQuery(query);							
    	    
    	    while(rs.next())
    		{
    		    String name = rs.getString("Name");
    			campaign_status = rs.getInt("CampaignStatus");
    			
    			System.out.println("Name and campaign_status fetched from the database is : " + name + " " + "and" + " " + campaign_status);
    		}
//    	    
    	    rs.close();
			con.close();
    		
		}
	
		catch(Exception e)	
		{
		
		System.out.println(e);
		e.printStackTrace();
		
		
	    }	
			

		
		return campaign_status;
	}
}


