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

public class EUP_UpdateProfile 
{
	WebDriver driver;
	EUP_Locators obj1 = new EUP_Locators();
	EUP_Common eupCommon=new EUP_Common();
	Reporting rep = new Reporting();
	
	public EUP_UpdateProfile(WebDriver ldriver)
	{
	  this.driver=ldriver;
	}
	
	public void userProfileUpdate()throws Exception
	{
		rep.logger= rep.report.startTest("UserProfile Update");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		try
		{
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj1.get_profile_navTab())));
			driver.findElement(By.xpath(obj1.get_profile_navTab())).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj1.get_edit_button())));
			driver.findElement(By.xpath(obj1.get_edit_button())).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj1.get_editPorf_fName())));
			driver.findElement(By.xpath(obj1.get_editPorf_fName())).clear();
			driver.findElement(By.xpath(obj1.get_editPorf_fName())).sendKeys("Siddharth123");
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj1.get_saveButton())));
			
			driver.findElement(By.xpath(obj1.get_saveButton())).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj1.get_success_dialog())));
			driver.findElement(By.xpath(obj1.get_success_dialog()));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj1.get_dialog_okButton())));
			driver.findElement(By.xpath(obj1.get_dialog_okButton())).click();
			Thread.sleep(2000);
			rep.report_status_pass("USer profile updated  succesfully");

		}
		catch(Exception e)
		{
			System.out.println(e);
			rep.report_status_fail("failed_updateProf", "User proile updatin not complete");
	
		}
		
	}
}
