package analyticsLive;

import java.util.List;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class GAMeth {
	
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
	public String L1_L3_TD="//*[@class='guestCount']/child::*/*//*/h4";
	public String L1_L4_TD="//*[@id='customerMix']/child::*/*//*/*//*/th[2]";
	public String L1_L5_TD="//*[@id='itemSales']/child::*/*//*/*//*/*/th[2]";

	public String L1_L7_TD="//*[@id='TopStoreBySale']/child::*/*//*/*//th[2]";
	public String L1_L8_TD="//*[@id='campaign']/child::*//*/th[2]";
	
	public String L1_exportPDF_button="//*[@class='sfr dbi tar filter_icon filter_icon_ac ov']/li[@ng-click='exportToPDF()']";
	public String L1_mailTo_button="//*[@class='sfr dbi tar filter_icon filter_icon_ac ov']/li[@ng-click='mailTO()']";
	public String L1_dashboard_button="//*[@class='sfr dbi tar filter_icon filter_icon_ac ov']/li[@id='saveWidgetListItem']";
	public String L1_reload_button="//*[@class='sfr dbi tar filter_icon filter_icon_ac ov']/li[@ng-click='showDefaultWidgets()']";
	public String backButton="//img[@class='x-icon h24e bgs2000p backs']";
	
	
	public String L1_checkbox="//div[@class='cockpit-header-cb']/child::*/label[@class='checkbox']";
	public String L1_checkboxValue="//div[@class='cockpit-header-cb']/child::*/input[@id='sameStore']";
	public String L1_checkboxClick_sideText="//div[@class='cockpit-header-cb']/span[@title='Same Store Count / Store Count']";
	
	public String L1_startDate="//li[@ng-if='showDates']/strong[1]";
	public String L1_endDate="//li[@ng-if='showDates']/strong[2]";
	public String L1_startend="//li[@ng-if='showDates']";
	
	public String L2_QP_dropdown="//ul[@class='filter_option large']/child::*/*//*/select[@id='periodFilter']";
	public String L2_dropdownPeriod="//ul[@class='filter_option large']/child::*/*//*/*//option[1]";
	public String L2_dropdownQuater="//ul[@class='filter_option large']/child::*/*//*/*//option[2]";
	public String L2_SF_samesotre="//div[@class='clearfix filters-net-sales']/child::*/label[2]/span[@class='ng-binding']";
	public String L2_SF_timeGrpoup="//div[@class='clearfix filters-net-sales']/child::*/label[3]/span[@class='ng-binding']";
	public String L2_SF_startdate="//div[@class='clearfix filters-net-sales']/child::*/label[4]/span[@class='ng-binding']";
	public String L2_SF_enddate="//div[@class='clearfix filters-net-sales']/child::*/label[5]/span[@class='ng-binding']";

	
	public String loginxp = "//*[@class='x-pad']/child::*/*[@value='Login']";
	public String KPI_XP = "//span[@class='pvtAttr' and text()='KPI']";
	public String Cydata = "//*[@id='pivottable']/child::*//*[@class='pvtTotal colTotal' and contains(@data-for, 'col0')]";
////*[@id='pivottable']/child::*//*[@class='pvtTotal colTotal' and contains(@data-for, 'col0')]
	public String Pydata = "//*[@id='pivottable']/child::*//*[@class='pvtTotal colTotal' and contains(@data-for, 'col0')]";
	
	
	public String L1_L1 = "//*[@class='netSales']/child::*/*//*/h3";
	public String L1_L2 = "//*[@class='checkAverage']/child::*/*//*/h3";
	public String L1_L3 = "//*[@class='guestCount']/child::*/*//*/h3";
	public String L1_L4 = "//*[@id='customerMix']/child::*//*/tbody/tr[1]/td[2]";
	public String L1_L5 = "//*[@id='itemSales']/child::*/*//*/tbody/tr[1]/td[2]";
	public String L1_L6 = "//*[@id='decile_bubble']/child::*/*//*[contains(text(),'NetSales')]";
	public String L1_L7 = "//*[@id='TopStoreBySale']/child::*//tbody/tr[1]/td[2]";
	public String L1_L8 = "//*[@id='campaign']/child::*//tbody/tr[1]/td[2]";
	
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
	
	//public String L1_netsales_navArrow="//div[@id='analyticsDBContainer']/div/ul/li[1]/child::*/*//*//*//li[2]";
	//public String L1_netsales_child1="//div[@id='analyticsDBContainer']/div/ul/li[1]/child::*/*//*//*//li[3]/ul/li[2]";
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
	
	public String L2_filter_button="//ul[@class='filter_option large']/li[1]";
	public String L2_closed_innerfilter_click="xpath=//div[10]/div[2]/div[1]";
	public String L2_open_innerfilter_data="//div[10]/child::*/*//*/*//*/*/label";
	
	
/*	public int[] L2_netsales_filter=new int[]{9,10,17,18,20,21,22,23};//22
	public int[] L2_checkaverage_filter=new int[]{9,10,17,18,19,20,21,22,23};//22
	public int[] L2_grosssales_filter=new int[]{9,10,17,18,20,21,22,23};//22
	public int[] L2_checkcount_filter=new int[]{9,10,17,20,21,22,23};//22
	public int[] L2_discount_filter=new int[]{9,10,17,20,21,22,23};//22
	public int[] L2_guestcount_filter=new int[]{9,10,17,20,21,22,23};//22
	public int[] L2_guestmix_filter=new int[]{9,10,17,20,21,22,23};//22
	
	public int[] L3_commonFilter=new int[]{9,10,11,12,13,14,15,17,18,19,20,21,22,23,24};//22
	public int[] L3_chkAvg_menumix=new int[]{9,10,11,12,13,14,15,17,18,19,20,25,26};
	public int[] L3_item_detail=new int[]{9,10,11,12,13,14,15,16,17,18,19,20,24,25,26,37};
	public int[] L3_cluster=new int[]{9,10,11,12,13,14,15,17,18,19,20,21,22,23,24,33,34,35,36};//22
	public int[] L3_campaign=new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,17,18,19,20,27,28,29};
	public int[] L3_promotion=new int[]{1,5,6,8,9,10,11,12,13,14,15,17,18,19,20,27,28,31,32};
	public int[] L3_loyalty=new int[]{1,9,10,11,12,13,14,15,17,18,19,20,21,22,23,24};//22
*/	
	public String L3_container1="//td[@class='pvtAxisContainer pvtUnused pvtVertList ui-sortable']";
	//public String caontainer1_element="//td[@class='pvtAxisContainer pvtUnused pvtVertList ui-sortable']/li"
	public String L3_container2="//td[@class='pvtAxisContainer pvtRows ui-sortable']";
	//public String caontainer2_element="//td[@class='pvtAxisContainer pvtRows ui-sortable']/li"
	
	public String L3_KPI_Dropdown="//*[@id='pivottable']/child::*//*/td[3]/li[1]/span/span";
	public String L3_Catogory_Dropdown="//*[@id='pivottable']/child::*//*/td[3]/li[2]/span/span";
	public String L3_kpi_element1="//td[@class='pvtAxisContainer pvtUnused pvtVertList ui-sortable']/div[3]/div/p[1]/label/span";
	public String L3_Kpi_ok_button="//td[@class='pvtAxisContainer pvtUnused pvtVertList ui-sortable']/div[3]/p[2]/button";
	
	public String L1_sma_t1 = "//li[1]/child::*//*[@id='ageRangeChart']";
	public String L1_sma_t2 = "//li[2]/child::*//*[contains(text(),'Male')]";
	public String L1_sma_t3 = "//li[3]/child::*//*[contains(text(),'25K')]";
	public String L1_sma_t4 = "//li[4]/child::*//*[contains(@class,'img-responsive')]";
	public String L1_sma_t5 = "//li[5]/child::*//*[contains(@id,'occupationChart')]";
	public String L1_sma_t6 = "//li[6]/child::*//*[contains(@id,'educationPieChart')]";
	public String L1_sma_t7 = "//li[7]/child::*//*[contains(@id,'prmEthnicityContainer')]";
	public String L1_sma_t8 = "//li[8]/child::*//*[contains(@class,'img-responsive')]";
	public String L1_sma_t9 = "//li[9]/child::*//*[contains(@class,'dark')]"; //can also use this     //li[9]/child::*//*[contains(text(),'High Likelyhood')]
	public String L1_sma_t10 = "//li[10]/child::*//*[contains(@class,'dark')]";
	public String L1_sma_t11 = "//li[11]/child::*//*[contains(@class,'dark')]";
	public String L1_sma_t12 = "//li[12]/child::*//*[contains(@class,'dark')]";
	public String L1_sma_t13 = "//li[13]/child::*//*[@id='avgCheckChart']";
	public String L1_sma_t14 = "//li[14]/child::*//*[@id='personaPieChart']";
	public String L1_sma_t15 = "//li[15]/child::*//*[@id='emailOpenRateChart']";
	public String L1_sma_t16 = "//li[16]/child::*//*[@id='emailRedemptionRateChart']";
	
	
	File dir1;
	String reportName;
	
	String date =null;
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
	
	public String  date()
	{
		final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	
	    LocalDate localDate = LocalDate.now();
        System.out.println(DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate));
		String datee = DateTimeFormatter.ofPattern("dd").format(localDate);
		return datee;
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
		   verifyelementL1(this.L1_L1, this.L1_L2, this.L1_L3, this.L1_L4, this.L1_L5, this.L1_L6, this.L1_L7, this.L1_L8);
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
			verifyelementL1(this.L1_L1, this.L1_L2, this.L1_L3, this.L1_L4, this.L1_L5, this.L1_L6, this.L1_L7, this.L1_L8);
			String l1=driver.findElement(By.xpath(L1_L1_TD)).getText();
			String l2=driver.findElement(By.xpath(L1_L2_TD)).getText();
			String l3=driver.findElement(By.xpath(L1_L3_TD)).getText();
			String l4=driver.findElement(By.xpath(L1_L4_TD)).getText();
			String l5=driver.findElement(By.xpath(L1_L5_TD)).getText();
			String l7=driver.findElement(By.xpath(L1_L7_TD)).getText();
			String l8=driver.findElement(By.xpath(L1_L8_TD)).getText();
			if(l1.equals("QTD")&&l2.equals("QTD")&&l3.equals("QTD")&&l4.equals("QTD")&&l5.equals("QTD")&&l7.equals("QTD")&&l8.equals("QTD"))
			{
				System.out.println(l1+l2+l3+l4+l5+l7+l8);
				logger.log(LogStatus.PASS, "QTD found on applying Quarter");
				return true;
			}
			else
			{
				String t =String.valueOf(System.currentTimeMillis());
				String snap = "failed_L1_QuarterQTD"+t;
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("document.body.style.zoom='" + 50 + "%'");
				Thread.sleep(2000);
				getscreenshot(snap);
				js.executeScript("document.body.style.zoom='" + 100 + "%'");
				Thread.sleep(2000);
				String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
				logger.log(LogStatus.FAIL, "QTD not found on applying Quarter",image);
				return false;
			}
			
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
			verifyelementL1(this.L1_L1, this.L1_L2, this.L1_L3, this.L1_L4, this.L1_L5, this.L1_L6, this.L1_L7, this.L1_L8);
			String l1=driver.findElement(By.xpath(L1_L1_TD)).getText();
			String l2=driver.findElement(By.xpath(L1_L2_TD)).getText();
			String l3=driver.findElement(By.xpath(L1_L3_TD)).getText();
			String l4=driver.findElement(By.xpath(L1_L4_TD)).getText();
			String l5=driver.findElement(By.xpath(L1_L5_TD)).getText();
			String l7=driver.findElement(By.xpath(L1_L7_TD)).getText();
			String l8=driver.findElement(By.xpath(L1_L8_TD)).getText();
			if(l1.equals("PTD")&&l2.equals("PTD")&&l3.equals("PTD")&&l4.equals("PTD")&&l5.equals("PTD")&&l7.equals("PTD")&&l8.equals("PTD"))
			{
				System.out.println(l1+l2+l3+l4+l5+l7+l8);
				logger.log(LogStatus.PASS, "PTD found on applying Quarter");
				return true;
			}
			else
			{
				String t =String.valueOf(System.currentTimeMillis());
				String snap = "failed_L1_PeriodPTD"+t;
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("document.body.style.zoom='" + 50 + "%'");
				Thread.sleep(2000);
				getscreenshot(snap);
				js.executeScript("document.body.style.zoom='" + 100 + "%'");
				Thread.sleep(2000);
				String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
				logger.log(LogStatus.FAIL, "PTD not found on applying Period",image);
				return false;
			}
			
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
			verifyelementL1(this.L1_L1, this.L1_L2, this.L1_L3, this.L1_L4, this.L1_L5, this.L1_L6, this.L1_L7, this.L1_L8);
			String l1=driver.findElement(By.xpath(L1_L1_TD)).getText();
			String l2=driver.findElement(By.xpath(L1_L2_TD)).getText();
			String l3=driver.findElement(By.xpath(L1_L3_TD)).getText();
			String l4=driver.findElement(By.xpath(L1_L4_TD)).getText();
			String l5=driver.findElement(By.xpath(L1_L5_TD)).getText();
			String l7=driver.findElement(By.xpath(L1_L7_TD)).getText();
			String l8=driver.findElement(By.xpath(L1_L8_TD)).getText();
			if(l1.equals("YTD")&&l2.equals("YTD")&&l3.equals("YTD")&&l4.equals("YTD")&&l5.equals("YTD")&&l7.equals("YTD")&&l8.equals("YTD"))
			{
				System.out.println(l1+l2+l3+l4+l5+l7+l8);
				logger.log(LogStatus.PASS, "YTD found on applying Quarter");
				return true;
			}
			else
			{
				String t =String.valueOf(System.currentTimeMillis());
				String snap = "failed_L1_buttonYearYTD"+t;
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("document.body.style.zoom='" + 50 + "%'");
				Thread.sleep(2000);
				getscreenshot(snap);
				js.executeScript("document.body.style.zoom='" + 100 + "%'");
				Thread.sleep(2000);
				String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
				logger.log(LogStatus.FAIL, "YTD not found on applying Quarter",image);
				return false;
			}
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
	}
	
	public boolean L1_checkboxClick() throws Exception{
		long start_m = System.currentTimeMillis();
		long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		WebDriverWait wait = new WebDriverWait(driver, 180);
		try
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(L1_checkbox)));
			driver.findElement(By.xpath(L1_checkbox)).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(L1_checkboxClick_sideText)));
			Thread.sleep(8000);
			String text=driver.findElement(By.xpath(L1_checkboxClick_sideText)).getText();
			if(ValidationMethod.isValidString(text)){
				System.out.println(text);
				logger.log(LogStatus.PASS, "on Checkbox Click text found ="+ text);
				return true;
			}
			else
			{
				String t =String.valueOf(System.currentTimeMillis());
				String snap = "failed_checkboxClick"+t;
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("document.body.style.zoom='" + 50 + "%'");
				Thread.sleep(2000);
				getscreenshot(snap);
				js.executeScript("document.body.style.zoom='" + 100 + "%'");
				Thread.sleep(2000);
				String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
				logger.log(LogStatus.FAIL, "nothing found on Checkbox Click",image);
				return false;
			}
		}
		catch(Exception e)
		{
			String t =String.valueOf(System.currentTimeMillis());
			String snap = "failed_checkboxClick"+t;
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.body.style.zoom='" + 50 + "%'");
			Thread.sleep(2000);
			getscreenshot(snap);
			js.executeScript("document.body.style.zoom='" + 100 + "%'");
			Thread.sleep(2000);
			String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
			logger.log(LogStatus.FAIL, "Something went wrong with Checkbox click ",image);
			return false;
		}
	}

	public boolean L1_dates()throws Exception{
		long start_m = System.currentTimeMillis();
		long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		try
		{
			String startD=driver.findElement(By.xpath(L1_startend)).getText();
			if(ValidationMethod.isValidString(startD))
			{
				System.out.println(startD);
				String[] splits = startD.split("\\ ");
				String sd = splits[3]; 
				String ed = splits[7]; 
				if(ValidationMethod.isValidString(sd))
				{
					System.out.println(sd);
				}
				else
				{
					String t =String.valueOf(System.currentTimeMillis());
					String snap = "failed_L1_dates"+t;
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("document.body.style.zoom='" + 50 + "%'");
					Thread.sleep(2000);
					getscreenshot(snap);
					js.executeScript("document.body.style.zoom='" + 100 + "%'");
					Thread.sleep(2000);
					String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
					logger.log(LogStatus.FAIL, "Start date not found",image);
					return false;
				}
				if(ValidationMethod.isValidString(ed))
				{
					System.out.println(ed);
				}
			else
			{
				String t =String.valueOf(System.currentTimeMillis());
				String snap = "failed_L1_dates"+t;
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("document.body.style.zoom='" + 50 + "%'");
				Thread.sleep(2000);
				getscreenshot(snap);
				js.executeScript("document.body.style.zoom='" + 100 + "%'");
				Thread.sleep(2000);
				String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
				logger.log(LogStatus.FAIL, "End date not found",image);
				return false;
			}
				logger.log(LogStatus.PASS, "Start and End date found");
			return true;
			}
			else
			{
				String t =String.valueOf(System.currentTimeMillis());
				String snap = "failed_L1_dates"+t;
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("document.body.style.zoom='" + 50 + "%'");
				Thread.sleep(2000);
				getscreenshot(snap);
				js.executeScript("document.body.style.zoom='" + 100 + "%'");
				Thread.sleep(2000);
				String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
				logger.log(LogStatus.FAIL, " Something went wrong while checking Dates",image);
				return false;
			}
		}
		catch(Exception e)
		{
			String t =String.valueOf(System.currentTimeMillis());
			String snap = "failed_L1_dates"+t;
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.body.style.zoom='" + 50 + "%'");
			Thread.sleep(2000);
			getscreenshot(snap);
			js.executeScript("document.body.style.zoom='" + 100 + "%'");
			Thread.sleep(2000);
			String time = timestamp();
			String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
			logger.log(LogStatus.FAIL, "Something went wrong with dates",image);
			return false;
		}	
	}
	
	public boolean L2_graphNavigator(String hovername,String graph,String L2type)throws Exception
	{	
		String type = null;
		logger=report.startTest("Starting test for "+hovername);
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
	
	public boolean L2_URLNavigation(String bsaeUrl, String rest) throws Exception{
		AppUrl=bsaeUrl;
		String completeUrl=AppUrl+rest;
		logger=report.startTest("Starting test for "+rest);
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
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(L1_checkbox)));
			driver.findElement(By.xpath(L1_checkbox)).click();

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
				String c=driver.findElement(By.xpath(L1_checkboxValue)).getAttribute("aria-checked");
				
				if(a.equalsIgnoreCase(c))
				{
					System.out.println("checkbox value matched after change");
				}
				else
				{
					String t =String.valueOf(System.currentTimeMillis());
					String snap = "failed_L2_dd_checkbox"+t;
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("document.body.style.zoom='" + 50 + "%'");
					Thread.sleep(2000);
					getscreenshot(snap);
					js.executeScript("document.body.style.zoom='" + 100 + "%'");
					Thread.sleep(2000);
					String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));;
					logger.log(LogStatus.FAIL, "checkbox value not matched after change",image);
					return false;
				}
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
			driver.findElement(By.xpath(L1_checkbox)).click();
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
				String c=driver.findElement(By.xpath(L1_checkboxValue)).getAttribute("aria-checked");
				
				if(a.equalsIgnoreCase(c))
				{
					System.out.println("checkbox value matched after change");
				}
				else
				{
					String t =String.valueOf(System.currentTimeMillis());
					String snap = "failed_L2_dd_checkboxPer"+t;
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("document.body.style.zoom='" + 50 + "%'");
					Thread.sleep(2000);
					getscreenshot(snap);
					js.executeScript("document.body.style.zoom='" + 100 + "%'");
					Thread.sleep(2000);
					String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
					logger.log(LogStatus.FAIL, "checkbox value not matched after change",image);
					return false;
				}
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
			logger.log(LogStatus.PASS, "Data loaded , date changed and value matched in L2_DropDownQuater");
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
				text1=	driver.findElement(By.xpath("//div[@class='showpanel timePanels']/div["+ddFilter.get(j)+"]/child::*/*//*/*//*/*/label")).getText();
				//driver.findElement(By.xpath("//div[@class='showpanel timePanels']/div["+arg[i]+"]/child::*/*//*/*//*/*/label")).click();
				 if(ValidationMethod.isValidString(text1))
				{
					// driver.findElement(By.xpath("//div[@class='showpanel timePanels']/div["+ddFilter.get(j)+"]/div[2]/div[1]")).click();
				}
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
				}
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
				String time = timestamp();
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
				String time = timestamp();
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
	
	public boolean L3_UrlNavigator(String baseUrl,String restUrl) throws Exception{
		AppUrl=baseUrl;
		String completeUrl=AppUrl+restUrl;
		logger=report.startTest("Starting test for "+restUrl);
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
	
	public boolean L3_covercount(int childNumber) throws Exception
	{
		String child = null;
		long start_m = System.currentTimeMillis();
		long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
		logger=report.startTest("Starting test for Cover Count child"+childNumber);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		WebDriverWait wait = new WebDriverWait(driver, 90);
		try
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(covercountHover)));
			WebElement a  =   driver.findElement(By.xpath(covercountHover));
			hoverOnly(a);
			if(childNumber ==1)
			{
				child = L1_covercount_child1;
			}
			else if(childNumber ==2)
			{
				child = L1_covercount_child2;
			}
			else if(childNumber ==3)
			{
				child = L1_covercount_child3;
			}
			else if(childNumber ==4)
			{
				child = L1_covercount_child4;
			}
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(L1_covercount_arrow)));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(L1_covercount_child1)));
			WebElement b = driver.findElement(By.xpath(L1_covercount_arrow));
			WebElement c = driver.findElement(By.xpath(child));
			hoverOnMainAndClickSubLink(b, c);
			verifyelement_L3(KPI_XP, Cydata, Pydata);
			logger.log(LogStatus.PASS, "Data Loaded successfully on Cover Count child "+childNumber);
			Thread.sleep(20000);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			logger.log(LogStatus.FAIL, "Data not Loaded successfully on Cover Count child "+childNumber);
			return false;
		}
		return true;
	}
	
	public boolean L3_hoverNavigator(String hoverElement,String arrow) throws Exception
	{
		long start_m = System.currentTimeMillis();
		logger=report.startTest("Starting test for "+hoverElement);
		long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		WebDriverWait wait = new WebDriverWait(driver, 90);
		try
		{
			verifyelementL1(this.L1_L1, this.L1_L2, this.L1_L3, this.L1_L4, this.L1_L5, this.L1_L6, this.L1_L7, this.L1_L8);
			if(hoverElement.equalsIgnoreCase("itemsalesHover"))
			{
				hoverElement = itemsalesHover;
				arrow = L1_itemsales_arrow;
			}
			else if(hoverElement.equalsIgnoreCase("topstoresHover"))
			{
				hoverElement = topstoresHover;
				arrow = L1_topStores_arrow;
			}
			else if(hoverElement.equalsIgnoreCase("campaignHover"))
			{
				hoverElement = campaignHover;
				arrow = L1_campaign_arrow;
			}
			
			else if(hoverElement.equalsIgnoreCase("netsalesdecileHover"))
			{
				hoverElement = netsalesdecileHover;
				arrow = L1_netsalesDecile_arrow;
			}
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(hoverElement)));
			WebElement a  =   driver.findElement(By.xpath(hoverElement));
			WebElement b  =   driver.findElement(By.xpath(arrow));
			hoverOnly(a);hoverOnMainAndClickSubLink(a,b);
			boolean result = verifyelement_L3(KPI_XP, Cydata, Pydata);
			if (result == true) 
			{
				String t =String.valueOf(System.currentTimeMillis());
				String snap = "pass_l3_hovernavigation"+t;
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("document.body.style.zoom='" + 50 + "%'");
				Thread.sleep(2000);
				getscreenshot(snap);
				js.executeScript("document.body.style.zoom='" + 100 + "%'");
				Thread.sleep(2000);
				String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
				logger.log(LogStatus.PASS, "Data Loaded successfully on hoverElement",image);
			 return true;
			}
			else 
			{
				String t =String.valueOf(System.currentTimeMillis());
				String snap = "failed_l3_hovernavigation"+t;
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("document.body.style.zoom='" + 50 + "%'");
				Thread.sleep(2000);
				getscreenshot(snap);
				js.executeScript("document.body.style.zoom='" + 100 + "%'");
				Thread.sleep(2000);
				String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
				logger.log(LogStatus.FAIL, "Data not  Loaded successfully on hoverElement",image);
				return false;
			}
		}
		catch(Exception e)
		{
			String t =String.valueOf(System.currentTimeMillis());
			String snap = "failed_l3_hovernavigation"+t;
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.body.style.zoom='" + 50 + "%'");
			Thread.sleep(2000);
			getscreenshot(snap);
			js.executeScript("document.body.style.zoom='" + 100 + "%'");
			Thread.sleep(2000);
			String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
			logger.log(LogStatus.FAIL, "Something went wrong with L3_hoverNavigator",image);
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
			verifyelementL1(this.L1_L1, this.L1_L2, this.L1_L3, this.L1_L4, this.L1_L5, this.L1_L6, this.L1_L7, this.L1_L8);
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
	
	public boolean L1_SMA(String mainUrl,String rest)throws Exception{
		logger=report.startTest("Starting test for L1_SMA");
		long start_m = System.currentTimeMillis();
		long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		WebDriverWait wait = new WebDriverWait(driver, 90);
		try
		{
			String url = mainUrl+rest;
			driver.get(url);
			verifyelementSMAL1();
			String t =String.valueOf(System.currentTimeMillis());
			   String snap = "passed_L1_SMA"+t;
			   JavascriptExecutor js = (JavascriptExecutor) driver;
			   js.executeScript("document.body.style.zoom='" + 50 + "%'");
			   Thread.sleep(2000);
			   getscreenshot(snap);
			   js.executeScript("document.body.style.zoom='" + 100 + "%'");
			   Thread.sleep(2000);
			   String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
			logger.log(LogStatus.PASS, "Data loaded successfullyfor SMA L1",image);
		}
		catch(Exception e)
		{
			String t =String.valueOf(System.currentTimeMillis());
			String snap = "failed_L1_SMA"+t;
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.body.style.zoom='" + 50 + "%'");
			Thread.sleep(2000);
			getscreenshot(snap);
			js.executeScript("document.body.style.zoom='" + 100 + "%'");
			Thread.sleep(2000);
			String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
			logger.log(LogStatus.FAIL, "Data not loaded on all tiles for L1_SMA",image);
			return false;
		}
		return true;
	}
	
	public boolean ddFilterNumberCheck()throws Exception {
		long start_m = System.currentTimeMillis();
		long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
		WebDriverWait wait = new WebDriverWait(driver, 90);
		try
		{
		/*//	L3_Catogory_DropdownL3_kpi_element1L3_Kpi_ok_button
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(L3_KPI_Dropdown)));
			WebElement a = driver.findElement(By.xpath(L3_KPI_Dropdown));
			a.click();
			Thread.sleep(10000);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(L3_kpi_element1)));
			WebElement element = driver.findElement(By.xpath(L3_kpi_element1));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
		//	b.click();
			Thread.sleep(10000);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(L3_Kpi_ok_button)));
			WebElement c = driver.findElement(By.xpath(L3_Kpi_ok_button));
			c.click();
			Thread.sleep(10000);*/
			
			//driver.findElement(By.xpath("//td[@class='pvtAxisContainer pvtRows ui-sortable']/li[1]")).click();
			driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
			//WebElement dragframe = driver.findElement(By.xpath("//*[@id='pivottable']/table/tbody/tr[2]/td[2]/li"));
			//WebElement dropframe = driver.findElement(By.xpath("//*[@class='pvtAxisContainer pvtUnused pvtVertList ui-sortable']"));
			WebElement dragframe = driver.findElement(By.xpath("//span[text()='Month/Period']"));
			WebElement dropframe = driver.findElement(By.xpath("//li[@class='axis_11 ui-sortable-handle']"));
			
			Actions ac=new Actions(driver);
			  ac.dragAndDrop(dragframe, dropframe);
		/*	
			Actions builder =  new Actions(driver);
			//builder.dragAndDrop(dragframe, dropframe).perform();
			Action dragAndDrop = builder.clickAndHold(dragframe).moveToElement(dropframe).release(dropframe).build();
			dragAndDrop.perform();*/

			Thread.sleep(20000);
			
			/*WebElement a = driver.findElement(By.xpath(L3_container2));
			allFromChildContainer2 = a.findElements(By.tagName("li"));
			
			for(int i= 1 ; i<allFromChildContainer2.size();i++)
			{
				//ddd("//td[@class='pvtAxisContainer pvtRows ui-sortable']/li[" + i+"]",L3_container1);
				dragAndDrop("//td[@class='pvtAxisContainer pvtRows ui-sortable']/li[" + i+"]", "//td[@class='pvtAxisContainer pvtUnused pvtVertList ui-sortable']/li[1]");
			}
			Thread.sleep(20000);*/
			/*WebElement form1 = driver.findElement(By.xpath(L3_container1));
			allFromChildContainer1 = form1.findElements(By.tagName("li"));
			System.out.println(allFromChildContainer1.size());
			for(int i= 1 ; i<=allFromChildContainer1.size();i++)
			{
				System.out.println(allFromChildContainer1.get(i).getText());
			}*/
		}
		catch(Exception e)
		{
			System.out.println(e);	
			return false;
		}
		return true;
	}
	
	public boolean customDAndD()throws Exception{
		long start_m = System.currentTimeMillis();
		long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
		try
		{
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
		return true;
	}
	
	public void dragAndDrop(String ele,String to)
	{
		WebElement element = driver.findElement(By.xpath(ele)); 

		WebElement target = driver.findElement(By.xpath(to));

		(new Actions(driver)).dragAndDrop(element, target).perform();
	}
	
	public void ddd(String ele,String to){
		Actions builder = new Actions(driver);
		WebElement someElement = driver.findElement(By.xpath(ele)); 

		WebElement someOtherElement = driver.findElement(By.xpath(to));
		builder.keyDown(Keys.CONTROL)
		   .click(someElement)
		   .click(someOtherElement)
		   .keyUp(Keys.CONTROL);

		// Then get the action:
		Action selectMultiple = builder.build();

		// And execute it:
		selectMultiple.perform();
		
		/*Actions builder = new Actions(driver);
		WebElement someElement = driver.findElement(By.xpath(ele)); 

		WebElement otherElement = driver.findElement(By.xpath(to));
		Action dragAndDrop = builder.clickAndHold(someElement)
		   .moveToElement(otherElement)
		   .release(otherElement)
		   .build();

		dragAndDrop.perform();*/
		
		
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
		else return false;
		
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
	
	public void verifyelementSMAL1() 
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(L1_sma_t1)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(L1_sma_t2)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(L1_sma_t3)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(L1_sma_t4)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(L1_sma_t5)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(L1_sma_t6)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(L1_sma_t7)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(L1_sma_t8)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(L1_sma_t9)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(L1_sma_t10)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(L1_sma_t11)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(L1_sma_t12)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(L1_sma_t13)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(L1_sma_t14)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(L1_sma_t15)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(L1_sma_t16)));
		
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
	
	public static void getscreenshot(String name) throws Exception {
		
		  String time = timestamp();
		 
		  File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		  String dest = SNAPLOC+"/"+ name+".png";
		  FileUtils.copyFile(scrFile, new File(dest));
		  // System.out.println("Screenshot taken");

		 }
	
	public static  String timestamp() {
		String dt = DateFormat.getDateTimeInstance().format(new Date());
		//dt = dt.replaceAll(":", "_");

		return dt;

	}
}