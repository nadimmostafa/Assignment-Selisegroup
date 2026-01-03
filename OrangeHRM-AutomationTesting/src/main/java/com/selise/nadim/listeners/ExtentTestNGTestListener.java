package com.selise.nadim.listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.selise.nadim.browserfactory.BrowserFactory;
import com.selise.nadim.utility.Utility;

public class ExtentTestNGTestListener implements ITestListener {
	
	ExtentReports extentReport = ExtentManager.createInstance();
	ThreadLocal<ExtentTest> parentTest = new ThreadLocal<>();
	ThreadLocal<BrowserFactory> sscapture = new ThreadLocal<>();
	
	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest etest = extentReport.createTest(result.getMethod().getMethodName());
		etest.assignAuthor("Nadim  Mostafa");
		parentTest.set(etest);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		parentTest.get().log(Status.PASS, result.getName() + " test is successed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		WebDriver driver = BrowserFactory.getBrowserInstance();
		String image64 = Utility.captureScreenshotInBase64String(driver);
		parentTest.get().log(
				Status.FAIL, "Test is Failed "+
						result.getThrowable().getMessage(),
						MediaEntityBuilder.createScreenCaptureFromBase64String(image64).build());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		parentTest.get().log(Status.SKIP, "Test is Skipped"+result.getThrowable().getMessage());
	}

	@Override
	public void onFinish(ITestContext context) {
		parentTest.get().log(Status.INFO, "Project Execution Completed");
		extentReport.flush();
	}

}
