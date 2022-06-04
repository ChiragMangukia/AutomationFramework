package com.qa.chirag.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.chirag.utils.ElementUtil;

public class DesktopsPage {

	WebDriver driver;

	private ElementUtil elementUtil;

	private By listedProducts = By.xpath("//div[@id='content']/div[4]/div");

	public DesktopsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public String getPageTitle() {
		return elementUtil.doGetTitle();
	}

	public int getProductCount() {
		return elementUtil.doGetElements(listedProducts).size();
	}

	public List<String> getProductsList() {
		List<String> products = new ArrayList<String>();
		for (WebElement e : elementUtil.doGetElements(listedProducts)) {
			products.add(e.getText());
		}
		return products;
	}

}
