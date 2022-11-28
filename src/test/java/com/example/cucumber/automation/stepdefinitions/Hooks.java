package com.example.cucumber.automation.stepdefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.example.cucumber.automation.utils.TestContextSetup;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class Hooks {

	private TestContextSetup testContextSetup;

	public Hooks(TestContextSetup testContextSetup) {
		super();
		this.testContextSetup = testContextSetup;
	}

	@After
	public void afterScenario() {
		testContextSetup.getTestBase().webDriverManager().quit();
	}

	@AfterStep
	public void addScreenShot(Scenario scenario) {
		if (scenario.isFailed()) {
			WebDriver webDriver = testContextSetup.getTestBase().webDriverManager();

			byte[] screenShot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenShot, "image/png", "image");

		}
	}

}
