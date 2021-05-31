package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropDown {
    WebDriver driver;
    String label;
    String optionLocator;
    String locator;

    public DropDown(WebDriver driver, String label, String page) {
        String baseLocator = "//*[contains(@class,'modal-body')]//*[text()='%s']/ancestor::*[contains(@class," +
                "'slds-form-element')]";
        if (page.equals("Account")) {
            locator = baseLocator + "//a";
            optionLocator = "//*[contains(@class,'uiMenuList') and contains(@class,'visible')]//a[@title='%s']";
        } else {
            locator = baseLocator + "//*[contains(@class,'slds-combobox_container')]//input";
            optionLocator = "//*[contains(@class,'modal-body')]//*[contains(@class,'slds-form-element')]//*[@title='%s']";
        }
        this.driver = driver;
        this.label = label;
    }

    public void select(String option) {
        driver.findElement(By.xpath(String.format(locator, label))).click();
        driver.findElement(By.xpath(String.format(optionLocator, option))).click();
    }
}
