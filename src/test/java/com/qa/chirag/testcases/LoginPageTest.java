package com.qa.chirag.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.chirag.base.BaseTest;

public class LoginPageTest extends BaseTest {

	@BeforeClass
	public void loginPageSetup() {
		loginPage = homePage.goToLoginPage();
	}

	@Test
	public void loginTest() {
		loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Assert.assertTrue(true);
	}

}
