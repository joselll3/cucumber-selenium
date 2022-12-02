package com.example.cucumber.automation.selenium;

import java.nio.file.Paths;
import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumConceptsTest {

	@Test
	void testConcepts() {

		// Start session
		System.setProperty("webdriver.chrome.driver",
				Paths.get(System.getProperty("user.dir"), "src/test/resources/chromedriver.exe").toString());
		WebDriver driver = new ChromeDriver();

		// Navigate to web page
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		// Request browser information
		String title = driver.getTitle();
		String currentUrl = driver.getCurrentUrl();
		String windowHandle = driver.getWindowHandle();

		// Waiting strategy
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

		// Finding elements
		WebElement searchInput = driver.findElement(By.xpath("//input[@type='search']"));
		WebElement linkTopDeals = driver.findElement(By.linkText("Top Deals"));
		WebElement increment = driver.findElement(By.cssSelector("a.increment"));
		WebElement quantityInput = driver.findElement(By.xpath("//input[@type='number']"));

		// Interacting with elements
		searchInput.sendKeys("Broco");
		increment.click();

		// Request element information
		String quantitySelected = quantityInput.getAttribute("value");

		Assertions.assertEquals(2, Integer.valueOf(quantitySelected));
		Assertions.assertEquals("GreenKart - veg and fruits kart", title);

		// End session

		driver.close();
	}

}
