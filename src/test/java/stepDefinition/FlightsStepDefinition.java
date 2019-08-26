package stepDefinition;

import base.BaseTest;
import cucumber.api.PendingException;
import io.cucumber.java.After;
import io.cucumber.java.Before;
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
    @Before
    public void setUp() {
        super.setUp();

    }

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

    @When("^user types first letter into Fly From field$")
    public void user_types_first_letter_into_fly_from_field() throws Throwable {
        flightsPage.sendText("k").chooseLastAutoSugg().clickSpaceFlyingFrom();
    }

    @Then("^amount of auto suggestions equals to ten$")
    public void amount_of_auto_suggestions_equals_to_ten() throws Throwable {
        Assert.assertTrue(flightsPage.flyingFromFieldStarts("S"));
    }



    @After
    public void tearDown() {
        super.tearDown();
    }
}



