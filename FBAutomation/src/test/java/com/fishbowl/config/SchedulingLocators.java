package com.fishbowl.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class SchedulingLocators 
{

		public static Properties pro;
		
		public SchedulingLocators()
		{
			try
			{
				File f= new File("D:/gitcode/SelAutomation/FBAutomation/Locators/Scheduling_Locators.property");
				FileInputStream fis =  new FileInputStream(f);
				pro = new Properties();
				pro.load(fis);
			}
		    catch (Exception e)
			    {
					
					System.out.println(e.getMessage());
				}
		}
		
		public  String respose_confirm_txtbox()
		{
			String respose_confirm_txtbox=pro.getProperty("respose_confirm_txtbox");
			return respose_confirm_txtbox;
		    
		}
		
		public  String welcome_txtbox()
		{
			String welcome_txtbox=pro.getProperty("welcome_txtbox");
			return welcome_txtbox;
		    
		}
		
		public  String existing_members_txtbox()
		{
			String existing_members_txtbox=pro.getProperty("existing_members_txtbox");
			return existing_members_txtbox;
		    
		}
		
		public  String invalid_msg_txtbox()
		{
			String invalid_msg_txtbox=pro.getProperty("invalid_msg_txtbox");
			return invalid_msg_txtbox;
		    
		}
		
		public  String response_submit_button()
		{
			String response_submit_button=pro.getProperty("response_submit_button");
			return response_submit_button;
		    
		}
		
		public  String scheduling_header()
		{
			String scheduling_header=pro.getProperty("scheduling_header");
			return scheduling_header;
		    
		}
		
		public  String sendNow_radiobtn()
		{
			String sendNow_radiobtn=pro.getProperty("sendNow_radiobtn");
			return sendNow_radiobtn;
		    
		}
		
		public  String button_saveNext()
		{
			String button_saveNext=pro.getProperty("button_saveNext");
			return button_saveNext;
		    
		}
		
		public  String start_time_info()
		{
			String start_time_info=pro.getProperty("start_time_info");
			return start_time_info;
		    
		}
		
		public  String schedule_save_btn_info()
		{
			String schedule_save_btn_info=pro.getProperty("schedule_save_btn_info");
			return schedule_save_btn_info;
		    
		}
		
		public  String publish_header()
		{
			String publish_header=pro.getProperty("publish_header");
			return publish_header;
		    
		}
		
		public  String event_criteria_dd()
		{
			String event_criteria_dd=pro.getProperty("event_criteria_dd");
			return event_criteria_dd;
		    
		}
		
		public  String event_value()
		{
			String event_value=pro.getProperty("event_value");
			return event_value;
		    
		}
		
		public  String trigger_days()
		{
			String trigger_days=pro.getProperty("trigger_days");
			return trigger_days;
		    
		}
		
	/*	
		public static void main(String[] args)
		{
			SchedulingLocators sch = new SchedulingLocators();
			sch.respose_confirm_txtbox();
		}
		*/
		
		
	}


