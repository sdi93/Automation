package com.fishbowl.testclp2;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ClpTestMeth 
{
	ExtentReports report;
	ExtentTest logger;
	public static WebDriver driver;
	String AppUrl = "https://test.clyptechs.com/#/login";
	File dir1;
	String reportName;
	String date =null;
	public static String initialSNAPLOC ;
	public static String SNAPLOC ;
	String repName = "TestClyptechs2.0";
	
	public void Browserinvoke()
	{
		date = date();
		initialSNAPLOC = "E:/SeleniumReport/"+repName+date;
		reportName = repName;

		dir1 = new File(initialSNAPLOC);
		SNAPLOC = initialSNAPLOC+"/";
		dir1.mkdir();
		report=new ExtentReports(SNAPLOC+"/"+repName+".html",true);
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		driver.get(AppUrl);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	
	public boolean login()
	{
		logger=report.startTest("Login");
		   long start_m = System.currentTimeMillis();
		   long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
		   driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		   WebDriverWait wait = new WebDriverWait(driver, 60);
		   try 
		   {
			   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='login']")));
			   driver.findElement(By.xpath("//input[@id='login']")).sendKeys("clypadmin");;
			   driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("password");
			   driver.findElement(By.xpath("//input[@class='login btn']")).click();
			   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(.,'Campaigns & Offers')]")));
			
			  
			   logger.log(LogStatus.PASS, "User able to login successfully");
		   } 
		   catch (Exception e)
		   { 
			   logger.log(LogStatus.FAIL, "Login failed");
			   return false;
		   }
		   return true;
	}
	
	public boolean cmapaignCreation()
	{
		logger=report.startTest("Campaign Creation");
		   long start_m = System.currentTimeMillis();
		   long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
		   driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		   WebDriverWait wait = new WebDriverWait(driver, 60);
		   try 
		   {
			   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(.,'Campaigns & Offers')]")));
			   
			   driver.findElement(By.xpath("//div[contains(.,'Create Campaign') and @class='button GreenButton']")).click();//clicking Green button to start creating campign
			   
			   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(.,'Select Channel')]")));
			   
			   driver.findElement(By.xpath("//*[text()='SMS']")).click();//clicking SMS radio button
			   
			   driver.findElement(By.xpath("//span[contains(.,'Save & Next')]")).click();//click save and next button
			   
			   logger.log(LogStatus.PASS, "Creating Campaign started successfully");
		   } 
		   catch (Exception e)
		   { 
			   logger.log(LogStatus.FAIL, "Campaign creation not successfully");
			   return false;
		   }
		   return true;
	}
	
	public boolean definingCampaign()
	{
		   logger=report.startTest("Defining campaign");
		   long start_m = System.currentTimeMillis();
		   long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
		   driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		   WebDriverWait wait = new WebDriverWait(driver, 60);
		   try 
		   {
			   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(.,'Define Campaign & Offer')]")));
			  
			   driver.findElement(By.xpath("//textarea[@id='offer_title']")).sendKeys("Test  26 May 2017");
			   
			   Thread.sleep(3000);
			   
			   driver.findElement(By.xpath("//span[contains(.,'Save & Next')]")).click();
			   
			   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(.,'Define Audience You Want to Target')]")));
			   
			   logger.log(LogStatus.PASS, "Campaign defining completed successfully");
		   } 
		   catch (Exception e)
		   { 
			   logger.log(LogStatus.FAIL, "Campaign defining not completed");
			   return false;
		   }
		   return true;
	}
	
	public boolean targetedAudience()
	{
		 logger=report.startTest("Targeting Audience");
		   long start_m = System.currentTimeMillis();
		   long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
		   driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		   WebDriverWait wait = new WebDriverWait(driver, 60);
		   try 
		   {
			   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(.,'Define Audience You Want to Target')]")));
			   
			   driver.findElement(By.xpath("//div[@id='divLeft']/child::*//*[contains(@ng-click,'clickAccordian(2)')]")).click();
			   
			   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@ng-model='groupData.currentSegmentGro']")));
			   
			   driver.findElement(By.xpath("//select[@ng-model='groupData.currentSegmentGro']")).click();;
			   
			   driver.findElement(By.xpath("//select[@ng-model='groupData.currentSegmentGro']/option[contains(.,'test_sanity_mighty_text')]")).click();
			   
			   Thread.sleep(5000);
			   
			   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,'Save & Next')]")));

			   driver.findElement(By.xpath("//a[contains(.,'Save & Next')]")).click();
			   
			   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(.,'Scheduled Triggers')]")));
			   
			   logger.log(LogStatus.PASS, "Audience targeted successfully");
		   } 
		   catch (Exception e)
		   { 
			   logger.log(LogStatus.FAIL, "Audience target not successful");
			   return false;
		   }
		   return true;
	}
	
	public boolean scheduling()
	{
		 logger=report.startTest("Scheduling Publishing");
		   long start_m = System.currentTimeMillis();
		   long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
		   driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		   WebDriverWait wait = new WebDriverWait(driver, 60);
		   try 
		   {
			   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(.,'Scheduled Triggers')]")));
			
			   driver.findElement(By.xpath("//*[contains(.,'Send Now') and @class='radio_text']")).click();
			   
			   driver.findElement(By.xpath("//span[contains(.,'Save & Publish')]")).click();
			   
			   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Ok'and @type='submit']")));
			   driver.findElement(By.xpath("//input[@value='Ok'and @type='submit']")).click();
			   
			   logger.log(LogStatus.PASS, "SMS set to send now and  published");
		   } 
		   catch (Exception e)
		   { 
			   logger.log(LogStatus.FAIL, "SMS could not be set to send now or published");
			   return false;
		   }
		   return true;
	}
	
	public boolean playingSMS()
	{
		 logger=report.startTest("Playing SMS");
		   long start_m = System.currentTimeMillis();
		   long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
		   driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		   WebDriverWait wait = new WebDriverWait(driver, 60);
		   try 
		   {
			   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(.,'Campaigns & Offers')]")));
			
			   driver.findElement(By.xpath("//a[@id='play_btn'][1]")).click();
			   
			   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Ok'and @type='submit']")));
			   driver.findElement(By.xpath("//input[@value='Ok'and @type='submit']")).click();
			   Thread.sleep(2000);
			   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Ok'and @type='submit']")));
			   driver.findElement(By.xpath("//input[@value='Ok'and @type='submit']")).click();
			 //  driver.findElement(By.xpath("//input[@value='Ok'and @type='submit']")).click();
			   
			   logger.log(LogStatus.PASS, "SMS played Successfully");
		   } 
		   catch (Exception e)
		   { 
			   logger.log(LogStatus.FAIL, "SMS play not Successful");
			   return false;
		   }
		   return true;
	}
	
	public String  date()
	{
		final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	    LocalDate localDate = LocalDate.now();
        System.out.println(DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate));
		String datee = DateTimeFormatter.ofPattern("dd").format(localDate);
		return datee;
	}

	public String  dateAndTime()
	{
		final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
	    final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
	    LocalDate localDate = LocalDate.now();
        System.out.println(DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate));
		String datee = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").format(localDate);
		return datee;
	}

}
