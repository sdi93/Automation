package malive;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import com.relevantcodes.extentreports.LogStatus;

public class SMSMeth 
{
	ExtentReports report;
	ExtentTest logger;
	public static WebDriver driver;
	List<String> list ;
	String url;
	String username;
	String password;
	String createcampaign ;
	String campaignname;
	String smstext ;
	String PromotionID ;
	String store;
	//String filePath = "C://Users//schaudhary_ic//Desktop";
	String filePath = "C:/Users/schaudhary_ic/Desktop";
	
	public String loginxp = "//*[@class='x-pad']/child::*/*[@value='Login']";
	public String button_createCampaign = "//span[contains(.,'Create Campaign ')]";
	public String sms_typeCampaign = "//li[@campaigntype='smsCampaign']";
	public String dropd_smsType = "//select[@ng-change='smsCampaignTypeChange()']";

	public String dd_broadcast = "//*[contains(text(),'Broadcast') and @value =4]";
	public String textbox_campName = "//*[@ placeholder='Campaign Name']";
	public String button_continue = "//button[@class='btn btn-primary active']";
	public String defCamp_textbox ="//*[@id='smsText']";
	public String defCamp_dropdown = "//input[@aria-label='Choose from saved messages to pre-fill SMS text.']";
	public String button_saveNext = "//input[@value='Save & Next']";
	public String button_saveContinue="//button[contains(.,'Save & Continue')]";
	public String radiobtn_store = "//*[contains(text(),'Using Stores & Other Attributes')]";
	public String radiobtn_ExtSegment= "//div[@class='pl20']/div[1]/child::*//*[contains(text(),'Using Existing Segment')]";
	public String selectStores_DD = "//div[@class='tree-input']";
	public String storeSearch_textbox = "//input[@placeholder='Search...']";
	public String sendNow_radiobtn = "//span[contains(text(),'Send Now')]";
	public String publish_button = "//input[@value='Publish']";
	
	public String L1_L1 = "//*[@class='netSales']/child::*/*//*/h3";
	public String L1_L2 = "//*[@class='checkAverage']/child::*/*//*/h3";
	public String L1_L3 = "//*[@class='guestCount']/child::*/*//*/h3";
	public String L1_L4 = "//*[@id='customerMix']/child::*//*/tbody/tr[1]/td[2]";
	public String L1_L5 = "//*[@id='itemSales']/child::*/*//*/tbody/tr[1]/td[2]";
	public String L1_L6 = "//*[@id='decile_bubble']/child::*/*//*[contains(text(),'NetSales')]";
	public String L1_L7 = "//*[@id='TopStoreBySale']/child::*//tbody/tr[1]/td[2]";
	public String L1_L8 = "//*[@id='campaign']/child::*//tbody/tr[1]/td[2]";
	
