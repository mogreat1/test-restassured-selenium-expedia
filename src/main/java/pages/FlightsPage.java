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
}
