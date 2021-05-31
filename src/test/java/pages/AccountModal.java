package pages;

import elements.DropDown;
import elements.Input;
import elements.TextArea;
import io.qameta.allure.Step;
import models.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountModal extends BasePage {
    public static final By SAVE_BUTTON = By.cssSelector("[title='Save']");
    public static final By ACCOUNTMODAL_TITLE = By.xpath("//h2[text()='New Account']");

    public AccountModal(WebDriver driver) {
        super(driver);
    }

    @Step("Checking Account modal page open")
    public boolean isPageOpened() {
        return isExist(ACCOUNTMODAL_TITLE);
    }

    @Step("Input data to crate new Account")
    public AccountDetailsPage create(Account account) {
        new Input(driver, "Account Name", "Account").write(account.getAccountName());
        new Input(driver, "Phone", "Account").write(account.getPhone());
        new Input(driver, "Website", "Account").write(account.getWebsite());
        new Input(driver, "Employees", "Account").write(account.getEmployees());
        new Input(driver, "Billing City", "Account").write(account.getBillingCity());
        new Input(driver, "Billing State/Province", "Account").write(account.getBillingState());
        new Input(driver, "Billing Zip/Postal Code", "Account").write(account.getBillingZipCode());
        new Input(driver, "Billing Country", "Account").write(account.getBillingCountry());
        new Input(driver, "Shipping Zip/Postal Code", "Account").write(account.getShippingZipCode());
        new Input(driver, "Shipping Country", "Account").write(account.getShippingCountry());
        new Input(driver, "Shipping City", "Account").write(account.getShippingCity());
        new Input(driver, "Shipping State/Province", "Account").write(account.getShippingState());
        new DropDown(driver, "Type", "Account").select("Analyst");
        new DropDown(driver, "Industry", "Account").select("Banking");
        new TextArea(driver, "Description").write(account.getDescription());
        new TextArea(driver, "Billing Street").write(account.getBillingStreet());
        new TextArea(driver, "Shipping Street").write(account.getShippingStreet());
        save();
        return new AccountDetailsPage(driver);
    }

    @Step("Click button Save")
    public void save() {
        driver.findElement(SAVE_BUTTON).click();
    }
}
