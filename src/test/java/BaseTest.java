import pages.LoginPage;
import pages.MainPage;
import pages.PopularTopicPage;
import utils.ConfigurationManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import selenium.WebBrowserSingleton;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver webDriver;
    public WebDriverWait webDriverWait;
    public FileWriter fileWriter;
    public MainPage mainPage;
    public LoginPage loginPage;
    public PopularTopicPage popularTopicPage;
    public ConfigurationManager configurationManager = new ConfigurationManager();

    @BeforeClass
    public void setup() throws IOException {
        webDriver = WebBrowserSingleton.newInstance(configurationManager.getDefaultBrowser()).getWebDriver();
        webDriverWait = new WebDriverWait(webDriver,15);

        mainPage = new MainPage(webDriver,webDriverWait);
        loginPage = new LoginPage(webDriver,webDriverWait);
        popularTopicPage = new PopularTopicPage(webDriver,webDriverWait);
        fileWriter = new FileWriter(configurationManager.getCsvFileName());

        webDriver.manage().window().maximize();
    }

    /*@AfterClass
    public void teardown(){
        webDriver.quit();
    }*/
}
