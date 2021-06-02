package pages;

import elements.LightningDropDown;
import elements.LightningInput;
import elements.TextArea;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ContactModal extends BasePage {
    public static final By SAVE_BUTTON = By.xpath("//button[@name='SaveEdit']");
    public static final By MODAL_TITLE = By.cssSelector("//h2[text()='New Contact']");

    public ContactModal(WebDriver driver) {
        super(driver);
    }

    @Step("Checking Contact modal page open")
    public boolean isPageOpened() {
        log.info("Checking Contact modal page open");
        return isExist(MODAL_TITLE);
    }

    @Step("Input data to create new Contact")
    public ContactDetailsPage create(Contact contact) {
        log.info("Input data to create new Contact");
        new LightningDropDown(driver, "Salutation").select(contact.getSalutation());
        new LightningInput(driver, "First Name").write(contact.getFirstName());
        new LightningInput(driver, "Middle Name").write(contact.getMiddleName());
        new LightningInput(driver, "Last Name").write(contact.getLastName());
        new LightningInput(driver, "Suffix").write(contact.getSuffix());
        new LightningDropDown(driver, "Account Name").select(contact.getAccountName());
        new LightningInput(driver, "Title").write(contact.getTitle());
        new LightningInput(driver, "Department").write(contact.getDepartment());
        new LightningInput(driver, "Email").write(contact.getEmail());
        new LightningInput(driver, "Fax").write(contact.getFax());
        new LightningInput(driver, "Phone").write(contact.getPhone());
        new LightningInput(driver, "Mobile").write(contact.getMobile());
        new LightningInput(driver, "Mailing City").write(contact.getMailingCity());
        new TextArea(driver, "Mailing Street").write(contact.getMailingStreet());
        new LightningInput(driver, "Mailing State/Province").write(contact.getMailingState());
        new LightningInput(driver, "Mailing Country").write(contact.getMailingCountry());
        new LightningInput(driver, "Mailing Zip/Postal Code").write(contact.getMailingZipCode());
        save();
        return new ContactDetailsPage(driver);
    }

    @Step("Click button Save")
    public void save() {
        log.info("Click button Save");
        driver.findElement(SAVE_BUTTON).click();
    }
}
