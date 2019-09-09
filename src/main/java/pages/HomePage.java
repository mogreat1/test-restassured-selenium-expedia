package pages;

import base.BasePage;
import com.aventstack.extentreports.gherkin.model.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static io.restassured.RestAssured.given;

public class HomePage extends BasePage {


    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//*[contains(@id,'primary-header')]")
    private List<WebElement> headerLinks;
    @FindBy(xpath = "//*[@id='package-departing-hp-package']")
    private WebElement departingDate;
    @FindBy(xpath = "//*[@class='datepicker-cal-date disabled']")
    private List<WebElement> disabledDates;
    @FindBy(xpath = "//*[@class='datepicker-cal-date']")
    private List<WebElement> futureDates;


    public int validateHeaderLinks() {
        int k = 0;
        Set<Integer> set = new HashSet<Integer>();
        for (WebElement link : headerLinks) {
            String url = link.getAttribute("href");

            int code = given().get(url).then().extract().response().statusCode();
            set.add(code);
            k++;
            if (k > 5) {
                break;
            }
        }
        return set.size();

    }

    public int validateLink() {
        int code = given().get("https://www.google.com").then().extract().response().statusCode();
        return code;

    }

    public HomePage clickDepartingDate() {
        clickElement(departingDate);
        return this;
    }

    public boolean isAmountDisabledDaysLess() {
        LocalDateTime now = LocalDateTime.now();
        int dayOfMonth = now.getDayOfMonth();
        int disabledDays = disabledDates.size();
        return disabledDays < dayOfMonth;
    }

    public boolean isPastDayEnabled() {
        WebElement pastDay = disabledDates.get(0);
        return pastDay.isEnabled();
    }

    public boolean isCurrentDayEnabled() {
        return futureDates.get(0).isEnabled();
    }

    public boolean isCurrentDay() {
        LocalDateTime now = LocalDateTime.now();
        int dayOfMonth = now.getDayOfMonth();
        String date = futureDates.get(0).getText().strip();
        System.out.println(date);
        String day = Integer.toString(dayOfMonth);
        return date.contains(day);
    }


}

