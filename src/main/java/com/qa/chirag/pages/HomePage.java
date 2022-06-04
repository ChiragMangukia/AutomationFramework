package com.qa.chirag.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.chirag.utils.ElementUtil;

public class HomePage {

	private WebDriver driver;

	private ElementUtil elementUtil;

	private By myAccountDropdown = By.cssSelector("div#top-links ul li.dropdown");
	private By loginLink = By.xpath("//div[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a");

	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public String getPageTitle() {
		return elementUtil.doGetTitle();
	}

	public String getCurrentURL() {
		return elementUtil.doGetURL();
	}

	public LoginPage goToLoginPage() {
		elementUtil.doClick(myAccountDropdown);
		if (elementUtil.doGetText(loginLink).equals("Login")) {
			elementUtil.doClick(loginLink);
		}
		return new LoginPage(driver);
	}

}
