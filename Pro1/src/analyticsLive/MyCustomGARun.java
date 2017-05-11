package analyticsLive;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyCustomGARun {
	 public String Username = "fbjambaadmin";
	 public String password = "SQj0Kp3Hez";
	public String AppUrl ="https://demo-fb.fishbowlcloud.com/#/insights/cockpit/";
	DemoFBMeth obj=new DemoFBMeth();
	public String reportName ="demo-fb";
	
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
	 
	@Test(priority=1)
	 public void L1_storename_dropdown() throws Exception{
		 boolean a =  obj.storename_dropDown();
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
