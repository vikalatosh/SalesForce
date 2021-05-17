package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddNewAccountPage extends BasePage {

    public static final By SAVE_BUTTON = By.cssSelector("[title='Save']");
    String input = "//*[contains(@class, 'forcePageBlock')]//descendant::*[contains(text(), '%s')]//following::input";

    public AddNewAccountPage(WebDriver driver) {
        super(driver);
    }

    public WebElement findField(String name) {
        return driver.findElement(By.xpath(String.format(input, name)));
    }

    public void addNewAccount(String account, String site, String phone, String employees, String street) {
        findField("Account Name").sendKeys(account);
        findField("Website").sendKeys(site);
        findField("Phone").sendKeys(phone);
        findField("Employees").sendKeys(employees);
        findField("Billing Street").sendKeys(street);
        driver.findElement(SAVE_BUTTON).click();
    }

    @Override
    public boolean isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SAVE_BUTTON));
        return isExist(SAVE_BUTTON);
    }
}
