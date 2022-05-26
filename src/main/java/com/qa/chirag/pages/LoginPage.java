package com.qa.chirag.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	private By txtEmail = By.id("input-email");
	private By txtPassword = By.id("input-password");
	private By loginBtn = By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void doLogin(String username, String password) {
		if(username != "" && password != "") {
			driver.findElement(txtEmail).sendKeys(username);
			driver.findElement(txtPassword).sendKeys(password);
			driver.findElement(loginBtn).click();
		}
	}
	
	
}
