package com.qa.chirag.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	
	public ExtentReports initReport() {
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
		String repName = "Test-Report-" + timeStamp + ".html";
		String browser = Utilities.getProp().getProperty("browser");
		
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter reporter = new ExtentSparkReporter("./Reportss/" + repName);
		reporter.config().setReportName("Automation Test Results");
		reporter.config().setDocumentTitle("Test Automation");
		extent.attachReporter(reporter);
		extent.setSystemInfo("System", System.getProperty("os.name"));
		extent.setSystemInfo("Browser", browser.substring(0, 1).toUpperCase() + browser.substring(1));
		extent.setSystemInfo("Author", "Chirag Mangukia");
		extent.setSystemInfo("Build#", "2.1");
		extent.setSystemInfo("Team", "OMS");
		
		reporter.config().setTheme(Theme.STANDARD);
		
		return extent;
	}

}
