package com.example.cucumber.automation.stepdefinitions;

import org.junit.jupiter.api.Assertions;

import com.example.cucumber.automation.pageobjects.LandingPage;
import com.example.cucumber.automation.utils.TestContextSetup;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LandingPageStepDefinitions {

	private TestContextSetup testContextSetup;
	private LandingPage landingPage;

	public LandingPageStepDefinitions(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		landingPage = testContextSetup.getPageObjectManager().getLandingPage();
	}

	@Given("User is on GreenCart landing page")
	public void user_is_on_green_cart_landing_page() {
		Assertions.assertTrue(landingPage.getTitle().contains("GreenKart"));
	}

	@When("^user searched with Shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName)
			throws InterruptedException {
		landingPage.searchItem(shortName);
		Thread.sleep(2000);
		testContextSetup.setLandingPageProductName(landingPage.getProductName());
		System.out.println(
				"Extracted product name landingPageProductName = " + testContextSetup.getLandingPageProductName());
	}

	@And("added {int} items of the selected product to cart")
	public void added_items_of_the_selected_product_to_cart(Integer quantity) {
		landingPage.incrementQuantity(quantity);
		landingPage.addToCart();
	}

}
