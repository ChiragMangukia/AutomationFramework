package com.qa.chirag.factory;

import java.util.Properties;

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
		if (boolean.parseBoolean(prop.getProperty("headless")))
			chrome.addArguments("--headless");
		if (boolean.parseBoolean(prop.getProperty("incognito")))
			chrome.addArguments("--incognito");
		return chrome;
	}

	public FirefoxOptions getFirefoxOptions() {
		firefox = new FirefoxOptions();
		if (boolean.parseBoolean(prop.getProperty("headless")))
			firefox.addArguments("--headless");
		if (boolean.parseBoolean(prop.getProperty("incognito")))
			firefox.addArguments("--incognito");
		return firefox;
	}
}
