package com.example.cucumber.automation.stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

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

		testContextSetup.driver = new ChromeDriver();
		testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}

	@When("user searched with Shortname {string} and extracted actual name of product")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName)
			throws InterruptedException {
		testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		Thread.sleep(2000);
		testContextSetup.landingPageProductName = testContextSetup.driver.findElement(By.cssSelector("h4.product-name"))
				.getText().split("-")[0].trim();
		System.out
				.println("Extracted product name landingPageProductName = " + testContextSetup.landingPageProductName);
	}

}
