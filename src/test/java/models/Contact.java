package models;

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
    String salutation = "Mr.";
    String accountName = "TestTest";

    public Contact(String firstName, String middleName, String lastName, String suffix, String title, String email,
                   String phone, String mobile, String department, String fax, String mailingStreet, String mailingCity,
                   String mailingZipCode, String mailingState, String mailingCountry) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
        this.title = title;
        this.email = email;
        this.phone = phone;
        this.mobile = mobile;
        this.department = department;
        this.fax = fax;
        this.mailingStreet = mailingStreet;
        this.mailingCity = mailingCity;
        this.mailingZipCode = mailingZipCode;
        this.mailingState = mailingState;
        this.mailingCountry = mailingCountry;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSuffix() {
        return suffix;
    }

    public String getTitle() {
        return title;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getMobile() {
        return mobile;
    }

    public String getDepartment() {
        return department;
    }

    public String getFax() {
        return fax;
    }

    public String getMailingStreet() {
        return mailingStreet;
    }

    public String getMailingZipCode() {
        return mailingZipCode;
    }

    public String getMailingState() {
        return mailingState;
    }

    public String getMailingCity() {
        return mailingCity;
    }

    public String getMailingCountry() {
        return mailingCountry;
    }

    public String getSalutation() {
        return salutation;
    }

    public String getAccountName() {
        return accountName;
    }
}
