package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class AccountTest extends BaseTest {

    @Test
    public void addNewAccount() {
        boolean isOpened = loginPage
                .open()
                .isPageOpened();
        assertTrue(isOpened, "Login Page не открылась");
        isOpened = loginPage
                .login("latosh.viktorija-xyh7@force.com", "password0")
                .isPageOpened();
        assertTrue(isOpened, "Home Page не открылась");
//        homePage
//                .contextBarOpen("Accounts");
//        accountListPage.open();
        isOpened = addNewAccountPage
                .isPageOpened();
        assertTrue(isOpened, "AccountList Page не открылась");
        accountListPage.clickButtonNew();
        isOpened = addNewAccountPage
                .isPageOpened();
        assertTrue(isOpened, "AddNewAccount Page не открылась");
        addNewAccountPage.addNewAccount("ERIP", "https://raschet.by/", "+375336575939",
                "200", "6 vulica Talstoha");
    }
}
