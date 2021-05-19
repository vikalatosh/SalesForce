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
        validateInput("Account Name", account.getAccountName());
        validateAHref("Phone", account.getPhone());
        validateAHref("Website", account.getWebsite());
        validateNumber("Employees", account.getEmployees());
        validateInput("Type", "Analyst");
        validateInput("Industry", "Banking");
        validateInput("Description", account.getDescription());
        validateAddress("Billing Address", new String[]{account.getBillingCity(), account.getBillingCountry(),
                account.getBillingState(), account.getBillingStreet(), account.getBillingZipCode()});
        validateAddress("Shipping Address", new String[]{account.getShippingCity(), account.getShippingCountry(),
                account.getShippingState(), account.getShippingStreet(), account.getShippingZipCode()});
    }
}
