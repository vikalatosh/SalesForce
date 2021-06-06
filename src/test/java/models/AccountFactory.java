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
                .billingCity("Minsk")
                .billingStreet("6 vulica Talstoha")
                .billingState("Minsk")
                .billingZipCode("321123")
                .billingCountry("Belarus")
                .shippingZipCode("123123")
                .shippingCity("Moscow")
                .shippingCountry("Russia")
                .shippingState("Moscow")
                .description("There is test")
                .shippingStreet("6 vulica Talstoha")
                .type("Analyst")
                .industry("Banking")
                .build();
    }
}
