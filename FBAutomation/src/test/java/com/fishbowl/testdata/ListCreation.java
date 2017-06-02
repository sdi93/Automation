package com.fishbowl.testdata;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.fishbowl.utility.RandomGenerator;

public class ListCreation
{

	WebDriver driver;
	
	public String add_btn = "//a[text()='Add']";
	
	public String channel_dd = ".//*[@id='storeeditor']/div/div/div[3]/div/div/div[3]/div[2]/select";
	
	public String name_txtbox = "//input[@id='Name']";
	
	public String save_btn = "//input[@value ='Save']";

	
	@Test
	public void create_list() throws InterruptedException
	{
	
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://stg-jamba.fishbowlcloud.com/#/settings/lists");
		
		try 
		{
			Thread.sleep(2000);
		} 
		catch (InterruptedException e)
		{
			
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//input[@id='login']")).sendKeys("serveradmin");
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("3OTaCGoiPP");
		driver.findElement(By.xpath("//div[@class='clearfix tac']//input[@class='bluebutton']")).click();	
		
		Thread.sleep(5000);
		
		driver.navigate().to("https://stg-jamba.fishbowlcloud.com/#/settings/lists");
		
		Thread.sleep(5000);
		driver.findElement(By.xpath(add_btn)).click();
		
		Thread.sleep(3000);
		
		WebElement channel_drop = driver.findElement(By.xpath(channel_dd));
		
		Select channel_dropdown = new Select(channel_drop);
		
		channel_dropdown.selectByVisibleText("SMS");
		
		String ListName = "ListJune_QATest"+RandomGenerator.random_number();
		driver.findElement(By.xpath(name_txtbox)).sendKeys(ListName);
		driver.findElement(By.xpath(save_btn)).click();
		
		
		
		
     }
}
