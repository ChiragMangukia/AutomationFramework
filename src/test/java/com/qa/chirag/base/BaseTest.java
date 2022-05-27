package com.qa.chirag.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.chirag.factory.DriverFactory;
import com.qa.chirag.pages.AccountPage;
import com.qa.chirag.pages.HomePage;
import com.qa.chirag.pages.LoginPage;
import com.qa.chirag.utils.Utilities;

public class BaseTest {

	DriverFactory df;
	WebDriver driver;
	protected Properties prop;

	protected HomePage homePage;
	protected LoginPage loginPage;
	protected AccountPage accountPage;

	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		prop = Utilities.getProp();
		driver = df.initDriver(prop);
		homePage = new HomePage(driver);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
		driver = null;
	}
}
