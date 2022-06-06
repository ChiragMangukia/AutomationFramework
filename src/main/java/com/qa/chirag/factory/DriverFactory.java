package com.qa.chirag.factory;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;
import com.qa.chirag.utils.Browsers;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	protected static WebDriver driver = null;
	OptionsManager optionsManager;

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
