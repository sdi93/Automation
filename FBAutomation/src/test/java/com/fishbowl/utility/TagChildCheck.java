package com.fishbowl.utility;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TagChildCheck {

	public static boolean byTagChildCheck(WebDriver driver,String parentPath,String tagName)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		try
			{
				WebElement parent1 = driver.findElement(By.xpath(parentPath));
				List<WebElement> forms = parent1.findElements(By.tagName(tagName));
				int count = forms.size();
				if(count>1)
				{
					return true;
				}
				else
				{
					return false;
				}
		}
		catch(Exception e)
		{
			return false;
		}
	}
}
