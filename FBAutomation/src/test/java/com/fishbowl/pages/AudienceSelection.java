package com.fishbowl.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fishbowl.utility.Reporting;

public class AudienceSelection 
{
	Reporting rep = new Reporting();
	
	WebDriver driver;

	public AudienceSelection(WebDriver ldriver)
	{
	  this.driver=ldriver;
	}
	
	@FindBy(how=How.XPATH,using="//button[@class='btn btn-primary active']")
    @CacheLookup
    WebElement button_continue;
    
    @FindBy(how=How.XPATH,using="//button[contains(.,'Save & Continue')]")
    @CacheLookup
    WebElement button_saveContinue;
    
    @FindBy(how=How.XPATH,using="//span[@class='radio_text'][text()='Using Stores & Other Attributes']")
    @CacheLookup
    WebElement radiobtn_store_broad;
    
    @FindBy(how=How.XPATH,using="//span[@class='radio_text'][text()='National Broadcast to all stores']")
    @CacheLookup
    WebElement radiobtn_NationalStore;
    
    @FindBy(how=How.XPATH,using="//span[@class='radio_text'][text()='Using Stores']")
    @CacheLookup
    WebElement radiobtn_store_trigger;
    
  /*  @FindBy(how=How.XPATH,using="//span[@class='radio_text'][text()='Using Stores']")
    @CacheLookup
    WebElement radiobtn_ExtSegment;*/
    
    @FindBy(how=How.XPATH,using="//*[@id='showUploadImagePopUpZindex']//select")
    @CacheLookup
    WebElement mailinglistdropdown;
    
    @FindBy(how=How.XPATH,using="//span[text()='Using List']")
    @CacheLookup
    WebElement usinglist;
    
    @FindBy(how=How.XPATH,using="//input[@value='Save & Next']")
    @CacheLookup
    WebElement button_saveNext;
    
    @FindBy(how=How.XPATH,using="//span[contains(text(),'Using Existing Segment')]")
    @CacheLookup
    WebElement using_extSeg;
    
    @FindBy(how=How.XPATH,using="//input[@placeholder='Add Inclusionary Segment']")
    @CacheLookup
    WebElement include_Segment;
    
    @FindBy(how=How.XPATH,using="//a[@ng-click='$removeTag()']")
    @CacheLookup
    WebElement remove_Segment;
    
         
    	public void store_audience_criteria_broadcast() throws Exception
		{
    		rep.logger=rep.report.startTest("Audience Selection");
    		
    		WebDriverWait wait = new WebDriverWait(driver, 60);
    		
    		try
    		{
    		
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='radio_text'][text()='Using Stores & Other Attributes']")));
			radiobtn_store_broad.click();
			button_saveNext.click();
    		
			rep.report_status_pass("Audience is selected");
			
    		}
    		
    		catch(Exception e)
    		{
    			rep.report_status_fail("Audience", "Audience is not selected");
    		}
		}
    		
    	public void store_audience_criteria_tiggered() throws Exception
		{
    		WebDriverWait wait = new WebDriverWait(driver, 60);
    		try
    		{
    		
		//	List<WebElement> audience_radio_btns = driver.findElements(By.xpath("//span[@class='radio_text']"));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='radio_text'][text()='Using Stores']")));
			radiobtn_store_trigger.click();
			button_saveContinue.click();
			rep.report_status_pass("Audience is selected");
    		}
    		
    		catch(Exception e)
    		{
    			rep.report_status_fail("Audience", "Audience is not selected");
    		}
		}
    	 
 	
    	 public void audienceselection_list_trigger() throws Exception
    	 {
    	
    		 try
    		 {
    	  
    	   usinglist.click();
    	   button_saveContinue.click();
    	   
    	   Select dropdown = new Select(driver.findElement(By.xpath("//*[@id='showUploadImagePopUpZindex']//select")));
    	   dropdown.selectByVisibleText("Dickey’s Barbecue Pit");
    	   button_saveNext.click();
    	   rep.report_status_pass("Audience is selected");
    	   
    		 }
    		 
    		 catch(Exception e)
    		 {
    			 rep.report_status_fail("Audience", "Audience is not selected");
    		 }
    	
   	 }
    	 
    	 
    	 public void audience_Criteria_ExstSegment() throws InterruptedException
         {
          remove_Segment.click();
          using_extSeg.click();
          include_Segment.click();
          include_Segment.sendKeys("Hawaii3_12_14");
          Thread.sleep(2000);
          include_Segment.sendKeys(Keys.TAB);
          
         }
    	 
    	 public void audience_Criteria_NationalBroadCast() throws Exception
         {
          
    		 rep.logger=rep.report.startTest("Audience Selection");
     		
     		WebDriverWait wait = new WebDriverWait(driver, 60);
     		
     		try
     		{
     		
 			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='radio_text'][text()='National Broadcast to all stores']")));
 			radiobtn_NationalStore.click();
 			button_saveNext.click();
     		
 			rep.report_status_pass("Audience is selected");
 			
     		}
     		
     		catch(Exception e)
     		{
     			rep.report_status_fail("Audience", "Audience is not selected");
     		}
          
         }
    	 
    }
 	   
 	   


	   
	
