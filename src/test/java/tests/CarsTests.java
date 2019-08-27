package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CarsPage;
import pages.FlightsPage;

public class CarsTests extends BaseTest {
    private CarsPage carsPage;
    private FlightsPage flightsPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        super.setUp();
        driver.get(prop.getProperty("baseUrl") + prop.getProperty("flightsResource"));
        carsPage = new CarsPage(driver);
        flightsPage = new FlightsPage(driver);
    }

    @Test(enabled = true, groups = {"functionalTest"})
    private void getToCarsPageFromFlightsTest() {
        flightsPage.openCarsWindowInSecondWindow();
        Assert.assertTrue(flightsPage.clickCarTab().isCarsPageTitleDisplayed());
    }

    @Test(enabled = true, groups = {"smokeTest"})
    private void verifyCarsOpenedInSecondWindowTest() {
        flightsPage.openCarsWindowInSecondWindow();
        Assert.assertTrue(carsPage.isSecondWindowTitleCars());
    }

    @Test(enabled = false, groups = {"functionalTest"})
    private void carsTabsAmountTest(){
        flightsPage.openCarsWindowInSecondWindow();
        Assert.assertTrue(carsPage.isTabsAmountFour());
    }

}
