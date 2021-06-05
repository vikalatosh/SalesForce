package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SFDropDown {
    WebDriver driver;
    String label;
    String locator = "//*[contains(@class,'modal-body')]//*[text()='%s']/ancestor::*[contains(@class," +
            "'slds-form-element')]//a";
    String optionLocator = "//*[contains(@class,'uiMenuList') and contains(@class,'visible')]//a[@title='%s']";

    public SFDropDown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void select(String option) {
        driver.findElement(By.xpath(String.format(locator, label))).click();
        driver.findElement(By.xpath(String.format(optionLocator, option))).click();
    }
}
