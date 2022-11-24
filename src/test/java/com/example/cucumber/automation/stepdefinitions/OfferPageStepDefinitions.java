package com.example.cucumber.automation.stepdefinitions;

import java.util.Iterator;

import org.junit.jupiter.api.Assertions;

import com.example.cucumber.automation.pageobjects.OfferPage;
import com.example.cucumber.automation.utils.TestContextSetup;

import io.cucumber.java.en.Then;

public class OfferPageStepDefinitions {

	private TestContextSetup testContextSetup;
	private String offerPageProductName;
	private OfferPage offerPage;

	public OfferPageStepDefinitions(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.offerPage = new OfferPage(testContextSetup.getDriver());
	}

	@Then("user searched for {string} shortname in offers page")
	public void user_searched_for_shortname_in_offers_page(String shortName) throws InterruptedException {

		swithToOfferPage();

		offerPage.searchItem(shortName);
		Thread.sleep(2000);
		offerPageProductName = offerPage.getProductName();
		System.out.println("Extracted product name offerPageProductName = " + offerPageProductName);

	}

	private void swithToOfferPage() {
		offerPage.selectTopDealsPage();
		Iterator<String> it = testContextSetup.getDriver().getWindowHandles().iterator();
		it.next();
		String childWindow = it.next();
		testContextSetup.getDriver().switchTo().window(childWindow);
	}

	@Then("validate product name in offers page matches with landing page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {
		Assertions.assertEquals(offerPageProductName, testContextSetup.getLandingPageProductName());
	}
}
