package com.selise.nadim.listeners;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.selise.nadim.utility.Utility;

public class ExtentManager {
	static ExtentReports extentReport;

	// if ExtentReports instance is already available then we don't create again
	// because creating each instance create one report file but one project we
	// should have one report only for that below code and call this method
	public static ExtentReports createInstance() {
		if (extentReport == null) {
			extentReport = createReport();
			return extentReport;
		} else {
			return extentReport;
		}
	}

	public static ExtentReports createReport() {

		File file = new File(System.getProperty("user.dir") + "/reports/testReport"+Utility.getFileName()+".html");

		// check file is exist or not if not then create
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		ExtentSparkReporter spark = new ExtentSparkReporter(file);
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("Automation Test Report-Nadim");
		spark.config().setDocumentTitle("Selise-Automation Report");
		spark.config().setTimeStampFormat("dd-MM-yyyy hh:mm:ss");
		
		
		extentReport = new ExtentReports();
		extentReport.attachReporter(spark);

		return extentReport;
	}
}
