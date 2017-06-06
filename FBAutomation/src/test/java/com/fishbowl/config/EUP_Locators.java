package com.fishbowl.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class EUP_Locators 
{
	public static Properties pro;
	
	public EUP_Locators()
	{
		try
		{
			File f= new File("/FishbowlGitCode/FBAutomation/Locators/EUPLocators.property");
			FileInputStream fis =  new FileInputStream(f);
			pro = new Properties();
			pro.load(fis);
		}
	    catch (Exception e)
		    {
				
				System.out.println(e.getMessage());
			}
	}
	
	public  String get_signup()
	{
		String signup_link=pro.getProperty("signup_link");
		System.out.println(signup_link);
		return signup_link;
	}
		
	public  String get_profile_navTab()
	{
		String profile_navTab_link=pro.getProperty("profile_navTab");
		System.out.println(profile_navTab_link);
		return profile_navTab_link;
	}
	
	public  String get_edit_button()
	{
		String edit_button_link=pro.getProperty("edit_button");
		System.out.println(edit_button_link);
		return edit_button_link;
	}
	
	public  String get_editPorf_fName()
	{
		String editPorf_fName_link=pro.getProperty("editPorf_fName");
		System.out.println(editPorf_fName_link);
		return editPorf_fName_link;
	}
	
	public  String get_saveButton()
	{
		String saveButton_link=pro.getProperty("saveButton");
		System.out.println(saveButton_link);
		return saveButton_link;
	}

	public  String get_dialog_okButton()
	{
		String dialog_okButton_link=pro.getProperty("dialog_okButton");
		System.out.println(dialog_okButton_link);
		return dialog_okButton_link;
	}
	
	public  String get_password_navTab()
	{
		String password_navTab_link=pro.getProperty("password_navTab");
		System.out.println(password_navTab_link);
		return password_navTab_link;
	}
	
	public  String get_newpassword_tetbox()
	{
		String newpassword_tetbox_link=pro.getProperty("newpassword_tetbox");
		System.out.println(newpassword_tetbox_link);
		return newpassword_tetbox_link;
	}
	
	public  String get_confPassword_textbox()
	{
		String confPassword_textbox_link=pro.getProperty("confPassword_textbox");
		System.out.println(confPassword_textbox_link);
		return confPassword_textbox_link;
	}
	
	public  String get_submitButton_password()
	{
		String submitButton_password_link=pro.getProperty("submitButton_password");
		System.out.println(submitButton_password_link);
		return submitButton_password_link;
	}
	
	public  String get_current_password()
	{
		String current_password_link=pro.getProperty("current_password");
		System.out.println(current_password_link);
		return current_password_link;
	}
	
	public  String get_success_dialog()
	{
		String success_dialog_link=pro.getProperty("success_dialog");
		System.out.println(success_dialog_link);
		return success_dialog_link;
	}
	
	public  String get_logout_navTab()
	{
		String logout_navTab_link=pro.getProperty("logout_navTab");
		System.out.println(logout_navTab_link);
		return logout_navTab_link;
	}
	
	public  String get_signUpForm()
	{
		String signUpForm_link=pro.getProperty("signUpForm");
		System.out.println(signUpForm_link);
		return signUpForm_link;
	}
	
	public  String get_signin_pageVerify()
	{
		String signin_pageVerify_link=pro.getProperty("signin_pageVerify");
		System.out.println(signin_pageVerify_link);
		return signin_pageVerify_link;
	}
		
	public  String get_resetPass_pageVerify()
	{
		String resetPass_pageVerify_link=pro.getProperty("resetPass_pageVerify");
		System.out.println(resetPass_pageVerify_link);
		return resetPass_pageVerify_link;
	}
}
