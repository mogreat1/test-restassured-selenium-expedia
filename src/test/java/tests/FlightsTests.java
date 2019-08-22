package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FlightsPage;

public class FlightsTests extends BaseTest {
   private FlightsPage flightsPage;
    @BeforeMethod
    public void setUp(){
        super.setUp();
        driver.get(prop.getProperty("flightsUrl"));
        flightsPage = new FlightsPage(driver);

    }

    @Test
    private void mainUrlTest(){
        String url =driver.getCurrentUrl();
        Assert.assertEquals(url, prop.getProperty("flightsUrl"));

    }

    @Test
    private void switchOneWayTest(){
    flightsPage.clickOneWay();
    Assert.assertTrue(flightsPage.isReturningDataInvisible());
    }
}
