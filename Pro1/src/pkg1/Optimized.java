package pkg1;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Optimized {
	ExtentReports report;
	static ExtentTest logger;
	public static WebDriver driver;

	public String Username = "schaudhary_ic";
	public String password = "Schaudhary123";
	//public String Username = "serveradmin";
	//public String password = "mP2$Kx_uz@NH";
	// public String Username = "fbjambaadmin";
	//public String password = "SQj0Kp3Hez";
	public static String SNAPLOC = "E:/SeleniumSnaps/";
	
	 //public String Username = "fbjambaadmin";
	 //public String password = "SQj0Kp3Hez";
	
	public String AppUrl ="https://txrh.fishbowlcloud.com/#/insights/cockpit/";

	String Reportname = AppUrl.substring(8);

	long time = System.currentTimeMillis();
	long finish = TimeUnit.MILLISECONDS.toSeconds(time);

	String timetaken = String.valueOf(finish);
	// public String Reportpath =
	// "D:\\Report\\Test_Report_".concat(Reportname).concat(timetaken).concat(".html");

	public String Reportpath = "E:/SeleniumReport/Test_Report_" + timestamp() + ".html";

	 
	// public String AppUrl =
	// "https://olga.fishbowlcloud.com/#/insights/cockpit/";
	
	// public String AppUrl =
	// "https://jamba.fishbowlcloud.com/#/insights/cockpit/";
	// public String AppUrl =
	// "https://hotfix-jamba.fishbowlcloud.com/#/insights/cockpit/";
	public String loginxp = "//*[@class='x-pad']/child::*/*[@value='Login']";
	public String KPI_XP = "//span[@class='pvtAttr' and text()='KPI']";
	public String Cydata = "//*[@id='pivottable']/child::*//*[@class='pvtVal row0 col0']";
	public String Pydata = "//*[@id='pivottable']/child::*//*[@class='pvtVal row0 col1']";
	public String L1 = "//*[@class='netSales']/child::*/*//*/h3";
	public String L2 = "//*[@class='checkAverage']/child::*/*//*/h3";
	public String L3 = "//*[@class='guestCount']/child::*/*//*/h3";
	public String L4 = "//*[@id='customerMix']/child::*//*/tbody/tr[1]/td[2]";
	public String L5 = "//*[@id='itemSales']/child::*/*//*/tbody/tr[1]/td[2]";
	public String L6 = "//*[@id='decile_bubble']/child::*/*//*[contains(text(),'NetSales')]";
	public String L7 = "//*[@id='TopStoreBySale']/child::*//tbody/tr[1]/td[2]";
	public String L8 = "//*[@id='campaign']/child::*//tbody/tr[1]/td[2]";
	public String Netsales_l2_1 = "//*[@id='chartContainer1']/child::*//*[contains(text(),'Net Sales')]";
	public String Netsales_l2_2 = "//*[@id='chartContainer2']/child::*//*[contains(text(),'Net Sales')]";
	public String Netsales_l2_3 = "//*[@id='chartContainer3']/child::*//*[contains(text(),'Net Sales')]";
	public String Netsales_l2_4 = "//*[@id='chartContainer4']/child::*//*[contains(text(),'Net Sales')]";
	public String Checkavg_l2_1 = "//*[@id='chartContainer1']/child::*//*[contains(text(),'Average')]";
	public String Checkavg_l2_2 = "//*[@id='chartContainer2']/child::*//*[contains(text(),'Check Avg SPLY($)')]";
	public String Checkavg_l2_3 = "//*[@id='chartContainer3']/child::*//*[contains(text(),'Qty')]";
	public String Checkavg_l2_4 = "//*[@id='chartContainer4']/child::*//*[contains(text(),'Average')]";
	public String Checkcount_l2_1 = "//*[@id='chartContainer1']/child::*//*[contains(text(),'Check')]";
	public String Checkcount_l2_2 = "//*[@id='chartContainer2']/child::*//*[contains(text(),'Check')]";
	public String Checkcount_l2_3 = "//*[@id='chartContainer3']/child::*//*[contains(text(),'Check')]";
	public String Checkcount_l2_4 = "//*[@id='chartContainer4']/child::*//*[contains(text(),'Check')]";
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

	// *[@id='chartContainer1']/child::*//*[contains(text(),'Discount')]
	@BeforeTest
	public void Browserinvoke() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		report = new ExtentReports(Reportpath, true);

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		driver.get(AppUrl);
		// logger.log(LogStatus.INFO, "Browser started ");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		


	}

	@Test(priority = 0)
	public void TestCockpit() throws Exception {
		login();
		logger = report.startTest("Validating data for Cockpit");
		long start_m = System.currentTimeMillis();
		long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		try {
			verifyelementL1(this.L1, this.L2, this.L3, this.L4, this.L5, this.L6, this.L7, this.L8);
			long finish_m = System.currentTimeMillis();
			long finish = TimeUnit.MILLISECONDS.toSeconds(finish_m);
			long totalTime = (finish - start);
			String timetaken = String.valueOf(totalTime);
			logger.log(LogStatus.PASS, "Cockpit Data is verified and Total time taken is " + timetaken + " Sec ");
		} catch (Exception e) {
			String snap = "failed_Cockpit";
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.body.style.zoom='" + 50 + "%'");
			Thread.sleep(2000);
			getscreenshot(snap);
			js.executeScript("document.body.style.zoom='" + 100 + "%'");
			Thread.sleep(2000);
			System.out.println(e.getMessage());

			// String image = logger.addScreenCapture(snap);
			String image = logger.addScreenCapture(SNAPLOC + snap + ".png");
			// System.out.println(image);
			logger.log(LogStatus.FAIL, "Some thing went wrong please see the snap shot", image);
			e.printStackTrace();
			// logger.log(LogStatus.FAIL, e.getMessage());
			// Basic_functions.capturescreenshot(driver, "Failed");
		}

	}

	@Test(priority = 1)
	public void TestNetsales() throws Exception {

		List<String> KPI = new ArrayList<String>();
		KPI.add(AppUrl + "netSales");
		KPI.add(AppUrl + "netSales/overTime");
		KPI.add(AppUrl + "netSales/dayPart");
		KPI.add(AppUrl + "netSales/orderMode");
		KPI.add(AppUrl + "netSales/dow");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		logger = report.startTest("Validating data for Net Sales");
		for (String opt : KPI) {
			long start_m = System.currentTimeMillis();
			long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
			driver.get(opt);
			if (opt.equalsIgnoreCase(AppUrl + "netSales")) {
				try {
					boolean result = verifyelement_L2(Netsales_l2_1, Netsales_l2_2, Netsales_l2_3, Netsales_l2_4);
					if (result == true) {
						long finish_m = System.currentTimeMillis();
						long finish = TimeUnit.MILLISECONDS.toSeconds(finish_m);
						long totalTime = (finish - start);
						String timetaken = String.valueOf(totalTime);
						String snap = "L2_Netsals";
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("document.body.style.zoom='" + 50 + "%'");
						Thread.sleep(2000);
						getscreenshot(snap);
						js.executeScript("document.body.style.zoom='" + 100 + "%'");
						Thread.sleep(2000);
						String image = logger.addScreenCapture(SNAPLOC + snap + ".png");
						logger.log(LogStatus.PASS,
								"L2 Charts are verified & Total Time taken is " + timetaken + " Sec ", image);
					} else {
						String snap = "failed_NetSalesL2";
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("document.body.style.zoom='" + 50 + "%'");
						Thread.sleep(2000);
						getscreenshot(snap);
						js.executeScript("document.body.style.zoom='" + 100 + "%'");
						Thread.sleep(2000);
						// e.printStackTrace();
						String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
						logger.log(LogStatus.FAIL, "Some thing went wrong please see the snap shot", image);

					}

				} catch (Exception e) {
					String snap = "failed_NetSalesL2";
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("document.body.style.zoom='" + 50 + "%'");
					Thread.sleep(2000);
					getscreenshot(snap);
					js.executeScript("document.body.style.zoom='" + 100 + "%'");
					Thread.sleep(2000);
					e.printStackTrace();
					String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
					logger.log(LogStatus.FAIL, "Some thing went wrong please see the snap shot", image);
				}

			} else {
				try {
					boolean result = verifyelement_L3(KPI_XP, Cydata, Pydata);
					if (result == true) {
						long finish_m = System.currentTimeMillis();
						long finish = TimeUnit.MILLISECONDS.toSeconds(finish_m);
						long totalTime = (finish - start);
						String timetaken = String.valueOf(totalTime);
						logger.log(LogStatus.PASS,
								"L3 Data is verified " + opt + " Total time taken is " + timetaken + " Sec ");
					} else {
						String snap = "failed_NetSalesL3";
						getscreenshot(snap);
						Thread.sleep(2000);
						// System.out.println(e.getMessage());
						String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
						logger.log(LogStatus.FAIL, "Some thing went wrong please see the snap shot", image);
					}
				} catch (Exception e) {
					String snap = "failed_NetSalesL3";
					getscreenshot(snap);
					Thread.sleep(2000);
					System.out.println(e.getMessage());
					String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
					logger.log(LogStatus.FAIL, "Some thing went wrong please see the snap shot", image);
				}
			}

			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}

	@Test(priority = 2)
	public void TestCheckAvg() throws Exception {
		// login();

		List<String> KPI = new ArrayList<String>();
		KPI.add(AppUrl + "checkAverage");
		KPI.add(AppUrl + "checkAverage/overTime");
		KPI.add(AppUrl + "checkAverage/topStore");
		KPI.add(AppUrl + "checkAverage/menuMix");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		logger = report.startTest("Validating data for checkAverage");
		for (String opt : KPI) {
			long start_m = System.currentTimeMillis();
			long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
			driver.get(opt);
			if (opt.equalsIgnoreCase(AppUrl + "checkAverage")) {
				try {
					boolean result = verifyelement_L2(Checkavg_l2_1, Checkavg_l2_2, Checkavg_l2_3, Checkavg_l2_4);
					if (result == true) {
						long finish_m = System.currentTimeMillis();
						long finish = TimeUnit.MILLISECONDS.toSeconds(finish_m);
						long totalTime = (finish - start);
						String timetaken = String.valueOf(totalTime);
						String snap = "L2_checkavg";
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("document.body.style.zoom='" + 50 + "%'");
						Thread.sleep(2000);
						getscreenshot(snap);
						js.executeScript("document.body.style.zoom='" + 100 + "%'");
						Thread.sleep(2000);
						String image = logger.addScreenCapture(SNAPLOC + snap + ".png");
						logger.log(LogStatus.PASS,
								"L2 Charts are verified & Total Time taken is " + timetaken + " Sec ", image);
					} else {
						String snap = "failed_checkavgL2";
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("document.body.style.zoom='" + 50 + "%'");
						Thread.sleep(2000);
						getscreenshot(snap);
						js.executeScript("document.body.style.zoom='" + 100 + "%'");
						Thread.sleep(2000);
						// System.out.println(e.getMessage());
						String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
						logger.log(LogStatus.FAIL, "Some thing went wrong please see the snap shot", image);
					}

				} catch (Exception e) {
					String snap = "failed_checkavgL2withex";
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("document.body.style.zoom='" + 50 + "%'");
					Thread.sleep(2000);
					getscreenshot(snap);
					js.executeScript("document.body.style.zoom='" + 100 + "%'");
					Thread.sleep(2000);
					System.out.println(e.getMessage());
					String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
					logger.log(LogStatus.FAIL, "Some thing went wrong please see the snap shot", image);
				}

			} else {
				try {
					boolean result = verifyelement_L3(KPI_XP, Cydata, Pydata);
					if (result == true) {
						long finish_m = System.currentTimeMillis();
						long finish = TimeUnit.MILLISECONDS.toSeconds(finish_m);
						long totalTime = (finish - start);
						String timetaken = String.valueOf(totalTime);
						logger.log(LogStatus.PASS,
								"L3 Data is verified " + opt + " Total time taken is " + timetaken + " Sec ");
					} else {
						String snap = "failed_checkavgL3";
						getscreenshot(snap);
						Thread.sleep(2000);
						// System.out.println(e.getMessage());
						String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
						logger.log(LogStatus.FAIL, "Some thing went wrong please see the snap shot", image);
					}
				} catch (Exception e) {
					String snap = "failed_checkavgL3exe";
					getscreenshot(snap);
					Thread.sleep(2000);
					System.out.println(e.getMessage());
					String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
					logger.log(LogStatus.FAIL, "Some thing went wrong please see the snap shot", image);
				}
			}

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}

	@Test(priority = 3)
	public void TestCheckcount() throws Exception {
		// login();

		List<String> KPI = new ArrayList<String>();
		KPI.add(AppUrl + "checkCount");
		KPI.add(AppUrl + "checkCount/overTime");
		KPI.add(AppUrl + "checkCount/dayPart");
		KPI.add(AppUrl + "checkCount/orderMode");
		KPI.add(AppUrl + "checkCount/dow");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		logger = report.startTest("Validating data for checkcount");
		for (String opt : KPI) {
			long start_m = System.currentTimeMillis();
			long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
			driver.get(opt);
			if (opt.equalsIgnoreCase(AppUrl + "checkCount")) {
				try {
					boolean result = verifyelement_L2(Checkcount_l2_1, Checkcount_l2_2, Checkcount_l2_3,
							Checkcount_l2_4);
					if (result == true) {
						long finish_m = System.currentTimeMillis();
						long finish = TimeUnit.MILLISECONDS.toSeconds(finish_m);
						long totalTime = (finish - start);
						String timetaken = String.valueOf(totalTime);
						String snap = "L2_checkcount";
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("document.body.style.zoom='" + 50 + "%'");
						Thread.sleep(2000);
						getscreenshot(snap);
						js.executeScript("document.body.style.zoom='" + 100 + "%'");
						Thread.sleep(2000);

						String image = logger.addScreenCapture(SNAPLOC + snap + ".png");
						logger.log(LogStatus.PASS,
								"L2 Charts are verified & Total Time taken is " + timetaken + " Sec ", image);
					} else {
						String snap = "failed_checkcountL2";
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("document.body.style.zoom='" + 50 + "%'");
						Thread.sleep(2000);
						getscreenshot(snap);
						js.executeScript("document.body.style.zoom='" + 100 + "%'");
						Thread.sleep(2000);
						// System.out.println(e.getMessage());
						String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
						logger.log(LogStatus.FAIL, "Some thing went wrong please see the snap shot", image);
					}

				} catch (Exception e) {
					String snap = "failed_checkcountL2exe";
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("document.body.style.zoom='" + 50 + "%'");
					Thread.sleep(2000);
					getscreenshot(snap);
					js.executeScript("document.body.style.zoom='" + 100 + "%'");
					Thread.sleep(2000);
					System.out.println(e.getMessage());
					String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
					logger.log(LogStatus.FAIL, "Some thing went wrong please see the snap shot", image);
				}

			} else {
				try {
					boolean result = verifyelement_L3(KPI_XP, Cydata, Pydata);
					if (result == true) {
						long finish_m = System.currentTimeMillis();
						long finish = TimeUnit.MILLISECONDS.toSeconds(finish_m);
						long totalTime = (finish - start);
						String timetaken = String.valueOf(totalTime);
						logger.log(LogStatus.PASS,
								"L3 Data is verified " + opt + " Total time taken is " + timetaken + " Sec ");
					} else {
						String snap = "failed_checkcountL3";
						getscreenshot(snap);
						Thread.sleep(2000);
						// System.out.println(e.getMessage());
						String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
						logger.log(LogStatus.FAIL, "Some thing went wrong please see the snap shot", image);
					}
				} catch (Exception e) {
					String snap = "failed_checkcountL3exe";
					getscreenshot(snap);
					Thread.sleep(2000);
					System.out.println(e.getMessage());
					String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
					logger.log(LogStatus.FAIL, "Some thing went wrong please see the snap shot", image);
				}
			}

			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}

	@Test(priority = 4)
	public void TestDiscount() throws Exception {
		// login();

		List<String> KPI = new ArrayList<String>();
		KPI.add(AppUrl + "discount");
		KPI.add(AppUrl + "discount/overTime");
		KPI.add(AppUrl + "discount/disDistribution");
		KPI.add(AppUrl + "discount/orderMode");
		KPI.add(AppUrl + "discount/dow");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		logger = report.startTest("Validating data for Discount");
		for (String opt : KPI) {
			long start_m = System.currentTimeMillis();
			long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
			driver.get(opt);
			if (opt.equalsIgnoreCase(AppUrl + "discount")) {
				try {
					boolean result = verifyelement_L2(Discount_l2_1, Discount_l2_2, Discount_l2_3, Discount_l2_4);
					if (result == true) {
						long finish_m = System.currentTimeMillis();
						long finish = TimeUnit.MILLISECONDS.toSeconds(finish_m);
						long totalTime = (finish - start);
						String timetaken = String.valueOf(totalTime);
						String snap = "L2_Discount";
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("document.body.style.zoom='" + 50 + "%'");
						Thread.sleep(2000);
						getscreenshot(snap);
						js.executeScript("document.body.style.zoom='" + 100 + "%'");
						Thread.sleep(2000);
						String image = logger.addScreenCapture(SNAPLOC + snap + ".png");
						logger.log(LogStatus.PASS,
								"L2 Charts are verified & Total Time taken is " + timetaken + " Sec ", image);
					} else {
						String snap = "failed_DiscountL2";
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("document.body.style.zoom='" + 50 + "%'");
						Thread.sleep(2000);
						getscreenshot(snap);
						js.executeScript("document.body.style.zoom='" + 100 + "%'");
						Thread.sleep(2000);
						// System.out.println(e.getMessage());
						String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
						logger.log(LogStatus.FAIL, "Some thing went wrong please see the snap shot", image);
					}

				} catch (Exception e) {
					String snap = "failed_DiscountL2exe";
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("document.body.style.zoom='" + 50 + "%'");
					Thread.sleep(2000);
					getscreenshot(snap);
					js.executeScript("document.body.style.zoom='" + 100 + "%'");
					Thread.sleep(2000);
					System.out.println(e.getMessage());
					String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
					logger.log(LogStatus.FAIL, "Some thing went wrong please see the snap shot", image);
				}

			} else {
				try {
					boolean result = verifyelement_L3(KPI_XP, Cydata, Pydata);
					if (result == true) {
						long finish_m = System.currentTimeMillis();
						long finish = TimeUnit.MILLISECONDS.toSeconds(finish_m);
						long totalTime = (finish - start);
						String timetaken = String.valueOf(totalTime);
						logger.log(LogStatus.PASS,
								"L3 Data is verified " + opt + " Total time taken is " + timetaken + " Sec ");
					} else {
						String snap = "failed_DiscountL3";
						getscreenshot(snap);
						Thread.sleep(2000);

						String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
						logger.log(LogStatus.FAIL, "Some thing went wrong please see the snap shot", image);
					}
				} catch (Exception e) {
					String snap = "failed_DiscountL3";
					getscreenshot(snap);
					Thread.sleep(2000);
					System.out.println(e.getMessage());
					String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
					logger.log(LogStatus.FAIL, "Some thing went wrong please see the snap shot", image);
				}
			}

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}

	@Test(priority = 5)
	public void TestgrossSales() throws Exception {
		// login();

		List<String> KPI = new ArrayList<String>();
		KPI.add(AppUrl + "grossSales");
		KPI.add(AppUrl + "grossSales/overTime");
		KPI.add(AppUrl + "grossSales/dayPart");
		KPI.add(AppUrl + "grossSales/orderMode");
		KPI.add(AppUrl + "grossSales/dow");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		logger = report.startTest("Validating data for Gross Sales");
		for (String opt : KPI) {
			long start_m = System.currentTimeMillis();
			long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
			driver.get(opt);
			if (opt.equalsIgnoreCase(AppUrl + "grossSales")) {
				try {
					boolean result = verifyelement_L2(Gross_l2_1, Gross_l2_2, Gross_l2_3, Gross_l2_4);
					if (result == true) {
						long finish_m = System.currentTimeMillis();
						long finish = TimeUnit.MILLISECONDS.toSeconds(finish_m);
						long totalTime = (finish - start);
						String timetaken = String.valueOf(totalTime);
						String snap = "L2_Grosssales";
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("document.body.style.zoom='" + 50 + "%'");
						Thread.sleep(2000);
						getscreenshot(snap);
						js.executeScript("document.body.style.zoom='" + 100 + "%'");
						Thread.sleep(2000);
						String image = logger.addScreenCapture(SNAPLOC + snap + ".png");
						logger.log(LogStatus.PASS,
								"L2 Charts are verified & Total Time taken is " + timetaken + " Sec ", image);
					}

					else {
						String snap = "failed_GrosssalesL2";
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("document.body.style.zoom='" + 50 + "%'");
						Thread.sleep(2000);
						getscreenshot(snap);
						js.executeScript("document.body.style.zoom='" + 100 + "%'");
						Thread.sleep(2000);
						// System.out.println(e.getMessage());
						String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
						logger.log(LogStatus.FAIL, "Some thing went wrong please see the snap shot", image);
					}

				} catch (Exception e) {
					String snap = "failed_GrosssalesL2exe";
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("document.body.style.zoom='" + 50 + "%'");
					Thread.sleep(2000);
					getscreenshot(snap);
					js.executeScript("document.body.style.zoom='" + 100 + "%'");
					Thread.sleep(2000);
					System.out.println(e.getMessage());
					String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
					logger.log(LogStatus.FAIL, "Some thing went wrong please see the snap shot", image);
				}

			} else {
				try {
					boolean result = verifyelement_L3(KPI_XP, Cydata, Pydata);
					if (result == true) {
						long finish_m = System.currentTimeMillis();
						long finish = TimeUnit.MILLISECONDS.toSeconds(finish_m);
						long totalTime = (finish - start);
						String timetaken = String.valueOf(totalTime);
						logger.log(LogStatus.PASS,
								"L3 Data is verified " + opt + " Total time taken is " + timetaken + " Sec ");
					} else {
						String snap = "failed_GrosssalesL3";
						getscreenshot(snap);
						Thread.sleep(2000);
						// System.out.println(e.getMessage());
						String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
						logger.log(LogStatus.FAIL, "Some thing went wrong please see the snap shot", image);
					}
				} catch (Exception e) {
					String snap = "failed_GrosssalesL3exe";
					getscreenshot(snap);
					Thread.sleep(2000);
					System.out.println(e.getMessage());
					String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
					logger.log(LogStatus.FAIL, "Some thing went wrong please see the snap shot", image);
				}
			}

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}

	@Test(priority = 6)
	public void TestGuestCount() throws Exception {
		// login();

		List<String> KPI = new ArrayList<String>();
		KPI.add(AppUrl + "guestCount");
		KPI.add(AppUrl + "guestCount/overTime");
		KPI.add(AppUrl + "guestCount/dayPart");
		KPI.add(AppUrl + "guestCount/orderMode");
		KPI.add(AppUrl + "guestCount/dow");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		logger = report.startTest("Validating data for Guest Count");
		for (String opt : KPI) {
			long start_m = System.currentTimeMillis();
			long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
			driver.get(opt);
			if (opt.equalsIgnoreCase(AppUrl + "guestCount")) {
				try {
					boolean result = verifyelement_L2(Guest_l2_1, Guest_l2_2, Guest_l2_3, Guest_l2_4);
					if (result == true) {
						long finish_m = System.currentTimeMillis();
						long finish = TimeUnit.MILLISECONDS.toSeconds(finish_m);
						long totalTime = (finish - start);
						String timetaken = String.valueOf(totalTime);
						String snap = "L2_Guestcount";
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("document.body.style.zoom='" + 50 + "%'");
						Thread.sleep(2000);
						getscreenshot(snap);
						js.executeScript("document.body.style.zoom='" + 100 + "%'");
						Thread.sleep(2000);
						String image = logger.addScreenCapture(SNAPLOC + snap + ".png");
						logger.log(LogStatus.PASS,
								"L2 Charts are verified & Total Time taken is " + timetaken + " Sec ", image);
					}

					else {
						String snap = "failed_GuestcountL2";
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("document.body.style.zoom='" + 50 + "%'");
						Thread.sleep(2000);
						getscreenshot(snap);
						js.executeScript("document.body.style.zoom='" + 100 + "%'");
						Thread.sleep(2000);
						// System.out.println(e.getMessage());
						String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
						logger.log(LogStatus.FAIL, "Some thing went wrong please see the snap shot", image);
					}

				} catch (Exception e) {
					String snap = "failed_GuestcountL2exe";
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("document.body.style.zoom='" + 50 + "%'");
					Thread.sleep(2000);
					getscreenshot(snap);
					js.executeScript("document.body.style.zoom='" + 100 + "%'");
					Thread.sleep(2000);
					System.out.println(e.getMessage());
					String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
					logger.log(LogStatus.FAIL, "Some thing went wrong please see the snap shot", image);
				}

			} else {
				try {
					boolean result = verifyelement_L3(KPI_XP, Cydata, Pydata);
					if (result == true) {
						long finish_m = System.currentTimeMillis();
						long finish = TimeUnit.MILLISECONDS.toSeconds(finish_m);
						long totalTime = (finish - start);
						String timetaken = String.valueOf(totalTime);
						logger.log(LogStatus.PASS,
								"L3 Data is verified " + opt + " Total time taken is " + timetaken + " Sec ");
					} else {
						String snap = "failed_GuestcountL3";
						getscreenshot(snap);
						Thread.sleep(2000);
						// System.out.println(e.getMessage());
						String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
						logger.log(LogStatus.FAIL, "Some thing went wrong please see the snap shot", image);
					}
				} catch (Exception e) {
					String snap = "failed_GuestcountL3exe";
					getscreenshot(snap);
					Thread.sleep(2000);
					System.out.println(e.getMessage());
					String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
					logger.log(LogStatus.FAIL, "Some thing went wrong please see the snap shot", image);
				}
			}

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}

	@Test(priority = 7)
	public void TestGuestMix() throws Exception {
		// login();

		List<String> KPI = new ArrayList<String>();
		KPI.add(AppUrl + "guestMix");
		KPI.add(AppUrl + "guestMix/overTime");
		KPI.add(AppUrl + "guestMix/dayPart");
		KPI.add(AppUrl + "guestMix/orderMode");
		KPI.add(AppUrl + "guestMix/dow");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		logger = report.startTest("Validating data for Guest Mix");
		for (String opt : KPI) {
			long start_m = System.currentTimeMillis();
			long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
			driver.get(opt);
			if (opt.equalsIgnoreCase(AppUrl + "guestMix")) {
				try {
					boolean result = verifyelement_L2(Guest_mix_l2_1, Guest_mix_l2_2, Guest_mix_l2_3, Guest_mix_l2_4);
					if (result == true) {
						long finish_m = System.currentTimeMillis();
						long finish = TimeUnit.MILLISECONDS.toSeconds(finish_m);
						long totalTime = (finish - start);
						String timetaken = String.valueOf(totalTime);
						String snap = "L2_Guestmix";
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("document.body.style.zoom='" + 50 + "%'");
						Thread.sleep(2000);
						getscreenshot(snap);
						js.executeScript("document.body.style.zoom='" + 100 + "%'");
						Thread.sleep(2000);
						String image = logger.addScreenCapture(SNAPLOC + snap + ".png");
						logger.log(LogStatus.PASS,
								"L2 Charts are verified & Total Time taken is " + timetaken + " Sec ", image);
					} else {
						String snap = "failed_GuestmixL2";
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("document.body.style.zoom='" + 50 + "%'");
						Thread.sleep(2000);
						getscreenshot(snap);
						js.executeScript("document.body.style.zoom='" + 100 + "%'");
						Thread.sleep(2000);
						// System.out.println(e.getMessage());

						String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
						logger.log(LogStatus.FAIL, "Some thing went wrong please see the snap shot", image);
					}

				} catch (Exception e) {
					String snap = "failed_GuestmixL2exe";
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("document.body.style.zoom='" + 50 + "%'");
					Thread.sleep(2000);
					getscreenshot(snap);
					js.executeScript("document.body.style.zoom='" + 100 + "%'");
					Thread.sleep(2000);
					System.out.println(e.getMessage());

					String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
					logger.log(LogStatus.FAIL, "Some thing went wrong please see the snap shot", image);
				}

			} else {
				try {
					boolean result = verifyelement_L3(KPI_XP, Cydata, Pydata);
					if (result == true) {
						long finish_m = System.currentTimeMillis();
						long finish = TimeUnit.MILLISECONDS.toSeconds(finish_m);
						long totalTime = (finish - start);
						String timetaken = String.valueOf(totalTime);
						logger.log(LogStatus.PASS,
								"L3 Data is verified " + opt + " Total time taken is " + timetaken + " Sec ");

					} else {
						String snap = "failed_GuestmixL3";
						getscreenshot(snap);
						Thread.sleep(2000);
						String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
						logger.log(LogStatus.FAIL, "Some thing went wrong please see the snap shot", image);
					}

				} catch (Exception e) {
					String snap = "failed_GuestmixL3exe";
					getscreenshot(snap);
					Thread.sleep(2000);
					System.out.println(e.getMessage());
					String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
					logger.log(LogStatus.FAIL, "Some thing went wrong please see the snap shot", image);
				}
			}

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}

	@Test(priority = 8)
	public void RestL3() throws Exception {
		List<String> http_L3 = new ArrayList<String>();
		logger = report.startTest("Validating data for Rest of All L3 KPI");
		http_L3.add(AppUrl + "TopStoreBySale");
		http_L3.add(AppUrl + "itemSales");
		http_L3.add(AppUrl + "campaign");

		http_L3.add(AppUrl + "clusters/spend");
		http_L3.add(AppUrl + "clusters/frequency");
		http_L3.add(AppUrl + "clusters/volume");
		http_L3.add(AppUrl + "clusters/recency");

		http_L3.add(AppUrl + "loyalty");
		for (String opt : http_L3) {
			long start_m = System.currentTimeMillis();
			long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
			driver.get(opt);
			try {
				verifyelement_L3(KPI_XP, Cydata, Pydata);
				long finish_m = System.currentTimeMillis();
				long finish = TimeUnit.MILLISECONDS.toSeconds(finish_m);
				long totalTime = (finish - start);
				String timetaken = String.valueOf(totalTime);
				logger.log(LogStatus.PASS,
						"L3 Data is verified " + opt + " Total time taken is " + timetaken + " Sec ");
			} catch (Exception e) {
				String snap = "L3Reports";
				getscreenshot(snap);
				Thread.sleep(2000);
				System.out.println(e.getMessage());
				String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
				logger.log(LogStatus.FAIL, "Some thing went wrong please see the snap shot", image);
			}

		}

	}

	public void login() {
		// WebDriverWait wait = new WebDriverWait(driver, 180);
		// driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);

		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys(Username);
		driver.findElement(By.id("pwd")).clear();
		driver.findElement(By.id("pwd")).sendKeys(password);
		WebElement loginbutton = driver.findElement(By.xpath(loginxp));
		loginbutton.click();

	}

	public boolean verifyelement_L2(String xp_L2_1, String xp_L2_2, String xp_L2_3, String xp_L2_4)

	{
		if (driver.findElement(By.xpath(xp_L2_1)).isDisplayed() && driver.findElement(By.xpath(xp_L2_2)).isDisplayed()
				&& driver.findElement(By.xpath(xp_L2_3)).isDisplayed()
				&& driver.findElement(By.xpath(xp_L2_4)).isDisplayed()) {
			return true;
		} else
			return false;
	}

	public boolean verifyelement_L3(String xp_L3_1, String xp_L3_2, String xp_L3_3)

	{
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp_L3_1)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp_L3_2)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp_L3_3)));
		String data1 = driver.findElement(By.xpath(xp_L3_2)).getAttribute("data-value").trim();

		String data2 = driver.findElement(By.xpath(xp_L3_3)).getAttribute("data-value").trim();

		// System.out.println("value of a=" + data1 + "value of b=" + data2);

		if ((driver.findElement(By.xpath(xp_L3_1)).isDisplayed()) && !data1.equals("0") && !data2.equals("0")) {
			// System.out.println("Inside true");
			return true;
		} else
			// System.out.println("Inside false");
			return false;

	}

	public void verifyelementL1(String xp1, String xp2, String xp3, String xp4, String xp5, String xp6, String xp7,
			String xp8) {
		WebDriverWait wait = new WebDriverWait(driver, 180);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp1)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp2)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp3)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp4)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp5)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp6)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp7)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp8)));

	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {

			// String screenshot_path =
			// Basic_functions.capturescreenshot(driver, result.getName());

			// String image = logger.addScreenCapture(screenshot_path);

			// logger.log(LogStatus.FAIL, "Data validation", image);

		}

		report.endTest(logger);
		report.flush();
		// driver.get("C:\\Report\\Test_Report.html");
	}

