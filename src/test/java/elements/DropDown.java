package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class DropDown {
    WebDriver driver;
    String label;
    String baseLocator = "//*[contains(@class,'modal-body')]//*[text()='%s']/ancestor::*[contains(@class," +
            "'slds-form-element')]";
    String optionLocator;

    public String locator() {
        try {
            String locator = baseLocator + "//a";
            driver.findElement(By.xpath(String.format(locator, label)));
            return locator;
        } catch (NoSuchElementException exception) {
            String locator = baseLocator + "//*[contains(@class,'slds-combobox_container')]//input";
            driver.findElement(By.xpath(String.format(locator, label)));
            return locator;
        }
    }

    public DropDown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void select(String option) {
        driver.findElement(By.xpath(String.format(locator(), label))).click();
        try {
            optionLocator = "//*[@class='select-options']//*[@title='%s']";
            driver.findElement(By.xpath(String.format(optionLocator, option))).click();
        } catch (NoSuchElementException exception) {
            optionLocator = "//*[contains(@class,'modal-body')]//*[contains(@class,'slds-form-element')]//*[@title='%s']";
            driver.findElement(By.xpath(String.format(optionLocator, option))).click();
        }
    }
}
