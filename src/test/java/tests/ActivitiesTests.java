package tests;

import apiCalls.GetCities;
import base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
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
        String [] areas = {"asdfasd", "London", "Max"};
            cityName = getCities.getCitiesNames(areas);

    }

    @BeforeMethod
    public void setUp() {
        super.setUp();
        driver.get(prop.getProperty("baseUrl") + prop.getProperty("activitiesResource"));
        activitiesPage = new ActivitiesPage(driver);
    }

    @Test
    private void searchActivityTest(){
        //when
        activitiesPage
                .clickActivitiesSearchField()
                .sendActivitiesText(cityName)
                .waitForCloseBtn()
                .pressEnterKey()
                .pressEnterKey();

        //then
        Assert.assertTrue(new ActivitiesSearchPage(driver).isActiveSearchPageDisplayed());
    }

    @Test
    private void sendCityNameInDateFromTest(){
       activitiesPage.sendTextDateFrom(cityName).pressEnterKey();
       Assert.assertTrue(activitiesPage.isDateFormatErrorDisplayed());
    }

    @Test
    private void staleElementTest(){
        WebElement element = driver.findElement(By.xpath("//*[text()='Search']"));
        driver.navigate().refresh();
        var error = "";
        try{
            element.click();
        } catch (StaleElementReferenceException e){
            error = e.getMessage();
        }
        Assert.assertTrue(error.contains("stale element reference: element is not attached to the page document"));

    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }
}
