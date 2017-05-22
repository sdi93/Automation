package malive;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SMSBroadcastStore {
	SMSMeth obj=new SMSMeth();
	String reportName =  "SMSBroadcastStore";
	
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
	 public void storeSelection() throws Exception{
		 boolean a = obj.storeSlection();
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
	 
	 @Test(priority=8)
	 public void databseCheck() throws Exception{
		 boolean a = obj.databaseTest();
		  Assert.assertEquals(a, true);
	 }
	 
	 @AfterMethod
		public void tearDown(ITestResult result) throws IOException {

			if (result.getStatus() == ITestResult.FAILURE) {
			}

		obj.reportFlush();
			
		}
		 @org.testng.annotations.AfterSuite
			public void quit() {
				obj.quit();
			}
	 
}
