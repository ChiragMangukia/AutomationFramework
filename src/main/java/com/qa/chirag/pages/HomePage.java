package com.qa.chirag.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	private WebDriver driver;

	private By myAccountDropdown = By.cssSelector("div#top-links ul li.dropdown");
	private By loginLink = By.xpath("//div[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}
	
	public LoginPage goToLoginPage() {
		driver.findElement(myAccountDropdown).click();
		driver.findElement(loginLink).click();
		return new LoginPage(driver);
	}

}
