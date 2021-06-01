package models;

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
    String leadStatus = "Unqualified";
    String salutation = "Dr.";
    String rating = "Cold";
    String industry = "Agriculture";
    String leadSource = "Advertisement";

    public Lead(String firstName, String middleName, String lastName, String suffix, String website, String title,
                String email, String phone, String mobile, String company, String numberOfEmployees, String street,
                String city, String zipCode, String state, String country) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
        this.website = website;
        this.title = title;
        this.email = email;
        this.phone = phone;
        this.mobile = mobile;
        this.company = company;
        this.numberOfEmployees = numberOfEmployees;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.state = state;
        this.country = country;
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

    public String getWebsite() {
        return website;
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

    public String getCompany() {
        return company;
    }

    public String getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getLeadStatus() {
        return leadStatus;
    }

    public String getSalutation() {
        return salutation;
    }

    public String getRating() {
        return rating;
    }

    public String getIndustry() {
        return industry;
    }

    public String getLeadSource() {
        return leadSource;
    }
}
