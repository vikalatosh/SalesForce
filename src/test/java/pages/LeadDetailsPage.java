package pages;

import io.qameta.allure.Step;
import models.Lead;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeadDetailsPage extends BasePage {
    public static final By DETAILS_TAB = By.xpath("//div[contains(@class,'active')]//*[@id='detailTab__item']");

    public LeadDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open Lead details page")
    public LeadDetailsPage openDetailsTab() {
        driver.findElement(DETAILS_TAB).click();
        return this;
    }

    public boolean isPageOpened() {
        return false;
    }

    @Step("Validate Lead")
    public void validateLead(Lead lead) {
        validateElement("Lead Status", lead.getLeadStatus());
        validateElement("Salutation", lead.getSalutation());
        validateElements("Name", new String[]{lead.getSalutation(), lead.getFirstName(), lead.getMiddleName(),
                lead.getLastName(), lead.getSuffix()});
        validateElement("Title", lead.getTitle());
        validateElement("Email", lead.getEmail());
        validateElement("Phone", lead.getPhone());
        validateElement("Mobile", lead.getMobile());
        validateElement("Rating", lead.getRating());
        validateElement("Website", lead.getWebsite());
        validateElement("Company", lead.getCompany());
        validateElement("Industry", lead.getIndustry());
        validateElement("No. of Employees", lead.getNumberOfEmployees());
        validateElement("Lead Source", lead.getLeadSource());
        validateElements("Address", new String[]{lead.getCity(), lead.getCountry(),
                lead.getState(), lead.getStreet(), lead.getZipCode()});
    }
}
