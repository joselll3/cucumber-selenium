package com.example.cucumber.automation.utils;

import org.openqa.selenium.WebDriver;

public class TestContextSetup {

	private WebDriver driver;
	private String landingPageProductName;

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public String getLandingPageProductName() {
		return landingPageProductName;
	}

	public void setLandingPageProductName(String landingPageProductName) {
		this.landingPageProductName = landingPageProductName;
	}

}
