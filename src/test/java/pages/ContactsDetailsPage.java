package pages;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactsDetailsPage extends BasePage {
    public static final By DETAILS_TAB = By.xpath("//div[contains(@class,'active')]//*[@id='detailTab__item']");

    public ContactsDetailsPage(WebDriver driver) {
        super(driver);
    }

    public ContactsDetailsPage openDetailsTab() {
        driver.findElement(DETAILS_TAB).click();
        return this;
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }

    public void validateContact(Contact contact) {
        validateElements("Account Name", new String[]{"TestTest"});
        validateElement("Title", contact.getTitle());
        validateElement("Email", contact.getEmail());
        validateElement("Phone", contact.getPhone());
        validateElement("Mobile", contact.getMobile());
        validateElement("Department", contact.getDepartment());
        validateElement("Fax", contact.getFax());
        validateElements("Mailing Address", new String[]{contact.getMailingCity(), contact.getMailingCountry(),
                contact.getMailingState(), contact.getMailingStreet(), contact.getMailingZipCode()});
    }
}
