package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class LoginPage extends BasePage {
    public static final By LOGIN_INPUT = By.id("username");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("Login");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return isExist(LOGIN_BUTTON);
    }

    @Step("Open Login Page")
    public LoginPage open() {
        log.info("Open Login Page");
        driver.get(BASE_URL);
        return this;
    }

    @Step("login by user: {user}")
    public HomePage login(String user, String password) {
        log.info("login by user: {user}");
        driver.findElement(LOGIN_INPUT).sendKeys(user);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new HomePage(driver);
    }
}
