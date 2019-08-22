package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        actions = new Actions(driver);
    }

    public void clickElement(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void sendText(WebElement element, String text){
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }

    public boolean elementInvisible(WebElement element){
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public String getTextField(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }




}