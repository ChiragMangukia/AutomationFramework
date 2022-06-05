package com.qa.chirag.pages;

import java.time.Month;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.chirag.utils.ElementUtil;

public class ProductPage {

	WebDriver driver;
	ElementUtil elementUtil;

	private By breadcrumb = By.cssSelector("ul.breadcrumb");
	private By productName = By.cssSelector("div#content h1");
	private By brandName = By.cssSelector("div#content ul.list-unstyled a");
	private By calendarDatePicker = By.xpath("//div[@class='input-group date']/span");
	private By currentDate = By.xpath("/html/body/div[4]/div/div[1]/table/thead/tr[1]/th[2]");
	private By moveToPreviousYear = By.xpath("/html/body/div[4]/div/div[3]/table/thead/tr/th[1]");
	private By moveToNextYear = By.xpath("/html/body/div[4]/div/div[3]/table/thead/tr/th[3]");
	private By months = By.xpath("/html/body/div[4]/div/div[2]/table/tbody/tr/td/span");
	private By yearHeader = By.xpath("/html/body/div[4]/div/div[2]/table/thead/tr/th[2]");
	private By years = By.xpath("/html/body/div[4]/div/div[3]/table/tbody/tr/td/span");
	private By dates = By.xpath("/html/body/div[4]/div/div[1]/table/tbody/tr/td[@class='day']");
	private By firstYearInBlock = By.xpath("/html/body/div[4]/div/div[3]/table/tbody/tr/td/span[1]");
	private By LastYearInBlock = By.xpath("/html/body/div[4]/div/div[3]/table/tbody/tr/td/span[12]");

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
	
	public void selectDate(String DDMMYYYY) {
		elementUtil.doScroll(calendarDatePicker);
		elementUtil.doClick(calendarDatePicker);
		String expectedDate = DDMMYYYY.substring(0, 2);
		String expectedMonth = Month.of(Integer.parseInt(DDMMYYYY.substring(2, 4))).toString().substring(0, 3);
		String expectedYear = DDMMYYYY.substring(4, 8);

		elementUtil.doClick(currentDate);
		elementUtil.doClick(yearHeader);

		if (!elementUtil.doFindAndClickFromElementsList(years, expectedYear)) {
			Boolean loop = true;
			while (loop) {
				int firstYearInBlockString = Integer.parseInt(elementUtil.doGetText(firstYearInBlock));
				int lastYearInBlockString = Integer.parseInt(elementUtil.doGetText(LastYearInBlock));
				if (Integer.parseInt(expectedYear) < firstYearInBlockString) {
					elementUtil.doClick(moveToPreviousYear);
					if (elementUtil.doFindAndClickFromElementsList(years, expectedYear)) {
						loop = false;
					}
				} else if (Integer.parseInt(expectedYear) > lastYearInBlockString) {
					elementUtil.doClick(moveToNextYear);
					if (elementUtil.doFindAndClickFromElementsList(years, expectedYear)) {
						loop = false;
					}
				}
			}
		}
		elementUtil.doFindAndClickFromElementsList(months, expectedMonth);
		elementUtil.doFindAndClickFromElementsList(dates, expectedDate);
	}
}
