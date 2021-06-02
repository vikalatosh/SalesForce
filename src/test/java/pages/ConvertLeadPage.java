package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ConvertLeadPage extends BasePage {
    public static final By MODAL_TITLE = By.cssSelector("//h2[contains(text(),'Convert Lead')]");
    public static final By CONVERT_BUTTON = By.xpath("//*[text()='Convert']");

    public ConvertLeadPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isExist(MODAL_TITLE);
    }

    public LeadListPage convertNewLead() {
        driver.findElement(CONVERT_BUTTON).click();
        return new LeadListPage(driver);
    }

//    public ConvertLeadPage convertChooseExisting() {
//        //
//        return this;
//    }
}
