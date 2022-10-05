package com.qa.chirag.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.chirag.base.BaseTest;

public class BrandPageTest extends BaseTest {

	@BeforeClass
	void brandPageSetup() {
		loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		desktopsPage = commonsPage.goToDesktopsPage();
		productPage = desktopsPage.selectProduct("Canon EOS 5D");
		brandPage = productPage.clickBrandName();
	}

	@Test(priority = 1)
	void verifyTitleTest() {
		Assert.assertEquals(brandPage.getTitle(), "Canon");
	}

	@Test(priority = 2)
	void verifyBrandNameTest() {
		Assert.assertEquals(brandPage.getBrandName(), "Canon");
	}
}