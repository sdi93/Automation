package com.fishbowl.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
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
    		rep.reportFlush();
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
    		rep.reportFlush();
		}
    	 
 	
    	 public void audienceselection_list_trigger() throws Exception
    	 {
    	
    		 try
    		 {
    	  
    	   usinglist.click();
    	   button_saveContinue.click();
    	   
    	   Select dropdown = new Select(driver.findElement(By.xpath("//*[@id='showUploadImagePopUpZindex']//select[@ng-model='Lists.selectedOption']")));
	    	 dropdown.selectByVisibleText("Test");
	    	 button_saveNext.click();
	    	 
    	   rep.report_status_pass("Audience is selected");
    	   
    		 }
    		 
    		 catch(Exception e)
    		 {
    			 rep.report_status_fail("Audience", "Audience is not selected");
    		 }
    		 rep.reportFlush();
   	 }
    	 
    	 
    	 public void audience_Criteria_ExstSegment() throws Exception
         {
    		 rep.logger=rep.report.startTest("Audience Selection");
      		
      		WebDriverWait wait = new WebDriverWait(driver, 60);
          try
          {
        	  
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Using Existing Segment')]")));
          driver.findElement(By.xpath("//span[contains(text(),'Using Existing Segment')]")).click();
          driver.findElement(By.xpath("//input[@value='Save & Next']")).click();
          //button_saveNext.click();
          
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Define Audience you want to Target ')]")));
          
          driver.findElement(By.xpath("//a[@ng-click='$removeTag()']")).click();
          driver.findElement(By.xpath("//input[@placeholder='Add Inclusionary Segment']")).click();
          driver.findElement(By.xpath("//input[@placeholder='Add Inclusionary Segment']")).sendKeys("Hawaii3_12_14");
          Thread.sleep(2000);
          driver.findElement(By.xpath("//input[@placeholder='Add Inclusionary Segment']")).sendKeys(Keys.TAB);
          driver.findElement(By.xpath("//input[@value='Save & Next']")).click();
          rep.report_status_pass("Audience is selected");
          }
          catch(Exception e)
   		{
        	  
   			rep.report_status_fail("Audience", "Audience is not selected");
   			
   		}
          rep.reportFlush();
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
     		rep.reportFlush();
         }
    	 public void audience_Criteria_AllMembers() throws Exception
         {
    		 rep.logger=rep.report.startTest("Audience Selection");
      		
      		WebDriverWait wait = new WebDriverWait(driver, 60);
          try
          {
        	  
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Create trigger for')]")));
          driver.findElement(By.xpath("//span[contains(text(),'Create trigger for')]")).click();
          driver.findElement(By.xpath("//button[contains(.,'Save & Continue')]")).click();
          
          rep.report_status_pass("Audience is selected");
          }
          catch(Exception e)
   		{
   			rep.report_status_fail("Audience", "Audience is not selected");
   		}
          rep.reportFlush();
         }
    	 
    	 public void audience_Criteria_All_Broad() throws Exception
         {
    		 rep.logger=rep.report.startTest("Audience Selection");
      		
      		WebDriverWait wait = new WebDriverWait(driver, 60);
          try
          {
        	  
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'All (Using List and Store, other Attributes)')]")));
          driver.findElement(By.xpath("//span[contains(text(),'All (Using List and Store, other Attributes)')]")).click();
          driver.findElement(By.xpath("//input[@value='Save & Next']")).click();
          
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='showUploadImagePopUpZindex']//select[@ng-model='Lists.selectedOption']")));
          
          // Select List
          driver.findElement(By.xpath("//*[@id='showUploadImagePopUpZindex']//select[@ng-model='Lists.selectedOption']")).click();
          Select dropdown = new Select(driver.findElement(By.xpath("//*[@id='showUploadImagePopUpZindex']//select[@ng-model='Lists.selectedOption']")));
          int lsize = dropdown.getOptions().size();
          if(lsize > 1)
          {
        	  driver.findElement(By.xpath("//*[@id='showUploadImagePopUpZindex']//select[@ng-model='Lists.selectedOption']/option[2]")).click();
          }
          
          //Select Segment
          driver.findElement(By.xpath("//a[@ng-click='$removeTag()']")).click();
          driver.findElement(By.xpath("//input[@placeholder='Add Inclusionary Segment']")).click();
          driver.findElement(By.xpath("//input[@placeholder='Add Inclusionary Segment']")).sendKeys("Hawaii3_12_14");
          Thread.sleep(2000);
          driver.findElement(By.xpath("//input[@placeholder='Add Inclusionary Segment']")).sendKeys(Keys.TAB);
          
          //Select Store
          
          
          rep.report_status_pass("Audience is selected");
          }
          catch(Exception e)
   		{
        	System.out.println(e.getMessage());
   			rep.report_status_fail("Audience", "Audience is not selected");
   		}
          rep.reportFlush();
         }
    	 
    	 
    	 
    }
 	   
 	   


	   
	
