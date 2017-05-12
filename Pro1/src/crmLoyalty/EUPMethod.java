package crmLoyalty;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import malive.ReadExcelFile;

public class EUPMethod
{
	ExtentReports report;
	ExtentTest logger;
	public static WebDriver driver;
	public static String initialSNAPLOC ;
	public static String SNAPLOC ;
	
	public String signup_link = "//a[contains(text(),'CREATE ONE')]";
	public String sugnUp_textBox = "//div[@class='scrollArea regscrollArea']/div/div[2]/div[3]/div/div[2]/input";
	
	public String profile_navTab = "//*[@id='myNavbar']/ul/li[2]/a";
	public String edit_button = "//button[contains(text(),'Edit')]";
	public String editPorf_fName = "//*[@placeholder='First name']";
	public String saveButton = "//button[contains(.,' Save')]";
	public String update_closeDialog = "//button[@ng-click='closeDialog();']";
	public String update_dialogMessage = "//*[@id='dialogContent_1']/div/md-list-item/p";
	public String dialog_okButton = "//button[contains(.,'      Ok    ')]";
	
	public String password_navTab = "//*[@id='myNavbar']/ul/li[7]/a";
	public String newpassword_tetbox = "//input[contains(@placeholder,' New Password')]";
	public String confPassword_textbox = "//input[contains(@placeholder,'Confirm Password')]"; 
	public String submitButton_password = "//button[contains(.,'Submit')]";
	public String success_dialog = "//h2[contains(.,'Success')]";
	
	public String logout_navTab = "//*[@id='myNavbar']/ul/li[8]/a";
	
	List<String> list ;
	String filePath = "C:/Users/schaudhary_ic/Desktop";
	String url;
	String fname,lname,phone,email,password,birthdate,zipcode,address,city;
	String newPass = "password123";
	String newEmail = null;

