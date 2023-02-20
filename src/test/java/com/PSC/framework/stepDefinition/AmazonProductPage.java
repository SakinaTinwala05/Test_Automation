package com.PSC.framework.stepDefinition;


import com.PSC.framework.settings.ObjectRepo;
import com.PSC.helper.PageObject.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonProductPage {

	LoginPage lp = new LoginPage(ObjectRepo.driver);
	
	@Given("User navigate to Amazon Page")
	public void user_navigate_to_amazon_page() {
		lp.navigateAmazonScreen();
	}

	@Then("Amazon page is displayed")
	public void amazon_page_is_displayed() {
	  lp.visibilityAmazonPage();
	}

	@When("User Click on All navigation Link")
	public void user_click_on_all_navigation_link() {
	   lp.clickAll();
	}

	@And("Click on Echo and Alexa")
	public void click_on_echo_and_alexa() {
	    lp.clickEchoAlexa();
	}

	@Then("Echo and Alexa manu page is displayed")
	public void echo_and_alexa_manu_page_is_displayed() {
	    lp.visibilityEchoPage();
	}

	@When("User Click on Echo Dot \\(3rd Gen)")
	public void user_click_on_echo_dot_3rd_gen() {
		lp.clickEchoMenu();
	}

	@And("Click on Buy Now")
	public void click_on_buy_now() {
	    lp.clickBuyNow();
	}
	
}
