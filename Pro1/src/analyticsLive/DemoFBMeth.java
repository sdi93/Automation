package analyticsLive;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

public class DemoFBMeth {

	ExtentReports report;
	ExtentTest logger;
	public static WebDriver driver;
	String AppUrl;
	String text,text1;
	public File dir;
	List<WebElement> allFromChildContainer1 ;
	List<WebElement> allFromChildContainer2;
	List<Integer> ddFilter = new ArrayList<Integer>();
	public static String initialSNAPLOC ;
	public static String SNAPLOC ;
	
	public String L1_allbrand = "//div[@empty-text='All Brands']/child::*/*[@ng-bind-html='varButtonLabel']";
	public String L1_brandText="//div[@class='acol']/child::*/*[@class='ng-binding']";
	public String L1_storepath="//div[@empty-text='All Stores']";
	public String L1_storelist="//div[@empty-text='All Stores']/child::*//*/*[@class='checkBoxContainer']/child::*//*//*/span[@class='ng-binding']";
	public String L1_buttonPeriod="//li[@id='ll_Period']";
	public String L1_buttonQuater="//li[@id='ll_Quarter']";
	public String L1_buttonYear="//li[@id='ll_Year']";
	public String L1_buttonApply="//div[@class='clearfix minx']/div[3]/div[1]/button";
	public String L1_L1_TD="//*[@class='netSales']/child::*/*//*/h4";
	public String L1_L2_TD="//*[@class='checkAverage']/child::*/*//*/h4";
	public String L1_L3_TD = "//*[@class='grossSales']/child::*/*//*/h4";
	public String L1_L4_TD = "//*[@class='discount']/child::*/*//*/h4";
	public String L1_L5_TD = "//*[@class='checkCount']/child::*/*//*/h4";
	public String L1_L7_TD="//*[@class='guestCount']/child::*/*//*/h4";
	public String L1_L10_TD = "//*[@class='salesPerGuest']/child::*/*//*/h4";
	
	public String L1_exportPDF_button="//*[@class='sfr dbi tar filter_icon filter_icon_ac ov']/li[@ng-click='exportToPDF()']";
	public String L1_mailTo_button="//*[@class='sfr dbi tar filter_icon filter_icon_ac ov']/li[@ng-click='mailTO()']";
	public String L1_dashboard_button="//*[@class='sfr dbi tar filter_icon filter_icon_ac ov']/li[@id='saveWidgetListItem']";
	public String L1_reload_button="//*[@class='sfr dbi tar filter_icon filter_icon_ac ov']/li[@ng-click='showDefaultWidgets()']";
	public String backButton="//input[@class='x-spec-button back' and @value='Back']";

	public String L1_checkbox="//div[@class='cockpit-header-cb']/child::*/label[@class='checkbox']";
	public String L1_checkboxValue="//div[@class='cockpit-header-cb']/child::*/input[@id='sameStore']";
	public String L1_checkboxClick_sideText="//div[@class='cockpit-header-cb']/span[@title='Same Store Count / Store Count']";
	
	public String L1_startDate="//li[@ng-if='showDates']/strong[1]";
	public String L1_endDate="//li[@ng-if='showDates']/strong[2]";
	public String L1_startend="//li[@ng-if='showDates']";
	
	public String L2_QP_dropdown="//ul[@class='filter_option large']/child::*/*//*/select";
	public String L2_dropdownPeriod="//ul[@class='filter_option large']/child::*/*//*/select/option[1]";
	public String L2_dropdownQuater="//ul[@class='filter_option large']/child::*/*//*/select/option[2]";
	public String L2_SF_samesotre="//div[@class='clearfix filters-net-sales']/child::*/label[2]/span[@class='ng-binding']";
	public String L2_SF_timeGrpoup="//div[@class='clearfix filters-net-sales']/child::*/label[contains(text(),'Time Group')]/span";
	public String L2_SF_startdate="//div[@class='clearfix filters-net-sales']/child::*/label[4]/span[@class='ng-binding']";
	public String L2_SF_enddate="//div[@class='clearfix filters-net-sales']/child::*/label[5]/span[@class='ng-binding']";

	
	public String loginxp = "//*[@class='x-pad']/child::*/*[@value='Login']";
	public String KPI_XP = "//span[@class='pvtAttr' and text()='KPI']";
	public String Cydata = "//*[@id='pivottable']/child::*//*[@class='pvtTotal colTotal' and contains(@data-for, 'col0')]";
	public String Pydata = "//*[@id='pivottable']/child::*//*[@class='pvtTotal colTotal' and contains(@data-for, 'col0')]";
	
	
	public String L1_L1 = "//*[@class='netSales']/child::*/*//*/h3";
	public String L1_L2 = "//*[@class='checkAverage']/child::*/*//*/h3";
	public String L1_L3 = "//*[@class='grossSales']/child::*/*//*/h3";
	public String L1_L4 = "//*[@class='discount']/child::*/*//*/h3";
	public String L1_L5 = "//*[@class='checkCount']/child::*/*//*/h3";
	public String L1_L6 = "//th[contains(.,'# of reservations')]";
	public String L1_L7 = "//*[@class='guestCount']/child::*/*//*/h3";
	public String L1_L8 = "//th[contains(.,'Earned and Redeemed Rewards')]";
	public String L1_L9 = "//th[contains(.,' Campaign')]";
	public String L1_L10 = "//*[@class='salesPerGuest']/child::*/*//*/h3";
	public String L1_L11 = "//th[contains(.,'Avg Frequency')]";
	public String L1_L12 = "//*[@id='TopStoreBySale']/child::*//tbody/tr[1]/td[2]";
	public String L1_L13 = "//*[@class='customerCount']/child::*/*//*/h3";
	public String L1_L14 = "//th[contains(.,'Sales per Guest')]";
	public String L1_L15 = "//*[@id='itemSales']/child::*/*//*/tbody/tr[1]/td[2]";
	public String L1_L16 = "//th[contains(.,'Persona Distribution')]";
	public String L1_L17 = "//*[@id='customerMix']/child::*//*/tbody/tr[1]/td[2]";
		
