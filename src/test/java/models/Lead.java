package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Lead {
    String firstName;
    String middleName;
    String lastName;
    String suffix;
    String website;
    String title;
    String email;
    String phone;
    String mobile;
    String company;
    String numberOfEmployees;
    String street;
    String city;
    String zipCode;
    String state;
    String country;
    String leadStatus;
    String salutation;
    String rating;
    String industry;
    String leadSource;
}
