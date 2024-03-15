package com.framework.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GlobalConstant
{
	public static String propertyFile="config.properties";
	public static String Visible_Text="visibleText";
	public static String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\";
	public static String readFilePath=System.getProperty("user.dir") + "\\TestData\\";
	public static String reportPath=System.getProperty("user.dir")+"\\Reports\\AutomationReport.html";
	public static String url=ReadPropFile.readData("Config.properties").getProperty("url");
	public static String projectName="Call Vault";
	public static String qaName="Shraddha";
	
	public static void loginFunction(WebDriver driver) throws Exception
	{
		driver.findElement(By.xpath("//input[@id='emailInput']")).sendKeys(ReadPropFile.readData(GlobalConstant.propertyFile).getProperty("Email_Address"));
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(ReadPropFile.readData(GlobalConstant.propertyFile).getProperty("Password"));
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@id=\"Show/Hide password\"]/img")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[@id='loginButton']")).click();
		Thread.sleep(500);
	}

}