	File dir1;
	String date =null;
	public void Browserinvoke(String repName)
	{
		
		date = date();
		initialSNAPLOC = "E:/SeleniumReport/"+repName+date;
	
		dir1 = new File(initialSNAPLOC);
		SNAPLOC = initialSNAPLOC+"/";
		dir1.mkdir();
		
		report=new ExtentReports(SNAPLOC+"/"+repName+".html",true);
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		WebDriverWait wait = new WebDriverWait(driver, 100);
		try
		{
			list = ReadExcelFile.readExcel(filePath, "ExportExcel.xlsx", "LoyaltyFields");
			url = list.get(0);
			 fname = list.get(1);
			 lname = list.get(2);
			 email = list.get(3);
			 password = list.get(4);
			 address = list.get(7);
			 city = list.get(8);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		driver.get(url);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(signup_link)));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
	}
	
	public String  date()
	{
		final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	    LocalDate localDate = LocalDate.now();
        System.out.println(DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate));
		String datee = DateTimeFormatter.ofPattern("dd").format(localDate);
		return datee;
	}
	
	public boolean signUpNavigation() throws Exception
	{
		logger=report.startTest("Sign-In Page");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		try
		{
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(signup_link)));
			Thread.sleep(2000);
			driver.findElement(By.xpath(signup_link)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@type='submit' and @class='btn_profile']")));
			
			 String t =String.valueOf(System.currentTimeMillis());
			   String snap = "passed_L1_dashboardView"+t;
			   JavascriptExecutor js = (JavascriptExecutor) driver;
			   js.executeScript("document.body.style.zoom='" + 50 + "%'");
			   Thread.sleep(2000);
			   getscreenshot(snap);
			   js.executeScript("document.body.style.zoom='" + 100 + "%'");
			   Thread.sleep(2000);
			   String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
			   logger.log(LogStatus.PASS, "SignUp page Loaded successfully",image);
			 
		}
		catch(Exception e)
		{
			 String t =String.valueOf(System.currentTimeMillis());
			   String snap = "passed_L1_dashboardView"+t;
			   JavascriptExecutor js = (JavascriptExecutor) driver;
			   js.executeScript("document.body.style.zoom='" + 50 + "%'");
			   Thread.sleep(2000);
			   getscreenshot(snap);
			   js.executeScript("document.body.style.zoom='" + 100 + "%'");
			   Thread.sleep(2000);
			   String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
			   logger.log(LogStatus.FAIL, "SignUp page not Loaded successfully",image);
			return false;
		}
		return true;
	}
	
	public boolean signUpForm()throws Exception
	{
		logger=report.startTest("Registration Page");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		try
		{
			WebElement a = driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']"));
			List<WebElement> allFromChild = a.findElements(By.id("regForm"));
			int childSize = allFromChild.size();
			String path ;
			for( int i= 1 ; i<=childSize;i++)
			{
/*				WebElement parent = driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]"));
				List<WebElement> forms = parent.findElements(By.tagName("div"));
				int count = forms.size();
*/
				boolean res = fromChildCheck("//div[@class='ng-scope row-mt10']/div["+i+"]");
				
				if(res==true)
				{
					String text =driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/div/div[1]")).getText();//only text path
					
					if(StringUtils.containsIgnoreCase(text, "First"))
					{
						driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/div/div[2]/input")).clear();
						driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/div/div[2]/input")).sendKeys(fname);//textBox
					}
					else if(StringUtils.containsIgnoreCase(text, "Last"))
					{
						driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/div/div[2]/input")).clear();
						driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/div/div[2]/input")).sendKeys(lname);//textBox
					}
									 
					else if(StringUtils.containsIgnoreCase(text, "Mobile Phone"))
					{
						driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/div/div[2]/input")).clear();
						Random rand = new Random();
						int num = rand.nextInt(9000000) + 1000000;
						phone = "999"+String.valueOf(num);
						driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/div/div[2]/input")).sendKeys(String.valueOf(phone));//textBox
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
						driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/div[1]/div[2]/input")).clear();
						Random rand = new Random();
						int num = rand.nextInt(900) + 100;
						newEmail = email+ String.valueOf(num) +"@gmail.com";
						driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/div[1]/div[2]/input")).sendKeys(newEmail);//textBox
						driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/div[2]/div[2]/input")).clear();
						driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/div[2]/div[2]/input")).sendKeys(newEmail);//textbox of conirm
						ReadExcelFile.writeExcel(filePath, "ExportExcel.xlsx", "LoyaltyFields",1,5,newEmail);
					}
					else if (StringUtils.containsIgnoreCase(text, "Password"))
					{
						driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/div[1]/div[2]/input")).clear();
						driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/div[1]/div[2]/input")).sendKeys(password);//textBox
						driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/div[2]/div[2]/input")).sendKeys(password);//textbox of conirm
					}	
					else if(StringUtils.containsIgnoreCase(text, "City"))
					{
						driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/div[1]/div[2]/input")).clear();
						driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/div/div[2]/input")).sendKeys(city);//textBox
					}
					else if(StringUtils.containsIgnoreCase(text, "Address"))
					{
						driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/div[1]/div[2]/input")).clear();
						driver.findElement(By.xpath("//div[@class='ng-scope row-mt10']/div["+i+"]/div/div[2]/input")).sendKeys(address);//textBox
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
				}
				else{
					System.out.println("asd");}
			}
			Thread.sleep(5000);
			//driver.findElement(By.xpath("//div[@class='scrollArea regscrollArea']/div[4]/div/input")).click();
			driver.findElement(By.xpath("//input[@ng-model='vm.reg.termsCondition']")).click();
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='myNavbar']/ul/li[1]/a")));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(.,'My Loyalty Points')]")));

			
			 
			   logger.log(LogStatus.PASS, "SignUp complete successfully");
			
		}
		catch(Exception e)
		{
			 String t =String.valueOf(System.currentTimeMillis());
			 String snap = "passed_signupForm"+t;
			   JavascriptExecutor js = (JavascriptExecutor) driver;
			   js.executeScript("document.body.style.zoom='" + 50 + "%'");
			   Thread.sleep(2000);
			   getscreenshot(snap);
			   js.executeScript("document.body.style.zoom='" + 100 + "%'");
			   Thread.sleep(2000);
			   String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
			   logger.log(LogStatus.FAIL, "SignUp form not submitted/completed succssfully",image);
			return false;
		}
		return true;
	}
	
	public boolean fromChildCheck(String parent)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		try
		{
		WebElement parent1 = driver.findElement(By.xpath(parent));
		List<WebElement> forms = parent1.findElements(By.tagName("div"));
		int count = forms.size();
		if(count>1){return true;}
		else
		{
			return false;
		}
		}
		catch(Exception e){
		return false;}
	}
	
	public boolean userProfileUpdate()throws Exception
	{
		logger=report.startTest("UserProfile Update");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		try
		{
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(profile_navTab)));
			driver.findElement(By.xpath(profile_navTab)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(edit_button)));
			driver.findElement(By.xpath(edit_button)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(editPorf_fName)));
			driver.findElement(By.xpath(editPorf_fName)).clear();
			driver.findElement(By.xpath(editPorf_fName)).sendKeys("Siddharth123");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(saveButton)));
			driver.findElement(By.xpath(saveButton)).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(success_dialog)));
			driver.findElement(By.xpath(success_dialog));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dialog_okButton)));
			driver.findElement(By.xpath(dialog_okButton)).click();
			Thread.sleep(2000);
			logger.log(LogStatus.PASS, "USer profile updated  succesfully");

		}
		catch(Exception e)
		{
			 String t =String.valueOf(System.currentTimeMillis());
			 String snap = "passed_profileUpdation"+t;
			   JavascriptExecutor js = (JavascriptExecutor) driver;
			   js.executeScript("document.body.style.zoom='" + 50 + "%'");
			   Thread.sleep(2000);
			   getscreenshot(snap);
			   js.executeScript("document.body.style.zoom='" + 100 + "%'");
			   Thread.sleep(2000);
			   String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
			   logger.log(LogStatus.FAIL, "User proile updatin not complete",image);
			return false;
		}
		return true;
	}
	
	public boolean updatePassword()throws Exception
	{
		logger=report.startTest("Change Password");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		try
		{
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(password_navTab)));
			driver.findElement(By.xpath("//span[contains(.,'RESET PASSWORD')]")).click();
			//driver.findElement(By.xpath(password_navTab)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(.,'Reset Password')]")));
			
			driver.findElement(By.xpath("//input[@placeholder='Current Password']")).clear();
			driver.findElement(By.xpath("//input[@placeholder='Current Password']")).sendKeys(password);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(newpassword_tetbox)));
			driver.findElement(By.xpath(newpassword_tetbox)).clear();
			driver.findElement(By.xpath(newpassword_tetbox)).sendKeys(newPass);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(confPassword_textbox)));
			driver.findElement(By.xpath(confPassword_textbox)).clear();
			driver.findElement(By.xpath(confPassword_textbox)).sendKeys(newPass);
			ReadExcelFile.writeExcel(filePath, "ExportExcel.xlsx", "LoyaltyFields",1,6,newPass);
			driver.findElement(By.xpath(submitButton_password)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(success_dialog)));
			driver.findElement(By.xpath(success_dialog));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dialog_okButton)));
			driver.findElement(By.xpath(dialog_okButton)).click();
			logger.log(LogStatus.PASS, "Password update Complete");
		}
		catch(Exception e)
		{
			 String t =String.valueOf(System.currentTimeMillis());
			 String snap = "passed_updatinPassword"+t;
			   JavascriptExecutor js = (JavascriptExecutor) driver;
			   js.executeScript("document.body.style.zoom='" + 50 + "%'");
			   Thread.sleep(2000);
			   getscreenshot(snap);
			   js.executeScript("document.body.style.zoom='" + 100 + "%'");
			   Thread.sleep(2000);
			   String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
			   logger.log(LogStatus.FAIL, "Password  not changed succssfully",image);
			return false;
		}
		return true;
	}
	
	public boolean logout(String after) throws Exception
	{
		logger=report.startTest("Log-Out after"+after);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		try
		{
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[contains(.,'LOG OUT')]")).click();
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(password_navTab)));
			//driver.findElement(By.xpath(logout_navTab)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Email/Mobile Phone')]")));
			logger.log(LogStatus.PASS, "Logout successfull");
			
		}
		catch(Exception e)
		{
			String t =String.valueOf(System.currentTimeMillis());
			String snap = "passed_signupForm"+t;
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.body.style.zoom='" + 50 + "%'");
			Thread.sleep(2000);
			getscreenshot(snap);
			js.executeScript("document.body.style.zoom='" + 100 + "%'");
			Thread.sleep(2000);
			String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
		   logger.log(LogStatus.FAIL, "Logout not completed succssfully",image);
			return false;
		}
		return true;
	}
	
	public boolean login()throws Exception
	{
		logger=report.startTest("Log-In with Registered User");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Email/Mobile Phone')]")));
			driver.findElement(By.id("exampleInputEmail1")).sendKeys(newEmail);
			driver.findElement(By.id("exampleInputPassword1")).sendKeys(password);
			driver.findElement(By.xpath("//input[@value='Sign in']")).click();
			logger.log(LogStatus.PASS, "Login Successfull");
		}
		catch(Exception e)
		{
			String t =String.valueOf(System.currentTimeMillis());
			String snap = "passed_login"+t;
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.body.style.zoom='" + 50 + "%'");
			Thread.sleep(2000);
			getscreenshot(snap);
			js.executeScript("document.body.style.zoom='" + 100 + "%'");
			Thread.sleep(2000);
			String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
		   logger.log(LogStatus.FAIL, "not able to Login",image);
			return false;
		}
		return true;
	}
	
	public boolean login2()throws Exception
	{
		logger=report.startTest("Log-In with New Password");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Email/Mobile Phone')]")));
			driver.findElement(By.id("exampleInputEmail1")).sendKeys(newEmail);
			driver.findElement(By.id("exampleInputPassword1")).sendKeys(newPass);
			driver.findElement(By.xpath("//input[@value='Sign in']")).click();
			Thread.sleep(30000);
			logger.log(LogStatus.PASS, "Login Successfull");
		}
		catch(Exception e)
		{
			String t =String.valueOf(System.currentTimeMillis());
			String snap = "passed_login"+t;
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.body.style.zoom='" + 50 + "%'");
			Thread.sleep(2000);
			getscreenshot(snap);
			js.executeScript("document.body.style.zoom='" + 100 + "%'");
			Thread.sleep(2000);
			String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
		   logger.log(LogStatus.FAIL, "not able to Login",image);
			return false;
		}
		return true;
	}
	
	public void quit()
	{
		driver.close();
		driver.quit();
	}

	public void reportFlush(){
		report.endTest(logger);
		report.flush();
	}
	
	public static void getscreenshot(String name) throws Exception {
		
		  
		 
		  File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		  String dest = SNAPLOC+"/"+ name+".png";
		  FileUtils.copyFile(scrFile, new File(dest));
		  // System.out.println("Screenshot taken");

		 }
}
