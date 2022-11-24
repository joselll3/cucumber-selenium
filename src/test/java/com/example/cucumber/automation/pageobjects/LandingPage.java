package com.example.cucumber.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

	private final static By SEARCH = By.xpath("//input[@type='search']");
	private final static By PRODUCT_NAME = By.cssSelector("h4.product-name");
	private WebDriver driver;

	public LandingPage(WebDriver driver) {
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
