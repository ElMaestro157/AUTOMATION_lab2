package selenium;

import org.openqa.selenium.WebDriver;

public class WebBrowserSingleton {

    private static WebBrowserSingleton instance;
    private static WebDriver webDriver;

    private WebBrowserSingleton(String browserName){
        this.webDriver = BrowserFactory.getWebDriver(browserName);
    }

    public static WebBrowserSingleton newInstance(String browserName){

        if(browserName == null){
            browserName = "chrome";
        }

        if(instance == null){
            instance = new WebBrowserSingleton(browserName);
        }
        return instance;
    }

    public WebDriver getWebDriver(){
        return webDriver;
    }
}
