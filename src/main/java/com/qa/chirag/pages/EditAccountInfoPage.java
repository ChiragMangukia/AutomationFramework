package com.qa.chirag.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditAccountInfoPage {

	WebDriver driver;

	private By txtFirstName = By.cssSelector("#input-firstname");
	private By txtLastName = By.cssSelector("#input-lastname");
	private By txtEmail = By.cssSelector("#input-email");
	private By txtTelephone = By.cssSelector("#input-telephone");
	private By btnSubmit = By.cssSelector("input.btn");

	public EditAccountInfoPage(WebDriver driver) {
		this.driver = driver;
	}

	public AccountPage editInfo(String firstname, String lastname, String email, String telephone) {
		driver.findElement(txtFirstName).clear();
		;
		driver.findElement(txtLastName).clear();
		;
		driver.findElement(txtEmail).clear();
		driver.findElement(txtTelephone).clear();
		driver.findElement(txtFirstName).sendKeys(firstname);
		driver.findElement(txtLastName).sendKeys(lastname);
		driver.findElement(txtEmail).sendKeys(email);
		driver.findElement(txtTelephone).sendKeys(telephone);
		driver.findElement(btnSubmit).click();
		return new AccountPage(driver);
	}

}
