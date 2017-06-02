package com.fishbowl.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fishbowl.config.Common;
import com.fishbowl.config.Level1_Locators;
import com.fishbowl.utility.Reporting;
import com.relevantcodes.extentreports.LogStatus;


public class Dashboard
{

	public WebDriver driver;
	
	WebDriverWait wait = new WebDriverWait(driver, 60);
	
	Reporting rep = new Reporting();
	
	Level1_Locators obj = new Level1_Locators();

	public void L1_dashboardView() throws Exception
	   {
		try
		{
		   verifyelementL1(obj.get_L1_L1_link(), obj.get_L1_L2_link(), obj.get_L1_L3_link(), obj.get_L1_L4_link(), obj.get_L1_L5_link(), obj.get_L1_L6_link(), obj.get_L1_L7_link(), obj.get_L1_L8_link());
			  
			   driver.get(Common.url+"marketing/campaign");
			   rep.logger.log(LogStatus.PASS, "Data Loaded successfully on L1");
		   } 
		   catch (Exception e)
		   { 
			   rep.logger.log(LogStatus.FAIL, "Data not loaded in all tiles for L1");
			   
		   }
		   
	   }
		   public void verifyelementL1(String xp1, String xp2, String xp3, String xp4, String xp5, String xp6, String xp7,	String xp8) 
			{
				
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp1)));
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp2)));
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp3)));
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp4)));
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp5)));
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp6)));
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp7)));
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp8)));
			}
			
		   
	  
}

