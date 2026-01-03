package com.selise.nadim.utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {

	static List<String> storeNames;
	static List<WebElement> allNameElements;
	static List<WebElement> allEmployeeElements;
	static List<String> storeStatus;
	
	
	// click element
	public static void clickOnElement(WebDriver driver, By locator) {
		try {
			driver.findElement(locator).click();
		} catch (Exception e) {
			try {
				Actions act = new Actions(driver);
				act.moveToElement(driver.findElement(locator)).click().build().perform();
			} catch (Exception e2) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click()", driver.findElement(locator));
			}
		}
	}

	// click element
	public static void clickOnElement(WebDriver driver, WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			try {
				Actions act = new Actions(driver);
				act.moveToElement(element).click().build().perform();
			} catch (Exception e2) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click()", element);
			}
		}
	}

	// custom wait
	public static Alert waitForAlert(WebDriver driver, int time) {
		Alert alt = null;
		for (int i = 0; i <= time; i++) {
			try {
				alt = driver.switchTo().alert();
			} catch (Exception e) {
				System.out.println("No alert Found! waiting for Alert");
				waitforSeconds(1);
			}
		}
		return alt;
	}

	public static void waitforSeconds(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// capture screenshot in base64string
	public static String captureScreenshotInBase64String(WebDriver driver) {
		// TakesScreenshot ts = (TakesScreenshot)driver;
		// ts.getScreenshotAs(OutputType.BASE64);
		// String screenshotAs = ((TakesScreenshot)
		// driver).getScreenshotAs(OutputType.BASE64);
		String screenshotAs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		try {
			byte[] decodedImageBytes = Base64.getDecoder().decode(screenshotAs);
			Path destinationFile = Paths.get("./screenshots/", Utility.getFileName() + ".png");
			Files.createDirectories(destinationFile.getParent());
			Files.write(destinationFile, decodedImageBytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return screenshotAs;
	}

	// generate any file name
	public static String getFileName() {
		return new SimpleDateFormat("HH_mm_ss_dd_MM_yy").format(new Date());
	}

	// implicit wait
	public void implicitWait(WebDriver driver, int timeInSecond) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSecond));
	}

	// explicit wait
	public static WebElement explicitWait(WebDriverWait wait, WebElement element) {
		try {
			return wait.until(ExpectedConditions.visibilityOf(element));
		} catch (NoSuchElementException e) {
			System.err.println("Element Not found During Wait");
			e.printStackTrace();
			return null;
		}

	}
	
	public static void scrollIntoView(WebDriver driver, int x_axis, int y_axis) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x_axis+","+y_axis+")");
	}
	
	
	public static boolean getEmployeeList(WebDriver driver, By locForName, By locForStatus ) {
		allNameElements = driver.findElements(locForName);
		allEmployeeElements = driver.findElements(locForStatus);
		
		storeNames = new ArrayList<>();
		storeStatus = new ArrayList<String>();
		
		int i=0;
		while(i<5) {
			storeNames.add(allNameElements.get(i).getText());
			
			if(!((allEmployeeElements.get(i).getText())==null)) {
				storeStatus.add(allEmployeeElements.get(i).getText());
			}else {
				storeStatus.add("");
			}
			
			i++;
		}
		
		for(String s:storeNames) {
			System.out.println(s);
		}
		
		for(String s:storeStatus) {
			System.out.println(s);
		}
		
		// check Extracted name is not empty
		return checkNonEmptyList(storeNames);
		
	}
	
	// check Extracted name is not empty
	public static boolean checkNonEmptyList(List<String> names) {
		boolean allNamesValid = true;
        for (String name : names) {
            if (name.isEmpty()) {
                allNamesValid = false;
                break;
            }
        }
        
        return allNamesValid;
	}

}
