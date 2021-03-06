package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ContactDetailsPage extends BasePage {
    public static final By DETAILS_TAB = By.xpath("//div[contains(@class,'active')]//*[@id='detailTab__item']");

    public ContactDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open Contact details page")
    public ContactDetailsPage openDetailsTab() {
        log.info("Open Contact details page");
        driver.findElement(DETAILS_TAB).click();
        return this;
    }

    @Step("Checking Contact details page is open")
    public boolean isPageOpened() {
        return false;
    }

    @Step("Validate Contact")
    public void validateContact(Contact contact) {
        log.info("Validate Contact");
        validateElements("Account Name", new String[]{contact.getAccountName()});
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
