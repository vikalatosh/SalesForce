package tests;

import models.Contact;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertTrue;

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
        Contact contact = new Contact("Tom", "--", "Smith", "12222",
                "TestTest", "Title", "test@gmail.com", "9379992",
                "375297365426", "department", "321336516", "6 vulica Talstoha",
                "Grodno", "220025", "Grodno", "Belarus");
        contactsListPage
                .open()
                .clickNew()
                .create(contact)
                .openDetailsTab()
                .validateContact(contact);
    }
}
