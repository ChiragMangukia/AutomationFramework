package com.qa.chirag.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.chirag.utils.ElementUtil;

public class ProductPage {

	WebDriver driver;
	ElementUtil elementUtil;

	private By breadcrumb = By.cssSelector("ul.breadcrumb");
	private By productName = By.cssSelector("div#content h1");
	private By brandName = By.cssSelector("div#content ul.list-unstyled a");

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		scrollToContents();
	}

	private void scrollToContents() {
		elementUtil.doScroll(breadcrumb);
	}

	public String getProductName() {
		return elementUtil.doGetText(productName);
	}

	public BrandPage clickBrandName() {
		elementUtil.doClick(brandName);
		return new BrandPage(driver);
	}
}
