package com.PSC.framework.stepDefinition;

import static org.testng.Assert.assertEquals;

//import org.junit.Assert;

import com.PSC.constants.Constants;
import com.PSC.framework.settings.ObjectRepo;
import com.PSC.helper.PageObject.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class AmazonPage {

	LoginPage lp = new LoginPage(ObjectRepo.driver);
	
	private static String invalidEmail = "s.sakina@.com";
	//private static String invalidPassword = "pass123";
	
	@Given("User navigate to Amazon Login Page")
	public void user_navigate_to_amazon_login_page() {
		lp.navigateToLoginScreen();
	}

	@Then("Amazon login page is displayed with Email and Continue Link")
	public void amazon_login_page_is_displayed_with_email_and_continue_link() {
		lp.visibilityEmailAndContinue();
	}

	@When("User Enter invalid email")
	public void user_enter_invalid_email() {
		lp.enterEmail(invalidEmail);
		
	}
	
	@And("Click on Continue")
	public void click_on_continue() {
		lp.clickContinue();
	}
	
	@Then("Error message")
	public void error_message() throws Throwable {
		String msg = lp.errorMsg();
		String exp_msg = "Enter your email or mobile phone number";
		assertEquals(msg,exp_msg);
		
	}
	
	@When("User Enter Email")
	public void user_enter_email() {
		lp.enterEmail(Constants.email);
	}
	
	@And("Click on Continue button")
	public void click_on_continue_button() {
		lp.clickContinueButton();
	}

	@Then("Password page is displayed with Password and SignIn Link")
	public void password_page_is_displayed_with_password_and_sign_in_link() {
		lp.visibilityPasswordAndSignIn();
	}

	@When("User Enter Password")
	public void user_enter_password() {
		lp.enterPassword(Constants.password);
	}

	@And("Click on SignIn")
	public void click_on_sign_in() {
		lp.clickSignInButton();
	}
	
	
	
	
	
}
