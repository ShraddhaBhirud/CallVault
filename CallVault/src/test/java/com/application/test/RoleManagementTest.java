package com.application.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.application.pages.RoleManagement;
import com.framework.utils.GlobalConstant;
import com.framework.utils.ReadExcel;
import com.framework.webdriver.WebDriverClass;

public class RoleManagementTest extends WebDriverClass
{
	@Test(priority=1,dataProvider="roleManagementdata")
	public void verifyAddRoleFunctionality(String callCenterDrpdwn,String roleNameTxt,String descriptionTxt) throws Exception
	{
		GlobalConstant.loginFunction(getDriver());
		
		RoleManagement.getRoleManagement();
		RoleManagement.commonFunction(callCenterDrpdwn,roleNameTxt,descriptionTxt);
	}
	
	@DataProvider(name="roleManagementdata")
	public String [][] readData()
	{
		String [][] data = ReadExcel.readData("TestData.xlsx", "RoleManagement");
		return data;
	}
	
	@Test(priority=2)
	public void verifyEditFunctionality() throws Exception
	{
		GlobalConstant.loginFunction(getDriver());
		
		RoleManagement.getRoleManagement();
		RoleManagement.editFunctionality();	
	}
	 

}
