package com.qa.chirag.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.chirag.base.BaseTest;
import com.qa.chirag.utils.Constants;

public class HomePageTest extends BaseTest {

	@BeforeClass
	void homePageSetup() {
		loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		commonsPage.clickLogo();
	}

	@Test(priority = 1)
	void titleTest() {
		String actualTitle = homePage.getPageTitle();
		Assert.assertEquals(actualTitle, Constants.HOME_PAGE_TITLE);
	}

	@Test(priority = 2)
	void urlTest() {
		String actualURL = homePage.getCurrentURL();
		Assert.assertEquals(actualURL, Constants.HOME_PAGE_URL_FRACTION);
	}

	@Test(priority = 3)
	void addProductToCartTest() {
		homePage.addProductToCart("iPhone");
	}

}
