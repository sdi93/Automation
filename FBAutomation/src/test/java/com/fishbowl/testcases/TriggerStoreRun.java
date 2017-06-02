package com.fishbowl.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.fishbowl.config.Common;
import com.fishbowl.pages.AudienceSelection;
import com.fishbowl.pages.CampaignDefinition;
import com.fishbowl.pages.CampaignName;
import com.fishbowl.pages.CampaignPublish;
import com.fishbowl.pages.Scheduling;
import com.fishbowl.pages.StoreSelection;

public class TriggerStoreRun extends Common
{
	@Test
	 public void triggerSMSFlow() throws Exception
	 {
		CampaignName obj1 = new CampaignName(driver);
        obj1.campaign_navigation();
       // obj1.enter_campName("Broadcast");
        String camp_name = obj1.enter_campName("Triggered");
        		
        		
        CampaignDefinition obj2 = new CampaignDefinition(driver);
        obj2.define_campaign("Triggered");
	  
	  AudienceSelection aud_select=PageFactory.initElements(driver, AudienceSelection.class);
	  aud_select.store_audience_criteria_tiggered();
	   
	  StoreSelection str_select=PageFactory.initElements(driver, StoreSelection.class);
	  str_select.storeSelection("2");
	
	  Scheduling sch = new Scheduling(driver);
	  sch.schedule_trigger();
	  
	  // CampaignPublish.publishing_trigger(driver);
	  CampaignPublish camp = new CampaignPublish(driver);
	  camp.publishing_trigger();
	 }
	 

}
