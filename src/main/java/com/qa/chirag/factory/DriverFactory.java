package com.qa.chirag.factory;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.qa.chirag.utils.Browsers;
import com.qa.chirag.utils.OptionsManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	protected WebDriver driver = null;
	OptionsManager optionsManager;

	public WebDriver initDriver(Properties prop) {
		if (driver == null) {
			optionsManager = new OptionsManager(prop);
			String browser = prop.getProperty("browser").trim();
			if (browser.equalsIgnoreCase(Browsers.CHROME.toString())) {
				driver = WebDriverManager.chromedriver().capabilities(optionsManager.getChromeOptions()).create();
			} else if (browser.equalsIgnoreCase(Browsers.FIREFOX.toString())) {
				driver = WebDriverManager.firefoxdriver().capabilities(optionsManager.getFirefoxOptions()).create();
			}
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url").trim());
		return driver;
	}

}
