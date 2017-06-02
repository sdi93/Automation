package com.fishbowl.config;


import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.fishbowl.utility.ReadExcelUtils;

public class RunTestNG extends ReadExcelUtils{

public static void main(String args []) throws Exception{

    XmlSuite suite = new XmlSuite();
    suite.setName("Suite");
    

    XmlTest test = new XmlTest(suite);
    test.setName("Test");
   

    XmlClass testClass = null;


    ArrayList<XmlClass> classes = new ArrayList<XmlClass>();
    ArrayList<XmlInclude> methodsToRun = new ArrayList<XmlInclude>();

    testClass = new XmlClass();
    testClass.setName("ClassName");
    ReadExcelUtils.setExcelFile("C:/Users/sshah_ic/Desktop/FBAutomation/CampaignData.xlsx", "RunTestStatus");
    int ncases = ReadExcelUtils.rowCount(2)-1;
    int j;
    for(j=ncases; j>=0; j--)
    {
    	if(ReadExcelUtils.getCellData(j,2).equalsIgnoreCase("y"))
    	{
    		String MethodName = ReadExcelUtils.getCellData(j, 0) +"." + ReadExcelUtils.getCellData(j, 1);
    	
    methodsToRun.add(new XmlInclude(MethodName));
    	}
    }
    
    testClass.setIncludedMethods(methodsToRun);
    classes.add(testClass);
    test.setXmlClasses(classes);

   
    test.setXmlClasses(classes);

    File file = new File("TestNG.xml");
    System.out.println(file);

    FileWriter writer = new FileWriter(file);
    writer.write(suite.toXml());
    writer.close(); 

}

}
