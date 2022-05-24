package com.qa.chirag.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.qa.chirag.factory.DriverFactory;
import com.qa.chirag.utils.ExtentReport;
import com.qa.chirag.utils.Utilities;

public class TestNGListener implements ITestListener {

	ExtentReport extentReport;
	public ExtentReports extent;
	public ExtentTest logger;

	@Override
	public void onTestStart(ITestResult result) {
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger = extent.createTest(result.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String file = DriverFactory.takeScreenshot();
		logger = extent.createTest(result.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
		try {
			logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder
					.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/" + file).build());
		} catch (IOException e) {
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger = extent.createTest(result.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		String file = DriverFactory.takeScreenshot();
		logger = extent.createTest(result.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
		try {
			logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder
					.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/" + file).build());
		} catch (IOException e) {
		}
	}

	@Override
	public void onStart(ITestContext context) {
		Utilities.checkAndCreateFolder("./Reports");
		Utilities.checkAndCreateFolder("./Screenshots");
		extentReport = new ExtentReport();
		extent = extentReport.initReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
