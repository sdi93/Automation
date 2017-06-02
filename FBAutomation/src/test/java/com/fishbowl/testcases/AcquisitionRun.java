package com.fishbowl.testcases;

import org.testng.annotations.Test;

import com.fishbowl.config.Common;
import com.fishbowl.pages.CampaignDefinition;
import com.fishbowl.pages.CampaignName;
import com.fishbowl.pages.CampaignPublish;
import com.fishbowl.pages.Scheduling;
import com.fishbowl.pages.SubscriptionSelection;
import com.fishbowl.utility.ActionBuilding;

public class AcquisitionRun extends Common
{
	
	@Test
	public void acquisition_camp_flow() throws Exception
	{
		CampaignName obj1 = new CampaignName(driver);
        obj1.campaign_navigation();
        String camp_name = obj1.enter_campName("Acquisition");
        		
        		
        CampaignDefinition obj2 = new CampaignDefinition(driver);
        obj2.define_campaign("Acquisition");
		
		SubscriptionSelection sb = new SubscriptionSelection(driver);
		sb.subscriptionCriteria_list();
			
		Scheduling sch = new Scheduling(driver);
		sch.scheduling_acq();
		
		CampaignPublish camp = new CampaignPublish(driver);
		camp.publishig_acquisition();
		
		ActionBuilding a = new ActionBuilding();
  		a.search(driver, camp_name);
	}

}
