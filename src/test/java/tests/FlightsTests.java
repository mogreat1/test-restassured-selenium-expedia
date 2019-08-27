package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FlightsPage;
import pages.LoginPage;

public class FlightsTests extends BaseTest {
   private FlightsPage flightsPage;
    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        super.setUp();
        driver.get(prop.getProperty("baseUrl")+prop.getProperty("flightsResource"));
        flightsPage = new FlightsPage(driver);

    }

    @Test(enabled = true, groups = {"functionalTest"})
    private void mainUrlTest(){
        String url =driver.getCurrentUrl();
        Assert.assertEquals(url, prop.getProperty("baseUrl")+prop.getProperty("flightsResource"));

    }

    @Test(enabled = false, groups = {"functionalTest"})
    private void switchOneWayTest(){
    flightsPage.clickOneWay();
    Assert.assertTrue(flightsPage.isReturningDataInvisible());
    }

    @Test(enabled = true, groups = {"functionalTest"})
    private void autoSuggestionTest(){
    flightsPage.sendText("k");
    Assert.assertEquals(flightsPage.amountAutoSuggestions(), 10);
    }

    @Test(enabled = false, groups = {"functionalTest"})
    private void lastFromAutoSuggStarsFromLetterTest(){
        String letter = "S";
        flightsPage.sendText(letter).chooseLastAutoSugg().clickSpaceFlyingFrom();
        Assert.assertTrue(flightsPage.flyingFromFieldStarts(letter));
    }

    @Test(enabled = false, groups = {"functionalTest"})
    private void calendarDisplayedTest(){
        flightsPage.clickDepartingData();
        Assert.assertTrue(flightsPage.isCalendarDisplayed(1));
    }

    @Test(enabled = false, groups = {"smokeTest"})
    private void closeCalendarTest(){
        flightsPage.clickDepartingData().closeCalendar();
        Assert.assertTrue(flightsPage.isCalendarDisplayed(0));
    }

    @Test(enabled = false, groups = {"smokeTest"})
    private void threeGroupsInTravelersTest(){
        flightsPage.clickTravelersDD();
        Assert.assertTrue(flightsPage.areAllTravelersGroupsPresent());
    }

    @Test(enabled = false, groups = {"smokeTest"})
    private void addChildTest(){
        flightsPage.clickTravelersDD().clickAddChild();
        Assert.assertTrue(flightsPage.isChildAgeDDDisplayed());
    }

    @Test(enabled = false, groups = {"functionalTest"})
    private void allChildAgesDisplayedTest(){
        flightsPage.clickTravelersDD().clickAddChild();
        Assert.assertTrue(flightsPage.isAllChildAgesDisplayed());
    }

    @Test(enabled = false, groups = {"functionalTest"})
    private void addCarBoxNotSelectedTest(){
        Assert.assertFalse(flightsPage.isAddCarBoxSelected());
    }

    @Test(enabled = false, groups = {"functionalTest"})
    private void saveMessageDisplayedTest(){
        flightsPage.clickAddCarBox();
        Assert.assertTrue(flightsPage.isSaveMessageDisplayed());
    }

    @Test(groups = {"functionalTest"})
    private void loadSignInPageTest(){
        LoginPage loginPage =flightsPage.clickAccountBtn().clickSignInBtn();
        Assert.assertTrue(loginPage.isSignUpBtnDisplayed());
    }

}
