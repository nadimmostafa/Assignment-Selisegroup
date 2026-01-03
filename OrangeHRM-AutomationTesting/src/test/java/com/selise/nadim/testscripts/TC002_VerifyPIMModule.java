package com.selise.nadim.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selise.nadim.base.BaseClass;
import com.selise.nadim.pages.DashboardPage;

public class TC002_VerifyPIMModule extends BaseClass{
	
	DashboardPage dashboard;
	
	@Test(dependsOnMethods = "com.selise.nadim.testscripts.TC001_VerifyLogin.verifyLoginFunctionality")
	public void clickOnPIMTab() {
		String expectedText="Employee List";
		dashboard = new DashboardPage(BaseClass.driver);
		dashboard.clickOnPIMModuleTab();
		String actualText=dashboard.getPIMTabEmployeeListText();
		Assert.assertEquals(actualText, expectedText);
	}
	
	@Test(dependsOnMethods = "com.selise.nadim.testscripts.TC001_VerifyLogin.verifyLoginFunctionality")
	public void verifyNamesNotEmpty() {
		Assert.assertTrue(dashboard.extractEmployee());
	}
	
}
