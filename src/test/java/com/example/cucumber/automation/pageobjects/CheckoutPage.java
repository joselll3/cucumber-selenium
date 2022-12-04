package com.example.cucumber.automation.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		return new WebDriverWait(driver, Duration.ofSeconds(2))
				.until(ExpectedConditions.visibilityOfElementLocated(PROMO_BTN)).isDisplayed();
	}

	public boolean verifyOrderBtn() {
		return new WebDriverWait(driver, Duration.ofSeconds(2))
				.until(ExpectedConditions.visibilityOfElementLocated(PLACE_ORDER_BTN)).isDisplayed();
	}

}
