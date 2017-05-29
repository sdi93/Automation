package analyticsLive;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyCustomGARun {
	public String Username = "schaudhary_ic";
	public String password = "Schaudhary123";
	//public String Username = "fbjambaadmin";
	//public String password = "SQj0Kp3Hez";
	public String AppUrl ="https://jamba.fishbowlcloud.com/#/insights/cockpit/";
	GAMeth obj=new GAMeth();
	public String reportName ="jamba";
	
	 @BeforeTest
		public void Browserinvoke()
	 {
		obj.Browserinvoke(AppUrl,reportName);
	}
	 
	 @Test(priority=0)
	 public void dshboardView() throws Exception{
		 boolean a = obj.L1_dashboardView(Username,password);
		  Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=171)
	 public void L3_PromotionNavigator()throws Exception{
		 boolean a = obj.L3_UrlNavigator(AppUrl,"promotion","no");
		  Assert.assertEquals(a, true);
	 }
	 
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
		}

	obj.reportFlush();
		
	}
	/* @org.testng.annotations.AfterSuite
		public void quit() {
			obj.quit();
		}*/
	 
}
