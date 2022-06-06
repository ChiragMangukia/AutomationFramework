package com.qa.chirag.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.chirag.utils.ElementUtil;

public class DesktopsPage {

	WebDriver driver;

	private ElementUtil elementUtil;

	private By labelRefineSearch = By.cssSelector("div#content h3");
	private By dropdownShow = By.cssSelector("select#input-limit");
	private By listedProducts = By.xpath("//div[@id='content']/div[4]/div");

	public DesktopsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	private By getProductLink(String product) {
		return By.partialLinkText(product);
	}

	public String getPageTitle() {
		return elementUtil.doGetTitle();
	}

	public int getProductCount() {
		return elementUtil.doGetElements(listedProducts).size();
	}

	public List<String> getProductsList() {
		return elementUtil.doGetTextListFromWebElements(listedProducts);
	}

	public void selectFromShowDropdown(int numberOfProductsToDisplay) {
		elementUtil.doScroll(labelRefineSearch);
		elementUtil.doSelectDropdownByVisibleText(dropdownShow, Integer.toString(numberOfProductsToDisplay));
	}

	public ProductPage selectProduct(String product) {
		if (elementUtil.checkIfElementIsPresent(getProductLink(product))) {
			elementUtil.doClick(getProductLink(product));
		}
		return new ProductPage(driver);
	}

	public ProductPage selectProduct(String product, int productCountFromDropdown) {
		selectFromShowDropdown(productCountFromDropdown);
		if (elementUtil.checkIfElementIsPresent(getProductLink(product))) {
			elementUtil.doClick(getProductLink(product));
		}
		return new ProductPage(driver);
	}
}
