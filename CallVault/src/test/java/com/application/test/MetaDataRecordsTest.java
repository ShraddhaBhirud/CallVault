package com.application.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.application.pages.MetaDataRecords;
import com.framework.utils.GlobalConstant;
import com.framework.utils.ReadExcel;
import com.framework.webdriver.WebDriverClass;

public class MetaDataRecordsTest extends WebDriverClass
{
	@Test(priority=1,dataProvider="Metadata")
	public void verifyLoginFunctionality(String categoryDrp,String name) throws Exception 
	{
		GlobalConstant.loginFunction(getDriver());
		
		MetaDataRecords.getMetaDataRecords();
		MetaDataRecords.commonFunction(categoryDrp, name);
	}
	
	@DataProvider(name="Metadata")
	public String [][] readData()
	{
		String [][] data = ReadExcel.readData("TestData.xlsx", "MetaDataRecords");
		return data;
	}

}
