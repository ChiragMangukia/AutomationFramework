package com.qa.chirag.utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement doGetElement(By by) {
		return driver.findElement(by);
	}

	public List<WebElement> doGetElements(By by) {
		return driver.findElements(by);
	}

	public void doClear(By by) {
		doGetElement(by).clear();
	}

	public String doGetTitle() {
		return driver.getTitle();
	}

	public String doGetCurrentURL() {
		return driver.getCurrentUrl();
	}

	public void doSendKeys(By by, String value) {
		doGetElement(by).sendKeys(value);
	}

	public void doClick(By by) {
		doGetElement(by).click();
	}

	public void waitForWebElements(By by, Duration timeOutInSeconds) {
		new WebDriverWait(driver, timeOutInSeconds)
				.until(ExpectedConditions.visibilityOfAllElements(doGetElements(by)));
	}

	public String doGetText(By by) {
		return doGetElement(by).getText();
	}

	public void doRefreshPage() {
		driver.navigate().refresh();
	}

	public void doNavigateBack() {
		driver.navigate().back();
	}

	public void doWait(By by, Duration timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void doWait(WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElements(webElement));
	}

	public void doScroll(By by) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", doGetElement(by));
	}

	public void sleep(int timeOutInSeconds) {
		try {
			Thread.sleep(timeOutInSeconds * 1000);
		} catch (InterruptedException e) {
		}
	}

	public Boolean checkIfElementIsPresent(By by) {
		try {
			doGetElement(by);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}