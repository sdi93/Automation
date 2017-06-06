package com.fishbowl.utility;

	import java.io.File;
	import java.text.DateFormat;
	import java.text.SimpleDateFormat;
	import java.time.LocalDate;
	import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.fishbowl.config.Common;
import com.relevantcodes.extentreports.ExtentReports;
	import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

	public class Reporting
	{
		
		public static ExtentReports report;
		public static ExtentTest logger;
		
		public static String initialSNAPLOC ;
		public static String SNAPLOC ;
		public static File dir1;
		public static String date =null;
		public static String time =null;
		
		public static String date()
		{
			final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		    final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		
		    LocalDate localDate = LocalDate.now();
	        System.out.println(DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate));
			String datee = DateTimeFormatter.ofPattern("dd").format(localDate);
			return datee;
		}

		
		public static void reportINitialise(String repName)
		{
			date = date();
			time = String.valueOf(System.currentTimeMillis());
			initialSNAPLOC = "D:/gitcode/SelAutomation/FBAutomation/report/"+repName+date+time;
			dir1 = new File(initialSNAPLOC);
			String absodir=dir1.getAbsolutePath();
			File dir2 =new File(absodir);
			SNAPLOC = absodir+"/";
			dir2.mkdir();
			report=new ExtentReports(SNAPLOC+repName+".html",true);
		}
		
        public void getscreenshot(String name) throws Exception
		{
        	
			File scrFile = ((TakesScreenshot) Common.driver).getScreenshotAs(OutputType.FILE);
		    String dest = SNAPLOC+"/"+ name+".png";
		    FileUtils.copyFile(scrFile, new File(dest));
	     
		    		
		}
        
        public void report_status_pass(String msg) throws Exception 
        {
        	try
        	{
        	String t =String.valueOf(System.currentTimeMillis());
            
            
            logger.log(LogStatus.PASS, msg);
        	}
        	catch(Exception e)
        	{
        		System.out.println(e.getMessage());
        	}
        }
		
        public void report_status_fail(String snap_name, String msg) throws Exception 
        {
        	try
        	{
        	String t =String.valueOf(System.currentTimeMillis());
            String snap = snap_name +t;
        	   
        	   JavascriptExecutor js = (JavascriptExecutor)Common.driver;
        	   js.executeScript("document.body.style.zoom='" + 50 + "%'");
        	   Thread.sleep(2000);
        	   
        	   getscreenshot(snap);
        	   
        	   js.executeScript("document.body.style.zoom='" + 100 + "%'");
        	  
        	   Thread.sleep(2000);
        	   String image = logger.addScreenCapture(SNAPLOC.concat(snap).concat(".png"));
        	   logger.log(LogStatus.FAIL, msg, image);
        	}
        	catch(Exception e)
        	{
        		System.out.println(e.getMessage());
        	}
        }
		
      
		public void reportFlush(){
			report.endTest(logger);
			report.flush();
		}
	}


