package com.fishbowl.testdata;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import com.fishbowl.utility.RandomGenerator;
public class SegmentCreation
{

	WebDriver driver;
	
	public String add_cust_btn = "//a[text()='Add Customer']";
	
	public String firstname_txtbox = "//input[@placeholder='First Name']";
	
	public String lastname_txtbox = "//input[@id='lastName']";
	
	public String email_txtbox = "//input[@id='email']";
	
	public String pwd_txtbox = "//input[@placeholder='Password']";
	
	public String confirm_pwd_txtbox = "//input[@placeholder='Confirm password']";
	
	public String phone_txtbox = "//input[@id='phone']";
	
	public String add_txtbox = "//input[@id='address']";
	
	public String city_txtbox = "//input[@id='city']";
	
	public String tester_chkbox = "//input[@id='useSMS0']";
	
	public String save_btn = "//input[@value ='save']";

	
	@Test
	public void create_list() throws InterruptedException
	{
	
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://stg-jamba.fishbowlcloud.com/#/marketing/customers");
		
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
		
		driver.navigate().to("https://stg-jamba.fishbowlcloud.com/#/marketing/customers");
		
		Thread.sleep(5000);
		driver.findElement(By.xpath(add_cust_btn)).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(firstname_txtbox)).sendKeys("Aviral");
		
		driver.findElement(By.xpath(lastname_txtbox)).sendKeys("Srivastava");
		
		driver.findElement(By.xpath(email_txtbox)).sendKeys("asrivastava_ic@fishbowl.com");
		
		driver.findElement(By.xpath(pwd_txtbox)).sendKeys("Avi@1989");
		
		driver.findElement(By.xpath(confirm_pwd_txtbox)).sendKeys("Avi@1989");
		
		String phone_number = "5555"+RandomGenerator.random_number();
		
		driver.findElement(By.xpath(phone_txtbox)).sendKeys(phone_number);
		
		driver.findElement(By.xpath(add_txtbox)).sendKeys("NOIDA");
		
		driver.findElement(By.xpath(city_txtbox)).sendKeys("NOIDA");
		
		boolean tester_displayed = driver.findElement(By.xpath(tester_chkbox)).isDisplayed();
		
		boolean tester_enabled = driver.findElement(By.xpath(tester_chkbox)).isEnabled();
		
		if(tester_displayed==true && tester_enabled==true)
		{
			driver.findElement(By.xpath(tester_chkbox)).click();
		}
		
		
		driver.findElement(By.xpath(save_btn)).click();
		
		
		
		
     }
}