	public String netsalesHover="//*[@class='box-header1']/*[contains(text(),'Net Sales')]";
	public String checkaverageHover="//*[@class='box-header1']/*[contains(text(),'Check Average')]";
	public String covercountHover="//*[@class='box-header1']/*[contains(text(),'Cover Count')]";
	public String guestmixHover="//*[@class='box-header1']/*[contains(text(),'Guest Mix')]";
	public String itemsalesHover="//*[@class='box-header1']/*[contains(text(),'Item Sales')]";
	public String netsalesdecileHover="//*[@class='box-header1']/*[contains(text(),'Net Sales Decile')]";
	public String topstoresHover="//*[@class='box-header1']/*[contains(text(),'Top Stores')]";
	public String campaignHover="//*[@class='box-header1']/*[contains(text(),'Campaign')]";
	
	public String L1_netsales_navgraphHover="//div[@id='analyticsDBContainer']/div/ul/li[1]/child::*/*//*//*//li[2]";
	public String L1_checkaverage_navgraphHover="//div[@id='analyticsDBContainer']/div/ul/li[2]/child::*/*//*//*//li[2]";
	public String L1_guestmix_navgraphHover="//div[@id='analyticsDBContainer']/div/ul/li[4]/child::*/*//*//*//li[2]";
	public String L1_coverount_navgraphHover="//div[@id='analyticsDBContainer']/div/ul/li[7]/child::*/*//*//*//li[2]";

	
	public String L2_Child1="//img[@ng-click='drillToGridScreen(chart_Sec_1_Name)']";
	public String L2_Child2="//img[@ng-click='drillToGridScreen(chart_Sec_2_Name)']";
	public String L2_Child3="//img[@ng-click='drillToGridScreen(chart_Sec_3_Name)']";
	public String L2_Child4="//img[@ng-click='drillToGridScreen(chart_Sec_4_Name)']";

	public String L1_covercount_arrow="//div[@id='analyticsDBContainer']/div/ul/li[3]/child::*/*//*//*//li[2]/img";
	public String L1_covercount_child1="//div[@id='analyticsDBContainer']/div/ul/li[3]/child::*/*//*//*//li[2]/ul/li[1]";
	public String L1_covercount_child2="//div[@id='analyticsDBContainer']/div/ul/li[3]/child::*/*//*//*//li[2]/ul/li[2]";
	public String L1_covercount_child3="//div[@id='analyticsDBContainer']/div/ul/li[3]/child::*/*//*//*//li[2]/ul/li[3]";
	public String L1_covercount_child4="//div[@id='analyticsDBContainer']/div/ul/li[3]/child::*/*//*//*//li[2]/ul/li[4]";
	public String L1_itemsales_arrow = "//div[@id='analyticsDBContainer']/div/ul/li[5]/child::*/*//*//*//li[2]/img";
	public String L1_netsalesDecile_arrow = "//div[@id='analyticsDBContainer']/div/ul/li[6]/child::*/*//*//*//li/img";
	public String L1_topStores_arrow = "//div[@id='analyticsDBContainer']/div/ul/li[7]/child::*/*//*//*//li[2]/img";
	public String L1_campaign_arrow = "//div[@id='analyticsDBContainer']/div/ul/li[8]/child::*/*//*//*//li[2]/img";
	
	public String Netsales_l2_1 = "//*[@id='chartContainer1']/child::*//*[contains(text(),'Net Sales')]";
	public String Netsales_l2_2 = "//*[@id='chartContainer1']/child::*//*[contains(text(),'Net Sales')]";
	public String Netsales_l2_3 = "//*[@id='chartContainer1']/child::*//*[contains(text(),'Net Sales')]";
	public String Netsales_l2_4 = "//*[@id='chartContainer1']/child::*//*[contains(text(),'Net Sales')]";
	
	public String Checkavg_l2_1 = "//*[@id='chartContainer1']/child::*//*[contains(text(),'Average')]";
	public String Checkavg_l2_2 = "//*[@id='chartContainer2']/child::*//*[contains(text(),'Check Avg SPLY($)')]";
	public String Checkavg_l2_3 = "//*[@id='chartContainer3']/child::*//*[contains(text(),'Qty')]";
	public String Checkavg_l2_4 = "//*[@id='chartContainer4']/child::*//*[contains(text(),'Average')]";
	
	public String Checkcount_l2_1 = "//*[@id='chartContainer1']/child::*/*//*[text()='Check Count']";
	public String Checkcount_l2_2 = "//*[@id='chartContainer2']/child::*/*//*[text()='Check Count']";
	public String Checkcount_l2_3 = "//*[@id='chartContainer3']/child::*/*//*[text()='Check Count']";
	public String Checkcount_l2_4 = "//*[@id='chartContainer4']/child::*/*//*[text()='Check Count']";
	
	public String Discount_l2_1 = "//*[@id='chartContainer1']/child::*//*[contains(text(),'Discount')]";
	public String Discount_l2_2 = "//*[@id='chartContainer2']/child::*//*[contains(text(),'Discount')]";
	public String Discount_l2_3 = "//*[@id='chartContainer3']/child::*//*[contains(text(),'Discount')]";
	public String Discount_l2_4 = "//*[@id='chartContainer4']/child::*//*[contains(text(),'Discount')]";
	
	public String Gross_l2_1 = "//*[@id='chartContainer1']/child::*//*[contains(text(),'Gross')]";
	public String Gross_l2_2 = "//*[@id='chartContainer2']/child::*//*[contains(text(),'Gross')]";
	public String Gross_l2_3 = "//*[@id='chartContainer3']/child::*//*[contains(text(),'Gross')]";
	public String Gross_l2_4 = "//*[@id='chartContainer4']/child::*//*[contains(text(),'Gross')]";
	
	public String Guest_l2_1 = "//*[@id='chartContainer1']/child::*//*[contains(text(),'Guest')]";
	public String Guest_l2_2 = "//*[@id='chartContainer2']/child::*//*[contains(text(),'Guest')]";
	public String Guest_l2_3 = "//*[@id='chartContainer3']/child::*//*[contains(text(),'Guest')]";
	public String Guest_l2_4 = "//*[@id='chartContainer4']/child::*//*[contains(text(),'Guest')]";
	
