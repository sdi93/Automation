package com.fishbowl.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.fishbowl.config.Common;
import com.fishbowl.pages.CampaignDefinition;
import com.fishbowl.pages.CampaignName;
import com.fishbowl.pages.CampaignPublish;
import com.fishbowl.pages.Scheduling;
import com.fishbowl.pages.StoreSelection;
import com.fishbowl.pages.SubscriptionSelection;
import com.fishbowl.utility.ActionBuilding;


public class InformationalRun extends Common
{

	@Test
	public void information_camp_flow() throws Exception
	{
		CampaignName obj1 = new CampaignName(driver);
        obj1.campaign_navigation();
        String camp_name = obj1.enter_campName("Informational");
        		    		
        CampaignDefinition obj2 = new CampaignDefinition(driver);
        obj2.define_campaign("Informational");
		
		SubscriptionSelection sb = new SubscriptionSelection(driver);
		sb.subscriptionCriteria_store();
		
		StoreSelection str_select=PageFactory.initElements(driver, StoreSelection.class);
		str_select.storeSelection("2");
			
		//Scheduling.definingResponse(driver, "Welcome to Informational", "Campaign26maydesc", "2", "Invalid message");
		Scheduling sch = new Scheduling(driver);
		sch.definingResponse("Welcome to Informational", "Campaign26maydesc", "2", "Invalid message");
		sch.scheduling_info();
		
		CampaignPublish camp = new CampaignPublish(driver);
		camp.publishigInformational();
		
		ActionBuilding a = new ActionBuilding();
  		a.search(driver, camp_name);
		
	}
	
} 
