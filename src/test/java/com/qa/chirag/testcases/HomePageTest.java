package com.qa.chirag.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.chirag.base.BaseTest;

public class HomePageTest extends BaseTest {
	
	@Test(priority = 1)
	public void titleTest() {
		String actualTitle = homePage.getPageTitle();
		Assert.assertEquals(actualTitle, "Google");
	}
	
	@Test(priority = 2)
	public void urlTest() {
		String actualURL = homePage.getCurrentURL();
		Assert.assertEquals(actualURL, "https://www.google.com/");
	}
	
	@Test(priority = 3)
	public void search() {
		homePage.doSearch("Hello World");
	}

}
