package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FlightsPage;
import pages.LoginPage;

public class FlightsTests extends BaseTest {
   private FlightsPage flightsPage;
    @BeforeMethod
    public void setUp(){
        super.setUp();
        driver.get(prop.getProperty("baseUrl")+prop.getProperty("flightsResource"));
        flightsPage = new FlightsPage(driver);

    }

    @Test(enabled = true)
    private void mainUrlTest(){
        String url =driver.getCurrentUrl();
        Assert.assertEquals(url, prop.getProperty("flightsUrl"));

    }

    @Test(enabled = true)
    private void switchOneWayTest(){
    flightsPage.clickOneWay();
    Assert.assertTrue(flightsPage.isReturningDataInvisible());
    }

    @Test(enabled = true)
    private void autoSuggestionTest(){
    flightsPage.sendText("k");
    Assert.assertEquals(flightsPage.amountAutoSuggestions(), 10);
    }

    @Test(enabled = true)
    private void lastFromAutoSuggStarsFromLetterTest(){
        String letter = "S";
        flightsPage.sendText(letter).chooseLastAutoSugg().clickSpaceFlyingFrom();
        Assert.assertTrue(flightsPage.flyingFromFieldStarts(letter));
    }

    @Test(enabled = true)
    private void calendarDisplayedTest(){
        flightsPage.clickDepartingData();
        Assert.assertTrue(flightsPage.isCalendarDisplayed(1));
    }

    @Test
    private void closeCalendarTest(){
        flightsPage.clickDepartingData().closeCalendar();
        Assert.assertTrue(flightsPage.isCalendarDisplayed(0));
    }

    @Test
    private void threeGroupsInTravelersTest(){
        flightsPage.clickTravelersDD();
        Assert.assertTrue(flightsPage.areAllTravelersGroupsPresent());
    }

    @Test
    private void addChildTest(){
        flightsPage.clickTravelersDD().clickAddChild();
        Assert.assertTrue(flightsPage.isChildAgeDDDisplayed());
    }

    @Test
    private void allChildAgesDisplayedTest(){
        flightsPage.clickTravelersDD().clickAddChild();
        Assert.assertTrue(flightsPage.isAllChildAgesDisplayed());
    }

    @Test
    private void addCarBoxNotSelectedTest(){
        Assert.assertFalse(flightsPage.isAddCarBoxSelected());
    }

    @Test
    private void saveMessageDisplayedTest(){
        flightsPage.clickAddCarBox();
        Assert.assertTrue(flightsPage.isSaveMessageDisplayed());
    }

    @Test
    private void loadSignInPageTest(){
        LoginPage loginPage =flightsPage.clickAccountBtn().clickSignInBtn();
        Assert.assertTrue(loginPage.isSignUpBtnDisplayed());
    }

}
