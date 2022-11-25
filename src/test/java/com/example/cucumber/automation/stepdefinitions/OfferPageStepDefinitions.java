package com.example.cucumber.automation.stepdefinitions;

import org.junit.jupiter.api.Assertions;

import com.example.cucumber.automation.pageobjects.OfferPage;
import com.example.cucumber.automation.utils.TestContextSetup;

import io.cucumber.java.en.Then;

public class OfferPageStepDefinitions {

	private TestContextSetup testContextSetup;
	private String offerPageProductName;

	public OfferPageStepDefinitions(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@Then("^user searched for (.+) shortname in offers page$")
	public void user_searched_for_shortname_in_offers_page(String shortName) throws InterruptedException {

		testContextSetup.getPageObjectManager().getLandingPage().selectTopDealsPage();
		testContextSetup.getGenericUtils().switchWindowToChild();

		OfferPage offerPage = testContextSetup.getPageObjectManager().getOfferPage();
		offerPage.searchItem(shortName);
		Thread.sleep(2000);
		offerPageProductName = offerPage.getProductName();
		System.out.println("Extracted product name offerPageProductName = " + offerPageProductName);

	}

	@Then("validate product name in offers page matches with landing page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {
		Assertions.assertEquals(offerPageProductName, testContextSetup.getLandingPageProductName());
	}
}
