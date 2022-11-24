package com.example.cucumber.automation.utils;

import com.example.cucumber.automation.pageobjects.PageObjectManager;

public class TestContextSetup {

	private String landingPageProductName;
	private PageObjectManager pageObjectManager;
	private TestBase testBase;
	private GenericUtils genericUtils;

	public TestContextSetup() {
		super();
		this.testBase = new TestBase();
		this.pageObjectManager = new PageObjectManager(testBase.webDriverManager());
		this.genericUtils = new GenericUtils(testBase.webDriverManager());
	}

	public String getLandingPageProductName() {
		return landingPageProductName;
	}

	public void setLandingPageProductName(String landingPageProductName) {
		this.landingPageProductName = landingPageProductName;
	}

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

	public GenericUtils getGenericUtils() {
		return genericUtils;
	}

}
