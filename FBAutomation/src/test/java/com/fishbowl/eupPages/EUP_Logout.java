package com.fishbowl.eupPages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fishbowl.config.EUP_Common;
import com.fishbowl.config.EUP_Locators;
import com.fishbowl.utility.Reporting;
import com.relevantcodes.extentreports.LogStatus;

public class EUP_Logout 
{
	WebDriver driver;
	EUP_Locators obj1 = new EUP_Locators();
	EUP_Common eupCommon=new EUP_Common();
	Reporting rep = new Reporting();

	
	public EUP_Logout(WebDriver ldriver)
	{
	  this.driver=ldriver;
	}
	
	public void logout(String after) throws Exception
	{
		//rep.report.startTest("Log-Out after"+after);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		try
		{
			Thread.sleep(1000);
			driver.findElement(By.xpath(obj1.get_logout_navTab())).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj1.get_signin_pageVerify())));
			rep.report_status_pass("Logout successfull");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			rep.report_status_fail("logout", "Logout not completed succssfully");
		
		}
	
	}
}

