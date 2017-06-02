package com.fishbowl.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.fishbowl.config.CampaignCreation_locators;
import com.fishbowl.utility.ActionBuilding;
import com.fishbowl.utility.RandomGenerator;
import com.fishbowl.utility.ReadExcelUtils;
import com.fishbowl.utility.Reporting;

public class CampaignName 
{

	CampaignCreation_locators obj = new CampaignCreation_locators();
	
	WebDriver driver;
	
	String campaign_name;
	
	Reporting rep = new Reporting();
	 
	public CampaignName(WebDriver ldriver)
	{
	  this.driver=ldriver;
	}
	
	public void campaign_navigation() throws Exception
	{
		rep.logger=rep.report.startTest("Campaign Navigation");
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
	   
	   try
	    {
		   
		   Thread.sleep(10000);
		   ReadExcelUtils.setExcelFile("/SeleniumWorkspace/ws1/FBAutomation/Data/CampaignData.xlsx", "Credentials");
		   driver.get(ReadExcelUtils.getCellData(0,0));
		   
		   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj.button_createCampaign())));
		   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Campaigns & Offers')]")));
		  
		   
		   WebElement a  = driver.findElement(By.xpath(obj.button_createCampaign()));
	       WebElement b  = driver.findElement(By.xpath(obj.sms_typeCampaign()));
	       ActionBuilding.hoverOnMainAndClickSubLink(driver,a,b);
	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(.,'Create SMS Campaign')]")));	
	       rep.report_status_pass("Campaign Navigated successfully");
	       
	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj.dropd_smsType())));
 		   driver.findElement(By.xpath(obj.dropd_smsType())).click();
	     }
	  
	   catch(Exception e)
	     {
		   rep.report_status_fail("Camp_navigate_snap","Campaign Not Navigated");
	     }

	   rep.reportFlush();
	}
	
		  
     public String enter_campName(String CampaignType) throws Exception
 	{
 		rep.logger=rep.report.startTest("BroadCast Camapign Information");
 		
 		WebDriverWait wait = new WebDriverWait(driver, 60);
 		
 		try
 		{
 			
 		
 		if(CampaignType.equalsIgnoreCase("BroadCast"))
 		{   
 		
 		  ReadExcelUtils.setExcelFile("/SeleniumWorkspace/ws1/FBAutomation/Data/CampaignData.xlsx", "CampaignSMSBroadcast");
 		   
 		   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj.dd_broadcast())));
 		   driver.findElement(By.xpath(obj.dd_broadcast())).click();
 		 
 		   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj.textbox_campName())));
 		   
 		   campaign_name = ReadExcelUtils.getCellData(0, 0) + RandomGenerator.random_number();
 		   driver.findElement(By.xpath(obj.textbox_campName())).sendKeys(campaign_name);
 		   
 		   driver.findElement(By.xpath(obj.button_continue())).click();

 		   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Define Campaign & Offer')]")));
 		   	    
 		}	
 		
 		else if(CampaignType.equalsIgnoreCase("Informational"))
		{
			ReadExcelUtils.setExcelFile("/SeleniumWorkspace/ws1/FBAutomation/Data/CampaignData.xlsx", "CampaignSMSInformational");
			
		//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj.dropd_smsType())));
		//	driver.findElement(By.xpath(obj.dropd_smsType())).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj.dd_informational())));
			driver.findElement(By.xpath(obj.dd_informational())).click();
			
			campaign_name = ReadExcelUtils.getCellData(0, 0) + RandomGenerator.random_number();
			driver.findElement(By.xpath(obj.textbox_campName())).sendKeys(campaign_name);
			
			driver.findElement(By.xpath(obj.button_continue())).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Define SMS Info Campaign')]")));
			
		}
 		
 		else if(CampaignType.equalsIgnoreCase("Acquisition"))
		{
			ReadExcelUtils.setExcelFile("/SeleniumWorkspace/ws1/FBAutomation/Data/CampaignData.xlsx", "CampaignAcquisition");
			
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj.dropd_smsType())));
//			driver.findElement(By.xpath(obj.dropd_smsType())).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj.dd_acquisition())));
			driver.findElement(By.xpath(obj.dd_acquisition())).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj.zip_append())));
			driver.findElement(By.xpath(obj.zip_append())).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj.zipSelector_dropdown())));
			driver.findElement(By.xpath(obj.zipSelector_dropdown()));
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj.textbox_campName())));
			
			campaign_name = ReadExcelUtils.getCellData(0, 0) + RandomGenerator.random_number();
			driver.findElement(By.xpath(obj.textbox_campName())).sendKeys(campaign_name);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj.textbox_campName())));
			driver.findElement(By.xpath(obj.button_continue())).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Define SMS Acquisition By Zip Append Campaign')]")));
			
		}
 		
 		else if(CampaignType.equalsIgnoreCase("Triggered"))
		   {
//		      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj.dropd_smsType())));
//		      driver.findElement(By.xpath(obj.dropd_smsType())).click();
		     
		      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj.dd_triggered())));
		      driver.findElement(By.xpath(obj.dd_triggered())).click();
		    
		      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj.textbox_campName())));
		      ReadExcelUtils.setExcelFile("/SeleniumWorkspace/ws1/FBAutomation/Data/CampaignData.xlsx","CamapignTrigger");
		      
		      campaign_name = ReadExcelUtils.getCellData(0, 0) + RandomGenerator.random_number();
		      driver.findElement(By.xpath(obj.textbox_campName())).sendKeys(campaign_name);
		      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj.textbox_campName())));
		      driver.findElement(By.xpath(obj.button_continue())).click();
		      
		      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Define Campaign & Offer')]")));
		      
		     rep.report_status_pass("Campaign name entered");
		      
		   }
 		
 		}
 	
     
     catch(Exception e)
     {
    	 
    	 rep.report_status_fail("camp_name", "Campaign name not entered");
    	 
     }
 		
       return campaign_name;
 		
 		
 	}
     
}
 	
     
//     //  campaign name verification(utility)
//     public boolean campaign_name_verify(WebDriver driver)
//     {
//      driver.findElement(By.xpath(obj.button_continue())).click();
//      String actualtext = driver.findElement(By.xpath("//span[contains(text(),'Campaign name is required')]")).getText();
//      Assert.assertEquals(actualtext, "Campaign name is required.");
//      return true;
//     }
// 
// }

