package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Constants;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver webDriver, WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);
    }

    public boolean loginToSite(String loginOrEmail,String password){
        boolean checkAuthorization = false;
        Actions actions = new Actions(webDriver);

        WebElement loginForm = webDriverWait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Constants.AUTHORIZATION_BLOCK_CSS_SELECTOR)));

        writeText(loginForm.findElement(By.cssSelector(Constants.INPUT_LOGIN_OR_EMAIL_CSS_SELECTOR)),loginOrEmail);
        writeText(loginForm.findElement(By.cssSelector(Constants.INPUT_PASSWORD_CSS_SELECTOR)),password);

        webDriverWait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Constants.CAPTCHA_AUTHORIZATION_CSS_SELECTOR)));

        click(actions,loginForm.findElement(By.cssSelector(Constants.DEFAULT_BUTTON_CSS_SELECTOR)));

        if(webDriver.findElements(By.xpath(Constants.INCORRECT_LOGIN_OR_PASSWORD_AUTH_XPATH)).size() !=0 ){
            checkAuthorization = true;
        }

        return checkAuthorization;
    }
}
