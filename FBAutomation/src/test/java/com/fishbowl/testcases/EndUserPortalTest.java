package com.fishbowl.testcases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fishbowl.config.EUP_Common;
import com.fishbowl.eupPages.EUP_ChangePassword;
import com.fishbowl.eupPages.EUP_Login;
import com.fishbowl.eupPages.EUP_Logout;
import com.fishbowl.eupPages.EUP_Registration;
import com.fishbowl.eupPages.EUP_UpdateProfile;
import com.fishbowl.pages.CampaignPublish;

import com.fishbowl.pages.Scheduling;
import com.fishbowl.pages.SubscriptionSelection;
import com.fishbowl.utility.Reporting;

public class EndUserPortalTest extends EUP_Common 
{
	EUP_Registration regobj;
	EUP_Logout logoutObj;
	EUP_Login loginObj;
	EUP_UpdateProfile updateProfObj;
	EUP_ChangePassword changePassObj;
	Reporting rep = new Reporting();
	@BeforeTest
	public void constructor_all()
	{
		 regobj = new EUP_Registration(driver);
		 logoutObj = new EUP_Logout(driver);
		 loginObj = new EUP_Login(driver);
		 updateProfObj = new EUP_UpdateProfile(driver);
		 changePassObj = new EUP_ChangePassword(driver);
	}
	
	@Test
	public void eup_regForm() throws Exception
	{
		regobj.signUpForm();		
	}
	
	@Test
	public void afterRegLogout() throws Exception
	{
		logoutObj.logout("Registration");
	}
	
	@Test
	public void loginNewAccount() throws Exception
	{
		loginObj.login("Simple");
	}
	
	@Test
	public void updateMemberProfile() throws Exception
	{
		updateProfObj.userProfileUpdate();
	}
	
	@Test
	public void changepassword() throws Exception
	{
		changePassObj.updatePassword();
	}
	
	@Test
	public void afterChangePasswordLogout() throws Exception
	{
		logoutObj.logout(" Change Password");
	}
	
	@Test
	public void loginWithChangePassword() throws Exception
	{
		loginObj.login("ChangedPassword");
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) { }

			rep.reportFlush();
		
	}
}
