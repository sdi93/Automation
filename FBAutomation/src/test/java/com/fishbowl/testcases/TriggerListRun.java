package com.fishbowl.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.fishbowl.config.Common;
import com.fishbowl.pages.AudienceSelection;
import com.fishbowl.pages.CampaignDefinition;
import com.fishbowl.pages.CampaignName;
import com.fishbowl.pages.CampaignPublish;
import com.fishbowl.pages.Scheduling;
import com.fishbowl.utility.ActionBuilding;

public class TriggerListRun extends Common
{

	@Test
	public void trigger_list_flow() throws Exception
	{
		CampaignName obj1 = new CampaignName(driver);
        obj1.campaign_navigation();
        obj1.enter_campName("Triggered");
        String camp_name = obj1.enter_campName("Triggered");
        		
        		
        CampaignDefinition obj2 = new CampaignDefinition(driver);
        obj2.define_campaign("Triggered");
		
		AudienceSelection aud_select=PageFactory.initElements(driver, AudienceSelection.class);
		aud_select.audienceselection_list_trigger();
		
		Scheduling sch = new Scheduling(driver);
		sch.schedule_trigger();
		
		//CampaignPublish.publishing_trigger(driver);
		CampaignPublish camp = new CampaignPublish(driver);
		camp.publishing_trigger();
		
		ActionBuilding a = new ActionBuilding();
  		a.search(driver, camp_name);
	}
}
