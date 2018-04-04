package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Constants;

public class PopularTopicPage extends BasePage {

    public PopularTopicPage(WebDriver webDriver, WebDriverWait webDriverWait){
        super(webDriver,webDriverWait);
    }

    public String getTopicName(){
        String name = webDriverWait.until(new ExpectedCondition<String>() {
            public String apply(WebDriver d) {
                return readText(By.xpath(Constants.FAVORITE_TOPIC_NAME));
            }
        });

        return name;
    }
}