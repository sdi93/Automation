package crmLoyalty;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import analyticsLive.GAMeth;

public class CRMRun {
	public String reportName ="Seaisland";
	Method obj=new Method();
	
	 @BeforeTest
		public void Browserinvoke()
	 {
		obj.Browserinvoke(reportName);
	}
	 
	@Test(priority=0)
	 public void dshboardView() throws Exception{
		 boolean a = obj.signUpNavigation();
		  Assert.assertEquals(a, true);
	 }
	 @Test(priority=1)
	 public void fillForm() throws Exception{
		 boolean a = obj.signUpForm();
		  Assert.assertEquals(a, true);
	 }
	 @Test(priority=2)
	 public void logout()throws Exception{
		 boolean a = obj.logout("Registration");
		 Assert.assertEquals(a, true);
	 }
	 @Test(priority=3)
	 public void login()throws Exception{
		 boolean a = obj.login();
		 Assert.assertEquals(a, true);
		 }
	 @Test(priority = 4)
	 public void userProfileUpdate() throws Exception{
		 boolean a = obj.userProfileUpdate();
		 Assert.assertEquals(a, true);
	 }
	 @Test(priority = 5)
	 public void userPasswordUpdate()throws Exception{
		 boolean a = obj.updatePassword();
		 Assert.assertEquals(a, true);
	 }
	 @Test(priority = 6)
	 public void finalLogout()throws Exception{
		 boolean a = obj.logout("Password Change");
		 Assert.assertEquals(a, true);
	 }
	 @Test(priority=7)
	 public void login2()throws Exception{
		 boolean a = obj.login2();
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
