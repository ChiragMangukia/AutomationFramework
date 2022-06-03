package com.qa.chirag.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

import com.qa.chirag.factory.DriverFactory;
import com.qa.chirag.pages.AccountPage;
import com.qa.chirag.pages.CommonsPage;
import com.qa.chirag.pages.DesktopsPage;
import com.qa.chirag.pages.EditAccountInfoPage;
import com.qa.chirag.pages.HomePage;
import com.qa.chirag.pages.LoginPage;
import com.qa.chirag.utils.Utilities;

public class BaseTest {

	WebDriver driver;

	DriverFactory df;

	protected Properties prop;

	protected CommonsPage commonsPage;
	protected HomePage homePage;
	protected LoginPage loginPage;
	protected AccountPage accountPage;
	protected DesktopsPage desktopsPage;
	protected EditAccountInfoPage editAccountInfoPage;

	public BaseTest() {
		df = new DriverFactory();
		prop = Utilities.getProp();
		driver = df.initDriver(prop);
		homePage = new HomePage(driver);
		commonsPage = new CommonsPage(driver);
		loginPage = new LoginPage(driver);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
		driver = null;
	}
}
