package malive;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import crmLoyalty.ReadingExcel;

public class TriggeredMethod 
{
	ExtentReports report;
	ExtentTest logger;
	public static WebDriver driver;
	
	public String L1_L1 = "//*[@class='netSales']/child::*/*//*/h3";
	public String L1_L2 = "//*[@class='checkAverage']/child::*/*//*/h3";
	public String L1_L3 = "//*[@class='guestCount']/child::*/*//*/h3";
	public String L1_L4 = "//*[@id='customerMix']/child::*//*/tbody/tr[1]/td[2]";
	public String L1_L5 = "//*[@id='itemSales']/child::*/*//*/tbody/tr[1]/td[2]";
	public String L1_L6 = "//*[@id='decile_bubble']/child::*/*//*[contains(text(),'NetSales')]";
	public String L1_L7 = "//*[@id='TopStoreBySale']/child::*//tbody/tr[1]/td[2]";
	public String L1_L8 = "//*[@id='campaign']/child::*//tbody/tr[1]/td[2]";
	public String loginxp = "//*[@class='x-pad']/child::*/*[@value='Login']";
	
	public String button_createCampaign = "//span[contains(.,'Create Campaign ')]";
	public String sms_typeCampaign = "//li[@campaigntype='smsCampaign']";
	public String dropd_smsType = "//select[@ng-change='smsCampaignTypeChange()']";
	public String dd_triggered = "//*[contains(text(),'Triggered') and @value =7]";
	public String textbox_campName = "//*[@ placeholder='Campaign Name']";
	public String button_continue = "//button[@class='btn btn-primary active']";
	
	List<String> list ;
	String url;
	String username;
	String password;
	String selectAll;
	String starttime;
	String campaignname;
	String CampaignDescription;
	String Keyword ;
	String welcomeMessage;
	String PromotionID ;
	String createcampaign;
	String store;
	String extMemeber;
	String invalidMessage;
	String todayScheduling;
	String sendingTime;
	String confirmMessage;
	
	public void Browserinvoke(String repName)
	{
		
		//report=new ExtentReports("/Users/fishbowl/Desktop/"+repName+".html");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		
		try
		{
			String filePath = "C:/Users/schaudhary_ic/Desktop";
			ReadingExcel read = new ReadingExcel();
			list = read.readfile(filePath, "ExportExcel.xlsx", "Acquisition");
			selectAll = Keys.chord(Keys.CONTROL, "a");
			url = list.get(0);
			username = list.get(1);
			password = list.get(2);
			createcampaign = list.get(3);
			campaignname = list.get(4);
			CampaignDescription = list.get(5);
			Keyword = list.get(6);
			welcomeMessage = list.get(7);
			PromotionID = list.get(8);
			starttime = list.get(9);
			extMemeber = list.get(12);
			invalidMessage =list.get(13);
			confirmMessage = list.get(14);
			store = list.get(15);
			//todayScheduling = list.get(16);
			//sendingTime = list.get(17);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		driver.get(url);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	
	public void login() {
		// WebDriverWait wait = new WebDriverWait(driver, 180);
		// driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
		
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys(username);
		driver.findElement(By.id("pwd")).clear();
		driver.findElement(By.id("pwd")).sendKeys(password);
		WebElement loginbutton = driver.findElement(By.xpath(loginxp));
		loginbutton.click();
	}

	public boolean L1_dashboardView() throws Exception
	   {
		   login();
		   long start_m = System.currentTimeMillis();
		   long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
		   driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		   try 
		   {
			 //  verifyelementL1(this.L1_L1, this.L1_L2, this.L1_L3, this.L1_L4, this.L1_L5, this.L1_L6, this.L1_L7, this.L1_L8);
			   Thread.sleep(10000);
		   } 
		   catch (Exception e)
		   { 		   
			  
			   return false;
		   }
		   return true;
	   }
   
   public boolean campaignNaivation()
	{
			long start_m = System.currentTimeMillis();
			long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);	
			WebDriverWait wait = new WebDriverWait(driver, 60);
			 try 
			   {
					driver.get(createcampaign);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(button_createCampaign)));
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Campaigns & Offers')]")));
			   } 
			   catch (Exception e)
			   { 
				   System.out.println(e);
				   return false;
			   }
			return true;
	}
   
   public boolean campaignCreation()
	{
		long start_m = System.currentTimeMillis();
		long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);	
		WebDriverWait wait = new WebDriverWait(driver, 60);
		try
		{
			WebElement a  = driver.findElement(By.xpath(button_createCampaign));
			WebElement b  = driver.findElement(By.xpath(sms_typeCampaign));
			hoverOnMainAndClickSubLink(a,b);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(.,'Create SMS Campaign')]")));
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropd_smsType)));
			
			driver.findElement(By.xpath(dropd_smsType)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dd_triggered)));
			driver.findElement(By.xpath(dd_triggered)).click();
			
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(textbox_campName)));
			driver.findElement(By.xpath(textbox_campName)).sendKeys(campaignname);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(textbox_campName)));
			driver.findElement(By.xpath(button_continue)).click();
		//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Define SMS Info Campaign')]")));
		}
		catch(Exception e)
		{
				return false;
		}
		return true;
	}
   
   public void verifyelementL1(String xp1, String xp2, String xp3, String xp4, String xp5, String xp6, String xp7,	String xp8) 
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp1)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp2)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp3)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp4)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp5)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp6)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp7)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp8)));
	}
   
	public void hoverOnMainAndClickSubLink(WebElement mainElement, WebElement subElement)
	{
		  Actions actions = new Actions(driver);
		  Actions builder = actions.moveToElement(mainElement);
		  Action b = builder.build();
		  b.perform();
		  actions.moveToElement(mainElement).click().build().perform();
		  actions.moveToElement(subElement);
		  actions.click().build().perform();
	}
   
}
