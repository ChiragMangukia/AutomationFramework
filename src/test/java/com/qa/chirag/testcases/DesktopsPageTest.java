package com.qa.chirag.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.chirag.base.BaseTest;
import com.qa.chirag.utils.Constants;

public class DesktopsPageTest extends BaseTest {
	
	@BeforeClass
	public void desktopsPageSetup() {
		loginPage = homePage.goToLoginPage();
		accountPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		desktopsPage = commonsPage.goToDesktopsPage();
	}
	
	@Test
	public void titleTest() {
		Assert.assertEquals(desktopsPage.getPageTitle(), Constants.DESKTOPS_PAGE_TITLE);
	}

}
