package com.example.cucumber.automation.stepdefinitions;

import org.junit.jupiter.api.Assertions;

import com.example.cucumber.automation.pageobjects.BlogPage;
import com.example.cucumber.automation.utils.TestContextSetup;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BlogStepDefinitions {

	private BlogPage blogPage;
	private TestContextSetup testContextSetup;

	public BlogStepDefinitions(TestContextSetup testContextSetup) {
		super();
		this.testContextSetup = testContextSetup;
		this.blogPage = testContextSetup.getPageObjectManager().getBlogPage();
	}

	@Given("el usuario accede a la sección del Blog")
	public void el_usuario_accede_a_la_seccion_del_blog() {
		blogPage.clickOnBlog();
	}

	@When("^selecciona la categoría (.+)$")
	public void selecciona_la_categoria(String categoryName) {
		blogPage.selectCategory(categoryName);
	}

	@And("selecciona el primer artículo")
	public void selecciona_el_primer_articulo() {
		blogPage.selectFirstArticle();
	}

	@Then("se carga el contenido del artículo")
	public void se_carga_el_contenido_del_articulo() {
		Assertions.assertTrue(blogPage.hasArticleTitle());
	}
}
