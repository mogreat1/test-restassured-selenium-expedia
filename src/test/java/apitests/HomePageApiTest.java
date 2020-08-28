package apitests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageApiTest extends BaseTest {

    private HomePage homePage;

    @Test
    private void shouldRespond200WhenRequestHeaderLinks() {
        // given
        driver.get(prop.getProperty("baseUrl"));
        homePage = new HomePage(driver);

        // when
        int size = homePage.validateHeaderLinks();

        // then
        Assert.assertEquals(size, 1);
    }

    @Test
    private void shouldRespond200WhenRequestedHost() {
        // given
        homePage = new HomePage(driver);

        // when
        int code = homePage.validateLink("https://www.google.pl/");

        // then
        Assert.assertEquals(code, 200);
    }
}
