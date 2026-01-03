package com.selise.nadim.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selise.nadim.base.BaseClass;
import com.selise.nadim.pages.DashboardPage;
import com.selise.nadim.pages.LoginPage;

public class TC001_VerifyLogin extends BaseClass{
	DashboardPage dashboard;

	@Test
	public void verifyLoginFunctionality() {
		String expectedResult="dashboard";
		
		LoginPage lp = new LoginPage(BaseClass.driver);
		dashboard = lp.login("Admin", "admin123");
		
		//assertion to verify user redirect to dashboard after login
		String actualResult=dashboard.verifyUserRedirectToDashboard();
		Assert.assertTrue(actualResult.contains(expectedResult));
	}
	
	@Test(dependsOnMethods = "verifyLoginFunctionality")
	public void verifyTitleIsDashboard() {
		String expectedResult="Dashboard";
		String actualResult=dashboard.getDashboardTitleName();
		
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	@Test(dependsOnMethods = "verifyLoginFunctionality")
	public void verifyAdminModuleTabPresent() {
		String expectedResult="Admin";
		String actualResult=dashboard.getAdminModuleTabName();
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	@Test(dependsOnMethods = "verifyLoginFunctionality")
	public void verifyPIMModuleTabPresent() {
		String expectedResult="PIM";
		String actualResult=dashboard.getPIMModuleTabName();
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	@Test(dependsOnMethods = "verifyLoginFunctionality")
	public void verifyUserProfileName() {
		String expectedResult="Keyur Bhavsar";
		String actualResult=dashboard.getUserProfileName();
		Assert.assertEquals(actualResult, expectedResult);
	}
}
