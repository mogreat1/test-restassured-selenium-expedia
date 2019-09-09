package pages;

import base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.*;
import java.time.LocalDateTime;


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
    @FindBy(xpath = "//*[@id='package-advanced-preferred-class-hp-package']")
    private WebElement preferredClass;

    public int preferredClassDDSize() {
        Select select = new Select(preferredClass);
        return select.getOptions().size();
    }

    public void choosePreferredClass(){
        Select select = new Select(preferredClass);
        select.selectByVisibleText("Business");
    }


    public boolean areAllTitlesPresent() {
        boolean result = true;
        for (String title : createTitleArrayList()) {
            if (!getLinkTitles().contains(title)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public HomePage openLinks() {
        int k = 0;
        for (int i = 0; i < headerLinks.size(); i++) {
            String openLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
            if (k < 5) {
                headerLinks.get(i).sendKeys(openLink);
                k++;
            } else {
                System.out.println("break");
                break;
            }
        }
        return this;
    }

    public ArrayList<String> getLinkTitles() {
        ArrayList<String> titles = new ArrayList<>();
        Set<String> windows = driver.getWindowHandles();
        String baseWindow = driver.getWindowHandle();
        for (String window : windows) {
            if (!window.equals(baseWindow)) {
                driver.switchTo().window(window);
                titles.add(driver.getTitle());
            }
        }
        return titles;
    }

    public ArrayList<String> createTitleArrayList() {
        ArrayList<String> titles = new ArrayList<>();
        titles.add("Cruises: Find Cheap Cruise Deals & Last Minute Cruises | Expedia");
        titles.add("Car Rental: Cheap Airport Car Rentals & Rental Car Deals | Expedia");
        titles.add("Vacation Packages: Find Travel Deals for Cheap Vacations | Expedia");
        titles.add("Hotels: Search Cheap Hotels, Deals, Discounts & Reservations | Expedia");
        titles.add("Cheap Flights: Airline Tickets, Airfare Deals & One Way Flights | Expedia");
        return titles;
    }

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

