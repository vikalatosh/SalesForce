package tests;

import lombok.extern.log4j.Log4j2;
import models.Lead;
import models.LeadFactory;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertTrue;

@Log4j2
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
        Lead lead = LeadFactory.get();
        leadListPage
                .open()
                .clickNew()
                .create(lead)
                .openDetailsTab()
                .validateLead(lead);
    }
}
