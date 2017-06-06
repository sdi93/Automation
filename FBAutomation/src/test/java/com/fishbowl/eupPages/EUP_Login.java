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

public class EUP_Login
{
	WebDriver driver;
	EUP_Locators obj1 = new EUP_Locators();
	EUP_Common eupCommon=new EUP_Common();
	Reporting rep = new Reporting();

	
	public EUP_Login(WebDriver ldriver)
	{
	  this.driver=ldriver;
	}
	public void login(String condition)throws Exception
	{
		//logger=report.startTest("Log-In with Registered User");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Email/Mobile Phone')]")));
			if(condition.equalsIgnoreCase("Simple"))
			{
				driver.findElement(By.id("exampleInputEmail1")).sendKeys(eupCommon.newEmail);
				driver.findElement(By.id("exampleInputPassword1")).sendKeys(eupCommon.password);
			}
			else
			{
				driver.findElement(By.id("exampleInputEmail1")).sendKeys(eupCommon.newEmail);
				driver.findElement(By.id("exampleInputPassword1")).sendKeys(eupCommon.newPass);
			}
			
			driver.findElement(By.xpath("//input[@value='Sign in']")).click();
			//logger.log(LogStatus.PASS, "Login Successfull");
		}
		catch(Exception e)
		{
			System.out.println(e);
			//rep.logger.log(LogStatus.FAIL, "not able to Login",image);
		
		}
	
	}
}
