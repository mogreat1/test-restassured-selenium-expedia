package tests;

import base.BaseTest;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CarsPage;
import pages.FlightsPage;

public class CarsTests extends BaseTest {
    private CarsPage carsPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        super.setUp();
        driver.get(prop.getProperty("baseUrl") + prop.getProperty("carsResource"));
        carsPage = new CarsPage(driver);
    }

    @Test
    private void discountCodeDDDisplayedTest() {
        carsPage.clickAdvancedOptions();
        Assert.assertTrue(carsPage.isDiscountCodeDDDisplayed());
    }

    @Test
    private void chosenCorporateOrContractedInDiscountCodeDDResultsSelectInRentalCarCompany() {
        carsPage.clickAdvancedOptions().selectDiscountCode("Corporate or contracted");
        Assert.assertEquals(carsPage.getSelectedOptionCarCompanyDD(), "-- Select from the list --");

    }


}
