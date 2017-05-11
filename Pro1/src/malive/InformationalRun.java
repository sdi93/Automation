package malive;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import analyticsLive.GAMeth;

public class InformationalRun {

	InformationalMethod obj=new InformationalMethod();
	public String reportName ="SMSInformational";
	
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
	 public void campaignNaivation() throws Exception{
		 boolean a = obj.campaignNaivation();
		  Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=2)
	 public void campaignCreation() throws Exception{
		 boolean a = obj.campaignCreation();
		  Assert.assertEquals(a, true);
	 }

	 @Test(priority=3)
	 public void defineCmapaign() throws Exception{
		 boolean a = obj.defineCmapaign();
		  Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=4)
	 public void subscriptionCriteria() throws Exception{
		 boolean a = obj.subscriptionCriteria();
		  Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=5)
	 public void storeSlection() throws Exception{
		 boolean a = obj.storeSlection();
		  Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=6)
	 public void definingResponse() throws Exception{
		 boolean a = obj.definingResponse();
		  Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=7)
	 public void scheduling() throws Exception{
		 boolean a = obj.scheduling();
		  Assert.assertEquals(a, true);
	 }
}
