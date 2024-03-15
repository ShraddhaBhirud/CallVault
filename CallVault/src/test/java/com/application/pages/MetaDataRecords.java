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

public class MetaDataRecords extends WebCommons
{
	@FindBy(xpath="//button[text()='Metadata Records']")
	static WebElement metaDataRecords;
	@FindBy(xpath="//select[@id='selectcategory']")
	static WebElement categoryDrpdwn;
	@FindBy(xpath="//input[@id='Call Center Name']")
	static WebElement callCenterName;
	@FindBy(xpath="//p[text()='Drop your files here or']")
	static WebElement uploadFile;
	@FindBy(xpath="//button[text()='Upload Metadata']")
	static WebElement uploadMetaDataBtn;
	@FindBy(xpath="//button[text()='Check Status']")
	static WebElement checkStatusBtn;
	@FindBy(xpath="//h5[text()='Total Call Records Uploaded']")
	static WebElement totalCallRecords;
	@FindBy(xpath="//h5[text()='Recording Not Uploaded']")
	static WebElement recordingNotUploaded;
	@FindBy(xpath="//button[text()='Next']")
	static WebElement nextBtn;
	@FindBy(xpath="//button[text()='Prevoius']")
	static WebElement previousBtn;
	@FindBy(xpath="//b[text()='Status Retrieved sucessfully']")
	static WebElement textVisible;
	
	
	public static void UploadMetaDataRecords() throws InterruptedException, IOException
	{
		waitDuration();
		click(metaDataRecords);
		waitDuration();
		click(categoryDrpdwn);
		waitDuration();
	}
	public static void categoryDropdown(String categoryDrp) throws InterruptedException
	{
		waitDuration();
		selectDropdown(categoryDrpdwn,GlobalConstant.Visible_Text,categoryDrp);
		waitDuration();
		click(categoryDrpdwn);
		boolean isSelectcategoryDrp=categoryDrpdwn.isDisplayed();
		Assert.assertTrue(isSelectcategoryDrp, "Option is not selected");
		waitDuration();
	}
	public static void callCenterName(String name) throws InterruptedException
	{
		enterInfo(callCenterName,name);
		waitDuration();
		String actualCallCenter = callCenterName.getAttribute("value");
		Assert.assertEquals(actualCallCenter,name, "Call Center Name is incorrect.");
		waitDuration();
	}
	public static void uploadFile() throws InterruptedException, IOException, AWTException
	{
		click(uploadFile);
		waitDuration();
		boolean isEnabledBtn=uploadFile.isEnabled();
		Assert.assertTrue(isEnabledBtn, "Upload File Button is not Enabled");
		waitDuration();
		//Runtime.getRuntime().exec("C:\\Users\\shrad\\Documents\\UploadFileMetaData.exe");
		uploadLocalFile();
		waitDuration();
		boolean uploadFileA=uploadMetaDataBtn.isDisplayed();
		Assert.assertTrue(uploadFileA, "Upload Meta Data Button is not visible");
		waitDuration();	
	}
	public static void uploadMetaDataButton() throws InterruptedException
	{
		click(uploadMetaDataBtn);
		waitDuration();
		boolean isEnabledUploadMetadataBtn=uploadFile.isEnabled();
		Assert.assertTrue(isEnabledUploadMetadataBtn, "Upload MetaData Button is not Enabled");
		waitDuration();
	}
	public static void checkStatusButton() throws InterruptedException
	{
		boolean isDisplayedCheckBtn=checkStatusBtn.isDisplayed();
		Assert.assertTrue(isDisplayedCheckBtn," Check Status Button is not visible");
		waitDuration();
		
		click(checkStatusBtn);
		waitDuration();
		
		Assert.assertEquals("Status Retrieved sucessfully",textVisible.getText());
		report("Status Displayed Successfully: " +textVisible.getText());
		waitDuration();
		
		click(totalCallRecords);
		waitDuration();
		click(recordingNotUploaded);
		waitDuration();	
	}
	public static void nextPrevioudButton() throws InterruptedException
	{
		boolean isEnabledNextBtn=nextBtn.isEnabled();
		Assert.assertTrue(isEnabledNextBtn, "Next Button is not Enabled");
		waitDuration();
		click(nextBtn);
		waitDuration();
		boolean isDisplayedPrevBtn=previousBtn.isDisplayed();
		Assert.assertTrue(isDisplayedPrevBtn, "Previous Button is not visible");
		waitDuration();
		
		boolean isEnabledPrevBtn=previousBtn.isEnabled();
		Assert.assertTrue(isEnabledPrevBtn, "Previous Button is not Enabled");
		waitDuration();
		click(previousBtn);
		waitDuration();
		boolean isDisplayedNextBtn=nextBtn.isDisplayed();
		Assert.assertTrue(isDisplayedNextBtn, "Next Button is not visible");
		waitDuration();
	}
	public static void commonFunction(String categoryDrp,String name) throws InterruptedException, IOException, AWTException
	{
		UploadMetaDataRecords();
		categoryDropdown(categoryDrp);
		callCenterName(name);
		uploadFile();
		uploadMetaDataButton();
		checkStatusButton();
		nextPrevioudButton();
	}
		
	

		
		
		
		
		

	public static MetaDataRecords getMetaDataRecords() 
	{
		return PageFactory.initElements(WebDriverClass.getDriver(), MetaDataRecords.class);
	}
}
