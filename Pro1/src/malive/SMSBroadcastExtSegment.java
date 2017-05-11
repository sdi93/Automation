package malive;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import analyticsLive.GAMeth;

public class SMSBroadcastExtSegment 
{
	SMSMeth obj=new SMSMeth();
	String reportName =  "SMSreport";
	
	@BeforeTest
	public void Browserinvoke()
	{
		obj.Browserinvoke(reportName);
	}
	
	 @Test(priority=0)
	 public void dshboardView() throws Exception{
		 boolean a = obj.L1_dashboardView();
		  Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=1)
	 public void CampaignPageNavigation() throws Exception{
		 boolean a = obj.campaignNaivation();
		  Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=2)
	 public void createCampaign() throws Exception{
		 boolean a = obj.campaignCreation();
		  Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=3)
	 public void definingCampaign() throws Exception{
		 boolean a = obj.defineCmapaign();
		  Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=4)
	 public void audienceSelection() throws Exception{
		 boolean a = obj.audienceCriteriaExtSegment();
		  Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=5)
	 public void segmentselection() throws Exception{
		 boolean a = obj.extSegmentSelection();
		  Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=6)
	 public void snedNow() throws Exception{
		 boolean a = obj.snedingSchedule();
		  Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=7)
	 public void publishMessage() throws Exception{
		 boolean a = obj.publishigBroadcast();
		  Assert.assertEquals(a, true);
	 }
	 
}

