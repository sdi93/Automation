package com.fishbowl.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fishbowl.utility.Reporting;


public class StoreSelection
{   
  
	Reporting rep = new Reporting();
	
	WebDriver driver;
	 
	public StoreSelection(WebDriver ldriver)
	{
	  this.driver=ldriver;
	}
    
    @FindBy(how=How.XPATH,using="//div[@class='tree-input']")
    @CacheLookup
    WebElement selectStores_DD;
    
    @FindBy(how=How.XPATH,using="//input[@placeholder='Search...']")
    @CacheLookup
    WebElement storeSearch_textbox;
    
    @FindBy(how=How.XPATH,using="//input[@value='Save & Next']")
    @CacheLookup
    WebElement button_saveNext;
    
    @FindBy(how=How.XPATH,using="//input[@placeholder='Add Exclusionary Segment']")
    @CacheLookup
    WebElement exclude_seg_box;

    
	public void storeSelection(String store) throws Exception
	   {
		
		rep.logger=rep.report.startTest("Store Selection");
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
			
		try
		{

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='tree-input']")));
		selectStores_DD.click();
		storeSearch_textbox.sendKeys(store);
		
		driver.findElement(By.xpath("//span[@class='expand ng-scope' and @tabindex='0']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='ng-scope']/child::*/*//*[contains(text(),'"+store+"')]")));
	   
		driver.findElement(By.xpath("//li[@class='ng-scope']/child::*/*//*[contains(text(),'"+store+"')]"));
	    driver.findElement(By.xpath("//li[@class='ng-scope']/child::*/*//*[contains(text(),'"+store+"')]")).click();
	   
	    button_saveNext.click();
	    
	    rep.report_status_pass("Store is selected successfully");
	    
		}
		
		catch(Exception e)
		{
			rep.report_status_fail("Store_selection", "Store is not selected");
		}
	    

		
		rep.reportFlush();
   
      }
	
	
	public void exclude_segment() throws Exception
	{
        
		rep.logger=rep.report.startTest("Exclude Segment");
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		
		try
		{

		   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Define Audience you want to Target ']")));
		   
		  exclude_seg_box.click();
		  driver.findElement(By.xpath("//span[text()='FRED_TEST_ONLY']")).click();
		   
		   button_saveNext.click();
		   
		   rep.report_status_pass("Store is selected successfully");
		   
		}
		
		catch(Exception e)
		{
			rep.report_status_fail("Store_selection", "Store is not selected");
		}
	}
	
	
}
