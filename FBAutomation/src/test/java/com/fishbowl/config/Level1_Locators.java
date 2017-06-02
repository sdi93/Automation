package com.fishbowl.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Level1_Locators 
{
    
	public static Properties pro;
	
	public Level1_Locators()
	{
		try
		{
			File f= new File("/SeleniumWorkspace/ws1/FBAutomation/Level1_Locators.property");
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
	
	
}
