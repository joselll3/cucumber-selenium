package com.example.cucumber.automation.pageobjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	private LandingPage landingPage;
	private OfferPage offerPage;
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

}
