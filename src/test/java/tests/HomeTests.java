package tests;

import base.BaseTest;

import io.restassured.RestAssured;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;

import static io.restassured.RestAssured.given;

public class HomeTests extends BaseTest {
    private HomePage homePage;

    @BeforeMethod
    public void setUp() {
        super.setUp();
        driver.get(prop.getProperty("baseUrl"));
        homePage = new HomePage(driver);
    }

    @Test
    private void shouldOpenCalendarWhenClickCheckInDate() {
        // when
        // then
        Assert.assertTrue(homePage.clickDepartingDate().isDoneBtnDisplayed());
    }

    @Test
    private void shouldHasSixTabsInMainPanel() {
        Assert.assertTrue(homePage.hasTabsAmount(6));
    }

    @Test
    private void openLinks() {
        homePage.openLinks();
        Assert.assertTrue(homePage.areAllTitlesPresent());
    }

    @Test
    private void preferredClassDDSizeTest() {
        Assert.assertEquals(homePage.preferredClassDDSize(), 4);
    }

}
