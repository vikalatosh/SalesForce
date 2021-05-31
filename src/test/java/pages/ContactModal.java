package pages;

import elements.DropDown;
import elements.Input;
import elements.TextArea;
import io.qameta.allure.Step;
import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactModal extends BasePage {
    public static final By SAVE_BUTTON = By.xpath("//button[@name='SaveEdit']");
    public static final By MODAL_TITLE = By.cssSelector("//h2[text()='New Contact']");

    public ContactModal(WebDriver driver) {
        super(driver);
    }

    @Step("Checking Contact modal page open")
    public boolean isPageOpened() {
        return isExist(MODAL_TITLE);
    }

    @Step("Input data to crate new Contact")
    public ContactDetailsPage create(Contact contact) {
        new DropDown(driver, "Salutation", "Contact").select("Mr.");
        new Input(driver, "First Name", "Contact").write(contact.getFirstName());
        new Input(driver, "Middle Name", "Contact").write(contact.getMiddleName());
        new Input(driver, "Last Name", "Contact").write(contact.getLastName());
        new Input(driver, "Suffix", "Contact").write(contact.getSuffix());
        new DropDown(driver, "Account Name", "Contact").select("TestTest");
        new Input(driver, "Title", "Contact").write(contact.getTitle());
        new Input(driver, "Email", "Contact").write(contact.getEmail());
        new Input(driver, "Phone", "Contact").write(contact.getPhone());
        new Input(driver, "Mobile", "Contact").write(contact.getMobile());
        new Input(driver, "Department", "Contact").write(contact.getDepartment());
        new Input(driver, "Fax", "Contact").write(contact.getFax());
        new Input(driver, "Mailing City", "Contact").write(contact.getMailingCity());
        new TextArea(driver, "Mailing Street").write(contact.getMailingStreet());
        new Input(driver, "Mailing State/Province", "Contact").write(contact.getMailingState());
        new Input(driver, "Mailing Country", "Contact").write(contact.getMailingCountry());
        new Input(driver, "Mailing Zip/Postal Code", "Contact").write(contact.getMailingZipCode());
        save();
        return new ContactDetailsPage(driver);
    }

    @Step("Click button Save")
    public void save() {
        driver.findElement(SAVE_BUTTON).click();
    }
}
