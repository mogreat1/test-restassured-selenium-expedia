package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CustomerAuthorizationPage;
import pages.FlightsPage;
import pages.HomePage;

public class LoginTests extends BaseTest {

    private CustomerAuthorizationPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        super.setUp();
        driver.get(prop.getProperty("baseUrl")+prop.getProperty("flightsResource"));
    }

    @Test
    private void shouldOpenSignInPopUp(){
        // when
        HomePage homePage = new HomePage(driver).clickSignInButton();

        // then
        Assert.assertTrue(homePage.isSignInButtonDisplayed());
    }

    @Test
    private void shouldRedirectToCustomerAuthorizationPageWhenClickPopUpSignInBtn(){
        // given
        HomePage homePage = new HomePage(driver).clickSignInButton();

        // when
        loginPage = homePage.clickPopUpSignInButton();

        // then
        Assert.assertTrue(loginPage.isContinueButtonDisplayed(true));
    }

    @Test
    private void shouldRedirectToCustomerAuthorizationPageWhenProvideEmail(){
        // given
        HomePage homePage = new HomePage(driver).clickSignInButton();
        loginPage = homePage.clickPopUpSignInButton();

        // when
        CustomerAuthorizationPage customerAuthorizationPage = loginPage
                .sendTextToPasswordField("email@gmail.com")
                .clickContinueButton();

        // then
        Assert.assertTrue(customerAuthorizationPage.isSignUpBtnDisplayed(true));
    }



    @Test(dataProvider = "loginDataProvider", groups = {"functionalTest"})//
    private void invalidCredentialsTest(String login, String password){
        FlightsPage flightsPage = new FlightsPage(driver);
//        loginPage = flightsPage.clickSignInBtn();
//        loginPage.sendLogin(login).sendPassword(password).clickSignInBtn();
//        Assert.assertTrue(loginPage.isLoginErrorDisplayed());
    }

    @DataProvider(name = "loginDataProvider")
    public Object[][] loginData() {
        return new Object[][] { {"", ""}/*,{ "one@asd.as", "" }, { "", "45644534" },
                { "three", "7809879" }, { "thr@ee.rr", "789hjkl!" } */};
    }
}
