package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeadListPage extends BasePage {
    public static final By NEW_BUTTON = By.cssSelector("[title='New']");
    By icon = By.cssSelector("img[title='New Lead']");

    public LeadListPage(WebDriver driver) {
        super(driver);
    }

    @Step("Checking Lead modal page open")
    public boolean isPageOpened() {
        return isExist(icon);
    }

    @Step("Open Leads Page")
    public LeadListPage open() {
        driver.get(BASE_URL + "lightning/o/Lead/list?filterName=Recent");
        return this;
    }

    @Step("Click button New")
    public LeadModal clickNew() {
        driver.findElement(NEW_BUTTON).click();
        return new LeadModal(driver);
    }
}
