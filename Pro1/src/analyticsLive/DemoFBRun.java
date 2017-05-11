package analyticsLive;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoFBRun {


	 public String Username = "fbjambaadmin";
	 public String password = "SQj0Kp3Hez";
	public String AppUrl ="https://demo-fb.fishbowlcloud.com/#/insights/cockpit/";
	DemoFBMeth obj=new DemoFBMeth();
	public String reportName ="demo-fb";
	
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
	 public void L2_netSalesNavigator()throws Exception{
		 boolean a = obj.L2_URLNavigation(AppUrl,"netSales");
		 //netsalesHover,checkaverageHover,guestmixHover
		 //L1_netsales_navgraphHover,L1_checkaverage_navgraphHover,L1_guestmix_navgraphHover
	     Assert.assertEquals(a, true);
	 }
	
	 @Test(priority=7)
	 public void netSalesStoreNameDropdown1()throws Exception{
		 boolean a =  obj.storename_dropDown();
		  Assert.assertEquals(a, true);
	 }
	 
	/*@Test(priority=10)
	 public void netSalesStoreListDropdown2()throws Exception{
		 boolean a = obj.sotreList_dropDown();
		  Assert.assertEquals(a, true);
	 }*/
	
	 @Test(priority=8)
	 public void netSalesQuarterDropdown()throws Exception{
		 boolean a = obj.L2_DropDownQuater("netSales");
		  Assert.assertEquals(a, true);
	 }
	 @Test(priority=9)
	 public void netSalesPeriodDropdown()throws Exception{
		 boolean a = obj.L2_DropDownPeriod("netSales");
		  Assert.assertEquals(a, true);
	 }
	
	 @Test(priority=10)
	 public void netSalesFilterDataCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		  Assert.assertEquals(a, true);
	 }
	 @Test(priority=11)
	 public void netsalesOverTime()throws Exception{
		 boolean a = obj.L3_UrlNavigator(AppUrl,"netSales/overTime");
		  Assert.assertEquals(a, true);
	 }
	 @Test(priority=12)
	 public void nsOTFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 @Test(priority=13)
	 public void  netsalesDayPart()throws Exception{
		 boolean a =obj.L3_UrlNavigator(AppUrl,"netSales/dayPart");
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=14)
	 public void nsDPFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 @Test(priority=15)
	 public void  netsalesOrderMode()throws Exception{
		 boolean a =obj.L3_UrlNavigator(AppUrl,"netSales/orderMode");
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=16)
	 public void nsOMFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 @Test(priority=17)
	 public void  netsalesDayOfWeek()throws Exception{
		 boolean a  =obj.L3_UrlNavigator(AppUrl,"netSales/dow");
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=18)
	 public void nsDWFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=19)
	 public void L2_checkAverageNavigator()throws Exception{
		 boolean a = obj.L2_URLNavigation(AppUrl,"checkAverage");
		 Assert.assertEquals(a, true);
		 }
	 
	 @Test(priority=20)
	 public void checkAverageQuarterDropdown()throws Exception{
		 boolean a = obj.L2_DropDownQuater("checkAverage");
		  Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=21)
	 public void checkAveragePeriodDropdown()throws Exception{
		 boolean a = obj.L2_DropDownPeriod("checkAverage");
		  Assert.assertEquals(a, true);
	 }
	
	 @Test(priority=22)
	 public void checkAverageFilterDataCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		  Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=23)
	 public void  checkAverageOverTime()throws Exception{
		 boolean a  =obj.L3_UrlNavigator(AppUrl,"checkAverage/overTime");
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=24)
	 public void caOTFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=25)
	 public void  checkAverageTopStores()throws Exception{
		 boolean a = obj.L3_UrlNavigator(AppUrl,"checkAverage/topStore");
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=26)
	 public void caTSFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	
	 @Test(priority=27)
	 public void  checkAverageMenuMix()throws Exception{
		 boolean a = obj.L3_UrlNavigator(AppUrl,"checkAverage/menuMix");
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=28)
	 public void caMMFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=29)
	 public void L2_grossSalesNavigator()throws Exception{
		 boolean a = obj.L2_URLNavigation(AppUrl,"grossSales");
	     Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=30)
	 public void grossSalesQuarterDropdown()throws Exception{
		 boolean a = obj.L2_DropDownQuater("grossSales");
		  Assert.assertEquals(a, true);
	 }
	
	 @Test(priority=31)
	 public void grossSalesPeriodDropdown()throws Exception{
		 boolean a = obj.L2_DropDownPeriod("grossSales");
		  Assert.assertEquals(a, true);
	 }
	
	 @Test(priority=32)
	 public void grossSalesFilterDataCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		  Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=33)
	 public void  grossSalesOverTime()throws Exception{
		 boolean a =obj.L3_UrlNavigator(AppUrl,"grossSales/overTime");
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=34)
	 public void grsSOTFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
		 
	 @Test(priority=35)
	 public void  grossSalesDayPart()throws Exception{
		 boolean a =obj.L3_UrlNavigator(AppUrl,"grossSales/dayPart");
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=36)
	 public void grsSDPFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 	 
	 @Test(priority=37)
	 public void  grossSalesOrderMode()throws Exception{
		 boolean a =obj.L3_UrlNavigator(AppUrl,"grossSales/orderMode");
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=38)
	 public void grsSOMFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }

	 @Test(priority=39)
	 public void  grossSalesDayOfWeek()throws Exception{
		 boolean a =obj.L3_UrlNavigator(AppUrl,"grossSales/dow");
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=40)
	 public void grsSDWFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=41)
	 public void L2_discountNavigator()throws Exception{
		 boolean a = obj.L2_URLNavigation(AppUrl,"discount");
		 Assert.assertEquals(a, true);
	 }
	 	
	 @Test(priority=42)
	 public void discountQuarterDropdown()throws Exception{
		 boolean a = obj.L2_DropDownQuater("discount");
		  Assert.assertEquals(a, true);
	 }

	 @Test(priority=43)
	 public void discountPeriodDropdown()throws Exception{
		 boolean a = obj.L2_DropDownPeriod("discount");
		  Assert.assertEquals(a, true);
	 }
	
	 @Test(priority=44)
	 public void discountFilterDataCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		  Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=45)
	 public void  discountOverTime()throws Exception{
		 boolean a =obj.L3_UrlNavigator(AppUrl,"discount/overTime");
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=46)
	 public void dOTFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 
	@Test(priority=47)
	 public void  discountDiscountDistribution()throws Exception{
		 boolean a =obj.L3_UrlNavigator(AppUrl,"discount/disDistribution");
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=48)
	 public void dDDFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=49)
	 public void  discountOrderMode()throws Exception{
		 boolean a =obj.L3_UrlNavigator(AppUrl,"discount/orderMode");
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=50)
	 public void dOMFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=51)
	 public void  discountDayOfWeek()throws Exception{
		 boolean a =obj.L3_UrlNavigator(AppUrl,"discount/dow");
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=52)
	 public void dDWFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=53)
	 public void L2_checkCountNavigator()throws Exception{
		 boolean a = obj.L2_URLNavigation(AppUrl,"checkCount");
		  Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=55)
	 public void checkCountQuarterDropdown()throws Exception{
		 boolean a = obj.L2_DropDownQuater("checkCount");
		  Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=56)
	 public void checkCountPeriodDropdown()throws Exception{
		 boolean a = obj.L2_DropDownPeriod("checkCount");
		  Assert.assertEquals(a, true);
	 }
	
	 @Test(priority=57)
	 public void checkCountFilterDataCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		  Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=58)
	 public void  checkCountOverTime()throws Exception{
		 boolean a =obj.L3_UrlNavigator(AppUrl,"checkCount/overTime");
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=59)
	 public void ccOTFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 
	@Test(priority=60)
	 public void  checkCountDayPart()throws Exception{
		boolean a =obj.L3_UrlNavigator(AppUrl,"checkCount/dayPart");
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=61)
	 public void ccDPFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	
	 @Test(priority=62)
	 public void  checkCountOrderMode()throws Exception{
		 boolean a =obj.L3_UrlNavigator(AppUrl,"checkCount/orderMode");
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=63)
	 public void ccOMFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 
	@Test(priority=64)
	 public void  checkCountDayOfWeek()throws Exception{
		boolean a =obj.L3_UrlNavigator(AppUrl,"checkCount/dow");
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=65)
	 public void ccDWFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=66)
	 public void L2_coverCountNavigator()throws Exception{
		 boolean a = obj.L2_graphNavigator("covercount","L1_coverount","covercount");
		 //netsalesHover,checkaverageHover,guestmixHover
		 //L1_netsales_navgraphHover,L1_checkaverage_navgraphHover,L1_guestmix_navgraphHover
	     Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=67)
	 public void coverCountQuarterDropdown()throws Exception{
		 boolean a = obj.L2_DropDownQuater("coverCount");
		  Assert.assertEquals(a, true);
	 }

	 @Test(priority=68)
	 public void coverCountPeriodDropdown()throws Exception{
		 boolean a = obj.L2_DropDownPeriod("coverCount");
		  Assert.assertEquals(a, true);
	 }
	
	 @Test(priority=69)
	 public void coverCountFilterDataCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		  Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=70)
	 public void coverCountOverTime()throws Exception{
		 boolean a =obj.L3_arrowNavigator(1);
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=71)
	 public void coverCountOTFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=72)
	 public void coverCountOTBack()throws Exception {
		 boolean a = obj.backToL2Click();
		 Assert.assertEquals(a,true);
	 }
	 
	 @Test(priority=73)
	 public void  coverCountDayPart()throws Exception{
		 boolean a =obj.L3_arrowNavigator(2);
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=74)
	 public void coverCountDPFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=75)
	 public void coverCountDPBack()throws Exception {
		 boolean a = obj.backToL2Click();
		 Assert.assertEquals(a,true);
	 }
	 
	 @Test(priority=76)
	 public void  coverCountOrderMode()throws Exception{
		 boolean a =obj.L3_arrowNavigator(3);
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=77)
	 public void coverCountOMFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=78)
	 public void coverCountOMBack()throws Exception {
		 boolean a = obj.backToL2Click();
		 Assert.assertEquals(a,true);
	 }
	 
	 @Test(priority=79)
	 public void  coverCountDayOfWeek()throws Exception{
		 boolean a =obj.L3_arrowNavigator(4);
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=80)
	 public void coverCountDWFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=81)
	 public void coverCountDWBack()throws Exception {
		 boolean a = obj.backToL2Click();
		 Assert.assertEquals(a,true);
	 }
	 
	 @Test(priority=82)
	 public void coverCountBack()throws Exception {
		 boolean a = obj.backToL1Click();
		 Assert.assertEquals(a,true);
	 }
	 
	 
	 @Test(priority=83)
	 public void L2_guestCountNavigator()throws Exception{
		 boolean a = obj.L2_URLNavigation(AppUrl,"guestCount");
		  Assert.assertEquals(a, true);
	 }
	 @Test(priority=84)
	 public void guestCountFilterDataCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		  Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=85)
	 public void  guestCountOverTime()throws Exception{
		 boolean a =obj.L3_arrowNavigator(1);
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=86)
	 public void gcOTFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=87)
	 public void gcOTBack()throws Exception {
		 boolean a = obj.backToL2Click();
		 Assert.assertEquals(a,true);
	 }
	 
	 @Test(priority=88)
	 public void  guestCountDayPart()throws Exception{
		 boolean a =obj.L3_arrowNavigator(2);
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=89)
	 public void gcDPFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=90)
	 public void gcDPBack()throws Exception {
		 boolean a = obj.backToL2Click();
		 Assert.assertEquals(a,true);
	 }
	 
	 @Test(priority=91)
	 public void  guestCountOrderMode()throws Exception{
		 boolean a =obj.L3_arrowNavigator(3);
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=92)
	 public void gcOMFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=93)
	 public void gcOMBack()throws Exception {
		 boolean a = obj.backToL2Click();
		 Assert.assertEquals(a,true);
	 }
	 
	 @Test(priority=94)
	 public void  guestCountDayOfWeek()throws Exception{
		 boolean a =obj.L3_arrowNavigator(4);
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=95)
	 public void gcDWFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 
	 @Test(priority=96)
	 public void gcDWBack()throws Exception {
		 boolean a = obj.backToL2Click();
		 Assert.assertEquals(a,true);
	 }
	 
	 @Test(priority=97)
	 public void guestCountBack()throws Exception {
		 boolean a = obj.backToL1Click();
		 Assert.assertEquals(a,true);
	 }
	 
	 @Test(priority=98)
	 public void L3_LoyaltyNavigator()throws Exception{
		 boolean a = obj.L3_UrlNavigator(AppUrl,"loyalty");
		  Assert.assertEquals(a, true);
	 }
	@Test(priority=99)
	 public void LoyaltyFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	 
	@Test(priority=100)
	 public void L3_Campaign()throws Exception {
		 boolean a = obj.L3_UrlNavigator(AppUrl,"campaign");
		 Assert.assertEquals(a,true);
	 }
	
	@Test(priority=101)
	 public void campaignFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	
	@Test(priority=102)
	 public void L3_TopStores()throws Exception {
		 boolean a = obj.L3_UrlNavigator(AppUrl,"TopStoreBySale");
		 Assert.assertEquals(a,true);
	 }
	
	@Test(priority=103)
	 public void topStoresFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	
	@Test(priority=104)
	 public void L3_ItemSales()throws Exception {
		 boolean a = obj.L3_UrlNavigator(AppUrl,"itemSales");
		 Assert.assertEquals(a,true);
	 }
	
	@Test(priority=105)
	 public void itemSalesFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	
	@Test(priority=106)
	 public void L3_PersonaNavigator()throws Exception{
		 boolean a = obj.L3_UrlNavigator(AppUrl,"persona");
		  Assert.assertEquals(a, true);
	 }
	
	@Test(priority=107)
	 public void PersonaFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	
	@Test(priority=108)
	 public void L3_clusterSpendNavigator()throws Exception{
		 boolean a = obj.L3_UrlNavigator(AppUrl,"clusters/spend");
		  Assert.assertEquals(a, true);
	 }
	@Test(priority=109)
	 public void clusterSpendFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
		
	@Test(priority=110)
	 public void L3_clusterFrequencyNavigator()throws Exception{
		 boolean a = obj.L3_UrlNavigator(AppUrl,"clusters/frequency");
		  Assert.assertEquals(a, true);
	 }
	@Test(priority=111)
	 public void clusterFrequencyFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	
	@Test(priority=112)
	 public void L3_clusterVolumeNavigator()throws Exception{
		 boolean a = obj.L3_UrlNavigator(AppUrl,"clusters/volume");
		  Assert.assertEquals(a, true);
	 }
	@Test(priority=113)
	 public void clusterVolumeFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }

	@Test(priority=114)
	 public void L3_clusterRecencyNavigator()throws Exception{
		 boolean a = obj.L3_UrlNavigator(AppUrl,"clusters/recency");
		  Assert.assertEquals(a, true);
	 }
	@Test(priority=115)
	 public void clusterRecencyFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	
	@Test(priority=116)
	 public void clusterRecencyBack()throws Exception {
		 boolean a = obj.backToL1Click();
		 Assert.assertEquals(a,true);
	 }
	
	@Test(priority=117)
	 public void L3_PromotionNavigator()throws Exception{
		 boolean a = obj.L3_UrlNavigator(AppUrl,"promotion");
		  Assert.assertEquals(a, true);
	 }
	@Test(priority=118)
	 public void PromotionFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	
	@Test(priority=119)
	 public void PromotionBack()throws Exception {
		 boolean a = obj.backToL1Click();
		 Assert.assertEquals(a,true);
	 }
	
	
	
	
	
		 /*

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
	 }
	
	

	
	
	@Test(priority=176)
	public void L1_SMA() throws Exception{
		boolean a = obj.L1_SMA(AppUrl ,"SMA");
		Assert.assertEquals(a, true);
	}
	
	@Test(priority=177)
	 public void L3_SMSDetails()throws Exception{
		 boolean a = obj.L3_UrlNavigator(AppUrl,"SMADetails");
		  Assert.assertEquals(a, true);
	 }
	@Test(priority=178)
	 public void smaDetailsFilerCheck()throws Exception{
		 boolean a = obj.dropdown_filter_check();
		 Assert.assertEquals(a, true);
	 }
	@Test(priority=173)
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
