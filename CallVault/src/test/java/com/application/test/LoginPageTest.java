package com.application.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.application.pages.Dashboard;
import com.application.pages.LoginPage;
import com.framework.utils.GlobalConstant;
import com.framework.utils.ReadExcel;
import com.framework.webdriver.WebDriverClass;

public class LoginPageTest extends WebDriverClass
{
		
	@Test(priority=1,dataProvider="logindata")
	public void verifyLoginFunctionality(String emailInput1, String password1) throws InterruptedException 
	{
		LoginPage loginpage = LoginPage.getLoginPage();
		loginpage.verifyLoginFunctionality(emailInput1, password1);
		
//		Dashboard dashboard=Dashboard.getDashboard();
//		dashboard.verifyDashboard();
		
	}
	
	@DataProvider(name="logindata")
	public String [][] readData()
	{
		String [][] data = ReadExcel.readData("TestData.xlsx", "Login");
		return data;
	}
	
	@Test(priority=2)
	public void verifyDashboardFunctionality() throws Exception
	{
		GlobalConstant.loginFunction(getDriver());
		Dashboard dashboard=Dashboard.getDashboard();
		dashboard.verifyDashboard();
		
	}
}
