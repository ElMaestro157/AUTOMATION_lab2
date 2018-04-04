package pages;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ConfigurationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Constants;

import org.openqa.selenium.support.ui.ExpectedCondition;
import java.util.concurrent.TimeUnit;

public class BasePage {

    public WebDriver webDriver;
    public WebDriverWait webDriverWait;
    public ConfigurationManager configurationManager;

    public BasePage() {
    }

    public BasePage(WebDriver webDriver, WebDriverWait webDriverWait) {
        this.webDriver = webDriver;
        this.webDriverWait = webDriverWait;
        this.configurationManager = new ConfigurationManager();
    }

    public void goToPage(String url){
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get(url);
    }

    public void click (Actions action, WebElement webElement){
        action.moveToElement(webElement);
        action.click().build().perform();
    }

    public void click(WebElement webElement){
        webElement.click();
    }

    public void signOut(){
        WebElement userBar = webDriverWait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(Constants.USER_BAR_XPATH)));
        userBar.click();

        WebElement dropDownMenu = webDriverWait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(Constants.DROPDOWN_USER_PROFILE)));
        dropDownMenu.findElement(By.cssSelector(Constants.BUTTON_LOGOUT_CSS_SELECTOR)).click();
    }

    public void writeText(By elementLocation, String text){
        webDriver.findElement(elementLocation).sendKeys(text);
    }

    public void writeText(WebElement elementLocation, String text){
        elementLocation.sendKeys(text);
    }

    public String readText(By elementLocation){
        return webDriver.findElement(elementLocation).getText();
    }
}
