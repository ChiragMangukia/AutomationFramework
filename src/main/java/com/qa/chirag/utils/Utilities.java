package com.qa.chirag.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Utilities {

	public static Properties getProp() {
		Properties prop = new Properties();
		String path = "./src/test/resources/config.properties";

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

}
