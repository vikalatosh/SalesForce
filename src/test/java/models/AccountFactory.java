package models;

import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class AccountFactory {

    public static Account get() {
        log.info("Create new Account");
        Faker faker = new Faker();
        return Account.builder()
                .accountName(faker.name().username())
                .phone("37592298798")
                .website("tut.by")
                .employees("150")
                .billingCity(faker.address().city())
                .billingStreet(faker.address().streetName())
                .billingState(faker.address().state())
                .billingZipCode(faker.address().zipCode())
                .billingCountry(faker.address().country())
                .shippingZipCode(faker.address().zipCode())
                .shippingCity(faker.address().city())
                .shippingCountry(faker.address().country())
                .shippingState(faker.address().state())
                .description("There is test")
                .shippingStreet(faker.address().streetName())
                .type("Analyst")
                .industry("Banking")
                .build();
    }
}
