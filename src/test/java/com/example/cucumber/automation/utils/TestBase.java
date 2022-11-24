package com.example.cucumber.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	private WebDriver driver;

	public WebDriver webDriverManager() {
		if (driver == null) {
			driver = new ChromeDriver();
			driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		}
		return driver;
	}

}
