package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Input {
    WebDriver driver;
    String label;
    String locator;
    String baseInputLocator = "//*[contains(@class,'modal-body')]//*[text()='%s']/ancestor::";

    public Input(WebDriver driver, String label, String page) {
        if (page.equals("Account")) {
            locator = baseInputLocator + "div[contains(@class, 'uiInput')]//input";
        } else {
            locator = baseInputLocator + "*[contains(@class,'slds-form-element')]/div/input";
        }
        this.driver = driver;
        this.label = label;
    }

    public void write(String text) {
        System.out.printf("Writing text '%s' into input with label %s", text, label);
        //JS set style
        WebElement element = driver.findElement(By.xpath(String.format(locator, label)));
        element.sendKeys(text);
    }
}
