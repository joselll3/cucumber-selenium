package com.example.cucumber.automation.stepdefinitions;

import com.example.cucumber.automation.utils.TestContextSetup;

import io.cucumber.java.After;

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

}
