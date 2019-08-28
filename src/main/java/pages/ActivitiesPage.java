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

    @FindBy(xpath = "//*[@id='activity-destination-alp']")
    private WebElement activitiesSearchField;
    @FindBy(xpath = "//*[@aria-label='Close']")
    private WebElement closeBtn;

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

}
