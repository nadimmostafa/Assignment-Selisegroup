package com.selise.nadim.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selise.nadim.utility.Utility;

public class LoginPage {
	
	private WebDriverWait wait;
	WebDriver driver;

	// create constructor
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	//page elements
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement userName;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginBtn;

	//perform action on the page elements
	public DashboardPage login(String uname, String pwd) {
		
		//Wait until the username and password fields are visible
		Utility.explicitWait(wait,userName).sendKeys(uname);
		Utility.explicitWait(wait, password).sendKeys(pwd);
		Utility.clickOnElement(driver, loginBtn);
		
		//Wait for the dashboard to be fully loaded after login
		Boolean isLoaed= (Boolean) wait.until((ExpectedConditions.jsReturnsValue("return document.readyState==='complete';")));
		System.out.println(isLoaed);
		return new DashboardPage(driver);
	}

}
