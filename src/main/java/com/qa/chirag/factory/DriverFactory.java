package com.qa.chirag.factory;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.qa.chirag.utils.Browsers;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	OptionsManager optionsManager;
	
	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	public WebDriver initDriver(Properties prop) {
		if (getDriver() == null) {
			optionsManager = new OptionsManager(prop);
			String browser = prop.getProperty("browser").trim();
			if (browser.equalsIgnoreCase(Browsers.CHROME)) {
				tlDriver.set(WebDriverManager.chromedriver().capabilities(optionsManager.getChromeOptions()).create());
			} else if (browser.equalsIgnoreCase(Browsers.FIREFOX)) {
				tlDriver.set(WebDriverManager.firefoxdriver().capabilities(optionsManager.getFirefoxOptions()).create());
			}
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url").trim());
		return getDriver();
	}
	
	protected static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
}