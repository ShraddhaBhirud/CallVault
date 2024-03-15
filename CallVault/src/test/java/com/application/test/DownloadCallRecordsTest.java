package com.application.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.application.pages.DownloadCallRecords;
import com.framework.utils.GlobalConstant;
import com.framework.utils.ReadExcel;
import com.framework.webdriver.WebDriverClass;

public class DownloadCallRecordsTest extends WebDriverClass
{
	@Test(priority=1,dataProvider="downloadcallRecorddata")
	public void verifyDownloadCallRecordFuntionality(String mobileNum, String callCenterDrpdwn,String startDatea,String endDatea) throws Exception//,String startDatea,String endDatea) throws Exception
	{
		GlobalConstant.loginFunction(getDriver());
		
		DownloadCallRecords.getCallRecords();
		DownloadCallRecords.commonFunctions(mobileNum,callCenterDrpdwn,startDatea,endDatea);
		
	}
	
	@DataProvider(name="downloadcallRecorddata")
	public String [][] readData()
	{
		String [][] data = ReadExcel.readData("TestData.xlsx", "DownloadCallRecords");
		return data;
	}


}
