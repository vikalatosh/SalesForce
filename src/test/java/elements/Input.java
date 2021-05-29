package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static java.lang.String.format;

public class Input {
    WebDriver driver;
    String label;
    String inputLocator = "//*[contains(@class,'modal-body')]//*[text()='%s']/ancestor::" +
            "*[contains(@class,'slds-form-element')]/div/input";

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void write(String text) {
        System.out.printf("Writing text '%s' into input with label %s%n", text, label);
        //JS set style
        driver.findElement(By.xpath(format(inputLocator, label))).sendKeys(text);
    }
}
