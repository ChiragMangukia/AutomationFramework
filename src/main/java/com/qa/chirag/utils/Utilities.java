package com.qa.chirag.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.common.io.Files;
import com.qa.chirag.factory.DriverFactory;

public class Utilities extends DriverFactory {

	public static Properties getProp() {
		Properties prop = new Properties();
		String path = "./src/test/resources/config/config.properties";
		
		FileInputStream ip;
		try {
			ip = new FileInputStream(path);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	public static void checkAndCreateFolder(String folderPath) {
		File file = new File(folderPath);
		if (!file.exists()) {
			file.mkdir();
		}
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
