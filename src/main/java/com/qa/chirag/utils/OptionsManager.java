package com.qa.chirag.utils;

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
		if (Boolean.parseBoolean(prop.getProperty("headless")))
			chrome.addArguments("--headless");
		if (Boolean.parseBoolean(prop.getProperty("incognito")))
			chrome.addArguments("--incognito");
		return chrome;
	}

	public FirefoxOptions getFirefoxOptions() {
		firefox = new FirefoxOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless")))
			chrome.addArguments("--headless");
		if (Boolean.parseBoolean(prop.getProperty("incognito")))
			chrome.addArguments("--incognito");
		return firefox;
	}

}
