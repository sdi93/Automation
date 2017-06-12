package com.fishbowl.config;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.fishbowl.utility.ReadExcelUtils;
import com.fishbowl.utility.Reporting;

public class GABase 
{
	public static WebDriver driver;
	public static List<String> list ;
	public static String filePath = "/FishbowlGitCode/FBAutomation/Data/";
	public static String fileName = "GA_Data.xlsx";
	public static String testSheet = "ClientInfo";
	public static String url,reportName,username,password;
	Reporting rep = new Reporting();
	GA_CommonLocators comLocs = new GA_CommonLocators();

		@BeforeSuite
		public void clientLogin() throws Exception 
		{
			
			try
				{
					list = ReadExcelUtils.readExcelList(filePath, fileName ,testSheet);
					reportName = list.get(0);
					url = list.get(1);
				 	username = list.get(2);
				 	password = list.get(3);
				}
			catch(Exception e)
				{
					System.out.println(e);
				}
		
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(url);
			rep.reportINitialise(reportName);
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
			
			
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(comLocs.get_loginUser())));
			driver.findElement(By.xpath(comLocs.get_loginUser())).clear();
			driver.findElement(By.xpath(comLocs.get_loginUser())).sendKeys(username);
			driver.findElement(By.xpath(comLocs.get_loginUser())).clear();
			driver.findElement(By.xpath(comLocs.get_loginUser())).sendKeys(password);
			WebElement loginbutton = driver.findElement(By.xpath(comLocs.get_loginButton()));
			loginbutton.click();
		   }
		
		 @org.testng.annotations.AfterSuite
			public void quit() {
			 driver.close();
				driver.quit();
			}
	   
}
