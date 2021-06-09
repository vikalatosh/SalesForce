package models;

import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class LeadFactory {

    public static Lead get() {
        log.info("Create new Lead");
        Faker faker = new Faker();
        return Lead.builder()
                .firstName(faker.name().firstName())
                .middleName("Alfredo")
                .lastName(faker.name().lastName())
                .suffix("1020058")
                .website("test.com")
                .title("fdhdghgh")
                .email("salesforcetest@gmail.com")
                .phone("5511566")
                .mobile("56165656")
                .company("TestRun")
                .numberOfEmployees("90")
                .street("wewvrwa")
                .city("gdrgdr")
                .zipCode("5846464")
                .state("wrrrw")
                .country("sgwsg")
                .salutation("Mr.")
                .leadStatus("Unqualified")
                .leadSource("Advertisement")
                .salutation("Dr.")
                .rating("Cold")
                .industry("Agriculture")
                .build();
    }
}