/*	public void getscreenshot(String name) throws Exception {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// The below method will save the screen shot in d drive with name
		// "screenshot.png"
		String dest = "C:\\Users\\Janak Tomar\\workspace\\GA\\Snapshots\\" + name + ".png";
		FileUtils.copyFile(scrFile, new File(dest));
		// System.out.println("Screenshot taken");

	}
*/
	public static String timestamp() {
		String dt = DateFormat.getDateTimeInstance().format(new Date());
		dt = dt.replaceAll(":", "_");

		return dt;

	}

	@org.testng.annotations.AfterSuite
	public void quit() {
		driver.close();
		driver.quit();
	}

	public static String snap_attachment(String name) {

		  String snap = name;
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("document.body.style.zoom='" + 50 + "%'");

		  try {
		   Thread.sleep(2000);
		  } catch (InterruptedException e1) {

		   e1.printStackTrace();
		  }
		  try {
		   getscreenshot(snap);
		  } catch (Exception e) {

		   e.printStackTrace();
		  }
		  js.executeScript("document.body.style.zoom='" + 100 + "%'");
		  try {
		   Thread.sleep(2000);
		  } catch (InterruptedException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }
		  String image = logger.addScreenCapture(SNAPLOC + snap + ".png");
		  return image;
		 }
	public static void getscreenshot(String name) throws Exception {
		  File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		  // The below method will save the screen shot in d drive with name
		  // "screenshot.png"
		  String dest = "E:/SeleniumSnaps/" + name+".png";
		  FileUtils.copyFile(scrFile, new File(dest));
		  // System.out.println("Screenshot taken");

		 }
}