	public String Guest_mix_l2_1 = "//*[@id='chartContainer1']/child::*//*[contains(text(),'Net Sales')]";
	public String Guest_mix_l2_2 = "//*[@id='chartContainer2']/child::*//*[contains(text(),'Net Sales')]";
	public String Guest_mix_l2_3 = "//*[@id='chartContainer3']/child::*//*[contains(text(),'Net Sales')]";
	public String Guest_mix_l2_4 = "//*[@id='chartContainer4']/child::*//*[contains(text(),'Net Sales')]";
	
	public String CoverCount_l2_1 = "//*[@id='chartContainer1']/child::*//*[contains(text(),'Cover Count')]";
	public String CoverCount_l2_2 = "//*[@id='chartContainer2']/child::*//*[contains(text(),'Cover Count')]";
	public String CoverCount_l2_3 = "//*[@id='chartContainer3']/child::*//*[contains(text(),'Cover Count')]";
	public String CoverCount_l2_4 = "//*[@id='chartContainer4']/child::*//*[contains(text(),'Cover Count')]";
	
	public String L2_filter_button="//ul[@class='filter_option large']/li[1]";
	public String L2_closed_innerfilter_click="xpath=//div[10]/div[2]/div[1]";
	public String L2_open_innerfilter_data="//div[10]/child::*/*//*/*//*/*/label";
	
	public String L3_container1="//td[@class='pvtAxisContainer pvtUnused pvtVertList ui-sortable']";
	public String L3_container2="//td[@class='pvtAxisContainer pvtRows ui-sortable']";

	public String L3_KPI_Dropdown="//*[@id='pivottable']/child::*//*/td[3]/li[1]/span/span";
	public String L3_Catogory_Dropdown="//*[@id='pivottable']/child::*//*/td[3]/li[2]/span/span";
	public String L3_kpi_element1="//td[@class='pvtAxisContainer pvtUnused pvtVertList ui-sortable']/div[3]/div/p[1]/label/span";
	public String L3_Kpi_ok_button="//td[@class='pvtAxisContainer pvtUnused pvtVertList ui-sortable']/div[3]/p[2]/button";
	
