package tests;

import models.Account;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertTrue;

public class AccountTest extends BaseTest {

    @Test (description = "Account should be created")
    public void accountShouldBeCreated() {
        boolean isOpened = loginPage
                .open()
                .isPageOpened();
        assertTrue(isOpened, "Login Page не открылась");
        isOpened = loginPage
                .login("latosh.viktorija-xyh7@force.com", "password0")
                .isPageOpened();
        assertTrue(isOpened, "Home Page не открылась");
        //FACTORY
        //BUILDER
        //RANDOM DATA
        Account account = new Account("Test", "375336575939", "tut.by", "100",
                "Minsk", "Minsk", "321123", "Belarus", "123123",
                "Russia", "Moscow", "Moscow", "There is test",
                "Talstoha Street", "Tverskaya Street");
        accountListPage
                .open()
                .clickNew()
                .create(account)
                .openDetailsTab()
                .validateAccount(account);
    }
}
