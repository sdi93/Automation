package com.fishbowl.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class GA_L1_Locators 
{
    
	public static Properties pro;
	
	public GA_L1_Locators()
	{
		try
		{
			File f= new File("/FishbowlGitCode/FBAutomation/Locators/GA_L1Locators.property");
			FileInputStream fis =  new FileInputStream(f);
			pro = new Properties();
			pro.load(fis);
		}
	    catch (Exception e)
		    {
				
				System.out.println(e.getMessage());
			}
	}
	
	public  String get_L1_L1_link()
	{
		String L1_l1_link=pro.getProperty("L1_L1");
		System.out.println(L1_l1_link);
		return L1_l1_link;
	    
	}
	
	public  String get_L1_L2_link()
	{
		String L1_l2_link=pro.getProperty("L1_L2");
		System.out.println(L1_l2_link);
		return L1_l2_link;
	    
	}
	
	public  String get_L1_L3_link()
	{
		String L1_l3_link=pro.getProperty("L1_L3");
		System.out.println(L1_l3_link);
		return L1_l3_link;
	    
	}
	
	public  String get_L1_L4_link()
	{
		String L1_l4_link=pro.getProperty("L1_L4");
		System.out.println(L1_l4_link);
		return L1_l4_link;
	    
	}
	
	public  String get_L1_L5_link()
	{
		String L1_l5_link=pro.getProperty("L1_L5");
		System.out.println(L1_l5_link);
		return L1_l5_link;
	    
	}
	
	public  String get_L1_L6_link()
	{
		String L1_l6_link=pro.getProperty("L1_L6");
		System.out.println(L1_l6_link);
		return L1_l6_link;
	    
	}
	
	public  String get_L1_L7_link()
	{
		String L1_l7_link=pro.getProperty("L1_L7");
		System.out.println(L1_l7_link);
		return L1_l7_link;
	    
	}
	
	public  String get_L1_L8_link()
	{
		String L1_l8_link=pro.getProperty("L1_L8");
		System.out.println(L1_l8_link);
		return L1_l8_link;   
	}

	public  String get_L1_buttonPeriod()
	{
		String  L1_buttonPeriod=pro.getProperty("L1_buttonPeriod");
		return  L1_buttonPeriod;   
	}
	
	public  String get_L1_buttonQuater()
	{
		String  L1_buttonQuater=pro.getProperty("L1_buttonQuater");
		return  L1_buttonQuater;   
	}
	
	public  String get_L1_buttonYear()
	{
		String  L1_buttonYear=pro.getProperty("L1_buttonYear");
		return  L1_buttonYear;   
	}
	
	public  String get_L1_buttonApply()
	{
		String  L1_buttonApply=pro.getProperty("L1_buttonApply");
		return  L1_buttonApply;   
	}
	
	public  String get_L1_L1_TD()
	{
		String  L1_L1_TD=pro.getProperty("L1_L1_TD");
		return  L1_L1_TD;   
	}
	
	public  String get_L1_L2_TD()
	{
		String  L1_L2_TD=pro.getProperty("L1_L2_TD");
		return  L1_L2_TD;   
	}
	
	public  String get_L1_L3_TD()
	{
		String  L1_L3_TD=pro.getProperty("L1_L3_TD");
		return  L1_L3_TD;   
	}
	
	public  String get_L1_L4_TD()
	{
		String  L1_L4_TD=pro.getProperty("L1_L4_TD");
		return  L1_L4_TD;   
	}
	
	public  String get_L1_L5_TD()
	{
		String  L1_L5_TD=pro.getProperty("L1_L5_TD");
		return  L1_L5_TD;   
	}
	
	public  String get_L1_L7_TD()
	{
		String  L1_L7_TD=pro.getProperty("L1_L7_TD");
		return  L1_L7_TD;   
	}
	
	public  String get_L1_L8_TD()
	{
		String  L1_L8_TD=pro.getProperty("L1_L8_TD");
		return  L1_L8_TD;   
	}
	
	public  String get_L1_startDate()
	{
		String  L1_startDate=pro.getProperty("L1_startDate");
		return  L1_startDate;   
	}
	
	public  String get_L1_endDate()
	{
		String  L1_endDate=pro.getProperty("L1_endDate");
		return  L1_endDate;   
	}
	
	public  String get_L1_startend()
	{
		String  L1_startend=pro.getProperty("L1_startend");
		return  L1_startend;   
	}
}
