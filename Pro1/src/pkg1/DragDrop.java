package pkg1;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.ExtentReports;

public class DragDrop {

	public static void main(String[] args) throws MalformedURLException{
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver	driver = new ChromeDriver();
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--disable-extensions");
		//driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
		driver.get("https://jamba.fishbowlcloud.com/#/login");
		// logger.log(LogStatus.INFO, "Browser started ");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys("serveradmin");
		driver.findElement(By.id("pwd")).clear();
		driver.findElement(By.id("pwd")).sendKeys("mP2$Kx_uz@NH");
		WebElement loginbutton = driver.findElement(By.xpath("//*[@class='x-pad']/child::*/*[@value='Login']"));
		loginbutton.click();
		
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			URL u= new URL("https://jamba.fishbowlcloud.com/#/insights/cockpit/netSales/dayPart");
		 driver.navigate().to(u);
		//driver.navigate().to("https://jamba.fishbowlcloud.com/#/insights/cockpit/netSales/dayPart");
		//driver.get("https://jamba.fishbowlcloud.com/#/insights/cockpit/netSales/dayPart");
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//WebElement dragframe = driver.findElement(By.xpath("//*[@id='pivottable']/table/tbody/tr[2]/td[2]/li"));
		//WebElement dropframe = driver.findElement(By.xpath("//*[@class='pvtAxisContainer pvtUnused pvtVertList ui-sortable']"));
		
		//WebElement dragframe = driver.findElement(By.xpath("//span[text()='Month/Period']"));
		//WebElement dropframe = driver.findElement(By.xpath("//li[@class='axis_11 ui-sortable-handle']"));
		
		
		//Actions ac=new Actions(driver);
		//ac.dragAndDrop(dragframe, dropframe);
		
		
		

	}

}
