package com.qa.chirag.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.chirag.utils.Constants;

public class LoginPage {
	
	private WebDriver driver;
	
	private By txtEmail = By.id("input-email");
	private By txtPassword = By.id("input-password");
	private By loginBtn = By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public AccountPage doLogin(String username, String password) {
		if(getLoginPageTitle().contains(Constants.LOGIN_PAGE_TITLE)) {
			if(username != "" && password != "") {
				driver.findElement(txtEmail).sendKeys(username);
				driver.findElement(txtPassword).sendKeys(password);
				driver.findElement(loginBtn).click();
			}
		}
		return new AccountPage(driver);
	}
	
	
}
