package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class AccountDetailsPage extends BasePage {

    public static final By DETAILS_TAB = By.xpath("//div[contains(@class,'active')]//*[@id='detailTab__item']");

    public AccountDetailsPage(WebDriver driver) {
        super(driver);
    }

    //TODO implement
    public boolean isPageOpened() {
        return false;
    }

    @Step("Open Account details page")
    public AccountDetailsPage openDetailsTab() {
        log.info("Open Account details page");
        driver.findElement(DETAILS_TAB).click();
        return this;
    }

    @Step("Validate Account")
    public void validateAccount(Account account) {
        log.info("Validate Account");
        validateElement("Account Name", account.getAccountName());
        validateElement("Phone", account.getPhone());
        validateElement("Website", account.getWebsite());
        validateElement("Employees", account.getEmployees());
        validateElement("Type", account.getType());
        validateElement("Industry", account.getIndustry());
        validateElement("Description", account.getDescription());
        validateElements("Billing Address", new String[]{account.getBillingCity(), account.getBillingCountry(),
                account.getBillingState(), account.getBillingStreet(), account.getBillingZipCode()});
        validateElements("Shipping Address", new String[]{account.getShippingCity(), account.getShippingCountry(),
                account.getShippingState(), account.getShippingStreet(), account.getShippingZipCode()});
    }
}
