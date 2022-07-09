package com.qa.chirag.factory;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.qa.chirag.utils.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	protected static WebDriver driver;
	OptionsManager optionsManager;

	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public WebDriver initDriver(Properties prop) {
			optionsManager = new OptionsManager(prop);
			String browser = prop.getProperty("browser").trim();
			if (browser.equalsIgnoreCase(Browser.CHROME)) {
				tlDriver.set(WebDriverManager.chromedriver().capabilities(optionsManager.getChromeOptions()).create());
			} else if (browser.equalsIgnoreCase(Browser.FIREFOX)) {
				tlDriver.set(
						WebDriverManager.firefoxdriver().capabilities(optionsManager.getFirefoxOptions()).create());
			}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url").trim());
		return getDriver();
	}

	private static synchronized WebDriver getDriver() {
		driver = tlDriver.get();
		return driver;
	}
}