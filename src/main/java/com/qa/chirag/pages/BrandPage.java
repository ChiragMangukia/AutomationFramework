package com.qa.chirag.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.chirag.utils.ElementUtil;

public class BrandPage {

	WebDriver driver;
	ElementUtil elementUtil;

	private By breadcrumb = By.cssSelector("ul.breadcrumb");
	private By brandName = By.cssSelector("div#content h2");

	public BrandPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		elementUtil.doScroll(breadcrumb);
	}

	public String getTitle() {
		return elementUtil.doGetTitle();
	}

	public String getBrandName() {
		return elementUtil.doGetText(brandName);
	}

}
