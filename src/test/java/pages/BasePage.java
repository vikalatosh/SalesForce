package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public abstract class BasePage {
    public static final String BASE_URL = "https://erip.my.salesforce.com/";
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

    public void validateInput(String label, String expected) {
        String locator = "//div[contains(@class,'active')]//span[text()='%s']" +
                "/ancestor::force-record-layout-item//lightning-formatted-text";
        assertEquals(
                driver.findElement(By.xpath(String.format(locator, label))).getText(),
                expected, "Input text is not correct"
        );
    }

    public void validateAHref(String label, String expected) {
        String locator = "//div[contains(@class,'active')]//span[text()='%s']" +
                "/ancestor::force-record-layout-item//a";
        assertEquals(
                driver.findElement(By.xpath(String.format(locator, label))).getText(),
                expected, "A text is not correct"
        );
    }

    public void validateAddress(String label, String[] expected) {
        String locator = "//div[contains(@class,'active')]//span[text()='%s']" +
                "/ancestor::force-record-layout-item//lightning-formatted-address/a";
        String addressText = driver.findElement(By.xpath(String.format(locator, label))).getText();
        for (String s : expected) {
            boolean isAddressCorrect = addressText.contains(s);
            assertTrue(isAddressCorrect, "Address text is not correct");
        }
    }

    public void validateNumber(String label, String expected) {
        String locator = "//div[contains(@class,'active')]//span[text()='%s']" +
                "/ancestor::force-record-layout-item//lightning-formatted-number";
        assertEquals(
                driver.findElement(By.xpath(String.format(locator, label))).getText(),
                expected, "Employees number is not correct"
        );
    }
}
