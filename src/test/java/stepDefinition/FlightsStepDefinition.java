package stepDefinition;

import base.BaseTest;
import cucumber.api.PendingException;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.FlightsPage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FlightsStepDefinition extends BaseTest {
    private FlightsPage flightsPage;

    @Given("^Flights Page is loaded$")
    public void flights_page_is_loaded() throws Throwable {
        driver.get(prop.getProperty("flightsUrl"));
        flightsPage = new FlightsPage(driver);
    }

    @When("^click the One Way tab$")
    public void click_the_one_way_tab() throws Throwable {
        flightsPage.clickOneWay();
    }

    @Then("^returning Data Field becomes invisible$")
    public void returning_data_field_becomes_invisible() throws Throwable {
        Assert.assertTrue(flightsPage.isReturningDataInvisible());
    }

    @When("^user types \"([^\"]*)\" into Fly From field$")
    public void user_types_something_into_fly_from_field(String strArg1) throws Throwable {
        flightsPage.sendText(strArg1).chooseLastAutoSugg().clickSpaceFlyingFrom();
    }

    @Then("^amount of auto suggestions equals to ten$")
    public void amount_of_auto_suggestions_equals_to_ten() throws Throwable {
        Assert.assertTrue(flightsPage.flyingFromFieldStarts("S"));
    }

    @Then("^value chosen filled into Fly From field starts from \"([^\"]*)\"$")
    public void value_chosen_filled_into_fly_from_field_starts_from_something(String strArg1) throws Throwable {
        Assert.assertTrue(flightsPage.flyingFromFieldStarts("S"));
    }

    @And("^choose last value from auto suggestion$")
    public void choose_last_value_from_auto_suggestion() throws Throwable {
        flightsPage.chooseLastAutoSugg();

    }

    @And("^click Space button$")
    public void click_space_button() throws Throwable {
        flightsPage.clickSpaceFlyingFrom();
    }

    @When("^user clicks Departing Data$")
    public void user_clicks_departing_data() throws Throwable {
        flightsPage.clickDepartingData();

    }

    @Then("^Calendar is displayed$")
    public void calendar_is_displayed() throws Throwable {
        Assert.assertTrue(flightsPage.isCalendarDisplayed(1));
    }

    @Then("^Calendar is not displayed$")
    public void calendar_is_not_displayed() throws Throwable {
        Assert.assertTrue(flightsPage.isCalendarDisplayed(0));
    }

    @And("^clicks Close button$")
    public void clicks_close_button() throws Throwable {
        flightsPage.closeCalendar();
    }

    @When("^user clicks Traveler Dropdown$")
    public void user_clicks_traveler_dropdown() throws Throwable {
        flightsPage.clickTravelersDD();
    }

    @Then("^Three Traveler groups are displayed$")
    public void three_traveler_groups_are_displayed() throws Throwable {
        Assert.assertTrue(flightsPage.areAllTravelersGroupsPresent());
    }

    @Then("^Child age button dropdown is displayed$")
    public void child_age_button_dropdown_is_displayed() throws Throwable {
        Assert.assertTrue(flightsPage.isChildAgeDDDisplayed());
    }

    @And("^clicks Add child button$")
    public void clicks_add_child_button() throws Throwable {
        flightsPage.clickAddChild();
    }


    @Then("^ChildAge Dropdown contains all child ages$")
    public void childage_dropdown_contains_all_child_ages() throws Throwable {
        Assert.assertTrue(flightsPage.isAllChildAgesDisplayed());
    }

    @When("^User doesn't select anything$")
    public void user_doesnt_select_anything() throws Throwable {

    }

    @Then("^Add Car checkbox is not selected$")
    public void add_car_checkbox_is_not_selected() throws Throwable {
        Assert.assertFalse(flightsPage.isAddCarBoxSelected());
    }

    @When("^check Add Car checkbox$")
    public void check_add_car_checkbox() throws Throwable {
        flightsPage.clickAddCarBox();
    }

    @Then("^Save Message is Displayed$")
    public void save_message_is_displayed() throws Throwable {
        Assert.assertTrue(flightsPage.isSaveMessageDisplayed());
    }


}



