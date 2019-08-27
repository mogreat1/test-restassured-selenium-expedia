package pages;

import base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FlightsPage extends BasePage {
    public FlightsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='flight-type-one-way-label-flp']")
    @CacheLookup
    private WebElement oneWay;
    @FindBy(xpath = "//*[@id='flight-returning-flp']")
    @CacheLookup
    private WebElement returningData;
    @FindBy(xpath = "//*[@id='flight-origin-flp']")
    @CacheLookup
    private WebElement flyingFromField;
    @FindBy(xpath = "//*[@class='results-item']")
    @CacheLookup
    private List<WebElement> autoSuggestions;
    @FindBy(xpath = "//*[@class='multiLineDisplay']/b")
    @CacheLookup
    private WebElement firstChar;
    @FindBy(xpath = "//*[@id='flight-departing-flp']")
    @CacheLookup
    private WebElement departing;
    @FindBy(xpath = "//*[@id='flight-returning-flp']")
    @CacheLookup
    private WebElement returning;
    @FindBy(xpath = "//*[@class='datepicker-cal']")
    @CacheLookup
    private List<WebElement> calendars;
    @FindBy(xpath = "//*[@class='datepicker-close-btn close btn-text']")
    @CacheLookup
    private WebElement closeBtn;
    @FindBy(xpath = "//*[@class='datepicker-cal']")
    @CacheLookup
    private List<WebElement> closeBtns;
    @FindBy(xpath = "//button[contains(@class,'traveler')]")
    @CacheLookup
    private WebElement travelersDropDown;
    @FindBy(xpath = "//*[@id='traveler-selector-flp']//*[@for='uitk-step-input-input']/span")
    @CacheLookup
    private List<WebElement> travelersValues;
    @FindBy(xpath = "//*[@id='traveler-selector-flp']//*[@class='btn btn-label']")
    @CacheLookup
    private WebElement travelerCloseBtn;
    @FindBy(xpath = "//*[text()='Add Child']")
    @CacheLookup
    private WebElement addChildBtn;
    @FindBy(xpath = "//*[@id='flight-age-select-1-flp']")
    @CacheLookup
    private List<WebElement> childAgeDD;
    @FindBy(xpath = "//*[@name='addCar']")
    @CacheLookup
    private WebElement addCarBox;
    @FindBy(xpath = "//*[text()='Book together and SAVE!']")
    @CacheLookup
    private List<WebElement> saveMessage;
    @FindBy(xpath = "//*[@id='primary-header-car']")
    @CacheLookup
    private WebElement carsWindow;
    @FindBy(xpath = "//*[@class='utility-nav nav-group cf']/li/a")
    @CacheLookup
    private List<WebElement> headerTabs;
    @FindBy(xpath = "//*[@id='header-account-menu']")
    @CacheLookup
    private WebElement accountBtn;
    @FindBy(xpath = "//*[@id='account-signin']")
    @CacheLookup
    private WebElement signInBtn;


    public FlightsPage clickOneWay() {
        clickElement(oneWay);
        return this;
    }

    public boolean isReturningDataInvisible() {
        return elementInvisible(returningData);
    }

    public FlightsPage sendText(String text) {
        sendText(flyingFromField, text);
        return this;
    }

    public long amountAutoSuggestions() {
        wait.until(ExpectedConditions.visibilityOfAllElements(autoSuggestions)).size();
        return autoSuggestions.size();
    }

    public FlightsPage chooseLastAutoSugg() {
        List<WebElement> list = wait.until(ExpectedConditions.visibilityOfAllElements(autoSuggestions));
        list.get(0).click();
        return this;
    }

    public FlightsPage clickSpaceFlyingFrom() {
        wait.until(ExpectedConditions.elementToBeClickable(flyingFromField)).sendKeys(Keys.SPACE);
        return this;
    }

    public boolean flyingFromFieldStarts(String letter) {
        System.out.println(getTextField(firstChar));
        return getTextField(firstChar).startsWith(letter);
    }

    public FlightsPage clickDepartingData() {
        clickElement(departing);
        return this;
    }

    public boolean isCalendarDisplayed(int value) {
        if (value == 0) {
            wait.until(ExpectedConditions.invisibilityOfAllElements(closeBtns));
        } else {
            wait.until(ExpectedConditions.visibilityOfAllElements(closeBtns));
        }

        return calendars.size() == value;
    }

    public FlightsPage closeCalendar() {
        wait.until(ExpectedConditions.visibilityOfAllElements(closeBtns));
        clickElement(closeBtn);
        return this;
    }

    public FlightsPage clickTravelersDD() {
        clickElement(travelersDropDown);
        return this;
    }

    public boolean areAllTravelersGroupsPresent() {
        boolean result = true;
        String[] groups = {"Adults", "Children", "Infants"};
        List<String> groupsList = Arrays.asList(groups);
        List<WebElement> values = wait.until(ExpectedConditions.visibilityOfAllElements(travelersValues));
        Set<String> set = new HashSet<>();
        for (WebElement value : values) {
            set.add(value.getText().replaceAll("\\s+", ""));
        }
        for (String value : groupsList) {
            if (set.add(value)) {
                System.out.println("A group not present: " + value);
                result = false;
            }
        }
        return result;
    }

    public FlightsPage clickAddChild() {
        actions.click(addChildBtn).build().perform();
        //clickElement(addChildBtn);
        return this;
    }

    public boolean isChildAgeDDDisplayed() {
        return childAgeDD.get(0).isDisplayed();
    }

    public boolean isAllChildAgesDisplayed() {
        Select select = new Select(childAgeDD.get(0));
        List<WebElement> list = select.getOptions();
        int sumOfAges = 0;
        for (WebElement element : list) {

            if(element.getText().length()<=2){
                int i = Integer.parseInt(element.getText());
                sumOfAges = i + sumOfAges;
            }
        }
        System.out.println(sumOfAges);
        return sumOfAges == 152;
    }
    public boolean isAddCarBoxSelected(){
        return addCarBox.isSelected();
    }

    public FlightsPage clickAddCarBox(){
        clickElement(addCarBox);
        return this;
    }

    public boolean isSaveMessageDisplayed(){
        return isWebElementDisplayed(saveMessage, true);
        //Finish this method
    }

    public CarsPage clickCarTab(){
        clickElement(carsWindow);
        return new CarsPage(driver);
    }

    public CarsPage openCarsWindowInSecondWindow(){
        openLinkInSecondTab(carsWindow);
        return new CarsPage(driver);
    }

    public FlightsPage clickAccountBtn(){
        clickElement(accountBtn);
        return this;
    }

    public LoginPage clickSignInBtn(){
        clickElement(signInBtn);
        return new LoginPage(driver);
    }
}
