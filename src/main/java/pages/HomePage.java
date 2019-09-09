package pages;

import base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static io.restassured.RestAssured.given;

public class HomePage extends BasePage {


    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//*[@id='cupid-weekendgetaways-container']//a[@class='flex-link']")
    private List<WebElement> weekendGetawaysLinks;
    @FindBy(xpath = "//*[@id='cupid-popdestinations-title']")
    private WebElement popularDestinationTitle;
    @FindBy(xpath = "//*[@class='utility-nav nav-group cf']//a")
    private List<WebElement> topLinks;


    public void openTopLinks() {

        List<WebElement> topLinkList = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.
                xpath("//*[@class='utility-nav nav-group cf']//a"), 5));
        int k = 0;
        for (int i = 0; i < topLinkList.size(); i++) {

            String openLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
            if (k < 5) {
                topLinkList.get(i).sendKeys(openLink);
                System.out.println(k);
                k++;
            } else {
                System.out.println("break");
                break;
            }

        }
        Set<String> windows = driver.getWindowHandles();
        Iterator iterator = windows.iterator();
        String baseWindow = driver.getWindowHandle();

        for (String window : windows) {
            if (!window.equals(baseWindow)) {
                driver.switchTo().window(window);
                System.out.println(driver.getTitle());
            }

        }
        driver.switchTo().defaultContent();
        System.out.println(driver.getTitle());

    }

    public void sendRequests() throws InterruptedException {
        List<WebElement> topLinkList = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.
                xpath("//*[@class='utility-nav nav-group cf']//a"), 5));
        int k = 0;
        for (WebElement element : topLinkList) {
            if (k < 5) {
                Thread.sleep(500);
                int status = given().get(element.getAttribute("href")).then().extract().statusCode();
                System.out.println(status);
                k++;
            } else {
                break;
            }


        }
    }


}

