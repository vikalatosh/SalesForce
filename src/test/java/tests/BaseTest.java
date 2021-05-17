package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import pages.AccountListPage;
import pages.AddNewAccountPage;
import pages.HomePage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    AccountListPage accountListPage;
    AddNewAccountPage addNewAccountPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
    }

//    @AfterMethod(alwaysRun = true)
//    public void tearDown() {
//        driver.quit();
//    }
}
