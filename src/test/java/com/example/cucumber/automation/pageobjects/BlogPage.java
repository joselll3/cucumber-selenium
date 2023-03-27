package com.example.cucumber.automation.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BlogPage {

	private static final By BLOG_LINK = By.xpath("//a[contains(text(),'Blog')]");
	private static final By ACEPTAR_COOKIES = By.className("modal-cacsp-btn-accept");
	private static final By SELECT_CATEGORY = By.xpath("//select");
	private static final By FIRST_ARTICLE = By.className("elementor-post__read-more");

	private static final By ARTICLE_TITLE = By.className("elementor-heading-title");

	private WebDriver driver;

	public BlogPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void clickOnBlog() {
		driver.findElement(BLOG_LINK).click();
		WebDriverWait dw = new WebDriverWait(driver, Duration.ofSeconds(2));

		WebElement elementAceptarCookies = dw.until(ExpectedConditions.elementToBeClickable(ACEPTAR_COOKIES));
		elementAceptarCookies.click();
	}

	public void selectCategory(String categoryName) {
		Select selectBox = new Select(driver.findElement(SELECT_CATEGORY));
		selectBox.selectByVisibleText(categoryName);
	}

	public void selectFirstArticle() {
		driver.findElement(FIRST_ARTICLE).click();
	}

	public boolean hasArticleTitle() {
		return driver.findElements(ARTICLE_TITLE).size() > 0;
	}

}
