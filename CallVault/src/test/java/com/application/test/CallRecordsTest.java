package com.application.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.application.pages.CallRecords;
import com.framework.utils.GlobalConstant;
import com.framework.utils.ReadExcel;
import com.framework.webdriver.WebDriverClass;

public class CallRecordsTest extends WebDriverClass
{
	@Test(priority=1,dataProvider="callRecorddata")
	public void verifyCallRecordFuntionality(String categoryDrp,String metaFile) throws Exception 
	{
		GlobalConstant.loginFunction(getDriver());
		
		CallRecords.getCallRecords();
		CallRecords.commonFunctions(categoryDrp, metaFile);

	}
	
	@DataProvider(name="callRecorddata")
	public String [][] readData()
	{
		String [][] data = ReadExcel.readData("TestData.xlsx", "Call Records");
		return data;
	}


}
