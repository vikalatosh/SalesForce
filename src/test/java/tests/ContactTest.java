package tests;

import lombok.extern.log4j.Log4j2;
import models.Contact;
import models.ContactFactory;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertTrue;

@Log4j2
public class ContactTest extends BaseTest {

    @Test(description = "Contact should be created")
    public void contactShouldBeCreated() {
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
        Contact contact = ContactFactory.get();
        contactListPage
                .open()
                .clickNew()
                .create(contact)
                .openDetailsTab()
                .validateContact(contact);
    }
}
