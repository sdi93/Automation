package com.fishbowl.eupPages;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fishbowl.config.EUP_Common;
import com.fishbowl.config.EUP_Locators;
import com.fishbowl.utility.ReadExcelUtils;
import com.fishbowl.utility.Reporting;
import com.fishbowl.utility.TagChildCheck;
import com.relevantcodes.extentreports.LogStatus;


public class EUP_Registration 
{
	public static WebDriver driver;
	public static EUP_Locators obj1 = new EUP_Locators();
	public static EUP_Common eupCommon=new EUP_Common();
	Reporting rep = new Reporting();
	public static int emailIndexCount=0,mobileIndexCount=0;
	
	public EUP_Registration(WebDriver ldriver)
	{
	  this.driver=ldriver;
	}
	
	public void signUpForm()throws Exception
	{
		rep.logger=rep.report.startTest("Registration Page");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		try
		{
			WebElement a = driver.findElement(By.xpath(obj1.get_signUpForm()));
			List<WebElement> allFromChild = a.findElements(By.id("regForm"));
			int childSize = allFromChild.size();
			for( int i= 1 ; i<=childSize;i++)
			{
				boolean res = TagChildCheck.byTagChildCheck(driver,"//div[@class='ng-scope row-mt10']/div["+i+"]","div");
				
				if(res==true)
				{
					String text =driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/div/div[1]")).getText();//only text path
					
					if(StringUtils.containsIgnoreCase(text, "First"))
					{
						driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/div/div[2]/input")).clear();
						driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/div/div[2]/input")).sendKeys(eupCommon.fname);//textBox
					}
					else if(StringUtils.containsIgnoreCase(text, "Last"))
					{
						driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/div/div[2]/input")).clear();
						driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/div/div[2]/input")).sendKeys(eupCommon.lname);//textBox
					}
									 
					else if(StringUtils.containsIgnoreCase(text, "Mobile Phone"))
					{
						mobileIndexCount = i;
						driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/div/div[2]/input")).clear();
						driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/div/div[2]/input")).sendKeys(String.valueOf("999-417-3235"));//textBox
					}
					else if(StringUtils.containsIgnoreCase(text, "Birth Date"))
					{
						driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/div/div[2]/input")).clear();
						driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/div/div[2]/input")).sendKeys("11/17/1993");//textBox
						driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/div/div[2]/input")).click();
					}
					else if(StringUtils.containsIgnoreCase(text, "Zip Code"))
					{
						driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/div/div[2]/input")).clear();
						driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/div/div[2]/input")).sendKeys("11009");//textBox
					}
					else if(StringUtils.containsIgnoreCase(text, "Favourite Location"))
					{
		
						driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/child::*//select")).click();
						wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/child::*//select/option[2]")));
						driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/child::*//select/option[3]")).click();
					}
					else if(StringUtils.containsIgnoreCase(text, "E-mail Address"))
					{
						emailIndexCount = i;
						driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/div[1]/div[2]/input")).clear();
						
						driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/div[1]/div[2]/input")).sendKeys(eupCommon.oldEmail);//textBox
						driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/div[2]/div[2]/input")).clear();
						driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/div[2]/div[2]/input")).sendKeys(eupCommon.oldEmail);//textbox of conirm
					
					}
					else if (StringUtils.containsIgnoreCase(text, "Password"))
					{
						driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/div[1]/div[2]/input")).clear();
						driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/div[1]/div[2]/input")).sendKeys(eupCommon.password);//textBox
						driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/div[2]/div[2]/input")).sendKeys(eupCommon.password);//textbox of conirm
					}	
					else if(StringUtils.containsIgnoreCase(text, "City"))
					{
						driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/div[1]/div[2]/input")).clear();
						driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/div/div[2]/input")).sendKeys(eupCommon.city);//textBox
					}
					else if(StringUtils.containsIgnoreCase(text, "Address"))
					{
						driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/div[1]/div[2]/input")).clear();
						driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/div/div[2]/input")).sendKeys(eupCommon.address);//textBox
					}
					else if(StringUtils.containsIgnoreCase(text, "Gender"))
					{
						driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/child::*//select")).click();
						wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/child::*//select/option[3]")));
						driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/child::*//select/option[3]")).click();
					}
					else if(StringUtils.containsIgnoreCase(text, "State"))
					{
			
						driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/child::*//select")).click();
						wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/child::*//select/option[3]")));
						driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/child::*//select/option[3]")).click();
					}
					else 
					{
						driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/div[1]/div[2]/input")).clear();
						driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/div/div[2]/input")).sendKeys(eupCommon.address);//textBox
					}
				}
				else{
					System.out.println("asd");}
			}
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//input[@ng-model='vm.reg.termsCondition']")).click();
			driver.findElement(By.xpath("//input[@type='submit' and @value='SUBMIT']")).click();
			Thread.sleep(5000);
			
			if( wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(.,'Please fill out')]"))).isDisplayed()  )
			{
				String em=	driver.findElement(By.xpath("//p[@class='ng-binding']")).getText();
				if(em.equalsIgnoreCase("Email already exists"))
				{
					extEmail();
				}
				else if(em.equalsIgnoreCase("Phone number already exists"))
				{
					extPhone();
				}
				
			}
			
			if( wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(.,'Please fill out')]"))).isDisplayed()  )
			{
				String em=	driver.findElement(By.xpath("//p[@class='ng-binding']")).getText();
				 if(em.equalsIgnoreCase("Phone number already exists"))
				{
					extPhone();
				}
				 else if(em.equalsIgnoreCase("Email already exists"))
				{
					extEmail();
				}
				
			}
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='myNavbar']/ul/li[1]/a")));
		//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(.,'My Loyalty Points')]")));

			rep.report_status_pass("SignUp complete successfully");
			 
			  
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			rep.report_status_fail("registration","SignUp failed");
			
		}

	}
	
	public  void extEmail()throws Exception
	{
		driver.findElement(By.xpath("//button[@aria-hidden='false']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+emailIndexCount+"]/div[1]/div[2]/input")).clear();
		
		driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+emailIndexCount+"]/div[1]/div[2]/input")).sendKeys(eupCommon.newEmail);//textBox
		driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+emailIndexCount+"]/div[2]/div[2]/input")).clear();
		driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+emailIndexCount+"]/div[2]/div[2]/input")).sendKeys(eupCommon.newEmail);//textbox of conirm
		ReadExcelUtils.writeExcel(eupCommon.filePath, eupCommon.fileName, eupCommon.testSheet,1,5,eupCommon.newEmail);
		driver.findElement(By.xpath("//input[@type='submit' and @value='SUBMIT']")).click();
		//ext number 999-417-3235  Phone number already exists
	}
	
	public void extPhone()throws Exception
	{
		driver.findElement(By.xpath("//button[@aria-hidden='false']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+mobileIndexCount+"]/div/div[2]/input")).clear();
		driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+mobileIndexCount+"]/div/div[2]/input")).sendKeys(String.valueOf(eupCommon.phone));//textBox
		driver.findElement(By.xpath("//input[@type='submit' and @value='SUBMIT']")).click();
	}
	
}
