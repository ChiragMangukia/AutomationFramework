package com.qa.chirag.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {

	WebDriver driver;

	private By successMsg = By.xpath("//div[@id='account-account']/div[1]");
	private By editAcInfoLink = By.xpath("//*[@id='content']/ul[1]/li[1]/a");
	private By changePswdLink = By.xpath("//*[@id='content']/ul[1]/li[2]/a");

	public AccountPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getSuccessMsg() {
		return driver.findElement(successMsg).getText();
	}

	public EditAccountInfoPage openEditAcInfoPage() {
		driver.findElement(editAcInfoLink).click();
		return new EditAccountInfoPage(driver);
	}

	public void navigateBack() {
		driver.navigate().back();
	}

	public void openChangePswdPage() {
		driver.findElement(changePswdLink).click();
	}

}
