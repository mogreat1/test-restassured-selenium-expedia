package stepDefinition;

import base.BaseTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.FlightsPage;
import pages.LoginPage;

public class LoginStepDefinition extends BaseTest {
    private LoginPage loginPage;
    private FlightsPage flightsPage;

    @Before
    public void setUp(){
        super.setUp();
    }

    @Given("^user loads a Flights Page$")
    public void user_loads_a_flights_page() throws Throwable {
        driver.get(prop.getProperty("flightsUrl"));
        flightsPage = new FlightsPage(driver);
    }

    @When("^user sends login and password$")
    public void user_sends_login_and_password() throws Throwable {
        loginPage.sendLogin("asdf").sendPassword("af");
    }

    @Then("^Login Error is Displayed$")
    public void login_error_is_displayed() throws Throwable {
        Assert.assertTrue(loginPage.areLoginErrorDisplayed());
    }

    @And("^click the Account Button$")
    public void click_the_account_button() throws Throwable {
        flightsPage.clickAccountBtn();
    }

    @And("^Click the Sign In Button$")
    public void click_the_sign_in_button() throws Throwable {
       loginPage = flightsPage.clickSignInBtn();
    }

    @And("^click Sign In button on the Login Page$")
    public void click_sign_in_button_on_the_login_page() throws Throwable {
        loginPage.clickSignInBtn();
    }

    @After
    public void tearDown() {
        super.tearDown();
    }

}
