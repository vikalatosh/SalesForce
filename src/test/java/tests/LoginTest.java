package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test (description = "Login should be successful")
    public void login() {
        boolean isOpened = loginPage
                .open()
                .isPageOpened();
        assertTrue(isOpened, "Login Page не открылась");
        isOpened = loginPage
                .login("latosh.viktorija-xyh7@force.com", "password0")
                .isPageOpened();
        assertTrue(isOpened, "Home Page не открылась");
    }
}