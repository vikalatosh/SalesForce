package pages;

import elements.LightningDropDown;
import elements.LightningInput;
import elements.TextArea;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Lead;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
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

    @Step("Input data to create new Lead")
    public LeadDetailsPage create(Lead lead) {
        log.info("Input data to create new Lead");
        new LightningDropDown(driver, "Lead Status").select(lead.getLeadStatus());
        new LightningInput(driver, "Website").write(lead.getWebsite());
        new LightningDropDown(driver, "Salutation").select(lead.getSalutation());
        new LightningInput(driver, "First Name").write(lead.getFirstName());
        new LightningInput(driver, "Middle Name").write(lead.getMiddleName());
        new LightningInput(driver, "Last Name").write(lead.getLastName());
        new LightningInput(driver, "Suffix").write(lead.getSuffix());
        new LightningInput(driver, "Title").write(lead.getTitle());
        new LightningInput(driver, "Email").write(lead.getEmail());
        new LightningInput(driver, "Company").write(lead.getCompany());
        new LightningDropDown(driver, "Industry").select(lead.getIndustry());
        new LightningInput(driver, "Phone").write(lead.getPhone());
        new LightningInput(driver, "Mobile").write(lead.getMobile());
        new LightningInput(driver, "Country").write(lead.getCountry());
        new LightningDropDown(driver, "Rating").select(lead.getRating());
        new LightningInput(driver, "No. of Employees").write(lead.getNumberOfEmployees());
        new LightningDropDown(driver, "Lead Source").select(lead.getLeadSource());
        new TextArea(driver, "Street").write(lead.getStreet());
        new LightningInput(driver, "City").write(lead.getCity());
        new LightningInput(driver, "State/Province").write(lead.getState());
        new LightningInput(driver, "Zip/Postal Code").write(lead.getZipCode());
        save();
        return new LeadDetailsPage(driver);
    }

    @Step("Click the button Save")
    public void save() {
        log.info("Click the button Save");
        driver.findElement(SAVE_BUTTON).click();
    }
}
