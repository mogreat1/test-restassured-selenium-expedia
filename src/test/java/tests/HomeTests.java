package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;

public class HomeTests extends BaseTest {
    private HomePage homePage;

    @BeforeMethod
    public void setUp() {
        super.setUp();
        driver.get(prop.getProperty("baseUrl"));
        homePage = new HomePage(driver);
    }

    @Test
    private void weekendGetawaysLinksValidTest() {
        int size = homePage.validateHeaderLinks();
        Assert.assertEquals(size, 1);
    }

    @Test
    private void urlTest() {
        int code = homePage.validateLink();
        Assert.assertEquals(code, 200);
    }

    @Test
    private void pastDaysDisabledTest() {
        homePage.clickDepartingDate();
        Assert.assertTrue(homePage.isAmountDisabledDaysLess());
    }

    @Test
    private void pastDayEnabledTest() {
        homePage.clickDepartingDate();
        Assert.assertFalse(homePage.isPastDayEnabled());
    }

    @Test
    private void currentDayEnabledTest() {
        homePage.clickDepartingDate();
        Assert.assertTrue(homePage.isCurrentDayEnabled());
    }

    @Test
    private void currentDayFirstEnabledDayTest(){
        homePage.clickDepartingDate();
        Assert.assertTrue(homePage.isCurrentDay());
    }

}
