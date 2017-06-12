package com.fishbowl.gaPages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fishbowl.config.GABase;
import com.fishbowl.config.GA_CommonLocators;
import com.fishbowl.config.GA_L1_Locators;
import com.relevantcodes.extentreports.LogStatus;


public class Level1Page
{
	WebDriver driver;
	GABase perent = new GABase();
	AnalyticsCommonMethods ga_common_meth  = new  AnalyticsCommonMethods();
	GA_L1_Locators l1_path = new GA_L1_Locators();
	GA_CommonLocators ga_com_locs = new GA_CommonLocators();
	public static String text,text1;
	
	
	public Level1Page(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	 public boolean L1_dashboardView(String un,String pass) throws Exception
	   {
		  // logger=report.startTest("L1_Dashboard");
		   long start_m = System.currentTimeMillis();
		   long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
		   driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		   try 
		   {
			   ga_common_meth.verifyelementL1(driver,l1_path.get_L1_L1_link(), l1_path.get_L1_L2_link(), l1_path.get_L1_L3_link(), l1_path.get_L1_L4_link(),
					   l1_path.get_L1_L5_link(), l1_path.get_L1_L6_link(), l1_path.get_L1_L7_link(), l1_path.get_L1_L8_link());
			 
			  // logger.log(LogStatus.PASS, "Data Loaded successfully",image);
		   } 
		   catch (Exception e)
		   { 
			   
			
			//   logger.log(LogStatus.FAIL, "Data not loaded in all tiles",image);
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
				driver.findElement(By.xpath(ga_com_locs.get_L1_allbrand())).click();
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ga_com_locs.get_L1_brandText())));
				text=	driver.findElement(By.xpath(ga_com_locs.get_L1_brandText())).getText();
				if(ga_common_meth.isValidString(text))
				{
					System.out.println(text);
					//logger.log(LogStatus.PASS, "Brand Name "+ text);
				}
				else
				{				
					//logger.log(LogStatus.FAIL, "Brand name not found",image);
					return false;
				}
			}
			catch(Exception e)
			{
				StackTraceElement[] elements = e.getStackTrace();
				//logger.log(LogStatus.FAIL, String.valueOf(elements[1]) );
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
				driver.findElement(By.xpath(ga_com_locs.get_L1_storepath())).click();
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ga_com_locs.get_L1_storelist())));
				text1=	driver.findElement(By.xpath(ga_com_locs.get_L1_storelist())).getText();
				if(ga_common_meth.isValidString(text1))
				{
					 System.out.println(text1);
					// logger.log(LogStatus.PASS, "Store List Found");
					 return true;
				}
					else
					{
						//logger.log(LogStatus.FAIL, "Store List not found",image);
						return false;
					}
			}
			catch(Exception e)
			{
				//logger.log(LogStatus.FAIL, "Something went wrong with store list dropdown",image);
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
					//logger.log(LogStatus.PASS, "QTD found on applying Quarter");
					return true;
				}
				else
				{
					//logger.log(LogStatus.FAIL, "QTD not found on applying Quarter",image);
					return false;
				}
				
			}
			catch(Exception e)
			{
				
				//logger.log(LogStatus.FAIL, "Something went wrong with button Quarter Apply",image);
				return false;
			}
		}
}
	