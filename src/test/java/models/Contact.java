package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Contact {
    String firstName;
    String middleName;
    String lastName;
    String suffix;
    String title;
    String email;
    String phone;
    String mobile;
    String department;
    String fax;
    String mailingStreet;
    String mailingCity;
    String mailingZipCode;
    String mailingState;
    String mailingCountry;
    String salutation;
    String accountName;
}
