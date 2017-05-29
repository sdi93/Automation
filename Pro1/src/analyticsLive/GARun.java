package analyticsLive;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GARun 
{

	public String Username = "schaudhary_ic";
	public String password = "Schaudhary123";
	// public String Username = "fbjambaadmin";
	// public String password = "SQj0Kp3Hez";
	public String AppUrl ="https://olga.fishbowlcloud.com/#/insights/cockpit/";
	GAMeth obj=new GAMeth();
	public String reportName ="olga";
	
	 @BeforeTest
		public void Browserinvoke()
	 {
		obj.Browserinvoke(AppUrl,reportName);
	}
	 
	 @Test(priority=0)
	 public void dshboardView() throws Exception{
		 boolean a = obj.L1_dashboardView(Username,password);
		  Assert.assertEquals(a, true);
	 }
	 
	@Test(priority=1)
	 public void L1_storename_dropdown() throws Exception{
		 boolean a =  obj.storename_dropDown();
		  Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=2)
	 public void L1_storelist_dropdown() throws Exception{
		 boolean a = obj.sotreList_dropDown();
		  Assert.assertEquals(a, true);
	 }
	
	 @Test(priority=3)
	 public void L1_buttonQuaterApply()throws Exception{
		 boolean a = obj.L1_buttonQuaterApply();
		  Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=4)
	 public void L1_buttonPeriodApply()throws Exception{
		 boolean a = obj.L1_buttonPeriodApply();
		  Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=5)
	 public void L1_buttonYearApply()throws Exception{
		 boolean a = obj.L1_buttonYearApply();
		  Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=6)
	 public void checkboxClick()throws Exception{
		 boolean a = obj.L1_checkboxClick();
		  Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=7)
	 public void L1_dateStartend()throws Exception{
		 boolean a = obj.L1_dates();
		  Assert.assertEquals(a, true);
		  //    TO-Do get end date and start date of dashboard;
	 }
	 
	 @Test(priority=8)
	 public void L2_netSalesNavigator()throws Exception{
		 boolean a = obj.L2_graphNavigator("netsales","L1_netsales","netSales");
		 //netsalesHover,checkaverageHover,guestmixHover
		 //L1_netsales_navgraphHover,L1_checkaverage_navgraphHover,L1_guestmix_navgraphHover
	     Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=9)
	 public void netSalesStoreNameDropdown1()throws Exception{
		 boolean a =  obj.storename_dropDown();
		  Assert.assertEquals(a, true);
	 }
	 
	@Test(priority=10)
	 public void netSalesStoreListDropdown2()throws Exception{
		 boolean a = obj.sotreList_dropDown();
		  Assert.assertEquals(a, true);
	 }
	
	 @Test(priority=11)
	 public void netSalesQuarterDropdown()throws Exception{
		 boolean a = obj.L2_DropDownQuater("netSales");
		  Assert.assertEquals(a, true);
	 }
	 @Test(priority=12)
	 public void netSalesPeriodDropdown()throws Exception{
		 boolean a = obj.L2_DropDownPeriod("netSales");
		  Assert.assertEquals(a, true);
	 }
	
	 @Test(priority=13)
	 public void netSalesFilterDataCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		  Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=14)
	 public void  netsalesOverTime()throws Exception{
		 boolean a =obj.L3_arrowNavigator(1);
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=15)
	 public void nsOTFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=16)
	 public void nsOTBack()throws Exception {
		 boolean a = obj.backToL2Click("netSales");
		 Assert.assertEquals(a,true);
	 }
	 
	 @Test(priority=17)
	 public void  netsalesDayPart()throws Exception{
		 boolean a =obj.L3_arrowNavigator(2);
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=18)
	 public void nsDPFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=19)
	 public void nsDPBack()throws Exception {
		 boolean a = obj.backToL2Click("netSales");
		 Assert.assertEquals(a,true);
	 }
	 
	 @Test(priority=20)
	 public void  netsalesOrderMode()throws Exception{
		 boolean a =obj.L3_arrowNavigator(3);
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=21)
	 public void nsOMFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=22)
	 public void nsOMBack()throws Exception {
		 boolean a = obj.backToL2Click("netSales");
		 Assert.assertEquals(a,true);
	 }
	 
	 @Test(priority=23)
	 public void  netsalesDayOfWeek()throws Exception{
		 boolean a =obj.L3_arrowNavigator(4);
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=24)
	 public void nsDWFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=25)
	 public void nsDWBack()throws Exception {
		 boolean a = obj.backToL2Click("netSales");
		 Assert.assertEquals(a,true);
	 }
	 
	 @Test(priority=26)
	 public void netsalesBack()throws Exception {
		 boolean a = obj.backToL1Click();
		 Assert.assertEquals(a,true);
	 }
	
	 @Test(priority=27)
	 public void L2_checkAverageNavigator()throws Exception{
		 boolean a = obj.L2_graphNavigator("checkaverage","L1_checkaverage","checkAverage");
		 //netsalesHover,checkaverageHover,guestmixHover
		 //L1_netsales_navgraphHover,L1_checkaverage_navgraphHover,L1_guestmix_navgraphHover
	     Assert.assertEquals(a, true);
		 }
		 
	 @Test(priority=28)
	 public void checkAverageStoreNameDropdown1()throws Exception{
		 boolean a =  obj.storename_dropDown();
		  Assert.assertEquals(a, true);
	 }
	 
	@Test(priority=29)
	 public void checkAverageStoreListDropdown2()throws Exception{
		 boolean a = obj.sotreList_dropDown();
		  Assert.assertEquals(a, true);
	 }
	
	 @Test(priority=30)
	 public void checkAverageQuarterDropdown()throws Exception{
		 boolean a = obj.L2_DropDownQuater("checkAverage");
		  Assert.assertEquals(a, true);
	 }
	 @Test(priority=31)
	 public void checkAveragePeriodDropdown()throws Exception{
		 boolean a = obj.L2_DropDownPeriod("checkAverage");
		  Assert.assertEquals(a, true);
	 }
	
	 @Test(priority=32)
	 public void checkAverageFilterDataCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		  Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=33)
	 public void  checkAverageOverTime()throws Exception{
		 boolean a =obj.L3_arrowNavigator(1);
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=34)
	 public void caOTFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=35)
	 public void caOTBack()throws Exception {
		 boolean a = obj.backToL2Click("checkAverage");
		 Assert.assertEquals(a,true);
	 }
	 
	 @Test(priority=36)
	 public void  checkAverageTopStores()throws Exception{
		 boolean a =obj.L3_arrowNavigator(2);
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=37)
	 public void caTSFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=38)
	 public void caTSBack()throws Exception {
		 boolean a = obj.backToL2Click("checkAverage");
		 Assert.assertEquals(a,true);
	 }
	 
	 @Test(priority=39)
	 public void  checkAverageMenuMix()throws Exception{
		 boolean a =obj.L3_arrowNavigator(3);
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=40)
	 public void caMMFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=41)
	 public void caMMBack()throws Exception {
		 boolean a = obj.backToL2Click("checkAverage");
		 Assert.assertEquals(a,true);
	 }
	 
	 
	 @Test(priority=42)
	 public void checkAverageBack()throws Exception {
		 boolean a = obj.backToL1Click();
		 Assert.assertEquals(a,true);
	 }
	 
	 @Test(priority=43)
	 public void L2_guestMixNavigator()throws Exception{
		 boolean a = obj.L2_graphNavigator("guestmix","L1_guestmix","guestmix");
		 //netsalesHover,checkaverageHover,guestmixHover
		 //L1_netsales_navgraphHover,L1_checkaverage_navgraphHover,L1_guestmix_navgraphHover
	     Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=44)
	 public void guestMixStoreNameDropdown1()throws Exception{
		 boolean a =  obj.storename_dropDown();
		  Assert.assertEquals(a, true);
	 }
	 
	@Test(priority=45)
	 public void guestMixStoreListDropdown2()throws Exception{
		 boolean a = obj.sotreList_dropDown();
		  Assert.assertEquals(a, true);
	 }
	
	 @Test(priority=46)
	 public void guestMixQuarterDropdown()throws Exception{
		 boolean a = obj.L2_DropDownQuater("guestMix");
		  Assert.assertEquals(a, true);
	 }
	 @Test(priority=47)
	 public void guestMixPeriodDropdown()throws Exception{
		 boolean a = obj.L2_DropDownPeriod("guestMix");
		  Assert.assertEquals(a, true);
	 }
	
	 @Test(priority=48)
	 public void guestMixFilterDataCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		  Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=49)
	 public void  guestMixOverTime()throws Exception{
		 boolean a =obj.L3_arrowNavigator(1);
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=50)
	 public void gmOTFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=51)
	 public void gmOTBack()throws Exception {
		 boolean a = obj.backToL2Click("guestMix");
		 Assert.assertEquals(a,true);
	 }
	 
	 @Test(priority=52)
	 public void  guestMixDayPart()throws Exception{
		 boolean a =obj.L3_arrowNavigator(2);
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=53)
	 public void gmDPFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=54)
	 public void gmDPBack()throws Exception {
		 boolean a = obj.backToL2Click("guestMix");
		 Assert.assertEquals(a,true);
	 }
	 
	 @Test(priority=55)
	 public void  guestMixOrderMode()throws Exception{
		 boolean a =obj.L3_arrowNavigator(3);
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=56)
	 public void gmOMFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=57)
	 public void gmOMBack()throws Exception {
		 boolean a = obj.backToL2Click("guestMix");
		 Assert.assertEquals(a,true);
	 }
	 
	 @Test(priority=58)
	 public void  guestMixDayOfWeek()throws Exception{
		 boolean a =obj.L3_arrowNavigator(4);
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=59)
	 public void gmDWFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=60)
	 public void gmDWBack()throws Exception {
		 boolean a = obj.backToL2Click("guestMix");
		 Assert.assertEquals(a,true);
	 }
	 
	 @Test(priority=61)
	 public void guestMixBack()throws Exception {
		 boolean a = obj.backToL1Click();
		 Assert.assertEquals(a,true);
	 }
	 
	 @Test(priority=62)
	 public void L2_checkCountNavigator()throws Exception{
		 boolean a = obj.L2_URLNavigation(AppUrl,"checkCount");
		 //netsalesHover,checkaverageHover,guestmixHover
		 //L1_netsales_navgraphHover,L1_checkaverage_navgraphHover,L1_guestmix_navgraphHover
	     Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=63)
	 public void checkCountStoreNameDropdown1()throws Exception{
		 boolean a =  obj.storename_dropDown();
		  Assert.assertEquals(a, true);
	 }
	 
	@Test(priority=64)
	 public void checkCountStoreListDropdown2()throws Exception{
		 boolean a = obj.sotreList_dropDown();
		  Assert.assertEquals(a, true);
	 }
	
	 @Test(priority=65)
	 public void checkCountQuarterDropdown()throws Exception{
		 boolean a = obj.L2_DropDownQuater("checkCount");
		  Assert.assertEquals(a, true);
	 }
	 @Test(priority=66)
	 public void checkCountPeriodDropdown()throws Exception{
		 boolean a = obj.L2_DropDownPeriod("checkCount");
		  Assert.assertEquals(a, true);
	 }
	
	 @Test(priority=67)
	 public void checkCountFilterDataCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		  Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=68)
	 public void  checkCountOverTime()throws Exception{
		 boolean a =obj.L3_arrowNavigator(1);
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=69)
	 public void ccOTFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=70)
	 public void ccOTBack()throws Exception {
		 boolean a = obj.backToL2Click("checkCount");
		 Assert.assertEquals(a,true);
	 }
	 
	 @Test(priority=71)
	 public void  checkCountDayPart()throws Exception{
		 boolean a =obj.L3_arrowNavigator(2);
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=72)
	 public void ccDPFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=73)
	 public void ccDPBack()throws Exception {
		 boolean a = obj.backToL2Click("checkCount");
		 Assert.assertEquals(a,true);
	 }
	 
	 @Test(priority=74)
	 public void  checkCountOrderMode()throws Exception{
		 boolean a =obj.L3_arrowNavigator(3);
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=75)
	 public void ccOMFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=76)
	 public void ccOMBack()throws Exception {
		 boolean a = obj.backToL2Click("checkCount");
		 Assert.assertEquals(a,true);
	 }
	 
	 @Test(priority=77)
	 public void  checkCountDayOfWeek()throws Exception{
		 boolean a =obj.L3_arrowNavigator(4);
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=78)
	 public void ccDWFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=79)
	 public void ccDWBack()throws Exception {
		 boolean a = obj.backToL2Click("checkCount");
		 Assert.assertEquals(a,true);
	 }
	 
	 @Test(priority=80)
	 public void checkCountBack()throws Exception {
		 boolean a = obj.backToL1Click();
		 Assert.assertEquals(a,true);
	 }
	 
	 @Test(priority=81)
	 public void L2_discountNavigator()throws Exception{
		 boolean a = obj.L2_URLNavigation(AppUrl,"discount");
		 //netsalesHover,checkaverageHover,guestmixHover
		 //L1_netsales_navgraphHover,L1_checkaverage_navgraphHover,L1_guestmix_navgraphHover
	     Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=82)
	 public void discountStoreNameDropdown1()throws Exception{
		 boolean a =  obj.storename_dropDown();
		  Assert.assertEquals(a, true);
	 }
	 
	@Test(priority=83)
	 public void discountStoreListDropdown2()throws Exception{
		 boolean a = obj.sotreList_dropDown();
		  Assert.assertEquals(a, true);
	 }
	
	 @Test(priority=84)
	 public void discountQuarterDropdown()throws Exception{
		 boolean a = obj.L2_DropDownQuater("discount");
		  Assert.assertEquals(a, true);
	 }
	 @Test(priority=85)
	 public void discountPeriodDropdown()throws Exception{
		 boolean a = obj.L2_DropDownPeriod("discount");
		  Assert.assertEquals(a, true);
	 }
	
	 @Test(priority=86)
	 public void discountFilterDataCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		  Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=87)
	 public void  discountOverTime()throws Exception{
		 boolean a =obj.L3_arrowNavigator(1);
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=88)
	 public void dOTFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=89)
	 public void dOTBack()throws Exception {
		 boolean a = obj.backToL2Click("discount");
		 Assert.assertEquals(a,true);
	 }
	 
	 @Test(priority=90)
	 public void  discountDiscountDistribution()throws Exception{
		 boolean a =obj.L3_arrowNavigator(2);
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=91)
	 public void dDDFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=92)
	 public void dDDPBack()throws Exception {
		 boolean a = obj.backToL2Click("discount");
		 Assert.assertEquals(a,true);
	 }
	 
	 @Test(priority=93)
	 public void  discountOrderMode()throws Exception{
		 boolean a =obj.L3_arrowNavigator(3);
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=94)
	 public void dOMFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=95)
	 public void dOMBack()throws Exception {
		 boolean a = obj.backToL2Click("discount");
		 Assert.assertEquals(a,true);
	 }
	 
	 @Test(priority=96)
	 public void  discountDayOfWeek()throws Exception{
		 boolean a =obj.L3_arrowNavigator(4);
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=97)
	 public void dDWFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=98)
	 public void dDWBack()throws Exception {
		 boolean a = obj.backToL2Click("discount");
		 Assert.assertEquals(a,true);
	 }
	 
	 @Test(priority=99)
	 public void discountBack()throws Exception {
		 boolean a = obj.backToL1Click();
		 Assert.assertEquals(a,true);
	 }
	 
	 @Test(priority=100)
	 public void L2_grossSalesNavigator()throws Exception{
		 boolean a = obj.L2_URLNavigation(AppUrl,"grossSales");
		 //netsalesHover,checkaverageHover,guestmixHover
		 //L1_netsales_navgraphHover,L1_checkaverage_navgraphHover,L1_guestmix_navgraphHover
	     Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=101)
	 public void grossSalesStoreNameDropdown1()throws Exception{
		 boolean a =  obj.storename_dropDown();
		  Assert.assertEquals(a, true);
	 }
	 
	@Test(priority=102)
	 public void grossSalesStoreListDropdown2()throws Exception{
		 boolean a = obj.sotreList_dropDown();
		  Assert.assertEquals(a, true);
	 }
	
	 @Test(priority=103)
	 public void grossSalesQuarterDropdown()throws Exception{
		 boolean a = obj.L2_DropDownQuater("grossSales");
		  Assert.assertEquals(a, true);
	 }
	 @Test(priority=104)
	 public void grossSalesPeriodDropdown()throws Exception{
		 boolean a = obj.L2_DropDownPeriod("grossSales");
		  Assert.assertEquals(a, true);
	 }
	
	 @Test(priority=105)
	 public void grossSalesFilterDataCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		  Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=106)
	 public void  grossSalesOverTime()throws Exception{
		 boolean a =obj.L3_arrowNavigator(1);
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=107)
	 public void grsSOTFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=108)
	 public void grsSOTBack()throws Exception {
		 boolean a = obj.backToL2Click("grossSales");
		 Assert.assertEquals(a,true);
	 }
	 
	 @Test(priority=109)
	 public void  grossSalesDayPart()throws Exception{
		 boolean a =obj.L3_arrowNavigator(2);
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=110)
	 public void grsSDPFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=111)
	 public void grsSDPBack()throws Exception {
		 boolean a = obj.backToL2Click("grossSales");
		 Assert.assertEquals(a,true);
	 }
	 
	 @Test(priority=112)
	 public void  grossSalesOrderMode()throws Exception{
		 boolean a =obj.L3_arrowNavigator(3);
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=113)
	 public void grsSOMFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=114)
	 public void grsSOMBack()throws Exception {
		 boolean a = obj.backToL2Click("grossSales");
		 Assert.assertEquals(a,true);
	 }
	 
	 @Test(priority=115)
	 public void  grossSalesDayOfWeek()throws Exception{
		 boolean a =obj.L3_arrowNavigator(4);
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=116)
	 public void grsSDWFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=117)
	 public void grsSDWBack()throws Exception {
		 boolean a = obj.backToL2Click("grossSales");
		 Assert.assertEquals(a,true);
	 }
	 
	 @Test(priority=118)
	 public void grossSalesBack()throws Exception {
		 boolean a = obj.backToL1Click();
		 Assert.assertEquals(a,true);
	 }
	 
	 @Test(priority=119)
	 public void L2_guestCountNavigator()throws Exception{
		 boolean a = obj.L2_URLNavigation(AppUrl,"guestCount");
		 //netsalesHover,checkaverageHover,guestmixHover
		 //L1_netsales_navgraphHover,L1_checkaverage_navgraphHover,L1_guestmix_navgraphHover
	     Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=120)
	 public void guestCountStoreNameDropdown1()throws Exception{
		 boolean a =  obj.storename_dropDown();
		  Assert.assertEquals(a, true);
	 }
	 
	@Test(priority=121)
	 public void guestCountStoreListDropdown2()throws Exception{
		 boolean a = obj.sotreList_dropDown();
		  Assert.assertEquals(a, true);
	 }
	
	 @Test(priority=122)
	 public void guestCountQuarterDropdown()throws Exception{
		 boolean a = obj.L2_DropDownQuater("guestCount");
		  Assert.assertEquals(a, true);
	 }
	 @Test(priority=123)
	 public void guestCountPeriodDropdown()throws Exception{
		 boolean a = obj.L2_DropDownPeriod("guestCount");
		  Assert.assertEquals(a, true);
	 }
	
	 @Test(priority=124)
	 public void guestCountFilterDataCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		  Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=125)
	 public void  guestCountOverTime()throws Exception{
		 boolean a =obj.L3_arrowNavigator(1);
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=126)
	 public void gcOTFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=127)
	 public void gcOTBack()throws Exception {
		 boolean a = obj.backToL2Click("guestCount");
		 Assert.assertEquals(a,true);
	 }
	 
	 @Test(priority=128)
	 public void  guestCountDayPart()throws Exception{
		 boolean a =obj.L3_arrowNavigator(2);
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=129)
	 public void gcDPFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=130)
	 public void gcDPBack()throws Exception {
		 boolean a = obj.backToL2Click("guestCount");
		 Assert.assertEquals(a,true);
	 }
	 
	 @Test(priority=131)
	 public void  guestCountOrderMode()throws Exception{
		 boolean a =obj.L3_arrowNavigator(3);
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=132)
	 public void gcOMFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=133)
	 public void gcOMBack()throws Exception {
		 boolean a = obj.backToL2Click("guestCount");
		 Assert.assertEquals(a,true);
	 }
	 
	 @Test(priority=134)
	 public void  guestCountDayOfWeek()throws Exception{
		 boolean a =obj.L3_arrowNavigator(4);
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=135)
	 public void gcDWFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=136)
	 public void gcDWBack()throws Exception {
		 boolean a = obj.backToL2Click("guestCount");
		 Assert.assertEquals(a,true);
	 }
	 
	 @Test(priority=137)
	 public void guestCountBack()throws Exception {
		 boolean a = obj.backToL1Click();
		 Assert.assertEquals(a,true);
	 }
	/* 
	 @Test(priority=16)
	 public void nsGetFilter2Type()throws Exception{
		 boolean a =  obj.ddFilterNumberCheck();
		 Assert.assertEquals(a, true);
	 }
	 */
	@Test(priority=138)
	 public void L3_ItemSales()throws Exception {
		 boolean a = obj.L3_hoverNavigator("itemsalesHover","L1_itemsales_arrow");
		 Assert.assertEquals(a,true);
	 }
	
	@Test(priority=139)
	 public void itemSalesFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	
	@Test(priority=140)
	 public void itemSalesBack()throws Exception {
		 boolean a = obj.backToL1Click();
		 Assert.assertEquals(a,true);
	 }
	
	@Test(priority=141)
	 public void L3_TopStores()throws Exception {
		 boolean a = obj.L3_hoverNavigator("topstoresHover","L1_topStores_arrow");
		 Assert.assertEquals(a,true);
	 }
	
	@Test(priority=142)
	 public void topStoresFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	
	@Test(priority=143)
	 public void topStoresBack()throws Exception {
		 boolean a = obj.backToL1Click();
		 Assert.assertEquals(a,true);
	 }
	
	@Test(priority=144)
	 public void L3_Campaign()throws Exception {
		 boolean a = obj.L3_hoverNavigator("campaignHover","L1_campaign_arrow");
		 Assert.assertEquals(a,true);
	 }
	@Test(priority=145)
	 public void campaignFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	
	@Test(priority=146)
	 public void campaignBack()throws Exception {
		 boolean a = obj.backToL1Click();
		 Assert.assertEquals(a,true);
	 }
	
	/*@Test(priority=147)
	 public void L3_covercount1()throws Exception {
		 boolean a = obj.L3_covercount(1);
		 Assert.assertEquals(a,true);
	 }
	@Test(priority=148)
	 public void covercount1FilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	
	@Test(priority=149)
	 public void covercount1Back()throws Exception {
		 boolean a = obj.backToL1Click();
		 Assert.assertEquals(a,true);
	 }
	
	@Test(priority=150)
	 public void L3_covercount2()throws Exception {
		 boolean a = obj.L3_covercount(2);
		 Assert.assertEquals(a,true);
	 }
	@Test(priority=151)
	 public void covercount2FilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	
	@Test(priority=152)
	 public void covercount2Back()throws Exception {
		 boolean a = obj.backToL1Click();
		 Assert.assertEquals(a,true);
	 }
	
	@Test(priority=153)
	 public void L3_covercount3()throws Exception {
		 boolean a = obj.L3_covercount(3);
		 Assert.assertEquals(a,true);
	 }
	@Test(priority=154)
	 public void covercount3FilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	
	@Test(priority=154)
	 public void covercount3Back()throws Exception {
		 boolean a = obj.backToL1Click();
		 Assert.assertEquals(a,true);
	 }
	
	@Test(priority=155)
	 public void L3_covercount4()throws Exception {
		 boolean a = obj.L3_covercount(2);
		 Assert.assertEquals(a,true);
	 }
	@Test(priority=156)
	 public void covercount4FilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	
	@Test(priority=152)
	 public void covercount4Back()throws Exception {
		 boolean a = obj.backToL1Click();
		 Assert.assertEquals(a,true);
	 }
	
	@Test(priority=153)
	 public void L3_NetSalesDecile()throws Exception {
		 boolean a = obj.L3_hoverNavigator("netsalesdecileHover","L1_netsalesDecile_arrow");
		 Assert.assertEquals(a,true);
	 }
	@Test(priority=154)
	 public void NsdFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	
	@Test(priority=155)
	 public void NsdBack()throws Exception {
		 boolean a = obj.backToL1Click();
		 Assert.assertEquals(a,true);
	 }*/
	@Test(priority=156)
	 public void L3_clusterSpendNavigator()throws Exception{
		 boolean a = obj.L3_UrlNavigator(AppUrl,"clusters/spend","no");
		  Assert.assertEquals(a, true);
	 }
	@Test(priority=157)
	 public void clusterSpendFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	
	/*@Test(priority=158)
	 public void clusterSpendBack()throws Exception {
		 boolean a = obj.backToL1Click();
		 Assert.assertEquals(a,true);
	 }*/
	
	@Test(priority=159)
	 public void L3_clusterFrequencyNavigator()throws Exception{
		 boolean a = obj.L3_UrlNavigator(AppUrl,"clusters/frequency","no");
		  Assert.assertEquals(a, true);
	 }
	@Test(priority=160)
	 public void clusterFrequencyFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	
	/*@Test(priority=161)
	 public void clusterFrequencyBack()throws Exception {
		 boolean a = obj.backToL1Click();
		 Assert.assertEquals(a,true);
	 }*/
	
	@Test(priority=162)
	 public void L3_clusterVolumeNavigator()throws Exception{
		 boolean a = obj.L3_UrlNavigator(AppUrl,"clusters/volume","no");
		  Assert.assertEquals(a, true);
	 }
	@Test(priority=163)
	 public void clusterVolumeFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	
	/*@Test(priority=164)
	 public void clusterVolumeBack()throws Exception {
		 boolean a = obj.backToL1Click();
		 Assert.assertEquals(a,true);
	 }*/
	
	@Test(priority=165)
	 public void L3_clusterRecencyNavigator()throws Exception{
		 boolean a = obj.L3_UrlNavigator(AppUrl,"clusters/recency","no");
		  Assert.assertEquals(a, true);
	 }
	@Test(priority=166)
	 public void clusterRecencyFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	
	/*@Test(priority=167)
	 public void clusterRecencyBack()throws Exception {
		 boolean a = obj.backToL1Click();
		 Assert.assertEquals(a,true);
	 }*/
	
	@Test(priority=168)
	 public void L3_PersonaNavigator()throws Exception{
		 boolean a = obj.L3_UrlNavigator(AppUrl,"persona","no");
		  Assert.assertEquals(a, true);
	 }
	@Test(priority=169)
	 public void PersonaFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	
	/*@Test(priority=170)
	 public void PersonaBack()throws Exception {
		 boolean a = obj.backToL1Click();
		 Assert.assertEquals(a,true);
	 }*/
	
	@Test(priority=171)
	 public void L3_PromotionNavigator()throws Exception{
		 boolean a = obj.L3_UrlNavigator(AppUrl,"promotion","no");
		  Assert.assertEquals(a, true);
	 }
	@Test(priority=172)
	 public void PromotionFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	
	/*@Test(priority=173)
	 public void PromotionBack()throws Exception {
		 boolean a = obj.backToL1Click();
		 Assert.assertEquals(a,true);
	 }*/
	
	@Test(priority=174)
	 public void L3_LoyaltyNavigator()throws Exception{
		 boolean a = obj.L3_UrlNavigator(AppUrl,"loyalty","no");
		  Assert.assertEquals(a, true);
	 }
	@Test(priority=175)
	 public void LoyaltyFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	
	@Test(priority=176)
	public void L1_SMA() throws Exception{
		boolean a = obj.L1_SMA(AppUrl ,"SMA");
		Assert.assertEquals(a, true);
	}
	
	@Test(priority=177)
	 public void L3_SMSDetails()throws Exception{
		 boolean a = obj.L3_UrlNavigator(AppUrl,"SMADetails","no");
		  Assert.assertEquals(a, true);
	 }
	@Test(priority=178)
	 public void smaDetailsFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	
	/*@Test(priority=173)
	 public void LoyaltyBack()throws Exception {
		 boolean a = obj.backToL1Click();
		 Assert.assertEquals(a,true);
	 }*/
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
		}

	obj.reportFlush();
		
	}
	 @org.testng.annotations.AfterSuite
		public void quit() {
			obj.quit();
		}
	 
}
