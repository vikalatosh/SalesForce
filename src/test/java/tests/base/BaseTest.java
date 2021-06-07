package tests.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.AccountListPage;
import pages.ContactListPage;
import pages.LeadListPage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

@Log4j2
@Listeners(TestListener.class)
public abstract class BaseTest {
    protected LoginPage loginPage;
    protected AccountListPage accountListPage;
    protected ContactListPage contactListPage;
    protected LeadListPage leadListPage;
    WebDriver driver;
    WebDriverWait wait;

    @Step("Open browser")
    @Parameters({"browser"})
    @BeforeMethod()
    public void setUp(@Optional("chrome") String browser, ITestContext testContext) {
        log.info("Open browser");
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
//            options.addArguments("--headless");
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
        } else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            driver = new EdgeDriver(options);
        }
        testContext.setAttribute("driver", driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        accountListPage = new AccountListPage(driver);
        contactListPage = new ContactListPage(driver);
        leadListPage = new LeadListPage(driver);
    }

    @Step("Close browser")
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        log.info("Close browser");
        driver.quit();
    }
}
