package com.example.cucumber.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfferPage {

	private static final By SEARCH = By.xpath("//input[@type='search']");
	private static final By PRODUCT_NAME = By.cssSelector("tr td:nth-child(1)");

	private WebDriver driver;

	public OfferPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void searchItem(String name) {
		driver.findElement(SEARCH).sendKeys(name);
	}

	public String getProductName() {
		return driver.findElement(PRODUCT_NAME).getText().split("-")[0].trim();
	}

}
