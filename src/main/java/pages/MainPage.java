package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.CSVUtils;
import utils.Constants;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainPage extends BasePage {

    public MainPage() {
        super();
    }

    public MainPage(WebDriver webDriver, WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);
    }

    public void goToMainPage(){
        goToPage(configurationManager.getUrl());
    }

    public void goToLoginPage(){
        WebElement loginButton = webDriverWait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector(Constants.AUTHORIZATION_BUTTON_MAIN_PAGE_CSS_SELECTOR)));
        click(loginButton.findElement(By.cssSelector(Constants.LOGIN_PAGE_CSS_SELECTOR)));
    }

    public void goToRandomPopularTopic(){
        List<WebElement> popularTopics = getPopularTopics();
        int count = popularTopics.size();
        Random random = new Random(System.currentTimeMillis());
        int randomNumber = random.nextInt(count);
        webDriver.get(popularTopics.get(randomNumber).getAttribute("href").toString());
    }

    private List getPopularTopics(){
        List<WebElement> popularTopics =  webDriver.findElements(By.xpath(Constants.ALL_POPULAR_TOPICS_XPATH));
        return popularTopics;
    }

    public void getOpinionsFromMainPage(FileWriter writer) throws IOException {
        String pageSource = webDriver.getPageSource();
        List<String> opinions = new ArrayList<>();
        Pattern p = Pattern.compile("<div class=\"b-opinions-main-2__text\">((.*)+)<");
        Matcher m = p.matcher(pageSource);
        while (m.find()){
            opinions.add(m.group(1));
        }
        CSVUtils.writeLine(writer,opinions,'\n');
        writer.flush();
        writer.close();
    }
}
