package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightsPage extends BasePage {
    public FlightsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='flight-type-one-way-label-flp']")
    WebElement oneWay;
    @FindBy(xpath = "//*[@id='flight-returning-flp']")
    WebElement returningData;

    public FlightsPage clickOneWay(){
        clickElement(oneWay);
        return this;
    }

    public boolean isReturningDataInvisible(){
        return elementInvisible(returningData);
    }
}