	File dir1;
	String date =null;
	String reportName;
	public void Browserinvoke(String url,String repName)
	{
		date = date();
		initialSNAPLOC = "E:/SeleniumReport/"+repName+date;
		reportName = repName;
		dir1 = new File(initialSNAPLOC);
		SNAPLOC = initialSNAPLOC+"/";
		dir1.mkdir();
		
		AppUrl=url;
		report=new ExtentReports(SNAPLOC+"/"+repName+".html",true);
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		driver.get(AppUrl);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	
	public boolean L1_dashboardView(String un,String pass) throws Exception
	   {
		   login(un,pass);
		   logger=report.startTest("L1_Dashboard");
		   long start_m = System.currentTimeMillis();
		   long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
		   driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		   try 
		   {
			   verifyelementL1(this.L1_L1, this.L1_L2, this.L1_L3, this.L1_L4, this.L1_L5, this.L1_L6, this.L1_L7
					   , this.L1_L8, this.L1_L9, this.L1_L10, this.L1_L11, this.L1_L12, this.L1_L13, this.L1_L14
					   , this.L1_L15, this.L1_L16, this.L1_L17);
			   String t =String.valueOf(System.currentTimeMillis());
			   String snap = "passed_L1_dashboardView"+t;
			   JavascriptExecutor js = (JavascriptExecutor) driver;
			   js.executeScript("document.body.style.zoom='" + 50 + "%'");
			   Thread.sleep(2000);
			   getscreenshot(snap);
			   js.executeScript("document.body.style.zoom='" + 100 + "%'");
			   Thread.sleep(2000);
			   String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
			   logger.log(LogStatus.PASS, "Data Loaded successfully",image);
		   } 
		   catch (Exception e)
		   { 
			   
			   String t =String.valueOf(System.currentTimeMillis());
			   String snap = "failed_L1_dashboardView"+t;
			   JavascriptExecutor js = (JavascriptExecutor) driver;
			   js.executeScript("document.body.style.zoom='" + 50 + "%'");
			   Thread.sleep(2000);
			   getscreenshot(snap);
			   js.executeScript("document.body.style.zoom='" + 100 + "%'");
			   Thread.sleep(2000);
			   String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
			   logger.log(LogStatus.FAIL, "Data not loaded in all tiles",image);
			   return false;
		   }
		   return true;
	   }

	  public boolean storename_dropDown() throws Exception
	   {
			long start_m = System.currentTimeMillis();
			long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
			driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);
			WebDriverWait wait = new WebDriverWait(driver, 60);
			try
			{
				driver.findElement(By.xpath(L1_allbrand)).click();
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(L1_brandText)));
				text=	driver.findElement(By.xpath(L1_brandText)).getText();
				if(ValidationMethod.isValidString(text))
				{
					System.out.println(text);
					logger.log(LogStatus.PASS, "Brand Name "+ text);
				}
				else
				{
					String t =String.valueOf(System.currentTimeMillis());
					String snap = "failed_L1_storename_dropDown"+t;
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("document.body.style.zoom='" + 50 + "%'");
					Thread.sleep(2000);
					getscreenshot(snap);
					js.executeScript("document.body.style.zoom='" + 100 + "%'");
					Thread.sleep(2000);
					String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
					logger.log(LogStatus.FAIL, "Brand name not found",image);
					return false;
				}
			}
			catch(Exception e)
			{
				StackTraceElement[] elements = e.getStackTrace();
				
				
				String t =String.valueOf(System.currentTimeMillis());
				String snap = "failed_L1_storename_dropDown"+t;
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("document.body.style.zoom='" + 50 + "%'");
				Thread.sleep(2000);
				getscreenshot(snap);
				js.executeScript("document.body.style.zoom='" + 100 + "%'");
				Thread.sleep(2000);
				String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
				logger.log(LogStatus.FAIL, String.valueOf(elements[1]) ,image);
				return false;
			}
			return true;
		}
	   
	   public boolean sotreList_dropDown() throws Exception{
			long start_m = System.currentTimeMillis();
			long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
			driver.manage().timeouts().implicitlyWait(65,TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 60);
			try
			{
				driver.findElement(By.xpath(L1_storepath)).click();
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(L1_storelist)));
				text1=	driver.findElement(By.xpath(L1_storelist)).getText();
				if(ValidationMethod.isValidString(text1))
				{
					 System.out.println(text1);
					 logger.log(LogStatus.PASS, "Store List Found");
					 return true;
				}
					else
					{
						String t =String.valueOf(System.currentTimeMillis());
						String snap = "failed_sotreList_dropDown"+t;
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("document.body.style.zoom='" + 50 + "%'");
						Thread.sleep(2000);
						getscreenshot(snap);
						js.executeScript("document.body.style.zoom='" + 100 + "%'");
						Thread.sleep(2000);
						String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
						logger.log(LogStatus.FAIL, "Store List not found",image);
						return false;
					}
			}
			catch(Exception e)
			{
				String t =String.valueOf(System.currentTimeMillis());
				String snap = "failed_sotreList_dropDown"+t;
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("document.body.style.zoom='" + 50 + "%'");
				Thread.sleep(2000);
				getscreenshot(snap);
				js.executeScript("document.body.style.zoom='" + 100 + "%'");
				Thread.sleep(2000);
				String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
				logger.log(LogStatus.FAIL, "Something went wrong with store list dropdown",image);
				return false;
			}
			
		}
	   
	   public boolean L1_buttonQuaterApply() throws Exception
	   {
			long start_m = System.currentTimeMillis();
			long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 180);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(L1_buttonQuater)));
				driver.findElement(By.xpath(L1_buttonQuater)).click();
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(L1_buttonApply)));
				WebElement applybutton = driver.findElement(By.xpath(L1_buttonApply));
				applybutton.click();
				 verifyelementL1(this.L1_L1, this.L1_L2, this.L1_L3, this.L1_L4, this.L1_L5, this.L1_L6, this.L1_L7
						   , this.L1_L8, this.L1_L9, this.L1_L10, this.L1_L11, this.L1_L12, this.L1_L13, this.L1_L14
						   , this.L1_L15, this.L1_L16, this.L1_L17);
				 logger.log(LogStatus.PASS, "QTD found on applying Quarter");				
			}
			catch(Exception e)
			{
				String t =String.valueOf(System.currentTimeMillis());
				String snap = "failed_L1_buttonQuarterApply"+t;
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("document.body.style.zoom='" + 50 + "%'");
				Thread.sleep(2000);
				getscreenshot(snap);
				js.executeScript("document.body.style.zoom='" + 100 + "%'");
				Thread.sleep(2000);
				String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
				logger.log(LogStatus.FAIL, "Something went wrong with button Quarter Apply",image);
				return false;
			}
			return true;
		}

	public boolean L1_buttonPeriodApply() throws Exception
		{
			long start_m = System.currentTimeMillis();
			long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 60);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(L1_buttonPeriod)));
				driver.findElement(By.xpath(L1_buttonPeriod)).click();
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(L1_buttonApply)));
				WebElement applybutton = driver.findElement(By.xpath(L1_buttonApply));
				applybutton.click();
				 verifyelementL1(this.L1_L1, this.L1_L2, this.L1_L3, this.L1_L4, this.L1_L5, this.L1_L6, this.L1_L7
						   , this.L1_L8, this.L1_L9, this.L1_L10, this.L1_L11, this.L1_L12, this.L1_L13, this.L1_L14
						   , this.L1_L15, this.L1_L16, this.L1_L17);
					logger.log(LogStatus.PASS, "PTD found on applying Quarter");
					
			}
			catch(Exception e)
			{
				String t =String.valueOf(System.currentTimeMillis());
				String snap = "failed_L1_buttonPeriodApply"+t;
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("document.body.style.zoom='" + 50 + "%'");
				Thread.sleep(2000);
				getscreenshot(snap);
				js.executeScript("document.body.style.zoom='" + 100 + "%'");
				Thread.sleep(2000);
				String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
				logger.log(LogStatus.FAIL, "Something went wrong with button Period Apply",image);
				return false;
			}
			return true;
		}
		
		public boolean L1_buttonYearApply() throws Exception
		{
			long start_m = System.currentTimeMillis();
			long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, 60);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(L1_buttonYear)));
				driver.findElement(By.xpath(L1_buttonYear)).click();
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(L1_buttonApply)));
				WebElement applybutton = driver.findElement(By.xpath(L1_buttonApply));
				applybutton.click();
				 verifyelementL1(this.L1_L1, this.L1_L2, this.L1_L3, this.L1_L4, this.L1_L5, this.L1_L6, this.L1_L7
						   , this.L1_L8, this.L1_L9, this.L1_L10, this.L1_L11, this.L1_L12, this.L1_L13, this.L1_L14
						   , this.L1_L15, this.L1_L16, this.L1_L17);
				
					logger.log(LogStatus.PASS, "YTD found on applying Quarter");
			}
			catch(Exception e)
			{
				String t =String.valueOf(System.currentTimeMillis());
				String snap = "failed_L1_buttonYearApply"+t;
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("document.body.style.zoom='" + 50 + "%'");
				Thread.sleep(2000);
				getscreenshot(snap);
				js.executeScript("document.body.style.zoom='" + 100 + "%'");
				Thread.sleep(2000);
				String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
				logger.log(LogStatus.FAIL, "Something went wrong with button Year Apply",image);
				return false;
			}
			return true;
		}
		
		public boolean L2_URLNavigation(String bsaeUrl, String rest) throws Exception{
			AppUrl=bsaeUrl;
			String completeUrl=AppUrl+rest;
			logger=report.startTest("L2_"+rest);
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
			long start_m = System.currentTimeMillis();
			long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
			driver.get(completeUrl);
			if (completeUrl.equalsIgnoreCase(AppUrl + rest)) 
			{
				try
				{	//String type=L2_Type(rest);
					boolean result = L2_Type(rest);
					if (result == true) 
					{
						String t =String.valueOf(System.currentTimeMillis());
						String snap = "passed_L2_"+rest+t;
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("document.body.style.zoom='" + 50 + "%'");
						Thread.sleep(2000);
						getscreenshot(snap);
						js.executeScript("document.body.style.zoom='" + 100 + "%'");
						Thread.sleep(2000);
						String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
						logger.log(LogStatus.PASS, "Data Loaded successfully for "+ rest,image);
					 return true;
					}
					else {
						String t =String.valueOf(System.currentTimeMillis());
						String snap = "failed_L2_"+rest+t;
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("document.body.style.zoom='" + 50 + "%'");
						Thread.sleep(2000);
						getscreenshot(snap);
						js.executeScript("document.body.style.zoom='" + 100 + "%'");
						Thread.sleep(2000);
						String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
						logger.log(LogStatus.FAIL, "Data not loaded successfully for "+rest,image);
						return false;
					}
				}
				catch(Exception e)
				{
					String t =String.valueOf(System.currentTimeMillis());
					String snap = "failed_L2_"+rest+t;
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("document.body.style.zoom='" + 50 + "%'");
					Thread.sleep(2000);
					getscreenshot(snap);
					js.executeScript("document.body.style.zoom='" + 100 + "%'");
					Thread.sleep(2000);
					String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
					logger.log(LogStatus.FAIL, "Something went wrong with L2_URLNavigation of " +rest,image);
					return false;
				}
			}
			return true;
		}
		
		public boolean L2_graphNavigator(String hovername,String graph,String L2type)throws Exception
		{	
			String type = null;
			logger=report.startTest("L2_"+hovername);
			long start_m = System.currentTimeMillis();
			long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
			try
			{
				//verifyelementL1(L1_L1, this.L1_L2, this.L1_L3, this.L1_L4, this.L1_L5, this.L1_L6, this.L1_L7, this.L1_L8);
				if(hovername.equalsIgnoreCase("netsales"))
				{
					hovername=netsalesHover;
					graph=L1_netsales_navgraphHover;
					type="netSales";
				}
				else if(hovername.equalsIgnoreCase("covercount"))
				{
					hovername=covercountHover;
					graph=L1_coverount_navgraphHover;
					type="covercount";
				}
				else if (hovername.equalsIgnoreCase("checkaverage"))
				{
					hovername=checkaverageHover;
					graph=L1_checkaverage_navgraphHover;
					type="checkAverage";
				}
				else if (hovername.equalsIgnoreCase("guestmix"))
				{
					hovername=guestmixHover;
					graph=L1_guestmix_navgraphHover;
					type="guestMix";
				}
				//WebElement a =driver.findElement(By.xpath(hovername+"Hover"));
				WebElement a  =   driver.findElement(By.xpath(hovername));
				WebElement b =driver.findElement(By.xpath(graph));
				hoverOnMainAndClickSubLink(a,b);
				// type=L2_Type(L2type);
				Thread.sleep(8000);
				boolean result =L2_Type(L2type);
				if (result == true) 
				{
					String t =String.valueOf(System.currentTimeMillis());
					String snap = "passed_L2_"+type+t;
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("document.body.style.zoom='" + 50 + "%'");
					Thread.sleep(2000);
					getscreenshot(snap);
					js.executeScript("document.body.style.zoom='" + 100 + "%'");
					Thread.sleep(2000);
					String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
					logger.log(LogStatus.PASS, "Data Loaded successfully for "+type,image);
				 return true;
				}
				else
				{
					String t =String.valueOf(System.currentTimeMillis());
					String snap = "failed_L2_"+type+t;
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("document.body.style.zoom='" + 50 + "%'");
					Thread.sleep(2000);
					getscreenshot(snap);
					js.executeScript("document.body.style.zoom='" + 100 + "%'");
					Thread.sleep(2000);
					String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
					logger.log(LogStatus.FAIL, "Something went wrong while loading data for "+type,image);
					return false;
				}
			}
			catch(Exception e)
			{
				String t =String.valueOf(System.currentTimeMillis());
				String snap = "failed_L2_"+type+t;
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("document.body.style.zoom='" + 50 + "%'");
				Thread.sleep(2000);
				getscreenshot(snap);
				js.executeScript("document.body.style.zoom='" + 100 + "%'");
				Thread.sleep(2000);
				String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
				logger.log(LogStatus.FAIL, "Something went wrong with L2_graphNavigator of "+type,image);
				return false;
			}
		}
		
		public boolean L2_DropDownQuater(String typel2) throws Exception{
			long start_m = System.currentTimeMillis();
			long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
			
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
			WebDriverWait wait = new WebDriverWait(driver, 180);
			try{
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(L2_QP_dropdown)));
				driver.findElement(By.xpath(L2_QP_dropdown)).click();
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(L2_dropdownQuater)));
				driver.findElement(By.xpath(L2_dropdownQuater)).click();
				
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(L1_buttonApply)));
				WebElement applybutton = driver.findElement(By.xpath(L1_buttonApply));
				applybutton.click();
				//String type=L2_Type(typel2);
				boolean result = L2_Type(typel2);
				if (result == true) 
				{
					System.out.println("verifyElement_L2 passed");
					String a= driver.findElement(By.xpath(L2_SF_samesotre)).getText();
					String b= driver.findElement(By.xpath(L2_SF_timeGrpoup)).getText();
					
					if(b.equals("Quarter"))
					{
						System.out.println("Dropdown value equals Timegroup value after change");
					}
					else
					{
						String t =String.valueOf(System.currentTimeMillis());
						String snap = "failed_L2_dd_value"+t;
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("document.body.style.zoom='" + 50 + "%'");
						Thread.sleep(2000);
						getscreenshot(snap);
						js.executeScript("document.body.style.zoom='" + 100 + "%'");
						Thread.sleep(2000);
						String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
						logger.log(LogStatus.FAIL, "Dropdown value not equals Timegroup value after change",image);
						return false;
					}
				}
				else
				{
					String t =String.valueOf(System.currentTimeMillis());
					String snap = "failed_L2_dd_quarterLoading"+t;
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("document.body.style.zoom='" + 50 + "%'");
					Thread.sleep(2000);
					getscreenshot(snap);
					js.executeScript("document.body.style.zoom='" + 100 + "%'");
					Thread.sleep(2000);
					String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
					logger.log(LogStatus.FAIL, "Data not loaded successfully in L2_QuarterDropdown",image);
					return false;
				}
				logger.log(LogStatus.PASS, "Data loaded , date changed and value matched in L2_DropDownQuater");
			}
			catch(Exception e)
			{
				String t =String.valueOf(System.currentTimeMillis());
				String snap = "failed_L2_dd_quarter"+t;
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("document.body.style.zoom='" + 50 + "%'");
				Thread.sleep(2000);
				getscreenshot(snap);
				js.executeScript("document.body.style.zoom='" + 100 + "%'");
				Thread.sleep(2000);
				String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
				logger.log(LogStatus.FAIL, "Something went wrong with L2_QuarterDropdown",image);
				return false;
			}
			return true;
		}

		public boolean L2_DropDownPeriod(String typel2) throws Exception{
			long start_m = System.currentTimeMillis();
			long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
			WebDriverWait wait = new WebDriverWait(driver, 180);
			try{
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(L2_QP_dropdown)));
				driver.findElement(By.xpath(L2_QP_dropdown)).click();
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(L2_dropdownPeriod)));
				driver.findElement(By.xpath(L2_dropdownPeriod)).click();
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(L1_buttonApply)));

				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(L1_buttonApply)));
				WebElement applybutton = driver.findElement(By.xpath(L1_buttonApply));
				applybutton.click();
				//String type=L2_Type(typel2);
				boolean result = L2_Type(typel2);
				if (result == true) 
				{
					System.out.println("verifyElement_L2 passed");
					String a= driver.findElement(By.xpath(L2_SF_samesotre)).getText();
					String b= driver.findElement(By.xpath(L2_SF_timeGrpoup)).getText();
					
					if(b.equals("Period"))
					{
						System.out.println("Dropdown value equals Timegroup value after change");
					}
					else
					{
						String t =String.valueOf(System.currentTimeMillis());
						String snap = "failed_L2_dd_valuePer"+t;
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("document.body.style.zoom='" + 50 + "%'");
						Thread.sleep(2000);
						getscreenshot(snap);
						js.executeScript("document.body.style.zoom='" + 100 + "%'");
						Thread.sleep(2000);
						String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
						logger.log(LogStatus.FAIL, "Dropdown value not equals Timegroup value after change",image);
						return false;
					}
				}
				else
				{
					String t =String.valueOf(System.currentTimeMillis());
					String snap = "failed_L2_dd_dataPer"+t;
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("document.body.style.zoom='" + 50 + "%'");
					Thread.sleep(2000);
					getscreenshot(snap);
					js.executeScript("document.body.style.zoom='" + 100 + "%'");
					Thread.sleep(2000);
					String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
					logger.log(LogStatus.FAIL, "Data not loaded successfully in L2_QuarterDropdown",image);
					return false;
				}
				logger.log(LogStatus.PASS, "Data loaded , date changed and value matched in L2_DropDownPeriod");
			}
			catch(Exception e)
			{
				String t =String.valueOf(System.currentTimeMillis());
				String snap = "failed_L2_dd_period"+t;
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("document.body.style.zoom='" + 50 + "%'");
				Thread.sleep(2000);
				getscreenshot(snap);
				js.executeScript("document.body.style.zoom='" + 100 + "%'");
				Thread.sleep(2000);
				String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
				logger.log(LogStatus.FAIL, "Something went wrong with L2_PeriodDropdown",image);
				return false;
			}
			return true;
		}

		public boolean dropdown_filter_check() throws Exception{
			int i;
			int[] arg=new int[]{};
			long start_m = System.currentTimeMillis();
			long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
			WebDriverWait wait = new WebDriverWait(driver, 45);
			try
			{
				driver.findElement(By.xpath(L2_filter_button)).click();
				ddFilter.clear();

				WebElement a = driver.findElement(By.xpath("//div[@class='showpanel timePanels']"));
				List<WebElement> allFromChild = a.findElements(By.className("clearfix"));
				int filtersize = allFromChild.size();
				boolean visibility ;
				for( i= 1 ; i<=filtersize;i++)
				{
					visibility = filterdisplay(i);
					if(visibility == false)
					{
						System.out.println(i);
					}
					else{
					ddFilter.add(i);
					}
				}
				if(ddFilter.size()>0){
				for(int j=0;j<ddFilter.size();j++)
				{
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div["+ddFilter.get(j)+"]/div[2]/div[1]")));
					driver.findElement(By.xpath("//div[@class='showpanel timePanels']/div["+ddFilter.get(j)+"]/div[2]/div[1]")).click();
					Thread.sleep(500);
					//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div["+ddFilter.get(j)+"]/child::*/*//*/*//*/*/label")));
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='showpanel timePanels']/div["+ddFilter.get(j)+"]/child::*/*//*/*//*/*/label")));
					driver.findElement(By.xpath("//div[@class='showpanel timePanels']/div["+ddFilter.get(j)+"]/child::*/*//*/*//*/*/label"));
					//text1=	driver.findElement(By.xpath("//div[@class='showpanel timePanels']/div["+ddFilter.get(j)+"]/child::*/*//*/*//*/*/label")).getText();
					//driver.findElement(By.xpath("//div[@class='showpanel timePanels']/div["+arg[i]+"]/child::*/*//*/*//*/*/label")).click();
					// if(ValidationMethod.isValidString(text1))
						//div[@class='showpanel timePanels']/div[15]/child::*/*//*/*//*/div
					//{
						// driver.findElement(By.xpath("//div[@class='showpanel timePanels']/div["+ddFilter.get(j)+"]/div[2]/div[1]")).click();
					/*}
					else
					{
						String t =String.valueOf(System.currentTimeMillis());
						String snap = "failed_filter_check"+t;
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("document.body.style.zoom='" + 50 + "%'");
						Thread.sleep(2000);
						getscreenshot(snap);
						js.executeScript("document.body.style.zoom='" + 100 + "%'");
						Thread.sleep(2000);
						String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
						logger.log(LogStatus.FAIL, "data inside filter not found",image);
						driver.findElement(By.xpath(L2_filter_button)).click();
						return false;
					}*/
				}
				}
						driver.findElement(By.xpath(L2_filter_button)).click();
						logger.log(LogStatus.PASS, "Data loaded for all Filters");
					}
					catch(Exception e){
						String t =String.valueOf(System.currentTimeMillis());
						String snap = "failed_filter"+t;
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("document.body.style.zoom='" + 50 + "%'");
						Thread.sleep(2000);
						getscreenshot(snap);
						js.executeScript("document.body.style.zoom='" + 100 + "%'");
						Thread.sleep(2000);
						String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
						logger.log(LogStatus.FAIL, "Data not loaded for all Filters",image);
						driver.findElement(By.xpath(L2_filter_button)).click();
						return false;
					}
					return true;
				}

		public boolean filterdisplay(int io){
		 boolean b;
		 WebDriverWait wait = new WebDriverWait(driver, 1);
		 if ((driver.findElement(By.xpath("//div[@class='showpanel timePanels']/div["+io+"]")).isDisplayed()) ) 
			{
			 return true;
			}
		 else{
			 return false;
		 }
		
	 }
	
		public boolean L3_UrlNavigator(String baseUrl,String restUrl) throws Exception{
			AppUrl=baseUrl;
			String completeUrl=AppUrl+restUrl;
			logger=report.startTest("L3_"+restUrl);
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
			long start_m = System.currentTimeMillis();
			long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
			driver.get(completeUrl);
			if (completeUrl.equalsIgnoreCase(AppUrl + restUrl)) {
				try 
				{
					boolean result = verifyelement_L3(KPI_XP, Cydata, Pydata);
					if (result == true) 
					{
						String t =String.valueOf(System.currentTimeMillis());
						String snap = "pass_l3_urlnavigation"+t;
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("document.body.style.zoom='" + 50 + "%'");
						Thread.sleep(2000);
						getscreenshot(snap);
						js.executeScript("document.body.style.zoom='" + 100 + "%'");
						Thread.sleep(2000);
						String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
						logger.log(LogStatus.PASS, "Data Loaded successfully on "+restUrl,image);
					 return true;
					}
					else
					{
						String t =String.valueOf(System.currentTimeMillis());
						String snap = "failed_l3_urlnavigation"+t;
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("document.body.style.zoom='" + 50 + "%'");
						Thread.sleep(2000);
						getscreenshot(snap);
						js.executeScript("document.body.style.zoom='" + 100 + "%'");
						Thread.sleep(2000);
						String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
						logger.log(LogStatus.FAIL, "Data not loaded successfully on "+restUrl,image);
						 return true;	
					}
				}
				catch(Exception e)
				{
					String t =String.valueOf(System.currentTimeMillis());
					String snap = "failed_l3_urlnavigation"+t;
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("document.body.style.zoom='" + 50 + "%'");
					Thread.sleep(2000);
					getscreenshot(snap);
					js.executeScript("document.body.style.zoom='" + 100 + "%'");
					Thread.sleep(2000);
					String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
					logger.log(LogStatus.FAIL, "Something went wrong with L3_UrlNavigator",image);
					return false;
					}
				}
			return true;
		}
		
		public boolean L3_arrowNavigator(int childNumber)	throws Exception
		{
			long start_m = System.currentTimeMillis();
			long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
			WebDriverWait wait = new WebDriverWait(driver, 90);
			try
			{
				String res = l3_child_type(childNumber);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(res)));
				driver.findElement(By.xpath(res)).click();	
				//Thread.sleep(60000);
				boolean result = verifyelement_L3(KPI_XP, Cydata, Pydata);
				if (result == true)
				{
					String t =String.valueOf(System.currentTimeMillis());
					String snap = "passed_l3_arrownavigation"+t;
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("document.body.style.zoom='" + 50 + "%'");
					Thread.sleep(2000);
					getscreenshot(snap);
					js.executeScript("document.body.style.zoom='" + 100 + "%'");
					Thread.sleep(2000);
					
					String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
					logger.log(LogStatus.PASS, "Data Loaded successfully",image);
				 return true;
				}
				else {
					String t =String.valueOf(System.currentTimeMillis());
					String snap = "failed_l3_arrownavigation"+t;
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("document.body.style.zoom='" + 50 + "%'");
					Thread.sleep(2000);
					getscreenshot(snap);
					js.executeScript("document.body.style.zoom='" + 100 + "%'");
					Thread.sleep(2000);
					String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
					logger.log(LogStatus.FAIL, "Data not Loaded successfully",image);
					return false;}
			}
			catch(Exception e)
			{
				String t =String.valueOf(System.currentTimeMillis());
				String snap = "failed_l3_arrownavigation"+t;
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("document.body.style.zoom='" + 50 + "%'");
				Thread.sleep(2000);
				getscreenshot(snap);
				js.executeScript("document.body.style.zoom='" + 100 + "%'");
				Thread.sleep(2000);
				String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
				logger.log(LogStatus.FAIL, "Something went wrong with L3_arrowNavigator",image);
				return false;
			}

		}
	
		public boolean backToL2Click()throws Exception{
			long start_m = System.currentTimeMillis();
			long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
			WebDriverWait wait = new WebDriverWait(driver, 90);
			try
			{
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(backButton)));
				driver.findElement(By.xpath(backButton)).click();
				Thread.sleep(8000);
				logger.log(LogStatus.PASS, "Back on L2");
			}
			catch(Exception e)
			{
				String t =String.valueOf(System.currentTimeMillis());
				String snap = "failed_backToL2Click"+t;
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("document.body.style.zoom='" + 50 + "%'");
				Thread.sleep(2000);
				getscreenshot(snap);
				js.executeScript("document.body.style.zoom='" + 100 + "%'");
				Thread.sleep(2000);
				String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
				logger.log(LogStatus.FAIL, "Something went wrong",image);
				return false;
			}
			return true;
		}
		
		public boolean backToL1Click()throws Exception{
			long start_m = System.currentTimeMillis();
			long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
			WebDriverWait wait = new WebDriverWait(driver, 90);
			try
			{
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(backButton)));
				driver.findElement(By.xpath(backButton)).click();
				  verifyelementL1(this.L1_L1, this.L1_L2, this.L1_L3, this.L1_L4, this.L1_L5, this.L1_L6, this.L1_L7
						   , this.L1_L8, this.L1_L9, this.L1_L10, this.L1_L11, this.L1_L12, this.L1_L13, this.L1_L14
						   , this.L1_L15, this.L1_L16, this.L1_L17);
				logger.log(LogStatus.PASS, "Back on L1 and data loaded successfully");
			}
			catch(Exception e)
			{
				String t =String.valueOf(System.currentTimeMillis());
				String snap = "failed_backToL2Click"+t;
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("document.body.style.zoom='" + 50 + "%'");
				Thread.sleep(2000);
				getscreenshot(snap);
				js.executeScript("document.body.style.zoom='" + 100 + "%'");
				Thread.sleep(2000);
				String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
				logger.log(LogStatus.FAIL, "Data not loaded on all tiles while usong back button",image);
				return false;
			}
			return true;
		}
		
		
	public String l3_child_type(int a)throws Exception
		{	
				String result;
				if (a==1){
					result=L2_Child1;
					return result;
				}
				else if(a==2){
					result=L2_Child2;
					return result;
				}
				else if(a==3){
					result=L2_Child3;
					return result;
				}
				else if(a==4){
					result=L2_Child4;
					return result;
				}
				return null;
			}
		
	public void verifyelementL1(String xp1, String xp2, String xp3, String xp4, String xp5, String xp6, String xp7,	String xp8
			,	String xp9,	String xp10,	String xp11,	String xp12,	String xp13,	String xp14,	String xp15,
			String xp16,	String xp17) 
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
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp9)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp10)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp11)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp12)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp13)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp14)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp15)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp16)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp17)));
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
	
	public static void getscreenshot(String name) throws Exception
	{	
		  File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		  String dest = SNAPLOC+"/"+ name+".png";
		  FileUtils.copyFile(scrFile, new File(dest));
	}
	
 	public void login(String un, String pass) {
		// WebDriverWait wait = new WebDriverWait(driver, 180);
		// driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
		String Username=un;String password=pass;
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys(Username);
		driver.findElement(By.id("pwd")).clear();
		driver.findElement(By.id("pwd")).sendKeys(password);
		WebElement loginbutton = driver.findElement(By.xpath(loginxp));
		loginbutton.click();
	}
 	
 	public boolean verifyelement_L2(String xp_L2_1, String xp_L2_2, String xp_L2_3, String xp_L2_4)

	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xp_L2_1)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xp_L2_2)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xp_L2_3)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xp_L2_4)));
		if (driver.findElement(By.xpath(xp_L2_1)).isDisplayed() && driver.findElement(By.xpath(xp_L2_2)).isDisplayed()
				&& driver.findElement(By.xpath(xp_L2_3)).isDisplayed()
				&& driver.findElement(By.xpath(xp_L2_4)).isDisplayed()) {
			return true;
		} else
			return false;
	}

	public boolean verifyelement_L3(String xp_L3_1, String xp_L3_2, String xp_L3_3)

	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp_L3_1)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp_L3_2)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp_L3_3)));
		String data1 = driver.findElement(By.xpath(xp_L3_2)).getAttribute("data-value").trim();
		String data2 = driver.findElement(By.xpath(xp_L3_3)).getAttribute("data-value").trim();

		if ((driver.findElement(By.xpath(xp_L3_1)).isDisplayed()) && ValidationMethod.isValidString(data1) && ValidationMethod.isValidString(data2) ) 
		{
			if(!data1.equals("0") &&!data2.equals("0")){
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	
	public boolean L2_Type(String type)
	{
	   boolean result;
		if(type.equalsIgnoreCase("netSales"))
		{
			type="Netsales";
			result=verifyelement_L2(Netsales_l2_1, Netsales_l2_2, Netsales_l2_3, Netsales_l2_4);
			return result;
		}
		else if(type.equalsIgnoreCase("checkAverage"))
		{
			type="Checkavg";
			result=verifyelement_L2(Checkavg_l2_1, Checkavg_l2_2, Checkavg_l2_3, Checkavg_l2_4);
			return result;
		}
		else if(type.equalsIgnoreCase("checkCount"))
		{
			type="Checkcount";
			result=verifyelement_L2(Checkcount_l2_1, Checkcount_l2_2, Checkcount_l2_3, Checkcount_l2_4);
			return result;
		}
		else if(type.equalsIgnoreCase("discount"))
		{
			type="Discount";
			result=verifyelement_L2(Discount_l2_1, Discount_l2_2, Discount_l2_3, Discount_l2_4);
			return result;
		}
		else if(type.equalsIgnoreCase("grossSales"))
		{
			type="Gross";
			 result=verifyelement_L2(Gross_l2_1, Gross_l2_2, Gross_l2_3, Gross_l2_4);
			 return result;
		}
		else if(type.equalsIgnoreCase("guestCount"))
		{
			type="Guest";
			result=verifyelement_L2(Guest_l2_1, Guest_l2_2, Guest_l2_3, Guest_l2_4);
			return result;
		}
		else if(type.equalsIgnoreCase("guestMix"))
		{
			type="Guest_mix";
			result=verifyelement_L2(Guest_mix_l2_1, Guest_mix_l2_2, Guest_mix_l2_3, Guest_mix_l2_4);
			return result;
			}
		if(type.equalsIgnoreCase("coverCount")){
			type="CoverCount";
			result=verifyelement_L2(CoverCount_l2_1, CoverCount_l2_2, CoverCount_l2_3, CoverCount_l2_4);
			return result;
		}
		else return false;
		
	}

	public void hoverOnly(WebElement element) 
	{
		  Actions hoverClick = new Actions(driver);
		  hoverClick.moveToElement(element).build().perform();
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
	
	public void quit()
	{
		driver.close();
		driver.quit();
		try{
			NewEmail.email(SNAPLOC,reportName);}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	public void reportFlush(){
		report.endTest(logger);
		report.flush();
	}
   
	
}
