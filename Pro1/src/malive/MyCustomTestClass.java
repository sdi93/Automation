package malive;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyCustomTestClass {

	SMSMeth obj=new SMSMeth();
	String reportName =  "SMSreport";
	
	 @Test(priority=1)
		public void Browserinvoke()
	 {
		obj.Browserinvoke(reportName);
	}
	 @Test(priority=2)
	 public void CampaignPageNavigation() throws Exception{
		 boolean a = obj.campaignNaivation();
		  Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=3)
	 public void createCampaign() throws Exception{
		 boolean a = obj.campaignCreation();
		  Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=4)
	 public void definingCampaign() throws Exception{
		 boolean a = obj.defineCmapaign();
		  Assert.assertEquals(a, true);
	 }
	
}
