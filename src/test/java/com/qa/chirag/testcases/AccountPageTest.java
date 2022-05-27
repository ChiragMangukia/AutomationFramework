package com.qa.chirag.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.chirag.base.BaseTest;

public class AccountPageTest extends BaseTest {
	
	@BeforeClass
	public void accountPageSetup() {
		loginPage = homePage.goToLoginPage();
		accountPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	}
	
	@Test(priority = 1)
	public void editAcInfo() {
		accountPage.openEditAcInfo();
		Assert.assertTrue(true);
	}
	
	@Test(priority = 2)
	public void goBack() {
		accountPage.navigateBack();
	}
	
	@Test(priority = 3)
	public void passwordChange() {
		accountPage.openChangePswd();
		Assert.assertTrue(true);
	}

}
