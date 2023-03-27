package com.example.cucumber.automation.pageobjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	private LandingPage landingPage;
	private OfferPage offerPage;
	private CheckoutPage checkoutPage;
	private BlogPage blogPage;

	private WebDriver driver;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public LandingPage getLandingPage() {
		if (landingPage == null) {
			landingPage = new LandingPage(driver);
		}
		return landingPage;
	}

	public OfferPage getOfferPage() {
		if (offerPage == null) {
			offerPage = new OfferPage(driver);
		}
		return offerPage;
	}

	public CheckoutPage getCheckoutPage() {
		if (checkoutPage == null) {
			checkoutPage = new CheckoutPage(driver);
		}
		return checkoutPage;
	}

	public BlogPage getBlogPage() {
		if (blogPage == null) {
			blogPage = new BlogPage(driver);
		}
		return blogPage;
	}
}
