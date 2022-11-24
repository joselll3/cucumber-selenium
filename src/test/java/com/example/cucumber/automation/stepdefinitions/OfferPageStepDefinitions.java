package com.example.cucumber.automation.stepdefinitions;

import java.util.Iterator;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import com.example.cucumber.automation.utils.TestContextSetup;

import io.cucumber.java.en.Then;

public class OfferPageStepDefinitions {

	private TestContextSetup testContextSetup;
	private String offerPageProductName;

	public OfferPageStepDefinitions(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@Then("user searched for {string} shortname in offers page")
	public void user_searched_for_shortname_in_offers_page(String shortName) throws InterruptedException {

		swithToOfferPage();

		testContextSetup.getDriver().findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		Thread.sleep(2000);
		offerPageProductName = testContextSetup.getDriver().findElement(By.cssSelector("tr td:nth-child(1)")).getText();
		System.out.println("Extracted product name offerPageProductName = " + offerPageProductName);

	}

	private void swithToOfferPage() {
		testContextSetup.getDriver().findElement(By.linkText("Top Deals")).click();
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
