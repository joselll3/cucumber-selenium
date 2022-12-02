package com.example.cucumber.automation.utils;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	private static final String GLOBAL_PROPERTIES = "global.properties";
	private static final String PROPERTY_BASE_URL = "baseUrl";
	private static final String PROPERTY_BROWSER = "browser";
	private static final String BROWSER_CHROME = "chrome";

	private WebDriver driver;

	public WebDriver webDriverManager() {
		if (driver == null) {
			Properties properties = loadProperties();
			if (properties.getProperty(PROPERTY_BROWSER).equalsIgnoreCase(BROWSER_CHROME)) {
				Paths.get(System.getProperty("user.dir"), "src/test/resources/chromedriver.exe");
				driver = new ChromeDriver();
			}
			driver.get(properties.getProperty(PROPERTY_BASE_URL));
		}
		return driver;
	}

	private Properties loadProperties() {
		Properties properties = new Properties();
		try {
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(GLOBAL_PROPERTIES));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
}
