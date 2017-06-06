package com.fishbowl.eupPages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fishbowl.config.EUP_Common;
import com.fishbowl.config.EUP_Locators;
import com.fishbowl.utility.ReadExcelUtils;
import com.fishbowl.utility.Reporting;
import com.relevantcodes.extentreports.LogStatus;



public class EUP_ChangePassword 
{
	WebDriver driver;
	EUP_Locators obj1 = new EUP_Locators();
	EUP_Common eupCommon=new EUP_Common();
	Reporting rep = new Reporting();

	
	public EUP_ChangePassword(WebDriver ldriver)
	{
	  this.driver=ldriver;
	}
	
	public void updatePassword()throws Exception
	{
		//logger=report.startTest("Change Password");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		try
		{
			driver.findElement(By.xpath(obj1.get_password_navTab())).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj1.get_resetPass_pageVerify())));
			
			driver.findElement(By.xpath(obj1.get_current_password())).clear();
			driver.findElement(By.xpath(obj1.get_current_password())).sendKeys(eupCommon.password);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj1.get_newpassword_tetbox())));
			driver.findElement(By.xpath(obj1.get_newpassword_tetbox())).clear();
			driver.findElement(By.xpath(obj1.get_newpassword_tetbox())).sendKeys(eupCommon.newPass);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj1.get_confPassword_textbox())));
			driver.findElement(By.xpath(obj1.get_confPassword_textbox())).clear();
			driver.findElement(By.xpath(obj1.get_confPassword_textbox())).sendKeys(eupCommon.newPass);
			
			ReadExcelUtils.writeExcel(eupCommon.filePath, eupCommon.fileName, eupCommon.testSheet,1 , 6, eupCommon.newPass);
			driver.findElement(By.xpath(obj1.get_submitButton_password())).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj1.get_success_dialog())));
			driver.findElement(By.xpath(obj1.get_success_dialog()));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj1.get_dialog_okButton())));
			driver.findElement(By.xpath(obj1.get_dialog_okButton())).click();
			//logger.log(LogStatus.PASS, "Password update Complete");
		}
		catch(Exception e)
		{
			 System.out.println(e);
			  // logger.log(LogStatus.FAIL, "Password  not changed succssfully",image);
		}
	}
	
}
