package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextArea {
    WebDriver driver;
    String label;
    String textareaLocator = "//*[contains(@class,'modal-body')]//*[text()='%s']/" +
            "ancestor::*[contains(@class,'slds-form-element')]//textarea";

    public TextArea(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void write(String text) {
        System.out.printf("Writing text '%s' into textarea with label %s%n", text, label);
        //JS set style
        driver.findElement(By.xpath(String.format(textareaLocator, label))).sendKeys(text);
    }
}
