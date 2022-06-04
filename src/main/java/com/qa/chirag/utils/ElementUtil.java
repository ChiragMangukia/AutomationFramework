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

	public String doGetTitle() {
		return driver.getTitle();
	}

	public void doSendKeys(By by, String value) {
		driver.findElement(by).sendKeys(value);
	}

	public void doClick(By by) {
		driver.findElement(by).click();
	}

	public List<WebElement> doGetElements(By by) {
		return driver.findElements(by);
	}

	public void waitForWebElements(List<WebElement> webElement, Duration timeOutInSeconds) {
		new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.visibilityOfAllElements(webElement));
	}

	public String doGetText(WebElement webElement) {
		return webElement.getText();
	}

	public void doRefreshPage() {
		driver.navigate().refresh();
	}

	public void doWait(By byLocator, Duration timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
	}

	public void doWait(WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElements(webElement));
	}

	public void doScroll(By by) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(by));
	}

	public void sleep(int timeOutInSeconds) {
		try {
			Thread.sleep(timeOutInSeconds * 1000);
		} catch (InterruptedException e) {
		}
	}
	
	public Boolean checkIfElementIsPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
