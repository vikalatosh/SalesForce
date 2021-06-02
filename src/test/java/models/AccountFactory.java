package models;

import com.github.javafaker.Faker;

public class AccountFactory {

    public static Account get() {
        Faker faker = new Faker();
        return Account.builder()
                .accountName("Test")
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
