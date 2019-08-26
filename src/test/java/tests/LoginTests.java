package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.FlightsPage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    private FlightsPage flightsPage;
    private LoginPage loginPage;
    @BeforeMethod
    public void setUp(){
        super.setUp();
        driver.get(prop.getProperty("baseUrl")+prop.getProperty("flightsResource"));
        flightsPage = new FlightsPage(driver);
        loginPage =flightsPage.clickAccountBtn().clickSignInBtn();

    }

    @Test(dataProvider = "loginDataProvider")
    private void invalidCredentialsTest(String login, String password){
        loginPage.sendLogin(login).sendPassword(password).clickSignInBtn();
        Assert.assertTrue(loginPage.areLoginErrorDisplayed());
    }

    @DataProvider(name = "loginDataProvider")
    public Object[][] loginData() {
        return new Object[][] { {"", ""},{ "one@asd.as", "" }, { "", "45644534" },
                { "three", "7809879" }, { "thr@ee.rr", "789hjkl!" } };
    }
}
