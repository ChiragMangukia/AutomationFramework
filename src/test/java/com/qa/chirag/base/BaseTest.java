package com.qa.chirag.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.chirag.factory.DriverFactory;
import com.qa.chirag.utils.Utilities;

public class BaseTest {
	
	DriverFactory df;
	WebDriver driver;

	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		driver = df.initDriver(Utilities.getProp());
	}
	
	@AfterTest
	public void tearDown() {
		driver = null;
		driver.quit();
	}
}
