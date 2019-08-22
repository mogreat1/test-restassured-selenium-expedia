package pages;

import base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Instant;
import java.util.List;

public class FlightsPage extends BasePage {
    public FlightsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='flight-type-one-way-label-flp']")
    WebElement oneWay;
    @FindBy(xpath = "//*[@id='flight-returning-flp']")
    WebElement returningData;
    @FindBy(xpath = "//*[@id='flight-origin-flp']")
    WebElement flyingFromField;
    @FindBy(xpath = "//*[@class='results-item']")
    List<WebElement> autoSuggestions;
    @FindBy(xpath = "//*[@class='multiLineDisplay']/b")
    WebElement firstChar;
    @FindBy(xpath = "//*[@id='flight-departing-flp']")
    WebElement departing;
    @FindBy(xpath = "//*[@id='flight-returning-flp']")
    WebElement returning;
    @FindBy(xpath = "//*[@class='datepicker-cal']")
    List<WebElement> calendars;
    @FindBy(xpath = "//*[@class='datepicker-cal']")
    WebElement calendar;
    @FindBy (xpath = "//*[@class='datepicker-close-btn close btn-text']")
    WebElement closeBtn;
    @FindBy(xpath = "//*[@class='datepicker-cal']")
    List<WebElement> closeBtns;
    @FindBy(xpath = "//button[contains(@class,'traveler')]")
    WebElement travelersDropDown;

    public FlightsPage clickOneWay(){
        clickElement(oneWay);
        return this;
    }

    public boolean isReturningDataInvisible(){
        return elementInvisible(returningData);
    }

    public FlightsPage sendText(String text){
        sendText(flyingFromField, text);
        return this;
    }

    public long amountAutoSuggestions(){
        wait.until(ExpectedConditions.visibilityOfAllElements(autoSuggestions)).size();
        return autoSuggestions.size();
    }

    public FlightsPage chooseLastAutoSugg(){
       List<WebElement> list = wait.until(ExpectedConditions.visibilityOfAllElements(autoSuggestions));
        list.get(0).click();
        return this;
    }

    public FlightsPage clickSpaceFlyingFrom(){
        wait.until(ExpectedConditions.elementToBeClickable(flyingFromField)).sendKeys(Keys.SPACE);
        return this;
    }

    public boolean flyingFromFieldStarts(String letter){
        System.out.println(getTextField(firstChar));
        return getTextField(firstChar).startsWith(letter);
    }

    public FlightsPage clickDepartingData(){
        clickElement(departing);
        return this;
    }

    public boolean isCalendarDisplayed(int value){
        if (value==0){
            wait.until(ExpectedConditions.invisibilityOfAllElements(closeBtns));
        } else {
            wait.until(ExpectedConditions.visibilityOfAllElements(closeBtns));
        }

        return calendars.size()==value;
    }

    public FlightsPage closeCalendar(){
        wait.until(ExpectedConditions.visibilityOfAllElements(closeBtns));
        clickElement(closeBtn);
        return this;
    }

    public FlightsPage clickTravelersDD(){
        clickElement(travelersDropDown);
        return this;
    }

}
