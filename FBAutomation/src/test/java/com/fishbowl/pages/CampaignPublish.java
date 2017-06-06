package com.fishbowl.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fishbowl.utility.Reporting;
import com.relevantcodes.extentreports.LogStatus;

public class CampaignPublish
{

    WebDriver driver;
    
    
	
	public CampaignPublish(WebDriver ldriver)
	{
	  this.driver=ldriver;
	}
	
    public static String publish_button = "//input[@value='Publish']";
	public static String button_saveNext = "//input[@value='Save & Next']";
	
	Reporting rep = new Reporting();
	

	public void publishigBroadcast() throws Exception
		{
		
		    rep.logger=rep.report.startTest("BroadCast Campaign Publishing Start");
		    
		    
		    
			WebDriverWait wait = new WebDriverWait(driver, 60);
			try
			{
				
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(publish_button)));
			    Thread.sleep(3000);
				driver.findElement(By.xpath(publish_button)).click();
				
			    // driver.findElement(By.xpath(button_saveNext)).click();
			    rep.report_status_pass("BroadCast Campaign published successfully");
			   
			}
			catch(Exception e)
			{
			   
				rep.report_status_fail("Camp_creation_snap","BroadCast Campaign not published successfully");
				
			}
			
			rep.reportFlush();
		
		}
	
	public void publishigInformational() throws Exception
	{
		rep.logger=rep.report.startTest("Informational Campaign Publishing Start");
		
		try
		{
			Thread.sleep(5000);
			driver.findElement(By.xpath(publish_button)).click();
		   
			rep.report_status_pass("Informational campaign published");
			
		}
		catch(Exception e)
		{
			rep.report_status_fail("Informational_publish", "Informational campaign not published");
			
			
		}
		
		rep.reportFlush();
		
	}
	
	public void publishig_acquisition()
	{
	   
		WebDriverWait wait = new WebDriverWait(driver, 60);
		try
		{
			Thread.sleep(5000);
			driver.findElement(By.xpath("//input[@value='Publish' and @type='submit']")).click();
		//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(publish_button)));
			//driver.findElement(By.xpath(publish_button)).click();
		//	driver.findElement(By.xpath(button_saveNext)).click();
			//logger.log(LogStatus.PASS, "SMS acquisition published");
			rep.reportFlush();
		}
		catch(Exception e)
		{
			System.out.println(e);
			//logger.log(LogStatus.FAIL, "SMS acquisition publish failed");
			rep.reportFlush();
			

		}
		
	}
	
	public void publishing_trigger() throws Exception
	{
		rep.logger=rep.report.startTest("Informational Campaign Publishing Start");
		WebDriverWait wait = new WebDriverWait(driver, 100);
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(.,'Review and Publish')]")));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Publish']")));
			driver.findElement(By.xpath("//input[@value='Publish']")).click();
			rep.report_status_pass("Trigger campaign published");
		}
		catch(Exception e)
		{
			rep.report_status_fail("Trigger_publish", "Trigger campaign not published");
		}
		rep.reportFlush();
	}
	
	
	   
}
