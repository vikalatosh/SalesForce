package models;

import com.github.javafaker.Faker;

public class ContactFactory {

    public static Contact get() {
        Faker faker = new Faker();
        return Contact.builder()
                .firstName(faker.name().firstName())
                .middleName("--")
                .lastName("Smith")
                .suffix("12222")
                .title("Title")
                .email("test@gmail.com")
                .phone("9379992")
                .mobile("375297365426")
                .department("department")
                .fax("321336516")
                .mailingStreet("6 vulica Talstoha")
                .mailingCity("Grodno")
                .mailingZipCode("220025")
                .mailingState("Grodno")
                .mailingCountry("Belarus")
                .salutation("Mr.")
                .accountName("TestTest")
                .build();
    }
}
