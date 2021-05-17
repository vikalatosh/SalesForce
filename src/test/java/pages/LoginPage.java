package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public static final By LOGIN_INPUT = By.id("username");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("Login");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
        return isExist(LOGIN_BUTTON);
    }

    public LoginPage open() {
        driver.get(BASE_URL);
        return this;
    }

    public HomePage login(String user, String password) {
        driver.findElement(LOGIN_INPUT).sendKeys(user);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new HomePage(driver);
    }
}
