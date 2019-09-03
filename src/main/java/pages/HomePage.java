package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage {


    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//*[@id='cupid-weekendgetaways-container']//a[@class='flex-link']")
    private List<WebElement> weekendGetawaysLinks;
    @FindBy(xpath = "//*[@id='cupid-popdestinations-title']")
    private WebElement popularDestinationTitle;


    public void  weekendGetawaysLinks() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        Thread.sleep(500);
        jse.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(500);
       List<WebElement> list =  driver.findElements(By.xpath("//*[@id='cupid-weekendgetaways-container']//a[@class='flex-link']"));
        System.out.println(list.size());
       // weekendGetawaysLinks.stream().forEach(element -> System.out.println(element));
    }



}

