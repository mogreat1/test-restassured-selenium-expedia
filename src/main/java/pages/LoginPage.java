package pages;

import base.BasePage;
import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='gss-signin-email']")
    @CacheLookup
    private WebElement loginField;
    @FindBy(xpath = "//*[@id='gss-signin-password']")
    @CacheLookup
    private WebElement passwordField;
    @FindBy(xpath = "//*[@id='gss-signin-submit']")
    @CacheLookup
    private WebElement signInBtn;
    @FindBy(xpath = "//*[@id='gss-goto-signup']")
    @CacheLookup
    private List<WebElement>signUpBtn;
    @FindBy(xpath = "//*[@id='signInEmailErrorMessage']")
    @CacheLookup
    private WebElement emailError;
    @FindBy(xpath = "//*[@id='signInEmailErrorMessage']")
    @CacheLookup
    private WebElement passwordError;
    @FindBy(xpath = "//*[@class='uitk-validation-error']")
    @CacheLookup()
    private List<WebElement> loginErrors;

    public boolean isSignUpBtnDisplayed(){
        return isWebElementDisplayed(signUpBtn, true);
    }

    public LoginPage sendLogin(String login){
        sendText(loginField, login);
        return this;
    }

    public LoginPage sendPassword(String password){
        sendText(passwordField, password);
        return this;
    }

    public LoginPage clickSignInBtn(){
        clickElement(signInBtn);
        return this;
    }

    public boolean areLoginErrorDisplayed(){
        return wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.
                xpath("//*[@class='uitk-validation-error']"), 0)).size()>=1;
    }

}