package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CustomerAuthorizationPage extends BasePage {

    public CustomerAuthorizationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='emailAddress']")
    private WebElement emailField;
    @FindBy(xpath = "//*[@id='signUpPassword']")
    private WebElement passwordField;
    @FindBy(xpath = "//*[@id='unifiedFormContinueBtn']")
    private List<WebElement> continueButton;
    @FindBy(xpath = "//*[@id='signUpBtn']")
    private List<WebElement> signUpBtn;

    public boolean isContinueButtonDisplayed(boolean isDisplayed){
        return isWebElementDisplayed(continueButton, isDisplayed);
    }

    public boolean isSignUpBtnDisplayed(boolean isDisplayed){
        return isWebElementDisplayed(signUpBtn, isDisplayed);
    }

    public CustomerAuthorizationPage sendTextToPasswordField(String text) {
        sendText(passwordField, text);
        return this;
    }

    public CustomerAuthorizationPage clickContinueButton(){
        clickElement(continueButton.get(0));
        return this;
    }
}
