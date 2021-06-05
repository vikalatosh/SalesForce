package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LightningInput {
    WebDriver driver;
    String label;
    String locator = "//*[contains(@class,'modal-body')]//*[text()='%s']/ancestor::*[contains(@class," +
            "'slds-form-element')]/div/input";

    public LightningInput(WebDriver driver, String label) {
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
