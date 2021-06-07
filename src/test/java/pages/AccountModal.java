package pages;

import elements.SFDropDown;
import elements.SFInput;
import elements.TextArea;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
public class AccountModal extends BasePage {
    public static final By SAVE_BUTTON = By.xpath("//*[@title='Save']");
    public static final By ACCOUNTMODAL_TITLE = By.xpath("//h2[text()='New Account']");

    public AccountModal(WebDriver driver) {
        super(driver);
    }

    @Step("Checking Account modal page open")
    public boolean isPageOpened() {
        log.info("Checking Account modal page open");
        return isExist(ACCOUNTMODAL_TITLE);
    }

    @Step("Input data to create new Account")
    public AccountDetailsPage create(Account account) {
        log.info("Input data to create new Account");
        new SFInput(driver, "Account Name").write(account.getAccountName());
        new SFInput(driver, "Phone").write(account.getPhone());
        new SFInput(driver, "Website").write(account.getWebsite());
        new SFInput(driver, "Employees").write(account.getEmployees());
        new SFInput(driver, "Billing City").write(account.getBillingCity());
        new SFInput(driver, "Billing State/Province").write(account.getBillingState());
        new SFInput(driver, "Billing Zip/Postal Code").write(account.getBillingZipCode());
        new SFInput(driver, "Billing Country").write(account.getBillingCountry());
        new SFInput(driver, "Shipping Zip/Postal Code").write(account.getShippingZipCode());
        new SFInput(driver, "Shipping Country").write(account.getShippingCountry());
        new SFInput(driver, "Shipping City").write(account.getShippingCity());
        new SFInput(driver, "Shipping State/Province").write(account.getShippingState());
        new SFDropDown(driver, "Type").select(account.getType());
        new SFDropDown(driver, "Parent Account").select(account.getParentAccount());
        new SFDropDown(driver, "Industry").select(account.getIndustry());
        new TextArea(driver, "Description").write(account.getDescription());
        new TextArea(driver, "Billing Street").write(account.getBillingStreet());
        new TextArea(driver, "Shipping Street").write(account.getShippingStreet());
        save();
        return new AccountDetailsPage(driver);
    }

    @Step("Click the button Save")
    public void save() {
        log.info("Click the button Save");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(SAVE_BUTTON);
        js.executeScript("arguments[0].click();", element);
        element.click();
    }
}
