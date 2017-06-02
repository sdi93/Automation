package com.fishbowl.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.fishbowl.config.Common;
import com.fishbowl.pages.AudienceSelection;
import com.fishbowl.pages.CampaignDefinition;
import com.fishbowl.pages.CampaignName;
import com.fishbowl.pages.CampaignPublish;
import com.fishbowl.pages.Scheduling;
import com.fishbowl.pages.StoreSelection;
import com.fishbowl.utility.ActionBuilding;

public class SMSBroadNationalRun extends Common
{
	 String camp_name;
	
	@Test(priority=1)
	public void sms_broadcastcamp_flow() throws Exception
	{
		CampaignName obj1 = new CampaignName(driver);
        obj1.campaign_navigation();
       // obj1.enter_campName("Broadcast");
         camp_name = obj1.enter_campName("Broadcast");
        		
        		
        CampaignDefinition obj2 = new CampaignDefinition(driver);
        obj2.define_campaign("Broadcast");
        
        AudienceSelection aud_select=PageFactory.initElements(driver, AudienceSelection.class);
        aud_select.audience_Criteria_NationalBroadCast();
		
        StoreSelection str_select=PageFactory.initElements(driver, StoreSelection.class);
        str_select.exclude_segment();
	
        Scheduling sch = new Scheduling(driver);
        sch.scheduling_broad();
	
        CampaignPublish camp = new CampaignPublish(driver);
        camp.publishigBroadcast();
          
  		ActionBuilding a = new ActionBuilding();
  		a.search(driver, camp_name);
  		
     		
 }

	@Test(priority=2)
	public void database_test() throws Throwable
	{
		Database_testing a = new Database_testing();
		a.databaseTest(camp_name);
	}
	
}

