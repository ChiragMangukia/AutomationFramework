package com.qa.chirag.pages;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.chirag.utils.ElementUtil;

public class HomePage {

	private WebDriver driver;

	private ElementUtil elementUtil;

	private By myAccountDropdown = By.cssSelector("div#top-links ul li.dropdown");
	private By loginLink = By.xpath("//div[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a");
	private By labelFeatured = By.cssSelector("div#content h3");
	private By addToCartButton = By.xpath("//div[@class='button-group']/button[1]/span");

	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	private By selectProduct(String product) {
		return By.xpath("//div[@class='caption']/h4/a[text()='" + product + "']");
	}

	public String getPageTitle() {
		return elementUtil.doGetTitle();
	}

	public String getCurrentURL() {
		return elementUtil.doGetCurrentURL();
	}

	public void addProductToCart(String product) {
		elementUtil.doScroll(labelFeatured);
		WebElement productThumb = elementUtil.doGetElement(selectProduct(product));
		elementUtil.doGetElement(with(addToCartButton).below(productThumb)).click();
		elementUtil.sleep(10);
	}

	public LoginPage goToLoginPage() {
		elementUtil.doClick(myAccountDropdown);
		if (elementUtil.doGetText(loginLink).equals("Login")) {
			elementUtil.doClick(loginLink);
		}
		return new LoginPage(driver);
	}
}