package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Log4j2
public abstract class BasePage {
    public static final String BASE_URL = "https://erip.my.salesforce.com/";
    String locator = "//div[contains(@class,'active')]//span[text()='%s']/ancestor::force-record-layout-item//*[@slot='outputField']";

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    public abstract boolean isPageOpened();

    public boolean isExist(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public void validateElement(String label, String expected) {
        assertEquals(
                driver.findElement(By.xpath(String.format(locator, label))).getText(),
                expected,
                "Element " + label + " text is not correct"
        );
    }

    public void validateElements(String label, String[] expected) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath(String.format(locator, label)));
        js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);
        String addressText = element.getText();
        for (String s : expected) {
            boolean isAddressCorrect = addressText.contains(s);
            assertTrue(isAddressCorrect, "Element text is not correct");
        }
    }
}
