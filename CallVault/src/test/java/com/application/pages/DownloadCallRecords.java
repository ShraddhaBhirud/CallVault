package com.application.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.framework.utils.GlobalConstant;
import com.framework.webcommons.WebCommons;
import com.framework.webdriver.WebDriverClass;

public class DownloadCallRecords extends WebCommons
{
	@FindBy(xpath="//button[text()='Download Call Records']")
	static WebElement downloadCallRecordBtn;
	@FindBy(xpath="//input[@class='download-records-textbox']")
	static WebElement mobileNo;
	@FindBy(xpath="//select[@class='download_call_dropdown']")
	static WebElement callCenterDrp;
	@FindBy(xpath="//*[@id=\"root\"]/div/div[3]/div/div[1]/div[3]/div[1]/div[1]/div/input")
	static WebElement startDate;
	@FindBy(xpath="//*[@id=\"root\"]/div/div[3]/div/div[1]/div[3]/div[2]/div/div/input")
	static WebElement endDate;
	@FindBy(xpath="//button[text()='Clear Date']")
	static WebElement clearDate;
	@FindBy(xpath="//a[text()='Recording']")
	static WebElement recordingBtn;
	
	
	
	public static void downloadCallRecordFunctionality() throws InterruptedException//,String callCenterDrpdwn,String startDatea,String endDatea) throws InterruptedException
	{
		waitDuration();
		click(downloadCallRecordBtn);
		waitDuration();
		boolean isEnabledBtn=downloadCallRecordBtn.isEnabled();
		Assert.assertTrue(isEnabledBtn, "Download Call Record Button is not Enabled");
		waitDuration();
	}

	 public static void mobileNumber(String mobileNum) throws InterruptedException
	 {
		enterInfo(mobileNo,mobileNum);
		waitDuration();
		String actualMobileNumber = mobileNo.getAttribute("value");
	    Assert.assertEquals(actualMobileNumber, mobileNum, "Mobile number is incorrect.");
	    waitDuration();
	     
	 }
	 public static void callCenterDropdown(String callCenterDrpdwn) throws InterruptedException
	 {
		 selectDropdown(callCenterDrp,GlobalConstant.Visible_Text,callCenterDrpdwn);
		 waitDuration();
		 boolean isSelectcallCenterDrp=callCenterDrp.isDisplayed();
		 Assert.assertTrue(isSelectcallCenterDrp, "Option is not selected");
		 waitDuration();
	 }
	 
	 public static void startDate(String startDatea) throws InterruptedException
	 {
		 enterInfo(startDate,startDatea);
		 waitDuration();
		 String actualstartDate = startDate.getAttribute("value");
		 Assert.assertEquals(actualstartDate,startDatea, "Start Date is incorrect.");
		 waitDuration();
	 }
	 
	 public static void endDate(String endDatea) throws InterruptedException
	 {
		 enterInfo(endDate,endDatea);
		 waitDuration();
		 String actualendDate = endDate.getAttribute("value");
		 Assert.assertEquals(actualendDate,endDatea, "End Date is incorrect.");
		 waitDuration(); 
	 }
	 public static void clearButton() throws InterruptedException
	 {
		 waitDuration();
		 click(clearDate);
		 waitDuration();
		 boolean isEnabledC=clearDate.isEnabled();
		 Assert.assertTrue(isEnabledC, "Clear Button is not Enabled");
		 waitDuration();
	 }
		 
	 public static void recordingButton() throws InterruptedException
	 {
		 waitDuration();
		 click(recordingBtn);
		 boolean isEnabledR=recordingBtn.isEnabled();
		 Assert.assertTrue(isEnabledR, "Recording Button is not Enabled");
		 waitDuration();
	 }
		
	 public static void commonFunctions(String mobileNum, String callCenterDrpdwn,String startDatea,String endDatea) throws InterruptedException
	 {
		 downloadCallRecordFunctionality();
		 mobileNumber(mobileNum);
		 callCenterDropdown(callCenterDrpdwn);
		 startDate(startDatea);
		 endDate(endDatea);
		 clearButton();
		 recordingButton();
		 	 
	 }
	public static DownloadCallRecords getCallRecords() 
	{
		
		return PageFactory.initElements(WebDriverClass.getDriver(), DownloadCallRecords.class);
	}

}
