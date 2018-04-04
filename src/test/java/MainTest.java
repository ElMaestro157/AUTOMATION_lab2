import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class MainTest extends BaseTest {

    @Test(priority = 1)
    public void openMainPage(){
        mainPage.goToMainPage();
        Assert.assertEquals(configurationManager.getUrl(),webDriver.getCurrentUrl());
    }

    @Test(priority = 2)
    public void authorization(){
        mainPage.goToLoginPage();
        boolean isError = loginPage.loginToSite(configurationManager.getLogin(),configurationManager.getPassword());
        Assert.assertEquals(false,isError);
    }

    @Test(priority = 3)
    public void openRandomPopularTopic(){
        mainPage.goToRandomPopularTopic();
        Assert.assertNotEquals(null,popularTopicPage.getTopicName());
        openMainPage();
    }

    @Test(priority = 4)
    public void getOpinionsFromMainPage() throws IOException {
        mainPage.getOpinionsFromMainPage(fileWriter);
    }

    @Test(priority = 5)
    public void signOut(){
        mainPage.signOut();
    }
}