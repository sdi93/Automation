package com.fishbowl.testcases;

import org.testng.annotations.Test;

import com.fishbowl.config.Common;
import com.fishbowl.pages.AudienceSelection;
import com.fishbowl.pages.CampaignDefinition;
import com.fishbowl.pages.CampaignName;
import com.fishbowl.pages.CampaignPublish;
import com.fishbowl.pages.Scheduling;

public class TriggerAllMembersRun extends Common{
	
	@Test
	public void TriggerAllMembers() throws Exception
	{
		CampaignName obj = new CampaignName(driver);
		obj.campaign_navigation();
		obj.enter_campName("Triggered");
		
		CampaignDefinition campdef = new CampaignDefinition(driver);
		campdef.define_campaign("Triggered");
		
		AudienceSelection as = new AudienceSelection(driver);
		as.audience_Criteria_AllMembers();
		
		Scheduling Schedule =  new Scheduling(driver);
		Schedule.schedule_trigger();
		
		CampaignPublish camp = new CampaignPublish(driver);
		camp.publishing_trigger();
	}

}
