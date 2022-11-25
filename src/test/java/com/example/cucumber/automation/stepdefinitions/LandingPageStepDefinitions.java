package com.example.cucumber.automation.stepdefinitions;

import com.example.cucumber.automation.pageobjects.LandingPage;
import com.example.cucumber.automation.utils.TestContextSetup;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LandingPageStepDefinitions {

	private TestContextSetup testContextSetup;

	public LandingPageStepDefinitions(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@Given("User is on GreenCart landing page")
	public void user_is_on_green_cart_landing_page() {
	}

	@When("^user searched with Shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName)
			throws InterruptedException {
		LandingPage landingPage = testContextSetup.getPageObjectManager().getLandingPage();
		landingPage.searchItem(shortName);
		Thread.sleep(2000);
		testContextSetup.setLandingPageProductName(landingPage.getProductName());
		System.out.println(
				"Extracted product name landingPageProductName = " + testContextSetup.getLandingPageProductName());
	}

}
