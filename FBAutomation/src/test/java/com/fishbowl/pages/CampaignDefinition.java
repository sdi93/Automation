package com.fishbowl.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.fishbowl.config.CampaignCreation_locators;
import com.fishbowl.utility.ActionBuilding;
import com.fishbowl.utility.Logging;
import com.fishbowl.utility.RandomGenerator;
import com.fishbowl.utility.ReadExcelUtils;
import com.fishbowl.utility.Reporting;


public class CampaignDefinition 
{
  
	WebDriver driver;
	 
	public CampaignDefinition(WebDriver ldriver)
	{
	  this.driver=ldriver;
	}
		
     CampaignCreation_locators obj = new CampaignCreation_locators();
     
     Reporting rep = new Reporting();
	
	
	public void define_campaign(String CampaignType) throws Exception
	{
		rep.logger=rep.report.startTest("Camapign Definition");
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		
		try
		{
		
		if(CampaignType.equalsIgnoreCase("BroadCast"))
		{   
		
		   ReadExcelUtils.setExcelFile("D:/gitcode/SelAutomation/FBAutomation/Data/CampaignData.xlsx", "CampaignSMSBroadcast");
		   
		   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj.defCamp_dropdown())));
		   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj.defCamp_textbox())));
		   driver.findElement(By.xpath(obj.defCamp_textbox())).sendKeys(ReadExcelUtils.getCellData(0, 1));
	    
		   driver.findElement(By.xpath(obj.button_saveNext())).click();
		   
		   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Choose Audience Criteria')]")));
		    
	    }
	
		else if(CampaignType.equalsIgnoreCase("Informational"))
		{
			ReadExcelUtils.setExcelFile("D:/gitcode/SelAutomation/FBAutomation/Data/CampaignData.xlsx", "CampaignSMSInformational");
			
			String keyword = RandomGenerator.random_number()+ReadExcelUtils.getCellData(0, 1);
			
			driver.findElement(By.xpath(obj.campKeyword_info())).sendKeys(keyword);
			driver.findElement(By.xpath(obj.campDesc())).sendKeys(ReadExcelUtils.getCellData(0, 2));
			
			driver.findElement(By.xpath("//textarea[@id='defaultMessage']")).sendKeys(ReadExcelUtils.getCellData(0, 1));
			//driver.findElement(By.id("welcomeMessage")).sendKeys(welcomeMessage);
			//driver.findElement(By.xpath(promotion_dropdown)).sendKeys(PromotionID);
			
			driver.findElement(By.xpath("//input[@value='Save & Next' and @class = 'bluebutton']")).click();
			
			
		}
		
		else if(CampaignType.equalsIgnoreCase("Acquisition"))
		{
			ReadExcelUtils.setExcelFile("D:/gitcode/SelAutomation/FBAutomation/Data/CampaignData.xlsx", "CampaignAcquisition");
					
			driver.findElement(By.xpath(obj.campDesc())).sendKeys(ReadExcelUtils.getCellData(0, 1));
			
			String keyword_acq = RandomGenerator.random_number()+ReadExcelUtils.getCellData(0, 2);
			driver.findElement(By.xpath(obj.campKeyword_acq())).sendKeys(keyword_acq);
			
			driver.findElement(By.xpath(obj.welcome_message())).sendKeys(ReadExcelUtils.getCellData(0, 3));
			driver.findElement(By.xpath(obj.confirmation_message())).sendKeys(ReadExcelUtils.getCellData(0, 4));
			
			driver.findElement(By.xpath(obj.existing_message())).sendKeys(ReadExcelUtils.getCellData(0, 5));
			
			driver.findElement(By.xpath(obj.invalid_message())).sendKeys(ReadExcelUtils.getCellData(0, 6));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Save & Next' and @class = 'bluebutton']")));
			
			driver.findElement(By.xpath("//input[@value='Save & Next' and @class = 'bluebutton']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Select a list that members will get subscribed to')]")));
		}
		
		else if(CampaignType.equalsIgnoreCase("Triggered"))
		   {
		      
		      ReadExcelUtils.setExcelFile("D:/gitcode/SelAutomation/FBAutomation/Data/CampaignData.xlsx","CamapignTrigger");
		 
//		      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj.defCamp_dropdown())));
//		      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj.defCamp_textbox())));
		   
		      driver.findElement(By.xpath(obj.defCamp_textbox())).sendKeys(ReadExcelUtils.getCellData(0, 2));
		    
		      driver.findElement(By.xpath(obj.button_saveNext())).click();
		      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Choose Audience Criteria')]")));
		   
	        }
		
		     rep.report_status_pass("Campaign definition entered");
		    
		
		}
		catch(Exception e)
		{
		
			rep.report_status_fail("Camp_creation_snap","Campaign definition not entered");
			
		}
		
		rep.reportFlush();
		
		
		
	}
	
	public void define_campaign_coupon(String campaignType) throws Exception
	 {
		rep.logger=rep.report.startTest("Camapign Coupon");
		
	    try
	    {
	    	
	     WebDriverWait wait = new WebDriverWait(driver, 60);
	     ReadExcelUtils.setExcelFile("D:/gitcode/SelAutomation/FBAutomation/Data/CampaignData.xlsx", "CampaignSMSBroadcast");
	    
	     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj.defCamp_dropdown())));
	     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj.defCamp_textbox())));
	     driver.findElement(By.xpath(obj.defCamp_textbox())).sendKeys(ReadExcelUtils.getCellData(0, 1));
	       
	     CouponSelection cs = new CouponSelection();
	     cs.couponSelection(driver);
	     
	    
	     driver.findElement(By.xpath(obj.button_saveNext())).click();
	     
//	     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Choose Audience Criteria')]")));
	     
	     rep.report_status_pass("Campaign coupon selected");
	    }
	    
	    catch(Exception e)
	    {
	    	rep.report_status_fail("Coupon", "Campaign coupon not selected");
	    }
	  
	    rep.reportFlush();
	     }
		
	
}
	


