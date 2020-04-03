package com.autotraders.StepDefinitions;

import com.autotraders.Pages.AdvanceSearchPage;
import com.autotraders.Pages.AutotradersPage;
import com.autotraders.Pages.BasePage;
import com.autotraders.utils.MyDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.concurrent.TimeUnit;

public class AutotradersSteps {

	AutotradersPage autotradersPage = new AutotradersPage();
	AdvanceSearchPage advanceSearchPage = new AdvanceSearchPage();


	@ Given ("user test with {string} browser")

	public void user_test_with_browser(String brs){
		if(brs.equals("chrome")){
			//ConfigurationReader.getProperty("browser");
			System.setProperty("browser","chrome");


		}else
			//ConfigurationReader.getProperty("browserfx");
		System.setProperty("browser","firefox");
	}


	@Given("User is in landing page")
	public void user_is_in_landing_page() {
		System.out.println("We are in landing Page");

		String actualTitle=MyDriver.get().getTitle();
		String expectedTitle="New Cars, Used Cars - Find Cars for Sale and Reviews at Autotrader";
		Assert.assertEquals(expectedTitle,actualTitle);
        //opening the landing page.

	}

	@Then("Verify that {string} are present")
	public void verify_that_are_present(String string) {

		autotradersPage.verification(string);
	}

	@Then("verify that search button is present.")
	public void verify_that_search_button_is_present() {
		autotradersPage.verifyButton();

	}

	@Then("verify that {string} and {string} is visible")
	public void verify_that_and_is_visible(String make, String model) {

		autotradersPage.verifyMakeAndModel(make, model);

		BasePage.clearCookiees();
	}

	//Second user story to start
	@Given("User click Advance Search link on the home page")
	public void user_click_Advance_Search_link_on_the_home_page()  {


		advanceSearchPage.verifyclickable();

		BasePage.clearCookiees();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("User enter {string} in the zip code text box")
	public void user_enter_in_the_text_box(String zipcode) {


		advanceSearchPage.verifyZipCode(zipcode);
	}

	@Then("User select {string} check box under {string}")
	public void user_select_check_box_under(String string,String str2)  {


		advanceSearchPage.verifyclickCertifiedAndConvertible(string);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("user update Year {string} to {string}")
	public void user_update_Year_to(String fromYear, String toYear) {

		advanceSearchPage.verifyselectStartAndEnd(fromYear,toYear);
	}

	@Then("user select {string} car from Make,Model and Trim section")
	public void user_select_car_from_Make_Model_and_Trim_section(String car) {

		advanceSearchPage.verifyselectVehicle(car);
		BasePage.clearCookiees();
	}

	@Then("User clicks Search button")
	public void user_clicks_button()  {

		advanceSearchPage.verifyClickSearchButton();
	}

	@Then("User verifies that he is in result page")
	public void user_verifies_that_he_is_in_result_page() {


		advanceSearchPage.VerifyUsersInPage();
	}

	@Then("User verifies that he sees only {string} cars in listing")
	public void user_verifies_that_he_sees_only_cars_in_listing(String car) {
		advanceSearchPage.VerifyThereIsOnlySelectedVehicle(car);


	}

	@Then("Display in console, the number of cars listed in result page")
	public void display_in_console_the_number_of_cars_listed_in_result_page() {
		advanceSearchPage.verifyNumberOfBMW();


	}

	@Given("choose make as {string}")
	public void choose_make_as(String make) {

		MyDriver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		autotradersPage.multiplechoice(make);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
