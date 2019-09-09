package tests;

import base.BaseTest;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
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
    private void weekendGetawaysLinksValidTest(){
        homePage.openTopLinks();
    }

    @Test
    private void sendRequestForLinksTest() throws InterruptedException {
        homePage.sendRequests();

    }


}
