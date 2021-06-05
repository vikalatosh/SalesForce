package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Lead;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
public class LeadDetailsPage extends BasePage {
    public static final By DETAILS_TAB = By.xpath("//div[contains(@class,'active')]//*[@id='detailTab__item']");
    public static final String MARK_STATUS_BUTTON = "//*[text()='Mark as Current Status']";
//    public static final By SHOW_DETAILS_BUTTON = By.xpath("//*[text()='Show Details']");

    public LeadDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open Lead details page")
    public LeadDetailsPage openDetailsTab() {
        log.info("Open Lead details page");
        WebElement element = driver.findElement(DETAILS_TAB);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        return this;
    }

    public boolean isPageOpened() {
        return false;
    }

    @Step("Validate Lead")
    public void validateLead(Lead lead) {
        log.info("Validate Lead");
        validateElement("Lead Status", lead.getLeadStatus());
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

    public void clickMarkStatus() {
        driver.findElement(By.xpath(MARK_STATUS_BUTTON)).click();
    }

    @Step("Open Convert Lead page")
    public ConvertLeadPage openConvertLeadPage() {
        log.info("Open Convert Lead page");
        clickMarkStatus();
        clickMarkStatus();
        clickMarkStatus();
        return new ConvertLeadPage(driver);
    }
}
