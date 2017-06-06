package com.fishbowl.testcases;

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

public class EndUserPortalTest extends EUP_Common 
{
	EUP_Registration regobj ;
	EUP_Logout logoutObj;
	EUP_Login loginObj;
	EUP_UpdateProfile updateProfObj;
	EUP_ChangePassword changePassObj;
	@Test
	public void eup_calling() throws Exception
	{
		regobj = new EUP_Registration(driver);
		regobj.signUpForm();
		
		logoutObj = new EUP_Logout(driver);
		logoutObj.logout("after Registration");
		
		loginObj = new EUP_Login(driver);
		loginObj.login("Simple");
		
		updateProfObj = new EUP_UpdateProfile(driver);
		updateProfObj.userProfileUpdate();
		
		changePassObj = new EUP_ChangePassword(driver);
		changePassObj.updatePassword();
		
		logoutObj.logout("after changePassword");
		
		loginObj.login("ChangedPassword");
	}
	
}
