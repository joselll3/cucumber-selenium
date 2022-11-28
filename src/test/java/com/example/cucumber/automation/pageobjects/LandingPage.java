package com.example.cucumber.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

	private static final By SEARCH = By.xpath("//input[@type='search']");
	private static final By PRODUCT_NAME = By.cssSelector("h4.product-name");
	private static final By LINK_TOP_DEALS = By.linkText("Top Deals");
	private static final By INCREMENT = By.cssSelector("a.increment");
	private static final By ADD_TO_CART = By.cssSelector(".product-action button");

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

	public void selectTopDealsPage() {
		driver.findElement(LINK_TOP_DEALS).click();
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public void incrementQuantity(int quantity) {
		int i = quantity - 1;
		while (i > 0) {
			driver.findElement(INCREMENT).click();
			i--;
		}
	}

	public void addToCart() {
		driver.findElement(ADD_TO_CART).click();
	}
}
