package com.fishbowl.gaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AnalyticsCommonMethods 
{
	public void verifyelementL1(WebDriver ldriver,String xp1, String xp2, String xp3, String xp4, String xp5, String xp6, String xp7,	String xp8) 
	{
		WebDriverWait wait = new WebDriverWait(ldriver, 60);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp1)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp2)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp3)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp4)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp5)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp6)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp7)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp8)));
	}
	
	public boolean verifyelement_L2(WebDriver ldriver,String xp_L2_1, String xp_L2_2, String xp_L2_3, String xp_L2_4)

	{
		WebDriverWait wait = new WebDriverWait(ldriver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xp_L2_1)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xp_L2_2)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xp_L2_3)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xp_L2_4)));
		if (ldriver.findElement(By.xpath(xp_L2_1)).isDisplayed() && ldriver.findElement(By.xpath(xp_L2_2)).isDisplayed()
				&& ldriver.findElement(By.xpath(xp_L2_3)).isDisplayed()
				&& ldriver.findElement(By.xpath(xp_L2_4)).isDisplayed()) {
			return true;
		} else
			return false;
	}

	public boolean verifyelement_L3(WebDriver ldriver,String xp_L3_1, String xp_L3_2)

	{
		WebDriverWait wait = new WebDriverWait(ldriver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp_L3_1)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp_L3_2)));
		int iCount = 0;
		iCount = ldriver.findElements(By.xpath(xp_L3_2)).size();
		for(int i = 1; i<=iCount;i++)
		{
			String data1 = ldriver.findElement(By.xpath(xp_L3_2+"["+i+"]")).getText();
			
			if (isValidString(data1) ) 
			{
				if(!data1.equals("0")){
				
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

		if ((ldriver.findElement(By.xpath(xp_L3_1)).isDisplayed())) 
		{
				return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean isValidString(String string) {
        if ( string == null || string.equals("") ) {
            return false;

        }
        return true;
    }
}
