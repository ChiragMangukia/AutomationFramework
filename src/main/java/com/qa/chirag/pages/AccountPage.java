package com.qa.chirag.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.chirag.utils.ElementUtil;

public class AccountPage {

	WebDriver driver;

	private ElementUtil elementUtil;

	private By successMsg = By.xpath("//div[@id='account-account']/div[1]");
	private By editAcInfoLink = By.xpath("//*[@id='content']/ul[1]/li[1]/a");
	private By changePswdLink = By.xpath("//*[@id='content']/ul[1]/li[2]/a");

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public String getSuccessMsg() {
		return elementUtil.doGetText(successMsg);
	}

	public EditAccountInfoPage openEditAcInfoPage() {
		elementUtil.doClick(editAcInfoLink);
		return new EditAccountInfoPage(driver);
	}

	public void navigateBack() {
		elementUtil.doNavigateBack();
	}

	public void openChangePswdPage() {
		elementUtil.doClick(changePswdLink);
	}

}
