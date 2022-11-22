package com.example.cucumber.automation.stepdefinitions;

import java.util.Iterator;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchProductStepDefinitions {

	private WebDriver driver;
	private String offerPageProductName;
	private String landingPageProductName;

	@Given("User is on GreenCart landing page")
	public void user_is_on_green_cart_landing_page() {

		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}

	@When("user searched with Shortname {string} and extracted actual name of product")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName)
			throws InterruptedException {
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		Thread.sleep(2000);
		landingPageProductName = driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
		System.out.println("Extracted product name landingPageProductName = " + landingPageProductName);
	}

	@Then("user searched for {string} shortname in offers page")
	public void user_searched_for_shortname_in_offers_page(String shortName) throws InterruptedException {
		driver.findElement(By.linkText("Top Deals")).click();
		Iterator<String> it = driver.getWindowHandles().iterator();
		it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		Thread.sleep(2000);
		offerPageProductName = driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
		System.out.println("Extracted product name offerPageProductName = " + offerPageProductName);

	}

	@Then("validate product name in offers page matches with landing page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {
		Assertions.assertEquals(offerPageProductName, landingPageProductName);

	}

}
