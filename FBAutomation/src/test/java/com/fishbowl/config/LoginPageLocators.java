package com.fishbowl.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class LoginPageLocators 
{
    
	public static Properties pro;
	
	public LoginPageLocators()
	{
		try
		{
			File f= new File("/SeleniumWorkspace/ws1/FBAutomation/Locators/LoginPageLocators.property");
			FileInputStream fis =  new FileInputStream(f);
			pro = new Properties();
			pro.load(fis);
		}
	    catch (Exception e)
		    {
				
				System.out.println(e.getMessage());
			}
	}
	
	public  String get_username()
	{
		String username=pro.getProperty("Username");
		return username;
	    
	}
	
	public  String get_password()
	{
		String password=pro.getProperty("Password");
		return password;
	    
	}
	
	public  String get_login_btn()
	{
		String login_btn=pro.getProperty("Login_button");
		return login_btn;
	    
	}
	
	
	
	
}
