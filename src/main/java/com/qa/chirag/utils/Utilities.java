package com.qa.chirag.utils;

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

}
