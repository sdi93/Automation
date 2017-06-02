package com.fishbowl.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionBuilding 
{
 
		public static void hoverOnMainAndClickSubLink(WebDriver driver, WebElement mainElement, WebElement subElement)
		   {
			  Actions actions = new Actions(driver);
			  actions.moveToElement(mainElement).click().build().perform();
			  actions.moveToElement(subElement);
			  actions.click().build().perform();
			 
			 }
			
		
		public static void search(WebDriver driver, String campaign_name)
		{
			driver.findElement(By.xpath("//input[@id='search_txt_id']")).sendKeys(campaign_name);
	  		driver.findElement(By.xpath("//span[@class='sfl dbi RedButton bgblue']")).click();
		}
	
}

