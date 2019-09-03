package tests;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomeTests extends BaseTest {
    private HomePage homePage;

    @BeforeMethod
    public void setUp(){
        super.setUp();
        driver.get(prop.getProperty("baseUrl"));
        homePage = new HomePage(driver);
    }

    @Test
    private void weekendGetawaysLinksValidTest() throws InterruptedException {
    homePage.weekendGetawaysLinks();
    }


}
