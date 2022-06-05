package com.qa.chirag.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.chirag.base.BaseTest;

public class ProductPageTest extends BaseTest {

	@BeforeClass
	public void productPageSetup() {
		loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		desktopsPage = commonsPage.goToDesktopsPage();
		productPage = desktopsPage.selectProduct("Apple Cinema");
	}

	@Test
	public void verifyProductNameTest() {
		Assert.assertEquals(productPage.getProductName(), "Apple Cinema 30\"");
	}
	
	@Test
	public void dateSelectionTest() {
		productPage.selectDate("14082022");
	}
}
