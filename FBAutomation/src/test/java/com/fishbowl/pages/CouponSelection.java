package com.fishbowl.pages;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.fishbowl.utility.ReadExcelUtils;

public class CouponSelection {
	
	List<WebElement> ls;
	
	@FindBy(how=How.XPATH,using="//*[@id='pmPromotionID']/div[1]/div/span")
	WebElement promotionid_text;
	
	@FindBy(how=How.XPATH,using="//*[@id='showUploadImagePopUpZindex']//span[contains(text(),'Insert as Hyper link')]")
	WebElement hyperlink_radio;		
	
	@FindBy(how=How.XPATH,using="//*[@id='showUploadImagePopUpZindex']//span[contains(text(),'Expire coupon from the send date')]")
	WebElement hyperlink_radio_expire;
	
	@FindBy(how=How.XPATH,using="//input[@placeholder='Days' and @aria-disabled='false']")
	WebElement days;
	
	@FindBy(how=How.XPATH,using="//div[@class='selectize-input']/div[@placeholder='Select Coupon']")
	WebElement coupon_select;	

	public void couponSelection(WebDriver driver) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		ReadExcelUtils.setExcelFile("/SeleniumWorkspace/ws1/FBAutomation/Data/CampaignData.xlsx", "CampaignSMSBroadcast");
		
		driver.findElement(By.xpath("//input[@placeholder='Select Promotion Id']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Select Promotion Id']")).sendKeys("LSM: $1 off WFN (T1 2015)");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='listbox']/div[@role='option'][1]")));
		driver.findElement(By.xpath("//div[@role='listbox']/div[@role='option'][1]")).click();
//		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='showUploadImagePopUpZindex']//span[contains(text(),'Insert as Hyper link')]")));
		driver.findElement(By.xpath("//*[@id='showUploadImagePopUpZindex']//span[contains(text(),'Insert as Hyper link')]")).click();
		
		System.out.println(driver.findElement(By.xpath("//label[@class='radio sfl npr nopad w100']/input[@value='2']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//label[@class='radio sfl npr nopad w100']/input[@value='2']")).isEnabled());
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='showUploadImagePopUpZindex']/div/div[2]/div/div/div/div/div/div[1]/div/div[8]/div/div[2]/div[5]/div/div/div[2]/div/div[2]/div[1]/label/span")));
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='showUploadImagePopUpZindex']/div/div[2]/div/div/div/div/div/div[1]/div/div[8]/div/div[2]/div[5]/div/div/div[2]/div/div[2]/div[1]/label/span")).click();

		
		driver.findElement(By.xpath("//input[@placeholder='Days' and @aria-disabled='false']")).sendKeys("2");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='couponID']/div[1]/input")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='couponID']/div[2]/div/div/div[2]/div")).click();
		
		
	}
}
