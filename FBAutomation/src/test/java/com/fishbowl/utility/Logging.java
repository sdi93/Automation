package com.fishbowl.utility;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;

public class Logging {
	
	public static void logging(String message)
	
	{
		
		Logger logger = Logger.getLogger("Logging");
		
		PropertyConfigurator.configure("log4j.properties");
		
		logger.info(message);
		
	}
	
}