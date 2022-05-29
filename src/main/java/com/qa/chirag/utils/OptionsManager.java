package com.qa.chirag.utils;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {

	Properties prop;
	ChromeOptions chrome;
	FirefoxOptions firefox;

	public OptionsManager(Properties prop) {
		this.prop = prop;
	}

	public ChromeOptions getChromeOptions() {
		chrome = new ChromeOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless")))
			chrome.addArguments("--headless");
		if (Boolean.parseBoolean(prop.getProperty("incognito")))
			chrome.addArguments("--incognito");
		return chrome;
	}

	public FirefoxOptions getFirefoxOptions() {
		firefox = new FirefoxOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless")))
			firefox.addArguments("--headless");
		if (Boolean.parseBoolean(prop.getProperty("incognito")))
			firefox.addArguments("--incognito");
		return firefox;
	}

	public WebDriver initDriver(Properties prop) {
			if (driver == null) {
				optionsManager = new OptionsManager(prop);
				String browser = prop.getProperty("browser").trim();
				if (browser.equalsIgnoreCase(Browsers.CHROME)) {
					driver = WebDriverManager.chromedriver().capabilities(optionsManager.getChromeOptions()).create();
				} else if (browser.equalsIgnoreCase(Browsers.FIREFOX)) {
					driver = WebDriverManager.firefoxdriver().capabilities(optionsManager.getFirefoxOptions()).create();
				}
			}
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url").trim());
			return driver;
		}
	
		/**
		 *
		 * @param driver Accepts WebDriver object
		 * @return Screenshots are stored in Screenshot folder at the root directory.
		 *         Saved file name is returned.
		 */
		public static String takeScreenshot() {
			String fileName = "";
			try {
				File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				fileName = System.currentTimeMillis() + ".png";
				String path = "./Screenshots/" + fileName;
				File destination = new File(path);
				Files.copy(src, destination);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return fileName;
		}

}
