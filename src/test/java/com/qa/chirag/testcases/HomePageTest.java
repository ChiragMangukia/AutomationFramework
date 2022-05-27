package com.qa.chirag.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.chirag.base.BaseTest;
import com.qa.chirag.utils.Constants;

public class HomePageTest extends BaseTest {

	@Test(priority = 1)
	public void titleTest() {
		String actualTitle = homePage.getPageTitle();
		Assert.assertEquals(actualTitle, Constants.HOME_PAGE_TITLE);
	}

	@Test(priority = 2)
	public void urlTest() {
		String actualURL = homePage.getCurrentURL();
		Assert.assertEquals(actualURL, Constants.HOME_PAGE_URL_FRACTION);
	}

}
