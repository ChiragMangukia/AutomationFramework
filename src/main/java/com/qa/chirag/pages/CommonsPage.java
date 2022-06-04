package com.qa.chirag.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.chirag.utils.ElementUtil;

public class CommonsPage {

	WebDriver driver;

	private ElementUtil elementUtil;

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
		elementUtil = new ElementUtil(driver);
	}

	private By selectOptionFromMyAccountDropdown(String option) {
		return By.xpath("//div[@id='top-links']/ul/li[2]/ul/li/a[text()='" + option + "']");
	}

	private void clickMyAccountDropdown() {
		clickLogo();
		elementUtil.doClick(myAccountDropdown);
	}

	public LoginPage goToLogin() {
		clickMyAccountDropdown();
		if (elementUtil.checkIfElementIsPresent(loginLink)) {
			elementUtil.doClick(loginLink);
		}
		return new LoginPage(driver);
	}

	public AccountPage goToMyAccount() {
		clickMyAccountDropdown();
		elementUtil.doClick(myAccountLink);
		return new AccountPage(driver);
	}

	public void goToOrderHistory() {
		clickMyAccountDropdown();
		elementUtil.doClick(orderHistoryLink);
		// return new AccountPage(driver);
	}

	public void goToTransactions() {
		clickMyAccountDropdown();
		elementUtil.doClick(transactionsLink);
		// return new AccountPage(driver);
	}

	public void goToDownloads() {
		clickMyAccountDropdown();
		elementUtil.doClick(downloadsLink);
	}

	public void doLogout() {
		clickMyAccountDropdown();
		elementUtil.doClick(logoutLink);
	}

	public HomePage clickLogo() {
		elementUtil.doClick(logo);
		return new HomePage(driver);
	}

	private void clickDesktop() {
		elementUtil.doClick(desktopMenu);
	}

	public DesktopsPage goToDesktopsPage() {
		clickDesktop();
		elementUtil.doClick(showAllDesktopsLink);
		return new DesktopsPage(driver);
	}

}
