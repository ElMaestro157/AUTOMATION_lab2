package utils;

import java.util.ResourceBundle;

public class ConfigurationManager {

    private String login;
    private String password;
    private String chromeBrowser;
    private String firefoxBrowser;
    private String iEBrowser;
    private String defaultBrowser;
    private String url;
    private String csvFileName;

    private ResourceBundle resources;

    public ConfigurationManager(){
        resources = ResourceBundle.getBundle("config");
        initSettings();
    }

    private void initSettings()
    {
        login = resources.getString("login");
        password = resources.getString("password");
        chromeBrowser = resources.getString("chromeBrowser");
        firefoxBrowser = resources.getString("firefoxBrowser");
        iEBrowser = resources.getString("IEBrowser");
        defaultBrowser = resources.getString("defaultBrowser");
        url = resources.getString("url");
        csvFileName = resources.getString("csvFileName");
    }

    public String getChromeBrowser() {
        return chromeBrowser;
    }

    public String getFirefoxBrowser() {
        return firefoxBrowser;
    }

    public String getiEBrowser() {
        return iEBrowser;
    }

    public String getUrl() {
        return url;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getCsvFileName() {
        return csvFileName;
    }

    public String getDefaultBrowser() {
        return defaultBrowser;
    }
}
