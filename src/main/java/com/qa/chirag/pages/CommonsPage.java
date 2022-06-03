package com.qa.chirag.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonsPage {

	WebDriver driver;

	private By logo = By.cssSelector("div#logo a img");

	private By myAccountDropdown = By.xpath("//li[@class='dropdown']/a/span[text()='My Account']");

	private By loginLink = selectOptionFromMyAccountDropdown("Login");
	private By myAccountLink = selectOptionFromMyAccountDropdown("My Account");
	private By orderHistoryLink = selectOptionFromMyAccountDropdown("Order History");
	private By transactionsLink = selectOptionFromMyAccountDropdown("Transactions");
	private By downloadsLink = selectOptionFromMyAccountDropdown("Downloads");
	private By logoutLink = selectOptionFromMyAccountDropdown("Logout");

	private By desktopMenu = By.xpath("//li[@class='dropdown']/a[text()='Desktops']");
	private By showAllDesktopsLink = By.xpath("//div[@class='dropdown-menu']/a[text()='Show All Desktops']");

	public CommonsPage(WebDriver driver) {
		this.driver = driver;
	}

	private By selectOptionFromMyAccountDropdown(String option) {
		return By.xpath("//div[@id='top-links']/ul/li[2]/ul/li/a[text()='" + option + "']");
	}

	private void clickMyAccountDropdown() {
		clickLogo();
		driver.findElement(myAccountDropdown).click();
	}

	public AccountPage goToMyAccount() {
		clickMyAccountDropdown();
		driver.findElement(myAccountLink).click();
		return new AccountPage(driver);
	}

	public void goToOrderHistory() {
		clickMyAccountDropdown();
		driver.findElement(orderHistoryLink).click();
		// return new AccountPage(driver);
	}

	public void goToTransactions() {
		clickMyAccountDropdown();
		driver.findElement(transactionsLink).click();
		// return new AccountPage(driver);
	}

	public void goToDownloads() {
		clickMyAccountDropdown();
		driver.findElement(downloadsLink).click();
	}

	public void doLogout() {
		clickMyAccountDropdown();
		driver.findElement(logoutLink).click();
	}

	public HomePage clickLogo() {
		driver.findElement(logo).click();
		return new HomePage(driver);
	}

	private void clickDesktop() {
		driver.findElement(desktopMenu).click();
	}

	public DesktopsPage goToDesktopsPage() {
		clickDesktop();
		driver.findElement(showAllDesktopsLink).click();
		return new DesktopsPage(driver);
	}

}
