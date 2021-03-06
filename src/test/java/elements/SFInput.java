package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
public class SFInput {
    WebDriver driver;
    String label;
    String locator = "//*[contains(@class,'modal-body')]//*[text()='%s']/ancestor::div[contains(@class, 'uiInput')]//input";

    public SFInput(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void write(String text) {
        log.debug(String.format("Writing text '%s' into input with label %s", text, label));
        WebElement element = driver.findElement(By.xpath(String.format(locator, label)));
        element.sendKeys(text);
    }
}
