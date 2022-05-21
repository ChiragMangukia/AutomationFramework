package com.qa.chirag.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.chirag.factory.DriverFactory;
import com.qa.chirag.pages.HomePage;
import com.qa.chirag.utils.Utilities;

public class BaseTest {
	
	DriverFactory df;
	WebDriver driver;
	
	protected HomePage homePage;

	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		driver = df.initDriver(Utilities.getProp());
		homePage = new HomePage(driver);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
		driver = null;
	}
}
