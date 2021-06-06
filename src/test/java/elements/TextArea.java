package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
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
        log.info(String.format("Writing text '%s' into textarea with label %s%n", text, label));
        WebElement element = driver.findElement(By.xpath(String.format(textareaLocator, label)));
        highlightElement(driver, element);
        element.sendKeys(text);
    }

    public void highlightElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);
    }
}
