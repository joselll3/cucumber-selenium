package com.example.cucumber.automation.selenium;

import java.nio.file.Paths;
import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumConceptsTwoTest {

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
		Assertions.assertEquals("GreenKart - veg and fruits kart", title);

		// Waiting strategy
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

		// Finding elements
		WebElement searchInput = driver.findElement(By.xpath("//input[@type='search']"));
		WebElement increment = driver.findElement(By.cssSelector("a.increment"));
		WebElement quantityInput = driver.findElement(By.xpath("//input[@type='number']"));

		// Interacting with elements
		searchInput.sendKeys("Broco");
		increment.click();

		// Request element information
		String quantitySelected = quantityInput.getAttribute("value");

		Assertions.assertEquals(2, Integer.valueOf(quantitySelected));

		driver.findElement(By.cssSelector(".product-action button")).click();
		driver.findElement(By.cssSelector("[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

		String totalAmount = driver.findElement(By.cssSelector(".totAmt")).getText();
		Assertions.assertEquals("240", totalAmount);

		WebElement btnPlaceOrder = driver.findElement(By.xpath("//button[contains(text(),'Place Order')]"));
		btnPlaceOrder.click();

		WebElement checkAgree = driver.findElement(By.cssSelector(".chkAgree"));
		checkAgree.click();

		final Select selectBox = new Select(driver.findElement(By.xpath("//select")));
		selectBox.selectByValue("Spain");

		WebElement btnProceedOrder = driver.findElement(By.xpath("//button[contains(text(),'Proceed')]"));
		btnProceedOrder.click();
		// End session

		driver.close();
	}
}
