package tests;

import apiCalls.GetCities;
import base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.ActivitiesPage;
import pages.ActivitiesSearchPage;

import java.util.Arrays;
import java.util.stream.Stream;

import static io.restassured.RestAssured.given;

public class ActivitiesTests extends BaseTest {
    private ActivitiesPage activitiesPage;
    private String cityName;

    @BeforeClass()
    private void getCityName(){
        GetCities  getCities = new GetCities();
        String [] areas = {"asdfasd"};
        for(String area: areas){
            if (getCities.getCitiesNames(area)!=null)
            cityName = getCities.getCitiesNames(area);
            break;
        }
    }

    @BeforeMethod
    public void setUp() {
        super.setUp();
        driver.get(prop.getProperty("baseUrl") + prop.getProperty("activitiesResource"));
        activitiesPage = new ActivitiesPage(driver);
    }

    @Test
    public void searchActivity(){
        activitiesPage.clickActivitiesSearchField().sendActivitiesText(cityName).waitForCloseBtn().pressEnterKey().pressEnterKey();
        Assert.assertTrue(new ActivitiesSearchPage(driver).isActiveSearchPageDisplayed());
    }

    @Test
    public void searchActivity2(){
        activitiesPage.clickActivitiesSearchField().sendActivitiesText(cityName).waitForCloseBtn().pressEnterKey().pressEnterKey();
        Assert.assertTrue(new ActivitiesSearchPage(driver).isActiveSearchPageDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }
}
