package com.selise.nadim.browserfactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	static WebDriver driver;

	// this method is need to get the driver 
	//for capturing screenshot in listener
	public static WebDriver getBrowserInstance() {
		return driver;
	}
	
	public static WebDriver initializeBrowser(String browserName, String url) {

		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("Sorry! " + browserName + " not supported and Test run with default browser");
			driver = new ChromeDriver();
		}

		// set global settings
		driver.manage().window().maximize();
		// set page load timeout
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

		// set script timeout
		//driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));

		driver.get(url);
		// set implicit timeout
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		return driver;
	}
}
