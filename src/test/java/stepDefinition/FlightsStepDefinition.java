package stepDefinition;

import cucumber.api.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FlightsStepDefinition {

    @Given("^user is on Flights Page$")
    public void user_is_on_flights_page() throws Throwable {
        System.out.println("on flight page");
    }

    @When("^click the Way tab$")
    public void click_the_way_tab() throws Throwable {
        System.out.println("click");
    }

    @Then("^returning Data Field becomes invisible$")
    public void returning_data_field_becomes_invisible() throws Throwable {
        System.out.println("assert");
    }


}
