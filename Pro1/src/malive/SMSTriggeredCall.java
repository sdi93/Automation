package malive;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SMSTriggeredCall 
{
	TriggeredMethod obj= new TriggeredMethod();
	String reportName =  "SMSTriggeredReport";
	
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
		 boolean a = obj.audienceCriteriaStore();
		  Assert.assertEquals(a, true);
	 }
	
	 @Test(priority=5)
	 public void storeSlection() throws Exception{
		 boolean a = obj.storeSlection();
		  Assert.assertEquals(a, true);
	 }
	
	 @Test(priority=6)
	 public void scheduling() throws Exception{
		 boolean a = obj.scheduling();
		  Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=7)
	 public void publishing() throws Exception{
		 boolean a = obj.publishing();
		  Assert.assertEquals(a, true);
	 }
	 
}
