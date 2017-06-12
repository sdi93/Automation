package com.fishbowl.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class GA_CommonLocators
{
public static Properties pro;
	
	public GA_CommonLocators()
	{
		try
		{
			File f= new File("/FishbowlGitCode/FBAutomation/Locators/GACommmonLocators.property");
			FileInputStream fis =  new FileInputStream(f);
			pro = new Properties();
			pro.load(fis);
		}
	    catch (Exception e)
		    {
				
				System.out.println(e.getMessage());
			}
	}
	
	public  String get_loginUser()
	{
		String loginUser = pro.getProperty("loginUser");
		System.out.println(loginUser);
		return loginUser;
	}
	
	public  String get_password()
	{
		String password = pro.getProperty("password");
		System.out.println(password);
		return password;
	}
	
	public  String get_loginButton()
	{
		String loginButton = pro.getProperty("loginButton");
		System.out.println(loginButton);
		return loginButton;
	}
	
	public  String get_L1_allbrand()
	{
		String L1_allbrand = pro.getProperty("L1_allbrand");
		return L1_allbrand;
	}
	
	public  String get_L1_brandText()
	{
		String L1_brandText = pro.getProperty("L1_brandText");
		return L1_brandText;
	}
	
	public  String get_L1_storepath()
	{
		String L1_storepath = pro.getProperty("L1_storepath");
		return L1_storepath;
	}
	
	public  String get_L1_storelist()
	{
		String L1_storelist = pro.getProperty("L1_storelist");
		return L1_storelist;
	}

	public  String get_backButton()
	{
		String backButton = pro.getProperty("backButton");
		return backButton;
	}
}
