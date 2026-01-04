package com.selise.nadim.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.selise.nadim.browserfactory.BrowserFactory;
import com.selise.nadim.dataprovider.ConfigReader;

public class BaseClass {
	
	public static WebDriver driver;
	
	@BeforeTest
	public void startUp() {
		driver = BrowserFactory
				.initializeBrowser(ConfigReader
						.getPropertyData("browserName"), ConfigReader.getPropertyData("application-url"));
	}
	
	//@AfterTest
	public void tearUp() {
		driver.close();
	}
}
