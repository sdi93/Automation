package com.fishbowl.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class SMA_Locators 
{
public static Properties pro;
	
	public SMA_Locators()
	{
		try
		{
			File f= new File("/FishbowlGitCode/FBAutomation/Locators/SMALocators.property");
			FileInputStream fis =  new FileInputStream(f);
			pro = new Properties();
			pro.load(fis);
		}
	    catch (Exception e)
		    {
				
				System.out.println(e.getMessage());
			}
	}
	
	public  String get_L1_sma_t1()
	{
		String L1_sma_t1 = pro.getProperty("L1_sma_t1");
		System.out.println(L1_sma_t1);
		return L1_sma_t1;
	}
	
	public  String get_L1_sma_t2()
	{
		String  L1_sma_t2 = pro.getProperty(" L1_sma_t2");
		System.out.println( L1_sma_t2);
		return  L1_sma_t2;
	}
	
	public  String get_L1_sma_t3()
	{
		String L1_sma_t3 = pro.getProperty("L1_sma_t3");
		System.out.println(L1_sma_t3);
		return L1_sma_t3;
	}
	
	public  String get_L1_sma_t4()
	{
		String L1_sma_t4 = pro.getProperty("L1_sma_t4");
		System.out.println(L1_sma_t4);
		return L1_sma_t4;
	}
	
	public  String get_L1_sma_t5()
	{
		String L1_sma_t5 = pro.getProperty("L1_sma_t5");
		System.out.println(L1_sma_t5);
		return L1_sma_t5;
	}
	
	public  String get_L1_sma_t6()
	{
		String L1_sma_t6 = pro.getProperty("L1_sma_t6");
		System.out.println(L1_sma_t6);
		return L1_sma_t6;
	}
	
	public  String get_L1_sma_t7()
	{
		String L1_sma_t7 = pro.getProperty("L1_sma_t7");
		System.out.println(L1_sma_t7);
		return L1_sma_t7;
	}
	
	public  String get_L1_sma_t8()
	{
		String L1_sma_t8 = pro.getProperty("L1_sma_t8");
		System.out.println(L1_sma_t8);
		return L1_sma_t8;
	}
	
	public  String get_L1_sma_t9()
	{
		String L1_sma_t9 = pro.getProperty("L1_sma_t9");
		System.out.println(L1_sma_t9);
		return L1_sma_t9;
	}
	
	public  String get_L1_sma_t10GaLite()
	{
		String L1_sma_t10GaLite = pro.getProperty("L1_sma_t10GaLite");
		System.out.println(L1_sma_t10GaLite);
		return L1_sma_t10GaLite;
	}
	
	public  String get_L1_sma_t10()
	{
		String L1_sma_t10 = pro.getProperty("L1_sma_t10");
		System.out.println(L1_sma_t10);
		return L1_sma_t10;
	}
	
	public  String get_L1_sma_t11()
	{
		String L1_sma_t11 = pro.getProperty("L1_sma_t11");
		System.out.println(L1_sma_t11);
		return L1_sma_t11;
	}
	
	public  String get_L1_sma_t12()
	{
		String L1_sma_t12 = pro.getProperty("L1_sma_t12");
		System.out.println(L1_sma_t12);
		return L1_sma_t12;
	}
	
	public  String get_L1_sma_t13()
	{
		String L1_sma_t13 = pro.getProperty("L1_sma_t13");
		System.out.println(L1_sma_t13);
		return L1_sma_t13;
	}
	
	public  String get_L1_sma_t14()
	{
		String L1_sma_t14 = pro.getProperty("L1_sma_t14");
		System.out.println(L1_sma_t14);
		return L1_sma_t14;
	}
	
	public  String get_L1_sma_t15()
	{
		String L1_sma_t15 = pro.getProperty("L1_sma_t15");
		System.out.println(L1_sma_t15);
		return L1_sma_t15;
	}
	
	public  String get_L1_sma_t16()
	{
		String L1_sma_t16 = pro.getProperty("L1_sma_t16");
		System.out.println(L1_sma_t16);
		return L1_sma_t16;
	}
	
	
}
