package pages;

import base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ActivitiesPage extends BasePage {
    public ActivitiesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@aria-label='Things to do in']")
    private WebElement activitiesSearchField;
    @FindBy(xpath = "//*[@aria-label='Close']")
    private WebElement closeBtn;
    @FindBy(xpath = "//*[@id='activity-start-alp']")
    private WebElement dateFrom;
    @FindBy(xpath = "//*[text()='Date format should be mm/dd/yyyy.']")
    private WebElement dateFormatError;
    @FindBy(xpath = "//*[text()='Search']")
    private WebElement searchBtn;

    public ActivitiesPage sendActivitiesText(String text){
        sendText(activitiesSearchField, text);
        return this;
    }

    public ActivitiesPage clickActivitiesSearchField(){
        clickElement(activitiesSearchField);
        return this;
    }

    public ActivitiesPage pressEnterKey(){
        activitiesSearchField.sendKeys(Keys.ENTER);
        return this;
    }

    public ActivitiesPage waitForCloseBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(closeBtn));
        return this;
    }
    public ActivitiesPage sendTextDateFrom(String text){
        sendText(dateFrom, text);
        return this;
    }

    public boolean isDateFormatErrorDisplayed(){
       return wait.until(ExpectedConditions.visibilityOf(dateFormatError)).isDisplayed();
    }



}
