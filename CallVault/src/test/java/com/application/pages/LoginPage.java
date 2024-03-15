package com.application.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.framework.webcommons.WebCommons;
import com.framework.webdriver.WebDriverClass;

public class LoginPage extends WebCommons
{
	@FindBy(xpath="//input[@id='emailInput']")
	WebElement emailAddress;
	@FindBy(xpath="//input[@id='password']")
	WebElement passwordTextBox;
	@FindBy(xpath="//*[@id=\"Show/Hide password\"]/img")
	WebElement eyeIcon;
	@FindBy(xpath="//button[@id='loginButton']")
	WebElement loginBtn;
	@FindBy(xpath="//b[text()='Metadata Records']")
	WebElement metaDataText;
	@FindBy(xpath="//div[text()='Email id: admin1@email.com does not exist']")
	WebElement errorMsgEmail;
	@FindBy(xpath="//small[text()='Please enter valid credentials']")
			//"//div[text()='Password does not match']")
	WebElement errorMsgPass;
	
	public void verifyLoginFunctionality(String emailInput1, String password1) throws InterruptedException
	{
		waitDuration();
		enterInfo(emailAddress,emailInput1);
		waitDuration();
		enterInfo(passwordTextBox, password1);
		waitDuration();
		click(eyeIcon);
		waitDuration();
		click(loginBtn);
		waitDuration();
		
	}
	
	public static LoginPage getLoginPage() 
	{
		return PageFactory.initElements(WebDriverClass.getDriver(), LoginPage.class);
	}


	

}
