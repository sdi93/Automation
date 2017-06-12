package com.fishbowl.gaPages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fishbowl.config.GABase;
import com.fishbowl.config.SMA_Locators;
import com.relevantcodes.extentreports.LogStatus;

public class SMAL1Page
{
	WebDriver driver;
	SMA_Locators smaLocs = new SMA_Locators();
	GABase perent = new GABase();
	

	public SMAL1Page(WebDriver ldriver)
	{
	  this.driver=ldriver;
	}
	
	public boolean L1_SMA(String smaType)throws Exception{
		//logger=report.startTest("Starting test for L1_SMA");
		long start_m = System.currentTimeMillis();
		long start = TimeUnit.MILLISECONDS.toSeconds(start_m);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		WebDriverWait wait = new WebDriverWait(driver, 90);
		try
		{
			String url = perent.url+"SMA";
			driver.get(url);
			if(smaType.equalsIgnoreCase("gaLite"))
			{
				verifyelementSMALite();
			}
			else
			{
				verifyelementSMAAnalytics();
			}
			
			//logger.log(LogStatus.PASS, "Data loaded successfullyfor SMA L1",image);
		}
		catch(Exception e)
		{
			//logger.log(LogStatus.FAIL, "Data not loaded on all tiles for L1_SMA",image);
			return false;
		}
		return true;
	}
	
	public void verifyelementSMAAnalytics() 
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(smaLocs.get_L1_sma_t1())));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(smaLocs.get_L1_sma_t2())));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(smaLocs.get_L1_sma_t3())));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(smaLocs.get_L1_sma_t4())));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(smaLocs.get_L1_sma_t5())));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(smaLocs.get_L1_sma_t6())));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(smaLocs.get_L1_sma_t7())));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(smaLocs.get_L1_sma_t8())));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(smaLocs.get_L1_sma_t9())));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(smaLocs.get_L1_sma_t10())));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(smaLocs.get_L1_sma_t11())));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(smaLocs.get_L1_sma_t12())));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(smaLocs.get_L1_sma_t13())));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(smaLocs.get_L1_sma_t14())));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(smaLocs.get_L1_sma_t15())));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(smaLocs.get_L1_sma_t16())));
		
	}
	
	public void verifyelementSMALite() 
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(smaLocs.get_L1_sma_t1())));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(smaLocs.get_L1_sma_t2())));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(smaLocs.get_L1_sma_t3())));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(smaLocs.get_L1_sma_t4())));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(smaLocs.get_L1_sma_t5())));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(smaLocs.get_L1_sma_t6())));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(smaLocs.get_L1_sma_t7())));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(smaLocs.get_L1_sma_t8())));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(smaLocs.get_L1_sma_t9())));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(smaLocs.get_L1_sma_t10GaLite())));
	}
}
