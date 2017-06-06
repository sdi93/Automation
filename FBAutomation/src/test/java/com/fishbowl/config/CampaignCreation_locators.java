package com.fishbowl.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class CampaignCreation_locators
{

public static Properties pro;
	
	public CampaignCreation_locators()
	{
		try
		{
			File f= new File("D:/gitcode/SelAutomation/FBAutomation/Locators/CreateCampaignLocators.property");
			FileInputStream fis =  new FileInputStream(f);
			pro = new Properties();
			pro.load(fis);
		}
	    catch (Exception e)
		    {
				
				System.out.println(e.getMessage());
			}
	}
	
	public  String button_createCampaign()
	{
		String button_createCampaign=pro.getProperty("button_createCampaign");
		return button_createCampaign;
	    
	}
	
	public  String sms_typeCampaign()
	{
		String sms_typeCampaign =pro.getProperty("sms_typeCampaign");
		
		return sms_typeCampaign;
	    
	}
	
	public  String dropd_smsType()
	{
		String dropd_smsType =pro.getProperty("dropd_smsType");
		
		return dropd_smsType;
	    
	}
	
	public  String dd_broadcast()
	{
		String dd_broadcast =pro.getProperty("dd_broadcast");
		
		return dd_broadcast;
	    
	}
	
	public  String dd_informational()
	{
		String dd_informational = pro.getProperty("dd_informational");
		
		return dd_informational;
	    
	}
	
	public  String dd_acquisition()
	{
		String dd_acquisition = pro.getProperty("dd_acquisition");
		
		return dd_acquisition;
	    
	}
	
	public  String dd_triggered()
	{
		String dd_triggered = pro.getProperty("dd_triggered");
		
		return dd_triggered;
	    
	}
	
	public  String textbox_campName()
	{
		String textbox_campName = pro.getProperty("textbox_campName");
		
		return textbox_campName;
	    
	}
	
	public String campDesc()
	{
		String campDesc = pro.getProperty("campDesc");
		
		return campDesc;
	    
	}
	
	public  String campKeyword_info()
	{
		String campKeyword_info = pro.getProperty("campKeyword_info");
		
		return campKeyword_info;
	    
	}
	
	
	public  String campKeyword_acq()
	{
		String campKeyword_acq = pro.getProperty("campKeyword_acq");
		
		return campKeyword_acq;
	    
	}
	
	public  String promotion_dropdown()
	{
		String promotion_dropdown = pro.getProperty("promotion_dropdown");
		
		return promotion_dropdown;
	    
	}
	
	public  String zip_append()
	{
		String zip_append = pro.getProperty("zip_append");
		
		return zip_append;
	    
	}
	
	public  String zipSelector_dropdown()
	{
		String zipSelector_dropdown = pro.getProperty("zipSelector_dropdown");
		
		return zipSelector_dropdown;
	    
	}
	
	public  String button_continue()
	{
		String button_continue = pro.getProperty("button_continue");
		
		return button_continue;
	    
	}
	
	public  String defCamp_textbox()
	{
		String defCamp_textbox = pro.getProperty("defCamp_textbox");
		
		return defCamp_textbox;
	    
	}
	
	public  String defCamp_dropdown()
	{
		String defCamp_dropdown = pro.getProperty("defCamp_dropdown");
		
		return defCamp_dropdown;
	    
	}
	
	public  String button_saveNext()
	{
		String button_saveNext = pro.getProperty("button_saveNext");
		
		return button_saveNext;
	    
	}
	
	public  String button_saveContinue()
	{
		String button_saveContinue = pro.getProperty("button_saveContinue");
		
		return button_saveContinue;
	    
	}
	
	public  String radiobtn_store()
	{
		String radiobtn_store = pro.getProperty("radiobtn_store");
		
		return radiobtn_store;
	    
	}
	
	public  String radiobtn_ExtSegment()
	{
		String radiobtn_ExtSegment = pro.getProperty("radiobtn_ExtSegment");
		
		return radiobtn_ExtSegment;
	    
	}
	
	public  String sendNow_radiobtn()
	{
		String sendNow_radiobtn = pro.getProperty("sendNow_radiobtn");
		
		return sendNow_radiobtn;
	    
	}
	
	public  String publish_button()
	{
		String publish_button = pro.getProperty("publish_button");
		
		return publish_button;
	    
	}
	
	public  String confirmation_message()
	{
		String confirmation_message = pro.getProperty("confirmation_message");
		
		return confirmation_message;
	    
	}
	
	public  String welcome_message()
	{
		String welcome_message = pro.getProperty("welcome_message");
		
		return welcome_message;
	    
	}
	
	public  String existing_message()
	{
		String existing_message = pro.getProperty("existing_message");
		
		return existing_message;
	    
	}
	
	public  String invalid_message()
	{
		String invalid_message = pro.getProperty("invalid_message");
		
		return invalid_message;
	    
	}
	
}
