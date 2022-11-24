package com.example.cucumber.automation.utils;

import java.util.Iterator;

import org.openqa.selenium.WebDriver;

public class GenericUtils {

	private WebDriver driver;

	public GenericUtils(WebDriver driver) {
		this.driver = driver;
	}

	public void switchWindowToChild() {
		Iterator<String> it = driver.getWindowHandles().iterator();
		it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
	}

}
