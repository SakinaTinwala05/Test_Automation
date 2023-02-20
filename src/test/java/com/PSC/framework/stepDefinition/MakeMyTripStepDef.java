package com.PSC.framework.stepDefinition;

import com.PSC.constants.Constants;
import com.PSC.framework.settings.ObjectRepo;
import com.PSC.helper.PageObject.MakeMyTrip;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MakeMyTripStepDef {

	MakeMyTrip lp = new MakeMyTrip(ObjectRepo.driver);

	@Given("User navigate to MakeMyTrip Page")
	public void user_navigate_to_make_my_trip_page() {
	   lp.navigateMakeMyTripScreen();
	}

	@Then("MakeMyTrip page is displayed")
	public void make_my_trip_page_is_displayed() {
	   lp.visibilityMakeMyTripPage();
	}

	@When("User Click on Flights")
	public void user_click_on_flights() {
	    lp.clickFlights();
	}

	@Then("User Enter City From")
	public void user_enter_city_from() {
	    lp.enterCityFrom(Constants.FromCity);
	}

	@And("User Enter City To")
	public void user_enter_city_to() {
		lp.enterCityTo(Constants.ToCity);
	}

	@When("Select departure date")
	public void select_departure_date() {
		lp.enterCityFrom(Constants.Departure);
	}

	@And("Click on search button")
	public void click_on_search_button() {
	   lp.clickSearch();
	}
	
}
