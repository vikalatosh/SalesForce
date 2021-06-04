package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ContactListPage extends BasePage {
    public static final By NEW_BUTTON = By.cssSelector("[title='New']");
    By icon = By.cssSelector("img[title='New Contact']");

    public ContactListPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return isExist(icon);
    }

    @Step("Open Contacts Page")
    public ContactListPage open() {
        log.info("Open Contacts Page");
        driver.get(BASE_URL + "lightning/o/Contact/list?filterName=Recent");
        return this;
    }

    @Step("Click the button New")
    public ContactModal clickNew() {
        log.info("Click the button New");
        driver.findElement(NEW_BUTTON).click();
        return new ContactModal(driver);
    }
}
