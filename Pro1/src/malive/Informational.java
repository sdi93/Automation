package malive;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.Test;

public class Informational {

	@Test
	public void InfoCampaign() throws Throwable {

		// Reading Excel file first
		// Also Printing the data of Excel
		// Set the url/username/password from the excel

		try {

			String filePath = "C://Users//RAHUL//Desktop";
			// ReadExcelFile read = new ReadExcelFile();

			List<String> list = ReadExcelFile.readExcel(filePath, "ExportExcel.xlsx", "TestSheet");

			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			String url = list.get(0);
			String username = list.get(1);
			String password = list.get(2);
			String selectAll = Keys.chord(Keys.CONTROL, "a");
			// String starttime = list.get(9);
			String campaignname = list.get(4);
			String CampaignDescription = list.get(5);
			String Keyword = list.get(6);
			String welcomeMessage = list.get(7);
			String PromotionID = list.get(8);
			String createcampaign = list.get(3);
			driver.get(url);
			driver.manage().window().maximize();

			// Login
			driver.findElement(By.id("login")).sendKeys(username);
			driver.findElement(By.id("pwd")).sendKeys(password);
			driver.findElement(By.xpath("//input[@value='Login']")).click();
			Thread.sleep(10000);
			// Navigating to SMS Campaign creation
			driver.get(createcampaign);
			Thread.sleep(10000);

			// Creating SMS Acquisition Zip Append Campaign
			Actions ac = new Actions(driver);
			WebElement we = driver.findElement(By.xpath("//li[@class='yellow active pr3 pl8']/span"));
			ac.moveToElement(we).build().perform();
			// Thread.sleep(5000);
			driver.findElement(By.xpath(".//*[@id='ulCampaignList']/li[1]")).click(); // Clicking
																						// SMS
																						// campaign
																						// link
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[contains(text(),'Informational') and @value =6]")).click(); // Selecting
																											// Informational
																											// campaign
			driver.findElement(By.xpath("//*[@ placeholder='Campaign Name']")).sendKeys(campaignname);
			driver.findElement(By.xpath("//button[@class='btn btn-primary active']")).click();
			Thread.sleep(10000);

			// STEP 1
			driver.findElement(By.xpath("//*[@placeholder='Campaign Description']")).sendKeys(CampaignDescription);
			driver.findElement(By.xpath("//*[@placeholder='Campaign Keyword']")).sendKeys(Keyword);
			driver.findElement(By.id("welcomeMessage")).sendKeys(welcomeMessage);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//input[@placeholder='Select Promotion Id']")).sendKeys(PromotionID);
			driver.findElement(By.xpath("//input[@class='bluebutton']")).click();
			Thread.sleep(5000);

			// STEP 2

			// setting Start Date
			String today = "24";
			// find the calendar
			driver.findElement(By.xpath(".//*[@placeholder='Start date']")).click();
			Thread.sleep(5000);
			WebElement dateWidget = driver.findElement(By.xpath("html/body/div[5]/div[1]/table/tbody"));
			List<WebElement> columns = dateWidget.findElements(By.tagName("td"));

			// comparing the text of cell with today's date and clicking it.
			for (WebElement cell : columns) {
				System.out.println("cell.getText() : " + cell.getText() + " today : " + today);
				System.out.println(cell.getText());
				// System.out.println(cell.getText().equals(today));
				if (cell.getText().equals(today)) {
					cell.click();
					System.out.println("clicked start date");
					break;
				}
			}
			Thread.sleep(5000);

			// Setting Start Time
			driver.findElement(By.xpath(".//*[@id='startTime']/input")).sendKeys(selectAll);
			driver.findElement(By.xpath(".//*[@id='startTime']/input")).sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.xpath(".//*[@id='startTime']/input")).sendKeys("03:28 PM");
			// Thread.sleep(5000);

			driver.findElement(By.xpath("//input[@class='bluebutton']")).click();

			/*
			 * driver.findElement(By.xpath("//div[@class='padder oh']"
			 * )).click(); // Setting End Date String date = "23";
			 * Thread.sleep(5000); // find the calendar
			 * driver.findElement(By.xpath(".//*[@placeholder='End date']"
			 * )).click(); Thread.sleep(15000);
			 * 
			 * WebElement endDate =
			 * driver.findElement(By.xpath("html/body/div[8]/div[1]/table/tbody"
			 * )); List<WebElement> column =
			 * endDate.findElements(By.tagName("td")); // comparing the text of
			 * cell with today's date and clicking it. for (WebElement cell :
			 * column) { System.out.println("cell.getText() : " + cell.getText()
			 * + " date : " + date);
			 * System.out.println(cell.getText().equals(date)); if
			 * (cell.getText().equals(date)) { Thread.sleep(3000); cell.click();
			 * Thread.sleep(3000); System.out.println("clicked End date");
			 * break; } } // Setting End Time
			 * driver.findElement(By.xpath(".//*[@id='endTime']/input")).click()
			 * ; driver.findElement(By.xpath(".//*[@id='endTime']/input")).
			 * sendKeys(selectAll);
			 * driver.findElement(By.xpath(".//*[@id='endTime']/input")).
			 * sendKeys(Keys.BACK_SPACE);
			 * driver.findElement(By.xpath(".//*[@id='endTime']/input")).
			 * sendKeys("9:28 PM"); // Save and Next
			 * driver.findElement(By.xpath("//input[@class='bluebutton']")).
			 * click(); // Save // and // Next Thread.sleep(5000);
			 */
			// Step 3 Review and Publish
			Thread.sleep(5000);
			// WebElement wait = new WebDriverWait(driver,
			// 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='bluebutton']")));
			driver.findElement(By.xpath("//input[@class='bluebutton']")).click();
			Thread.sleep(5000);
			
			

			// DB Validation
			String query = "SELECT * FROM Acme.Campaign order by 1 desc Limit 1";
			// SQLConnector sql = new SQLConnector();
			String reschk = SqlConnector.dbconnector("Name", query);
			System.out.println(reschk);
			if (reschk.equals(campaignname)) {
				System.out.println("Campaign Created Successfully");
			} else {
				System.out.println("Error occured while creating Campaign, Please check");
			}

			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
