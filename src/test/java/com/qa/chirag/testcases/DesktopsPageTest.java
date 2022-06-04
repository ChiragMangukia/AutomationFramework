package com.qa.chirag.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.chirag.base.BaseTest;
import com.qa.chirag.utils.Constants;

public class DesktopsPageTest extends BaseTest {

	@BeforeClass
	public void desktopsPageSetup() {
		loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		desktopsPage = commonsPage.goToDesktopsPage();
	}

	@Test(priority = 1)
	public void titleTest() {
		Assert.assertEquals(desktopsPage.getPageTitle(), Constants.DESKTOPS_PAGE_TITLE);
	}

	@Test(priority = 2)
	public void productLimitDropdownTest() {
		desktopsPage.selectFromShowDropdown(100);
	}

	@Test(priority = 3)
	public void selectProductTest() {
		desktopsPage.selectProduct("Samsung SyncMaster");
	}
}
