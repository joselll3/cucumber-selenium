package com.example.cucumber.automation.stepdefinitions;

import org.junit.jupiter.api.Assertions;

import com.example.cucumber.automation.pageobjects.CheckoutPage;
import com.example.cucumber.automation.utils.TestContextSetup;

import io.cucumber.java.en.Then;

public class CheckoutPageStepDefinitions {

	private TestContextSetup testContextSetup;
	private CheckoutPage checkoutPage;

	public CheckoutPageStepDefinitions(TestContextSetup testContextSetup) {
		super();
		this.testContextSetup = testContextSetup;
		this.checkoutPage = testContextSetup.getPageObjectManager().getCheckoutPage();
	}

	@Then("verify user has ability to enter promo code and place the order")
	public void verify_user_has_ability_to_enter_promo_code_and_place_the_order() {
		Assertions.assertTrue(checkoutPage.verifyPromoBtn());
		Assertions.assertTrue(checkoutPage.verifyOrderBtn());

	}

	@Then("^user proceds to Checkout and validate the (.+) items in checkout page$")
	public void user_proceds_to_checkout_and_validate_the_tom_items_in_checkout_page(String items)
			throws InterruptedException {
		checkoutPage.checkoutItems();
	}

}
