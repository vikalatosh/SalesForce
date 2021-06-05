package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        driver.get(BASE_URL + "lightning/o/Contact/list?filterName=Recent");
        return this;
    }

    @Step("Click button New")
    public ContactModal clickNew() {
        driver.findElement(NEW_BUTTON).click();
        return new ContactModal(driver);
    }
}
