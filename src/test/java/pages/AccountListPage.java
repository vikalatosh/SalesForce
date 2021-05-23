package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountListPage extends BasePage {
    public static final By NEW_BUTTON = By.cssSelector("[title='New']");
    By icon = By.cssSelector("img[title='Accounts']");

    public AccountListPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return isExist(icon);
    }

    public AccountListPage open() {
        driver.get(BASE_URL + "lightning/o/Account/list?filterName=Recent");
        return this;
    }

    public AccountModal clickNew() {
        driver.findElement(NEW_BUTTON).click();
        return new AccountModal(driver);
    }
}
