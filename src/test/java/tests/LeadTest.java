package tests;

import models.Lead;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertTrue;

public class LeadTest extends BaseTest {
    @Test(description = "Lead should be created")
    public void leadShouldBeCreated() {
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
        Lead lead = new Lead("Joel", "Alfredo", "Tamiz", "1020058", "test.com",
                "fdhdghgh", "salesforcetest@gmail.com", "5511566", "56165656", "TestRun",
                "90", "wewvrwa", "gdrgdr", "5846464", "wrrrw", "sgwsg");
        leadListPage
                .open()
                .clickNew()
                .create(lead)
                .openDetailsTab()
                .validateLead(lead);
    }
}
