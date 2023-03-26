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

class CheckoutOrderTest {

	@Test
	void test() {
		System.setProperty("webdriver.chrome.driver",
				Paths.get(System.getProperty("user.dir"), "src/test/resources/chromedriver.exe").toString());
		System.setProperty("webdriver.http.factory", "jdk-http-client");

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		String title = driver.getTitle();

		Assertions.assertEquals("GreenKart - veg and fruits kart", title);

		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

		WebElement searchInput = driver.findElement(By.xpath("//input[@type='search']"));
		WebElement increment = driver.findElement(By.cssSelector("a.increment"));
		WebElement quantityInput = driver.findElement(By.xpath("//input[@type='number']"));

		searchInput.sendKeys("Broco");
		increment.click();

		String quantitySelected = quantityInput.getAttribute("value");

		Assertions.assertEquals(2, Integer.valueOf(quantitySelected));

		driver.findElement(By.cssSelector(".product-action button")).click();

		driver.findElement(By.cssSelector("[alt='Cart']")).click();

		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

		String totalAmount = driver.findElement(By.cssSelector(".totAmt")).getText();

		Assertions.assertEquals(240, Integer.valueOf(totalAmount));

		driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();

		WebElement checkAgree = driver.findElement(By.cssSelector(".chkAgree"));
		checkAgree.click();

		Select selectBox = new Select(driver.findElement(By.xpath("//select")));
		selectBox.selectByValue("Spain");

		WebElement btnProceedOrder = driver.findElement(By.xpath("//button[contains(text(),'Proceed')]"));
		btnProceedOrder.click();

	}

}
