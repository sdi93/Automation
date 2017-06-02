package com.fishbowl.testcases;

import com.fishbowl.utility.DBConnector;
import com.fishbowl.utility.Reporting;

public class Database_testing
{
	Reporting rep = new Reporting();
	
	public void databaseTest(String campaignname) throws Throwable
	{
		rep.logger=rep.report.startTest("Campaign Database testing");
		
	 try
	 {
	  
          String query = "SELECT Name, CampaignStatus FROM jamba_stg.Campaign WHERE NAME ='"+campaignname+"' LIMIT 1";
	   
          Thread.sleep(50000);
          
		  int campaign_status = DBConnector.dbCheck("jdbc:mysql://10.80.60.65:4008","app_common","1@WSXCDE#4",query);
	   
		  if(campaign_status == 4)
	   
	      {
	         System.out.println("Campaign is completed and campaign status is : " + campaign_status);
	         
	    
	      }
		  
	   else
	   {
		   
	     System.out.println("Campaign is not completed and campaign status is : " + campaign_status);
	    
	   }
		  
	       rep.report_status_pass("Database connected");
	  }
 
	 catch(Exception e)
	 {
		 
	   rep.report_status_fail("Database_snap","Database not connected");
	 
	  
	 }
	 
   }
}
