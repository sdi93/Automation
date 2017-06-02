package com.fishbowl.utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class FailedTest_reporter implements IRetryAnalyzer
{
	
   int counter = 0;
   int retryLimit = 4;

 
public boolean retry(ITestResult result) 
 {
 
    if(counter < retryLimit)
    {
      counter++;
      return true;
    }
  return false;

 }

}



