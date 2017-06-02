package com.fishbowl.utility;


import java.util.Date;
import java.util.Random;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class RandomGenerator 
{

	public static int random_number()
	{
		
		Random random_no = new Random(); 
		int value = random_no.nextInt(1000); 
		return value;
		
	}
	
	/*public static void get_currentDate()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
	}*/
	
	
		
}
