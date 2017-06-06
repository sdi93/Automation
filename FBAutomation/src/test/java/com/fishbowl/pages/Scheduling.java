package com.fishbowl.pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fishbowl.config.SchedulingLocators;
import com.fishbowl.utility.Reporting;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Scheduling 
{
	SchedulingLocators sch = new SchedulingLocators();
	
	Reporting rep = new Reporting();
	
	WebDriver driver;
	
	public Scheduling(WebDriver ldriver)
	{
	  this.driver=ldriver;
	}
	
     public String button_saveNext = "//input[@value='Save & Next']";
     public static String sendNow_radiobtn = "//span[contains(text(),'Send Now')]";
   
	public void definingResponse(String welcomeMessage, String CampaignDescription, String extMemeber, String invalidMessage)
	{
		 
		WebDriverWait wait = new WebDriverWait(driver, 60);
		try
		{	
			driver.findElement(By.xpath(sch.respose_confirm_txtbox())).sendKeys(CampaignDescription);
			driver.findElement(By.xpath(sch.welcome_txtbox())).sendKeys(welcomeMessage);
			
			driver.findElement(By.xpath(sch.existing_members_txtbox())).sendKeys(extMemeber);
			driver.findElement(By.xpath(sch.invalid_msg_txtbox())).sendKeys(invalidMessage);
			
			driver.findElement(By.xpath(sch.response_submit_button())).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(.,'Scheduling')]")));
			
			
			
		}
	
		catch(Exception e)
		{
			rep.logger.log(LogStatus.FAIL, "Defining response failed");
			
		}
		
	}
	
	public void scheduling_broad()
	{
		rep.logger=rep.report.startTest("Sending BroadCast Schedule");
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);	
		WebDriverWait wait = new WebDriverWait(driver, 60);
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sch.sendNow_radiobtn())));
			driver.findElement(By.xpath(sch.sendNow_radiobtn())).click();
			driver.findElement(By.xpath(button_saveNext)).click();
			rep.logger.log(LogStatus.PASS, "Sending schedule set to send now complete");
			
		}
		catch(Exception e)
		{
			rep.logger.log(LogStatus.FAIL, "Sending schedule set to send now failed");

			
		}
		
		rep.reportFlush();
		
	}
	
	public void scheduling_info()
	{
		WebDriverWait wait = new WebDriverWait(driver, 100);
		
		try
		{		
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sch.scheduling_header())));
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sch.start_time_info())));
			
			driver.findElement(By.xpath(sch.start_time_info())).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='startTime']/child::*//*//*/*[@class='btn btn-link']")));
			
			driver.findElement(By.xpath("//*[@id='startTime']/child::*//*//*/*[@class='btn btn-link']")).click();
			driver.findElement(By.xpath(sch.schedule_save_btn_info())).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sch.publish_header())));
			
			//logger.log(LogStatus.PASS, "Sending schedule set");
		}
		catch(Exception e)
		{
			//logger.log(LogStatus.FAIL, "Sending schedule failed");
			System.out.println(e);
			
		}
		
	}
		

		 public void scheduling_acq()
			{
			   
				WebDriverWait wait = new WebDriverWait(driver, 100);
				try
				{			
					Thread.sleep(5000);
					driver.findElement(By.xpath(sch.schedule_save_btn_info())).click();
				//	logger.log(LogStatus.PASS, "Sending schedule set");
				}
				catch(Exception e)
				{
					System.out.println(e);
				//	logger.log(LogStatus.FAIL, "Setting sending schedule failed");
					
				}
				rep.reportFlush();
		
	        }
		   		    
		    public void schedule_trigger() 
		    {
		    	rep.logger=rep.report.startTest("Sending Trigger Schedule");
		    	
				WebDriverWait wait = new WebDriverWait(driver, 100);
				try
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sch.start_time_info())));
					driver.findElement(By.xpath(sch.event_criteria_dd())).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sch.event_value())));
					driver.findElement(By.xpath(sch.event_value())).click();
					driver.findElement(By.xpath(sch.trigger_days())).sendKeys("1");
					driver.findElement(By.xpath(sch.start_time_info())).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='startTime']/child::*//*//*/*[@class='btn btn-link']")));
					driver.findElement(By.xpath("//*[@id='startTime']/child::*//*//*/*[@class='btn btn-link']")).click();
					
					driver.findElement(By.xpath(sch.button_saveNext())).click();
					Thread.sleep(10000);
					rep.logger.log(LogStatus.PASS, "Sending schedule set complete");
					
				}
				catch(Exception e)
				{
					rep.logger.log(LogStatus.FAIL, "Sending schedule set failed");
				}
				
				rep.reportFlush();
		    }

}
