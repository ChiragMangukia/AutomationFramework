package com.qa.chirag.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.chirag.utils.ElementUtil;

public class EditAccountInfoPage {

	WebDriver driver;

	private ElementUtil elementUtil;

	private By txtFirstName = By.cssSelector("#input-firstname");
	private By txtLastName = By.cssSelector("#input-lastname");
	private By txtEmail = By.cssSelector("#input-email");
	private By txtTelephone = By.cssSelector("#input-telephone");
	private By btnSubmit = By.cssSelector("input.btn");

	public EditAccountInfoPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public AccountPage editInfo(String firstname, String lastname, String email, String telephone) {
		elementUtil.doClearTextbox(txtFirstName);
		elementUtil.doClearTextbox(txtLastName);
		elementUtil.doClearTextbox(txtEmail);
		elementUtil.doClearTextbox(txtTelephone);
		elementUtil.doSendKeys(txtFirstName, firstname);
		elementUtil.doSendKeys(txtLastName, lastname);
		elementUtil.doSendKeys(txtEmail, email);
		elementUtil.doSendKeys(txtTelephone, telephone);
		elementUtil.doClick(btnSubmit);
		return new AccountPage(driver);
	}

}
