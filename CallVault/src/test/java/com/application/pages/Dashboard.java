package com.application.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.framework.webcommons.WebCommons;
import com.framework.webdriver.WebDriverClass;

public class Dashboard extends WebCommons
{
	@FindBy(xpath="//button[text()='Metadata Records']")
	WebElement dashboard;
	
	public void verifyDashboard()
	{
		String compareText=dashboard.getText();
		String expectedText = "Metadata Records";
		Assert.assertTrue(compareText.equals(expectedText));
		report("Login Sucessfully : " +compareText);
	}
	
	public static Dashboard getDashboard() 
	{
		return PageFactory.initElements(WebDriverClass.getDriver(), Dashboard.class);
	}

}
