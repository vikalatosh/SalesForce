package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LightningDropDown {
    WebDriver driver;
    String label;
    String locator = "//*[contains(@class,'modal-body')]//*[text()='%s']/ancestor::*[contains(@class," +
            "'slds-form-element')]//*[contains(@class,'slds-combobox_container')]//input";
    String optionLocator = "//*[contains(@class,'modal-body')]//*[contains(@class,'slds-form-element')]//span[@title='%s']";

    public LightningDropDown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void select(String option) {
        driver.findElement(By.xpath(String.format(locator, label))).click();
        driver.findElement(By.xpath(String.format(optionLocator, option))).click();
    }
}
