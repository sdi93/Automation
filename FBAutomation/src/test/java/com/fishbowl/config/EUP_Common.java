package com.fishbowl.config;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import com.fishbowl.utility.ReadExcelUtils;
import com.fishbowl.utility.Reporting;

public class EUP_Common {

public static WebDriver driver;
public static List<String> list ;
public static String filePath = "/FishbowlGitCode/FBAutomation/Data/";
public static String fileName = "EUP_Data.xlsx";
public static String testSheet = "Registration";
public static String fname,lname,phone,email,password,birthdate,zipcode,address,city,oldEmail,url,newEmail;
public static String newPass = "password123";
Reporting rep = new Reporting();

	@BeforeSuite
	public void endUserPortal() throws Exception 
	{
		
		try
			{
				list = ReadExcelUtils.readExcelList(filePath, fileName ,testSheet);
				url = list.get(0);
				fname = list.get(1);
				lname = list.get(2);
				email = list.get(3);
				password = list.get(4);
			 	oldEmail = list.get(5);
			 	address = list.get(7);
			 	city = list.get(8);
			 	
			 	Random rand = new Random();
				int num = rand.nextInt(9000000) + 1000000;
				phone = "999"+String.valueOf(num);
				
				Random random = new Random();
				int numb = random.nextInt(900) + 100;
				newEmail = email+ String.valueOf(num) +"@gmail.com";
			}
		catch(Exception e)
			{
				System.out.println(e);
			}
	
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		rep.reportINitialise("EUPReport");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
		
		EUP_Locators obj1 = new EUP_Locators();
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj1.get_signup())));
		driver.findElement(By.xpath(obj1.get_signup())).click();
	   }
	
	 @org.testng.annotations.AfterSuite
		public void quit() {
		 driver.close();
			driver.quit();
		}
}
