package com.example.cucumber.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

	private static final By CART_BAG = By.cssSelector("[alt='Cart']");
	private static final By CHECKOUT_BUTTON = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	private static final By PROMO_BTN = By.cssSelector(".promoBtn");
	private static final By PLACE_ORDER_BTN = By.xpath("//button[contains(text(),'Place Order')]");

	private WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void checkoutItems() {
		driver.findElement(CART_BAG).click();
		driver.findElement(CHECKOUT_BUTTON).click();
	}

	public boolean verifyPromoBtn() {
		return driver.findElement(PROMO_BTN).isDisplayed();
	}

	public boolean verifyOrderBtn() {
		return driver.findElement(PLACE_ORDER_BTN).isDisplayed();
	}

}
