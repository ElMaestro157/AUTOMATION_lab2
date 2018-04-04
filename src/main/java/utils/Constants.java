package utils;

public class Constants {
    public static final String AUTHORIZATION_BUTTON_MAIN_PAGE_CSS_SELECTOR = ".auth-bar--top";
    public static final String LOGIN_PAGE_CSS_SELECTOR = ".auth-bar__item--text";
    public static final String AUTHORIZATION_BLOCK_CSS_SELECTOR = "#auth-container__forms";
    public static final String INPUT_LOGIN_OR_EMAIL_CSS_SELECTOR = "input[type='text']";
    public static final String INPUT_PASSWORD_CSS_SELECTOR = "input[type='password']";
    public static final String CAPTCHA_AUTHORIZATION_CSS_SELECTOR = "#captcha-box__login";
    public static final String INCORRECT_LOGIN_OR_PASSWORD_AUTH_XPATH =
            "//*[contains(@class,'auth-box__line auth-box__line--error js-error')]";
    public static final String DEFAULT_BUTTON_CSS_SELECTOR ="button";
    public static final String ALL_POPULAR_TOPICS_XPATH =
            "//*[contains(@class,'project-navigation__part project-navigation__part_1')]/ul/li/a";
    public static final String FAVORITE_TOPIC_NAME = "//*[contains(@class,'schema-header')]/h1";
    public static final String USER_BAR_XPATH = "//*[@id=\"userbar\"]/div/div/a";
    public static final String DROPDOWN_USER_PROFILE = "//*[@id=\"userbar\"]/div/div/div";
    public static final String BUTTON_LOGOUT_CSS_SELECTOR = ".b-top-profile__link_secondary";
}
