package com.qa.chirag.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DesktopsPage {
	
	WebDriver driver;
	
	private By listedProducts = By.xpath("//div[@id='content']/div[4]/div");
	
	public DesktopsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public int getProductCount() {
		return driver.findElements(listedProducts).size();
	}
	
	public List<String> getProductsList() {
		List<String> products = new ArrayList<String>();
		for (WebElement e : driver.findElements(listedProducts)) {
			products.add(e.getText());
		}
		return products;
	}

}
