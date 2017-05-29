package malive;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import com.relevantcodes.extentreports.LogStatus;

public class AcquisitionMethod 
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
		public String dd_acquisition = "//*[contains(text(),'Acquisition') and @value =5]";
		public String textbox_campName = "//*[@ placeholder='Campaign Name']";
		public String button_continue = "//button[@class='btn btn-primary active']";
		public String zipSelector_dropdown  = "//select[contains(@ng-model,'campaignPopupType.uiMetaData.acquisitionType')]";
		public String zip_append = "//option[contains(.,'Zip Append')]";
		
		public String campDesc = "//*[@placeholder='Campaign Description']";
		public String campKeyword = "//input[@ng-model='campaign.smsKeyWord.keyword']";
		public String confirmation_message = "//textarea[@placeholder='Confirmation Message']";
		public String welcome_message = "//textarea[@placeholder='Welcome Message']";
		public String existing_message = "//textarea[@placeholder='Response to Existing Members']";
		public String invalid_message ="//textarea[@placeholder='Invalid Message']";
	
		
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
		

		File dir1;
		String reportName;
		
		String date =null;
		public static String initialSNAPLOC ;
		public static String SNAPLOC ;
		
		public void Browserinvoke(String repName)
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
			
			try
			{
				String filePath = "C:/Users/schaudhary_ic/Desktop";
				ExcelFileRW read = new ExcelFileRW();
				list = read.readExcel(filePath, "ExportExcel.xlsx", "Acquisition");
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
			   logger=report.startTest("L1_Dashboard");
			   long start_m = System.currentTimeMillis();
			   long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
			   driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
			   try 
			   {
				   login();
				   verifyelementL1(this.L1_L1, this.L1_L2, this.L1_L3, this.L1_L4, this.L1_L5, this.L1_L6, this.L1_L7, this.L1_L8);
				   logger.log(LogStatus.PASS, "Data Loaded successfully on L1");
			   } 
			   catch (Exception e)
			   { 		   
				   logger.log(LogStatus.FAIL, "Data not loaded in all tiles for L1");
				   return false;
			   }
			   return true;
		   }
	   
	   public boolean campaignNaivation()
		{
		   logger=report.startTest("Campaign Navigation");
				long start_m = System.currentTimeMillis();
				long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
				driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);	
				WebDriverWait wait = new WebDriverWait(driver, 60);
				 try 
				   {
						driver.get(createcampaign);
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(button_createCampaign)));
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Campaigns & Offers')]")));
						 logger.log(LogStatus.PASS, "Navigation to campaign page successful");
				   } 
				   catch (Exception e)
				   { 
					   System.out.println(e);
					   logger.log(LogStatus.FAIL, "Navigation to campaign page failed");
					   return false;
				   }
				return true;
		}
	   
	   public boolean campaignCreation()
		{
		   logger=report.startTest("Campaign Creation");
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
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dd_acquisition)));
				driver.findElement(By.xpath(dd_acquisition)).click();
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(zip_append)));
				driver.findElement(By.xpath(zip_append)).click();
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(zipSelector_dropdown)));
				driver.findElement(By.xpath(zipSelector_dropdown));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(textbox_campName)));
				driver.findElement(By.xpath(textbox_campName)).sendKeys(campaignname);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(textbox_campName)));
				driver.findElement(By.xpath(button_continue)).click();
			//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Define SMS')]")));
				logger.log(LogStatus.PASS, "New campaign created Successfully");
			}
			catch(Exception e)
			{
				logger.log(LogStatus.FAIL, "New campaign creation failed");
					return false;
			}
			return true;
		}
	   
	   public boolean defineCmapaign()
		{
		   logger=report.startTest("Defining Campaign");
			long start_m = System.currentTimeMillis();
			long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);	
			WebDriverWait wait = new WebDriverWait(driver, 60);
			try
			{	
				driver.findElement(By.xpath(campDesc)).sendKeys(CampaignDescription);
				driver.findElement(By.xpath(campKeyword)).sendKeys(Keyword);
				driver.findElement(By.xpath(confirmation_message)).sendKeys(confirmMessage);
				driver.findElement(By.xpath(welcome_message)).sendKeys(welcomeMessage);
				driver.findElement(By.xpath(existing_message)).sendKeys(extMemeber);
				driver.findElement(By.xpath(invalid_message)).sendKeys(invalidMessage);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Save & Next' and @class = 'bluebutton']")));
				driver.findElement(By.xpath("//input[@value='Save & Next' and @class = 'bluebutton']")).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Select a list that members will get subscribed to')]")));
				logger.log(LogStatus.PASS, "Campaign definition complete");
			}
			catch(Exception e)
			{
				logger.log(LogStatus.FAIL, "Campaign definition failed");
					return false;
			}
			return true;
		}
	   
	   public boolean subscriptionCriteria()
		{
		   logger=report.startTest("Subscription Criteria");
			long start_m = System.currentTimeMillis();
			long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);	
			WebDriverWait wait = new WebDriverWait(driver, 60);
			try
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[contains(@ng-model,'Lists.selectedOption')]")));
				driver.findElement(By.xpath("//select[contains(@ng-model,'Lists.selectedOption')]")).click();
				driver.findElement(By.xpath("//select[contains(@ng-model,'Lists.selectedOption')]")).sendKeys("Trigger list");
				driver.findElement(By.xpath("//input[@value='Save & Next' and @class = 'bluebutton']")).click();
				//driver.findElement(By.xpath(button_saveContinue)).click();
				logger.log(LogStatus.PASS, "Choosing subscription Criteria complete");
			}
			catch(Exception e)
			{
				logger.log(LogStatus.FAIL, "Chooosing subscription Criteria failed");
				return false;
			}
			
			return true;
		}
	   
	   public boolean scheduling()
		{
		   logger=report.startTest("Sending Schedule");
			long start_m = System.currentTimeMillis();
			long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);	
			WebDriverWait wait = new WebDriverWait(driver, 100);
			try
			{			
				Thread.sleep(5000);
				driver.findElement(By.xpath("//input[@value='Save & Next' and @class = 'bluebutton']")).click();
				logger.log(LogStatus.PASS, "Sending schedule set");
			}
			catch(Exception e)
			{
				System.out.println(e);
				logger.log(LogStatus.FAIL, "Setting sending schedule failed");
				return false;
			}
			return true;
		}
	   
	   public boolean scheduling2()
		{
			long start_m = System.currentTimeMillis();
			long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);	
			WebDriverWait wait = new WebDriverWait(driver, 100);
			try
			{	Thread.sleep(8000);
				// setting Start Date
				
				// find the calendar
				driver.findElement(By.xpath(".//*[@placeholder='Start date']")).click();
				Thread.sleep(5000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div[10]/div[@class='datepicker-days']//td[contains(@class,'active')]")));
				driver.findElement(By.xpath("//body/div[10]/div[@class='datepicker-days']//td[contains(@class,'active')]")).getText();
				WebElement dateWidget = driver.findElement(By.xpath("//body/div[10]/div[@class='datepicker-days']//td[contains(@class,'active')]"));
				List<WebElement> columns = dateWidget.findElements(By.tagName("td"));
				todayScheduling = "3";
				// comparing the text of cell with today's date and clicking it.
				for (WebElement cell : columns) {
					System.out.println("cell.getText() : " + cell.getText() + " today : " + todayScheduling);
					System.out.println(cell.getText());
					if (cell.getText().equals(todayScheduling)) {
						cell.click();
						System.out.println("clicked start date");
						break;
					}
				}
				Thread.sleep(5000);

				// Setting Start Time
				driver.findElement(By.xpath("//*[@id='startTime']/input")).sendKeys(selectAll);
				driver.findElement(By.xpath("//*[@id='startTime']/input")).sendKeys(Keys.BACK_SPACE);
				driver.findElement(By.xpath(".//*[@id='startTime']/input")).sendKeys(sendingTime);
				// Thread.sleep(5000);

				driver.findElement(By.xpath("//input[@class='bluebutton']")).click();

			}
			catch(Exception e)
			{
				System.out.println(e);
				return false;
			}
			return true;
		}
	   
	   public boolean publishig()
		{
		   logger=report.startTest("Publishing SMS Acquisition");
			long start_m = System.currentTimeMillis();
			long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);	
			WebDriverWait wait = new WebDriverWait(driver, 60);
			try
			{
				Thread.sleep(5000);
				driver.findElement(By.xpath("//input[@value='Publish' and @type='submit']")).click();
			//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(publish_button)));
				//driver.findElement(By.xpath(publish_button)).click();
			//	driver.findElement(By.xpath(button_saveNext)).click();
				logger.log(LogStatus.PASS, "SMS acquisition published");
			}
			catch(Exception e)
			{
				System.out.println(e);
				logger.log(LogStatus.FAIL, "SMS acquisition publish failed");
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
		public String  date()
		{
			final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		    final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		
		    LocalDate localDate = LocalDate.now();
	        System.out.println(DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate));
			String datee = DateTimeFormatter.ofPattern("dd").format(localDate);
			return datee;
		}
		
		public void quit()
		{
			driver.close();
			driver.quit();
			
		}
		
		public void reportFlush(){
			report.endTest(logger);
			report.flush();
		}
	}
