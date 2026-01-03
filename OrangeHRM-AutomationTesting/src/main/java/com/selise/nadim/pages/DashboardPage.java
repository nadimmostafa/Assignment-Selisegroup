package com.selise.nadim.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selise.nadim.utility.Utility;

public class DashboardPage {
	
	WebDriver driver;
	By locForName = By.xpath("//div[@class='oxd-table-cell oxd-padding-cell'][3]");
	By locForStatus = By.xpath("//div[@class='oxd-table-cell oxd-padding-cell'][6]");
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	//page elements
	@FindBy(xpath="//h6[text()='Dashboard']")
	private WebElement dashboardTitle;
	
	@FindBy(xpath="//span[text()='Admin']")
	private WebElement adminModuleTab;
	
	@FindBy(xpath="//span[text()='PIM']")
	private WebElement pimModuleTab;
	
	@FindBy(xpath="//p[@class='oxd-userdropdown-name']")
	private WebElement userProfileName;
	
	@FindBy(xpath="//a[text()='Employee List']")
	private WebElement pimEmployeeListTab;
	
	//@FindBy(xpath="//div[@class='oxd-table-cell oxd-padding-cell'][3]")
	//private WebElement getEmployeeList;
	
	//Methods for performing action on the page elements
	public String verifyUserRedirectToDashboard() {
		//check current url
		return driver.getCurrentUrl();
	}
	
	public String getDashboardTitleName() {
		return dashboardTitle.getText();
	}
	
	
	public String getAdminModuleTabName() {
		return adminModuleTab.getText();
	}
	
	public String getPIMModuleTabName() {
		return pimModuleTab.getText();
	}
	
	
	public String getUserProfileName() {
		return userProfileName.getText();
	}
	
	//click on the PIM module tab
	public void clickOnPIMModuleTab() {
		Utility.clickOnElement(driver, pimModuleTab);;
	}
	
	public String getPIMTabEmployeeListText() {
		return pimEmployeeListTab.getText();
	}
	
	
	
	//Extract 5 employees from the list
	
	
	public boolean extractEmployee() {
		Utility.scrollIntoView(driver, 0, 500);
		return Utility.getEmployeeList(driver, locForName, locForStatus);
		
	}
	
}
