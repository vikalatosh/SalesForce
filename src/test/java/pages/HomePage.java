package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    public static final By TITLE = By.xpath("//*[@title='Sales']");
    String titleContextBar = "//*[@title='%s']/span]";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return isExist(TITLE);
    }

    public HomePage contextBarOpen(String title) {
        driver.findElement(By.xpath(String.format(titleContextBar, title))).click();
        return new HomePage(driver);
    }
}
