package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class AccountListPage extends BasePage {
    public static final By NEW_BUTTON = By.cssSelector("[title='New']");
    By icon = By.cssSelector("img[title='Accounts']");

    public AccountListPage(WebDriver driver) {
        super(driver);
    }

    @Step("Checkout Accountlist page is open")
    public boolean isPageOpened() {
        log.info("Open Account List page");
        return isExist(icon);
    }

    @Step("Open Accounts page")
    public AccountListPage open() {
        log.info("Open Accounts page");
        driver.get(BASE_URL + "lightning/o/Account/list?filterName=Recent");
        return this;
    }

    @Step("Click button New")
    public AccountModal clickNew() {
        log.info("Click button New");
        driver.findElement(NEW_BUTTON).click();
        return new AccountModal(driver);
    }
}
