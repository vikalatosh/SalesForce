package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactsListPage extends BasePage {
    public static final By NEW_BUTTON = By.cssSelector("[title='New']");
    By icon = By.cssSelector("img[title='New Contact']");

    public ContactsListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isExist(icon);
    }

    public ContactsListPage open() {
        driver.get(BASE_URL + "lightning/o/Contact/list?filterName=Recent");
        return this;
    }

    public ContactModal clickNew() {
        driver.findElement(NEW_BUTTON).click();
        return new ContactModal(driver);
    }


}
