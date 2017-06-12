package com.fishbowl.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import com.fishbowl.utility.ReadExcelUtils;
import com.fishbowl.utility.Reporting;

public class Common 
{

	public static WebDriver driver;
	
	public static String url = null;

	

	@BeforeTest
	public void login() throws Exception 
	{
		
		ReadExcelUtils.setExcelFile("/FishboelGitCode/FBAutomation/Data/CampaignData.xlsx", "Credentials");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	    url = ReadExcelUtils.getCellData(0,0);
	    
	    driver.get(url);
		
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		
		LoginPageLocators obj1 = new LoginPageLocators();
		
		
		driver.findElement(By.xpath(obj1.get_username())).sendKeys(ReadExcelUtils.getCellData(0,1));
		driver.findElement(By.xpath(obj1.get_password())).sendKeys(ReadExcelUtils.getCellData(0,2));
	    driver.findElement(By.xpath(obj1.get_login_btn())).click();
	   
	    
	    Reporting rep = new Reporting();
	    rep.reportINitialise("Report");
	    
	   }
	
	
	@AfterTest
	public void close()
	{
		Reporting rep = new Reporting();
		rep.reportFlush();
		driver.close();
	}
	   
	   
}	

