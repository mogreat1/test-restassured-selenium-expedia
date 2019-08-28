package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ActivitiesSearchPage extends BasePage {
    public ActivitiesSearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//*[@id='titleHeading']")
    private List<WebElement> activSearchTitle;

    public boolean isActiveSearchPageDisplayed(){
        return isWebElementDisplayed(activSearchTitle, true);
    }



}
