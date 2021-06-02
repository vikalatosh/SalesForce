package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class LeadListPage extends BasePage {
    public static final By NEW_BUTTON = By.cssSelector("[title='New']");
    By icon = By.cssSelector("img[title='New Lead']");

    public LeadListPage(WebDriver driver) {
        super(driver);
    }

    @Step("Checking Lead modal page open")
    public boolean isPageOpened() {
        log.info("Checking Lead modal page open");
        return isExist(icon);
    }

    @Step("Open Leads Page")
    public LeadListPage open() {
        log.info("Open Leads Page");
        driver.get(BASE_URL + "lightning/o/Lead/list?filterName=Recent");
        return this;
    }

    @Step("Click button New")
    public LeadModal clickNew() {
        log.info("Click button New");
        driver.findElement(NEW_BUTTON).click();
        return new LeadModal(driver);
    }
}
