package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public class SFDropDown {
    WebDriver driver;
    WebDriverWait wait;
    String label;
    String locator = "//*[contains(@class,'modal-body')]//*[text()='%s']/ancestor::*[contains(@class," +
            "'slds-form-element')]//a";
    String optionLocator = "//*[contains(@class,'uiMenuList') and contains(@class,'visible')]//a[@title='%s']";

    public SFDropDown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void select(String option) {
        log.debug(String.format("Writing text '%s' into input with label %s", option, label));
        WebElement element = driver.findElement(By.xpath(String.format(locator, label)));
        highlightElement(driver, element);
        element.click();
        wait = new WebDriverWait(driver, 3);
        element = driver.findElement(By.xpath(String.format(optionLocator, option)));
        highlightElement(driver, element);
        element.click();
    }

    public void highlightElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: #3cff3c; border: 2px solid red;');", element);
    }
}
