package com.example.cucumber.automation.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinitions {

	@Given("^User is on NetBanking landing page$")
	public void user_is_on_netbanking_landing_page() throws Throwable {
		System.out.println("^User is on NetBanking landing page$");
	}

	@When("User login into application with username {string} and password {string}")
	public void user_login_into_application_with_username_and_password(String username, String password) {
		System.out.println("^User login into application with username {string} and password {string}$");
		System.out.println("username=" + username);
		System.out.println("password=" + password);
	}

	@Then("^Home page is populated$")
	public void home_page_is_populated() throws Throwable {
		System.out.println("^Home page is populated$");
	}

	@And("Cards displayed are {string}")
	public void cards_displayed_are(String string) {
		System.out.println("Cards displayed are " + string);
	}

	@When("User sign up with following credentials")
	public void user_sign_up_with_following_credentials(DataTable dataTable) {
		System.out.println(dataTable.asLists().get(0));
	}

}
