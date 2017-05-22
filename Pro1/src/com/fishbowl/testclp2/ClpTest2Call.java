package com.fishbowl.testclp2;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import analyticsLive.GAMeth;

public class ClpTest2Call
{	
	ClpTestMeth obj=new ClpTestMeth();
	
	@BeforeTest
		public void Browserinvoke()
	 {
		obj.Browserinvoke();
	}
	 
	 @Test(priority=0)
	 public void login() throws Exception{
		 boolean a = obj.login();
		  Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=1)
	 public void cmapaignCreation() throws Exception{
		 boolean a = obj.cmapaignCreation();
		  Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=2)
	 public void definingCampaign() throws Exception{
		 boolean a = obj.definingCampaign();
		  Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=3)
	 public void targetedAudience() throws Exception{
		 boolean a = obj.targetedAudience();
		  Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=4)
	 public void scheduling() throws Exception{
		 boolean a = obj.scheduling();
		  Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=5)
	 public void playingSMS() throws Exception{
		 boolean a = obj.playingSMS();
		  Assert.assertEquals(a, true);
	 }
	 
}
