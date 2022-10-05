package com.qa.chirag.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.chirag.base.BaseTest;
import com.qa.chirag.utils.Constants;

public class AccountPageTest extends BaseTest {

	@BeforeClass
	void accountPageSetup() {
		accountPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	}

	@Test(priority = 1)
	void editAccountDetails() {
		accountPage = commonsPage.goToMyAccount();
		editAccountInfoPage = accountPage.openEditAcInfoPage();
		editAccountInfoPage.editInfo(prop.getProperty("firstname"), prop.getProperty("lastname"),
				prop.getProperty("username"), prop.getProperty("phone"));
		Assert.assertEquals(accountPage.getSuccessMsg(), Constants.ACCOUNT_PAGE_SUCCESS_MSG);
	}

	@Test(priority = 2)
	void goToHomePage() {
		commonsPage.clickLogo();
	}

	@Test(priority = 3)
	void logoutTest() {
		commonsPage.doLogout();
	}

}
