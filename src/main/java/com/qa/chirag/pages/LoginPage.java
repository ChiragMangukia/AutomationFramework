package com.qa.chirag.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.chirag.utils.Constants;
import com.qa.chirag.utils.ElementUtil;

public class LoginPage {

	private WebDriver driver;

	private ElementUtil elementUtil;

	private By breadcrumb = By.cssSelector("ul.breadcrumb");
	private By txtEmail = By.id("input-email");
	private By txtPassword = By.id("input-password");
	private By loginBtn = By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public String getLoginPageTitle() {
		return elementUtil.doGetTitle();
	}

	public AccountPage doLogin(String username, String password) {
		CommonsPage commonsPage = new CommonsPage(driver);
		commonsPage.goToLogin();
		if (getLoginPageTitle().contains(Constants.LOGIN_PAGE_TITLE)) {
			if (username != "" && password != "") {
				elementUtil.doScroll(breadcrumb);
				elementUtil.doSendKeys(txtEmail, username);
				elementUtil.doSendKeys(txtPassword, password);
				elementUtil.doClick(loginBtn);
			}
		}
		return new AccountPage(driver);
	}

}