	public void Browserinvoke(String repName)
	{
		
		report=new ExtentReports("E:/SeleniumWorkspace/ws1/Pro1/report/"+repName+".html",true);
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		try
		{
			list = ReadExcelFile.readExcel(filePath, "ExportExcel.xlsx", "SMSBroadcast");
			url = list.get(0);
			username = list.get(1);
			password = list.get(2);
		 	createcampaign = list.get(3);
		 	campaignname = list.get(4);
		 	//PromotionID = list.get(8);
		 	smstext = list.get(6);
		 	store = list.get(7);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		driver.get(url);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	
	public void login()
	{
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys(username);
		driver.findElement(By.id("pwd")).clear();
		driver.findElement(By.id("pwd")).sendKeys(password);
		WebElement loginbutton = driver.findElement(By.xpath(loginxp));
		loginbutton.click();
	}
	
	public boolean L1_dashboardView() throws Exception
	   {
		   
		   long start_m = System.currentTimeMillis();
		   long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
		   driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		   try 
		   {
			   login();
			   verifyelementL1(this.L1_L1, this.L1_L2, this.L1_L3, this.L1_L4, this.L1_L5, this.L1_L6, this.L1_L7, this.L1_L8);
			   
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
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dd_broadcast)));
			driver.findElement(By.xpath(dd_broadcast)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(textbox_campName)));
			driver.findElement(By.xpath(textbox_campName)).sendKeys(campaignname);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(textbox_campName)));
			driver.findElement(By.xpath(button_continue)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Define Campaign & Offer')]")));
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	}
	
	public boolean defineCmapaign()
	{
		long start_m = System.currentTimeMillis();
		long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);	
		WebDriverWait wait = new WebDriverWait(driver, 60);
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(defCamp_dropdown)));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(defCamp_textbox)));
			driver.findElement(By.xpath(defCamp_textbox)).sendKeys(smstext);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(defCamp_textbox)));
			driver.findElement(By.xpath(button_saveNext)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Choose Audience Criteria')]")));
		}
		catch(Exception e)
		{
			

		}
		return true;
	}
	
	public boolean audienceCriteriaStore()
	{
		long start_m = System.currentTimeMillis();
		long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);	
		WebDriverWait wait = new WebDriverWait(driver, 60);
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(radiobtn_store)));
			driver.findElement(By.xpath(radiobtn_store)).click();
			driver.findElement(By.xpath(button_saveContinue)).click();
		}
		catch(Exception e)
		{
			

		}
		return true;
	}
	public boolean audienceCriteriaExtSegment()
	{
		long start_m = System.currentTimeMillis();
		long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);	
		WebDriverWait wait = new WebDriverWait(driver, 60);
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(radiobtn_ExtSegment)));
			driver.findElement(By.xpath(radiobtn_ExtSegment)).click();
			driver.findElement(By.xpath(button_saveContinue)).click();
		}
		catch(Exception e)
		{
			

		}
		return true;
	}
	
	public boolean extSegmentSelection()
	{
		
		long start_m = System.currentTimeMillis();
		long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);	
		WebDriverWait wait = new WebDriverWait(driver, 60);
	
		try{
			driver.findElement(By.xpath("//div[@class='selectize-input']")).click();
		driver.findElement(By.xpath(".//*[@id='selectedSegment']/div[1]/input")).sendKeys("rgtTest");
		driver.findElement(By.xpath(".//*[@id='selectedSegment']/div[1]/input")).sendKeys(Keys.DOWN);
		driver.findElement(By.xpath(".//*[@id='selectedSegment']/div[1]/input")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(button_saveNext)).click();
		//driver.findElement(By.xpath("//div[@class='option ui-select-choices-row-inner']"));
		// driver.findElement(By.xpath(".//*[@id='selectedSegment']/div[1]/input")).sendKeys(Keys.TAB);
		
	}
	catch(Exception e){
		
	}
	return true;
	}
	
	
	public boolean storeSlection()
	{
		long start_m = System.currentTimeMillis();
		long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);	
		WebDriverWait wait = new WebDriverWait(driver, 100);
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selectStores_DD)));
			driver.findElement(By.xpath(selectStores_DD)).click();
			driver.findElement(By.xpath(storeSearch_textbox)).sendKeys(store);
			driver.findElement(By.xpath("//span[@class='expand ng-scope' and @tabindex='0']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='ng-scope']/child::*/*//*[contains(text(),'"+store+"')]")));
		//driver.findElement(By.xpath("//li[@class='ng-scope']/child::*/*//*[contains(text(),'"+store+"')]"));
		driver.findElement(By.xpath("//li[@class='ng-scope']/child::*/*//*[contains(text(),'"+store+"')]")).click();
		driver.findElement(By.xpath(button_saveNext)).click();
			}
		catch(Exception e)
		{
			
			return false;
		}
		return true;
	}
	
	public boolean snedingSchedule()
	{
		long start_m = System.currentTimeMillis();
		long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);	
		WebDriverWait wait = new WebDriverWait(driver, 60);
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sendNow_radiobtn)));
			driver.findElement(By.xpath(sendNow_radiobtn)).click();
			driver.findElement(By.xpath(button_saveNext)).click();
		}
		catch(Exception e)
		{
			

		}
		return true;
	}
	
	public boolean databaseTest()
	{
		try
		{
			String query = "SELECT CampaignStatus FROM Acme.Campaign WHERE NAME ='"+campaignname+"' LIMIT 1";
			
			for(int i=0;i<5;i++)
			{
				int reschk = DBConnector.dbCheck("jdbc:mysql://qa-linux-apps1.fishbowlcloud.com","app_common","1@WSXCDE#4",query);
				if(reschk ==4){
					System.out.println(reschk);
					break;
				}
				Thread.sleep(30000);
			}
		}
		catch(Exception e){} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	
	public boolean publishigBroadcast()
	{
		long start_m = System.currentTimeMillis();
		long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);	
		WebDriverWait wait = new WebDriverWait(driver, 60);
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(publish_button)));
			driver.findElement(By.xpath(publish_button)).click();
		//	driver.findElement(By.xpath(button_saveNext)).click();
		}
		catch(Exception e)
		{
			

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
