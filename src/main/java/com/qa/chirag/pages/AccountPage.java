package com.qa.chirag.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
	
	WebDriver driver;
	
	private By editAcInfoLink = By.xpath("//*[@id=\"content\"]/ul[1]/li[1]/a");
	private By changePswdLink = By.xpath("//*[@id=\"content\"]/ul[1]/li[2]/a");
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void openEditAcInfo() {
		driver.findElement(editAcInfoLink).click();
	}
	
	public void navigateBack() {
		driver.navigate().back();
	}
	
	public void openChangePswd() {
		driver.findElement(changePswdLink).click();
	}

}
