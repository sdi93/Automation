package com.fishbowl.testcases;

import org.testng.annotations.Test;

import com.fishbowl.config.Common;
import com.fishbowl.pages.AudienceSelection;
import com.fishbowl.pages.CampaignDefinition;
import com.fishbowl.pages.CampaignName;
import com.fishbowl.pages.CampaignPublish;
import com.fishbowl.pages.CouponSelection;
import com.fishbowl.pages.Scheduling;

public class SMSBroadCastCoupon extends Common{
	
	@Test
	public void SMSBroadCast_Coupon() throws Exception
	{
		CampaignName obj = new CampaignName(driver);
		obj.campaign_navigation();
		obj.enter_campName("Broadcast");
		
		CampaignDefinition campdef = new CampaignDefinition(driver);
		campdef.define_campaign_coupon("BroadCast");
		
		CouponSelection coupon = new CouponSelection();
		coupon.couponSelection(driver);
		
		AudienceSelection as = new AudienceSelection(driver);
		as.audience_Criteria_ExstSegment();
		
		Scheduling Schedule =  new Scheduling(driver);
		Schedule.scheduling_broad();
		
		CampaignPublish camp = new CampaignPublish(driver);
		camp.publishigBroadcast();
	}

}
