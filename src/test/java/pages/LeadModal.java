package pages;

import elements.DropDown;
import elements.Input;
import io.qameta.allure.Step;
import models.Lead;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeadModal extends BasePage {
    public static final By SAVE_BUTTON = By.xpath("//button[@name='SaveEdit']");
    public static final By MODAL_TITLE = By.cssSelector("//h2[text()='New Lead']");

    public LeadModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isExist(MODAL_TITLE);
    }

    @Step("Input data to crate new Lead")
    public LeadDetailsPage create(Lead lead) {
        new DropDown(driver, "Lead Status", "Lead").select("Working");
        new DropDown(driver, "Salutation", "Lead").select("Dr.");
        new Input(driver, "First Name", "Lead").write(lead.getFirstName());
        new Input(driver, "Middle Name", "Lead").write(lead.getMiddleName());
        new Input(driver, "Last Name", "Lead").write(lead.getLastName());
        new Input(driver, "Suffix", "Lead").write(lead.getSuffix());
        new Input(driver, "Website", "Lead").write(lead.getWebsite());
        new Input(driver, "Title", "Lead").write(lead.getTitle());
        new Input(driver, "Email", "Lead").write(lead.getEmail());
        new Input(driver, "Phone", "Lead").write(lead.getPhone());
        new Input(driver, "Mobile", "Lead").write(lead.getMobile());
        new DropDown(driver, "Rating", "Lead").select("Cold");
        new Input(driver, "Company", "Lead").write(lead.getCompany());
        new DropDown(driver, "Industry", "Lead").select("Industry");
        new Input(driver, "No. of Employees", "Lead").write(lead.getNumberOfEmployees());
        new DropDown(driver, "Lead Source", "Lead").select("Lead Source");
        new Input(driver, "City", "Lead").write(lead.getCity());
        new Input(driver, "State/Province", "Lead").write(lead.getState());
        new Input(driver, "Country", "Lead").write(lead.getCountry());
        new Input(driver, "Zip/Postal Code", "Lead").write(lead.getZipCode());
        save();
        return new LeadDetailsPage(driver);
    }

    @Step("Click button Save")
    public void save() {
        driver.findElement(SAVE_BUTTON).click();
    }
}
