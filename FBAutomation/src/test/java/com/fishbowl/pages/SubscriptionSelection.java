package com.fishbowl.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fishbowl.utility.Reporting;
import com.relevantcodes.extentreports.LogStatus;

public class SubscriptionSelection
{
	Reporting rep = new Reporting();
	public static String radio_storesOnly =  "//span[contains(.,'Using Stores')]";
	
	WebDriver driver;

	public SubscriptionSelection(WebDriver ldriver)
	{
	  this.driver=ldriver;
	}
	
	public  void subscriptionCriteria_store() throws Exception
	{
		rep.logger=rep.report.startTest("Subscription Selection");
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		
		try
		{
			driver.findElement(By.xpath(radio_storesOnly)).click();
			driver.findElement(By.xpath("//input[@value='Save & Continue']")).click();
			rep.report_status_pass("Subscription criteria is selected");
			//driver.findElement(By.xpath(button_saveContinue)).click();
		}
		catch(Exception e)
		{
			rep.report_status_fail("Subscription", "Subscription criteria is not selected");
			
		}
		
	}
		
		public void subscriptionCriteria_list() throws Exception
		{
			rep.logger=rep.report.startTest("Subscription Selection");
			WebDriverWait wait = new WebDriverWait(driver, 60);
			try
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[contains(@ng-model,'Lists.selectedOption')]")));
				driver.findElement(By.xpath("//select[contains(@ng-model,'Lists.selectedOption')]")).click();
				driver.findElement(By.xpath("//select[contains(@ng-model,'Lists.selectedOption')]")).sendKeys("Trigger list");
				driver.findElement(By.xpath("//input[@value='Save & Next' and @class = 'bluebutton']")).click();
				
				rep.report_status_pass("Subscription criteria is selected");
			}
			catch(Exception e)
			{
				rep.report_status_fail("Subscription","Subscription criteria is not selected");
				
			}
			
		}
	
}
