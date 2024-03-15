package com.framework.reports;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.framework.utils.GlobalConstant;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class ExtentReportsClass 
{
	
	//This class will have all the methods to generate html reports
	
	public static ExtentReports extent ;
	public static ExtentTest logger;
	
	
	@BeforeSuite(alwaysRun=true)
	public static void setupReport() 
	{
		extent = new ExtentReports(GlobalConstant.reportPath);			
		extent.addSystemInfo("Project Name", GlobalConstant.projectName).addSystemInfo("QA", GlobalConstant.qaName); // Add project details in report dashboard
		
	}
	
	@AfterSuite(alwaysRun=true)
	public static void teardownReport()
	{
		extent.flush(); // stop printing
		extent.close(); //Close report
	}
}
