package pages;

import elements.DropDown;
import elements.Input;
import elements.TextArea;
import models.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountModal extends BasePage {
    public static final By SAVE_BUTTON = By.cssSelector("[title='Save']");
    public static final By MODAL_TITLE = By.cssSelector("//h2[text()='New Account']");

    public AccountModal(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return isExist(MODAL_TITLE);
    }

    public AccountDetailsPage create(Account account) {
        new Input(driver, "Account Name").write(account.getAccountName());
        new Input(driver, "Phone").write(account.getPhone());
        new Input(driver, "Website").write(account.getWebsite());
        new Input(driver, "Employees").write(account.getEmployees());
        new Input(driver, "Billing City").write(account.getBillingCity());
        new Input(driver, "Billing State/Province").write(account.getBillingState());
        new Input(driver, "Billing Zip/Postal Code").write(account.getBillingZipCode());
        new Input(driver, "Billing Country").write(account.getBillingCountry());
        new Input(driver, "Shipping Zip/Postal Code").write(account.getShippingZipCode());
        new Input(driver, "Shipping Country").write(account.getShippingCountry());
        new Input(driver, "Shipping City").write(account.getShippingCity());
        new Input(driver, "Shipping State/Province").write(account.getShippingState());
        new DropDown(driver, "Type").select("Analyst");
        new DropDown(driver, "Industry").select("Banking");
        new TextArea(driver, "Description").write(account.getDescription());
        new TextArea(driver, "Billing Street").write(account.getBillingStreet());
        new TextArea(driver, "Shipping Street").write(account.getShippingStreet());
        save();
        return new AccountDetailsPage(driver);
    }

    public void save() {
        driver.findElement(SAVE_BUTTON).click();
    }
}
