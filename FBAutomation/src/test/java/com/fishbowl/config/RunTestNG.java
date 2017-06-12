package com.fishbowl.config;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import org.junit.internal.runners.SuiteMethod;
import org.junit.runners.Suite;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.fishbowl.utility.ReadExcelUtils;
import com.fishbowl.utility.Reporting;

public class RunTestNG {

	public static void main(String[] args) throws Exception {
		
		/*XmlSuite s1 = new XmlSuite();
		s1.setName("Suite1");
		
		XmlTest t1 = new XmlTest(s1);
		t1.setName("Test1");
		
		ReadExcelUtils.setExcelFile("/FishbowlGitCode/FBAutomation/Data/CampaignData.xlsx", "RunStatus");
		
		ArrayList<XmlClass> Ac = new ArrayList<XmlClass>();
		
		int ncases = ReadExcelUtils.rowCount(5);
		
		for(int i=0; i<ncases; i++)
		{
			String status = ReadExcelUtils.getCellData(i, 2);
			if (status.equalsIgnoreCase("Y"))
			{
				String package_name = ReadExcelUtils.getCellData(i, 0);
				String class_name = ReadExcelUtils.getCellData(i, 1);				
				XmlClass c1 = new XmlClass(package_name+"."+class_name);
				Ac.add(c1);
			}
			
        }
		
		t1.setXmlClasses(Ac);
		
		ArrayList<XmlTest> At = new ArrayList<XmlTest>();
		At.add(t1);
		
		s1.setTests(At);
		
		ArrayList<XmlSuite> As = new ArrayList<XmlSuite>();
		As.add(s1);
		
		File file = new File("TestNG.xml");
	    System.out.println(file);

	    FileWriter writer = new FileWriter(file);
	    writer.write(s1.toXml());
	    writer.close(); 
	    */
	
		XmlSuite suite = new XmlSuite();
	      suite.setName("Suite");
	      

	      XmlTest test = new XmlTest(suite);
	      test.setName("Test");
	     

	      XmlClass testClass = null;


	     
	      ReadExcelUtils.setExcelFile("/FishbowlGitCode/FBAutomation/Data/CampaignData.xlsx", "RunStatus");
	   ArrayList<XmlClass> Ac = new ArrayList<XmlClass>();
	      int ncases = ReadExcelUtils.rowCount(5);
	 for(int i=0; i<ncases; i++){
	    String status = ReadExcelUtils.getCellData(i, 2);
	      {
	       if(status.equalsIgnoreCase("Y"))
	       {
	        String package_name = ReadExcelUtils.getCellData(i, 0);
	  String class_name = ReadExcelUtils.getCellData(i, 1);
	  String test_name = ReadExcelUtils.getCellData(i, 3);
	       
	      XmlClass c1 = new XmlClass(package_name+"."+class_name+"."+test_name);
	    Ac.add(c1);
	       }
	      }
	 }
	   
	     
	      test.setXmlClasses(Ac);
	      ArrayList<XmlTest> At = new ArrayList<XmlTest>();
	      At.add(test);
	      
	     suite.setTests(At);
	      ArrayList<XmlSuite> As = new ArrayList<XmlSuite>();
	      As.add(suite);
	      
	      File file = new File("TestNG.xml");
	      System.out.println(file);

	      FileWriter writer = new FileWriter(file);
	      writer.write(suite.toXml());
	      writer.close(); 
	    
//	     Reporting rep = new Reporting();
//	     rep.createFolder();
	     
	  TestNG tn = new TestNG();
	  tn.setXmlSuites(As);
	  tn.run();

	}

	}
