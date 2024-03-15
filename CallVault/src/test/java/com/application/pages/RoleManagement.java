package com.application.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.framework.utils.GlobalConstant;
import com.framework.webcommons.WebCommons;
import com.framework.webdriver.WebDriverClass;

public class RoleManagement extends WebCommons
{
	@FindBy(xpath="//button[text()='Role Management']")
	static WebElement roleManagementBtn;
	@FindBy(xpath="//*[@id=\"root\"]/div/div[3]/div/div[1]/div[2]/button")
	static WebElement addRole;
	@FindBy(xpath="//select[@id='callcentre']")
	static WebElement callCentreDrp;
	@FindBy(xpath="//input[@id='Rolename']")
	static WebElement roleName;
	@FindBy(xpath="//input[@id='Description']")
	static WebElement description;
	@FindBy(xpath="//*[@id=\"root\"]/div/div[4]/div/div[3]/div[1]/div/table/tbody/tr[1]/td[2]/input")
	static WebElement viewCallRecords;
	@FindBy(xpath="//*[@id=\"root\"]/div/div[4]/div/div[3]/div[1]/div/table/tbody/tr[2]/td[3]/input")
	static WebElement addDownloadCallRecords;
	@FindBy(xpath="//*[@id=\"root\"]/div/div[4]/div/div[3]/div[1]/div/table/tbody/tr[3]/td[4]/input")
	static WebElement editReport;
	@FindBy(xpath="//*[@id=\"root\"]/div/div[4]/div/div[3]/div[1]/div/table/tbody/tr[4]/td[2]/input")
	static WebElement viewRoleManagement;
	@FindBy(xpath="//*[@id=\"root\"]/div/div[4]/div/div[3]/div[1]/div/table/tbody/tr[4]/td[3]/input")
	static WebElement addRoleManagement;
	@FindBy(xpath="//*[@id=\"root\"]/div/div[4]/div/div[3]/div[1]/div/table/tbody/tr[5]/td[2]/input")
	static WebElement viewUserMaster;
	@FindBy(xpath="//*[@id=\"root\"]/div/div[4]/div/div[3]/div[1]/div/table/tbody/tr[6]/td[2]/input")
	static WebElement viewCallCenter;
	@FindBy(xpath="//button[text()='Cancel']")
	static WebElement cancelBtn;
	@FindBy(xpath="//*[@id=\"root\"]/div/div[4]/div/div[3]/div[2]/div/button")
	static WebElement addRollBtn;
	@FindBy(xpath="//*[@id=\"root\"]/div/div[3]/div/div[2]/div/table/tbody/tr[3]/td[5]/div/img[1]")
	static WebElement editBtn;
	
	public static void addRoleFunctionality() throws InterruptedException
	{
		waitDuration();
		click(roleManagementBtn);
		waitDuration();
		click(addRole);
		waitDuration();
	}
	public static void callCenterDropdown(String callCenterDrpdwn) throws InterruptedException
	{
		waitDuration();
		selectDropdown(callCentreDrp,GlobalConstant.Visible_Text,callCenterDrpdwn);
		waitDuration();
		boolean dropdownC=callCentreDrp.isDisplayed();
		Assert.assertTrue(dropdownC, "Option is not selected");
		waitDuration();
	}
	public static void roleName(String roleNameTxt) throws InterruptedException
	{
		enterInfo(roleName,roleNameTxt);
		waitDuration();
		String actualCallCenter = roleName.getAttribute("value");
		Assert.assertEquals(actualCallCenter,roleNameTxt, "Role Name is incorrect.");
		waitDuration();
	}
	public static void description(String descriptionTxt) throws InterruptedException
	{
		enterInfo(description,descriptionTxt);
		waitDuration();
		String actualCallCenter = description.getAttribute("value");
		Assert.assertEquals(actualCallCenter,descriptionTxt, "Role Name is incorrect.");
		waitDuration();
	}
	public static void viewCallRecordsCheck() throws InterruptedException
	{
		selectCheckbox(viewCallRecords);
		waitDuration();
		Assert.assertTrue(viewCallRecords.isSelected(), "Checkbox is not selected.");
		waitDuration();
	}
	public static void addDownloadCallRecordsCheck() throws InterruptedException
	{
		selectCheckbox(addDownloadCallRecords);
		waitDuration();
		Assert.assertTrue(addDownloadCallRecords.isSelected(), "Checkbox is not selected.");
		waitDuration();
	}
	public static void editReportCheck() throws InterruptedException
	{
		selectCheckbox(editReport);
		waitDuration();
		Assert.assertTrue(editReport.isSelected(), "Checkbox is not selected.");
		waitDuration();
	}
	public static void viewAddRoleManagementCheck() throws InterruptedException
	{
		selectCheckbox(viewRoleManagement);
		waitDuration();
		Assert.assertTrue(viewRoleManagement.isSelected(), "Checkbox is not selected.");
		waitDuration();
		selectCheckbox(addRoleManagement);
		waitDuration();
		Assert.assertTrue(addRoleManagement.isSelected(), "Checkbox is not selected.");
		waitDuration();
	}
	public static void viewUserMasterCheck() throws InterruptedException
	{
		selectCheckbox(viewUserMaster);
		waitDuration();
		Assert.assertTrue(viewUserMaster.isSelected(), "Checkbox is not selected.");
		waitDuration();
	}
	public static void viewCallCenterCheck() throws InterruptedException
	{
		selectCheckbox(viewCallCenter);
		waitDuration();
		Assert.assertTrue(viewCallCenter.isSelected(), "Checkbox is not selected.");
		waitDuration();
	}
	public static void addRoleButton() throws InterruptedException
	{
		click(addRollBtn);
		waitDuration();
		boolean enable=addRollBtn.isEnabled();
		Assert.assertTrue(enable, "Add Role Button is not Enabled");
		waitDuration();	
	}
	
	public static void editFunctionality() throws InterruptedException
	{
//		waitDuration();
//		click(roleManagementBtn);
//		waitDuration();
//		//waitDuration();
//		//click(editBtn);
//		waitDuration();
		 try {
		        waitDuration();
		        click(roleManagementBtn);
		        waitDuration();
		        // Ensure that the element click operation is successful.
		        // Example: click(editBtn);
		        waitDuration();
		    } catch (Exception e) {
		        // Log the exception details for debugging purposes.
		        e.printStackTrace();
		        Assert.fail("Failed to perform the edit functionality: " + e.getMessage());
		    }
	}
	public static void commonFunction(String callCenterDrpdwn,String roleNameTxt,String descriptionTxt) throws InterruptedException
	{
		addRoleFunctionality();
		callCenterDropdown(callCenterDrpdwn);
		roleName(roleNameTxt);
		description(descriptionTxt);
		viewCallRecordsCheck();
		addDownloadCallRecordsCheck();
		editReportCheck();
		viewAddRoleManagementCheck();
		viewUserMasterCheck();
		viewCallCenterCheck();
		addRoleButton();
	}

	public static RoleManagement getRoleManagement() 
	{
		return PageFactory.initElements(WebDriverClass.getDriver(), RoleManagement.class);
	}

	

}
