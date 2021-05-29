package pages;

import models.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountDetailsPage extends BasePage {

    public static final By DETAILS_TAB = By.xpath("//div[contains(@class,'active')]//*[@id='detailTab__item']");

    public AccountDetailsPage(WebDriver driver) {
        super(driver);
    }

    //TODO implement
    public boolean isPageOpened() {
        return false;
    }

    public AccountDetailsPage openDetailsTab() {
        driver.findElement(DETAILS_TAB).click();
        return this;
    }

    public void validateAccount(Account account) {
        validateElement("Account Name", account.getAccountName());
        validateElement("Phone", account.getPhone());
        validateElement("Website", account.getWebsite());
        validateElement("Employees", account.getEmployees());
        validateElement("Type", "Analyst");
        validateElement("Industry", "Banking");
        validateElement("Description", account.getDescription());
        validateElements("Billing Address", new String[]{account.getBillingCity(), account.getBillingCountry(),
                account.getBillingState(), account.getBillingStreet(), account.getBillingZipCode()});
        validateElements("Shipping Address", new String[]{account.getShippingCity(), account.getShippingCountry(),
                account.getShippingState(), account.getShippingStreet(), account.getShippingZipCode()});
    }
}
