package com.application.pages;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.framework.utils.GlobalConstant;
import com.framework.webcommons.WebCommons;
import com.framework.webdriver.WebDriverClass;

public class CallRecords extends WebCommons
{
	@FindBy(xpath="//button[text()='Call Records']")
	static WebElement callRecordsBtn;
	@FindBy(xpath="//select[@id='selectcategory']")
	static WebElement categoryDrpdwn;
	@FindBy(xpath="//select[@id='selectMetaFile']")
	static WebElement metaFileDrp;
	@FindBy(xpath="//p[text()='Browse files']")
	static WebElement browseFiles;
	@FindBy(xpath="//button[text()='Upload Call Records']")
	static WebElement uploadMetaDataBtn;
	@FindBy(xpath="//button[text()='Proceed']")
	static WebElement proceedBtn;
	@FindBy(xpath="//button[text()='Check Status']")
	static WebElement checkStatusBtn;
	@FindBy(xpath="//button[text()='Next']")
	static WebElement nextBtn;
	@FindBy(xpath="//*[@id=\"root\"]/div/div[3]/div[6]/button[1]")
	static WebElement previousBtn;
	
	public static void callRecordFunctionality() throws InterruptedException, IOException		
	{
		waitDuration();
		
		boolean isElementVisible = callRecordsBtn.isDisplayed();
		Assert.assertTrue(isElementVisible, "Call Records Button is not visible");
		waitDuration();
		click(callRecordsBtn);
		waitDuration();
	}
	
	public static void categoryDropdown(String categoryDrp) throws InterruptedException
	{
		click(categoryDrpdwn);
		waitDuration();
		selectDropdown(categoryDrpdwn,GlobalConstant.Visible_Text,categoryDrp);
		waitDuration();
		
		boolean dropdownC=categoryDrpdwn.isDisplayed();
		Assert.assertTrue(dropdownC, "Option is not selected");
		waitDuration();
		
	}
	public static void metaFileDropdown(String metaFile) throws InterruptedException
	{
		waitDuration();
		click(metaFileDrp);
		waitDuration();
		selectDropdown(metaFileDrp,GlobalConstant.Visible_Text,metaFile);
		waitDuration();
		
		boolean isSelectMetaFileDrp=metaFileDrp.isDisplayed();
		Assert.assertTrue(isSelectMetaFileDrp, "File is not selected");
		waitDuration();
	}
	public static void browseFile() throws InterruptedException, IOException, AWTException 
	{
		click(browseFiles);
		waitDuration();
		
		//Runtime.getRuntime().exec("C:\\Users\\shrad\\Documents\\callRecordsUploadFile.exe");
		
		uploadLocalFile();
		waitDuration();
		
		
		boolean uploadMetaFileButton=uploadMetaDataBtn.isDisplayed();
		Assert.assertTrue(uploadMetaFileButton, "Meta File is Not Displayed");
		waitDuration();

	}
	public static void metaDataButton() throws InterruptedException
	{
		click(uploadMetaDataBtn);
		waitDuration();
		waitDuration();
		boolean isProceedBtnVisible=proceedBtn.isDisplayed();
		Assert.assertTrue(isProceedBtnVisible, "Proceed button is not visible");
		waitDuration();
	}
	public static void proceedButton() throws InterruptedException
	{
		waitDuration();
		click(proceedBtn);
		waitDuration();
		boolean checkStatusBtnVisible=checkStatusBtn.isDisplayed();
		Assert.assertTrue(checkStatusBtnVisible,"Check Status Button is not visible");
		waitDuration();
	}
	public static void checkStatusButton() throws InterruptedException
	{
		waitDuration();
		click(checkStatusBtn);
		waitDuration();
		boolean nextBtnVisible=nextBtn.isDisplayed();
		Assert.assertTrue(nextBtnVisible, "Next button is not visible");
		//report(nextBtn.isDisplayed() + "Next Button is Visible");
		waitDuration();
	}
	public static void nextPreviousButton() throws InterruptedException
	{
		waitDuration();
		click(nextBtn);
		waitDuration();
		boolean previousBtnVisible=previousBtn.isDisplayed();
		Assert.assertTrue(previousBtnVisible, "Previous Button is not Visible");
		//report(previousBtn.isDisplayed() + "Previous Button is Visible");
		waitDuration();
		
		click(previousBtn);
		boolean enable=previousBtn.isEnabled();
		Assert.assertTrue(enable, "Previous Button is not Enabled");
		//System.out.println("Previous Button is visible: " +enable );
		waitDuration();	
	}
	public static void commonFunctions(String categoryDrp,String metaFile) throws InterruptedException, IOException, AWTException
	{
		callRecordFunctionality();
		categoryDropdown(categoryDrp);
		metaFileDropdown(metaFile);
		browseFile();
		metaDataButton();
		proceedButton();
		checkStatusButton();
		nextPreviousButton();
	}

	public static CallRecords getCallRecords() 
	{
		return PageFactory.initElements(WebDriverClass.getDriver(), CallRecords.class);
	}
	
	

}
