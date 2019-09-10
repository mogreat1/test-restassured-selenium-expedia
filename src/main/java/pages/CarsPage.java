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

import java.util.List;
import java.util.Set;

public class CarsPage extends BasePage {
    public CarsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//*[contains(text(),'Search Rental Car Deals')]")
    private List<WebElement> carsPageTitle;
    @FindBy(xpath = "//*[@class='tabs cf col']/li")
    private List<WebElement> carsTabs;
    @FindBy(xpath = "//*[@class='utility-nav nav-group cf']/li/a")
    private List<WebElement> headerTabs;
    @FindBy(xpath = "//*[@data-toggle-text='Advanced options']")
    private WebElement advancedOptionsMenu;
    @FindBy(xpath = "//*[@id='car-options-discount-clp']")
    private WebElement discountCodeDD;
    @FindBy(xpath = "//*[@id='car-options-vendor-clp']")
    private WebElement carCompanyDD;


    public String getSelectedOptionCarCompanyDD() {
        Select select = new Select(carCompanyDD);
        return select.getFirstSelectedOption().getText();
    }

    public CarsPage selectDiscountCode(String value) {
        Select select = new Select(discountCodeDD);
        select.selectByVisibleText(value);
        return this;
    }

    public CarsPage clickAdvancedOptions() {
        clickElement(advancedOptionsMenu);
        return this;
    }

    public boolean isDiscountCodeDDDisplayed() {
        return discountCodeDD.isDisplayed();
    }


    public boolean isCarsPageTitleDisplayed() {
        return isWebElementDisplayed(carsPageTitle, true);
    }

    public boolean isSecondWindowTitleCars() {
        switchToNewOpenedWindow();
        return isWebElementDisplayed(carsPageTitle, true);
    }

    public boolean isTabsAmountFour() {
        int size = wait.until(ExpectedConditions.visibilityOfAllElements(carsTabs)).size();
        return size == 4;
    }

    public CarsPage getWindows() {
        String flightsPage = driver.getWindowHandle();
        Set<String> pages = driver.getWindowHandles();
        for (String value : pages) {
            System.out.println(value);
        }
        return this;
    }
}
