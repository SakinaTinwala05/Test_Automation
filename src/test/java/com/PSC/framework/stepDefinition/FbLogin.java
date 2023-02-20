/*package com.PSC.framework.stepDefinition;


import com.PSC.constants.Constants;
import com.PSC.framework.settings.ObjectRepo;
import com.PSC.helper.PageObject.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FbLogin {

LoginPage lp = new LoginPage(ObjectRepo.driver);
	
	
	@Given("User navigate to Facebook Login Page")
	public void user_navigate_to_facebook_login_page() {
		lp.navigateToLoginScreen();
	}

	@Then("Facebook login page is displayed with Email, Password, Login button, Forgotten account Link and Sign up for Facebook Link")
	public void facebook_login_page_is_displayed_with_email_password_login_button_forgotten_account_link_and_sign_up_for_facebook_link() {
		lp.visibilityEmailPasswordAndLogin();
	}

	@When("User Enter email and Password")
	public void user_enter_email_and_password() {
		lp.enterEmail(Constants.email);
		lp.enterPassword(Constants.password);
	}

	@And("Click on login")
	public void fbclick_on_login() {
		lp.clickLoginButton();
	}
	

	
}*/
