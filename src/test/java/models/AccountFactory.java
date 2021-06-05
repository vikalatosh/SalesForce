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
                .phone("375336575939")
                .website("tut.by")
                .employees("100")
                .billingCity(faker.address().city())
                .billingStreet("Talstoha Street")
                .billingState("Minsk")
                .billingZipCode("321123")
                .billingCountry("Belarus")
                .shippingZipCode("123123")
                .shippingCity("Moscow")
                .shippingCountry("Russia")
                .shippingState("Moscow")
                .description("There is test")
                .shippingStreet("Tverskaya Street")
                .type("Analyst")
                .industry("Banking")
                .build();
    }
}
