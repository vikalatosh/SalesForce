package models;

public class Account {
    String accountName;
    String phone;
    String website;
    String employees;
    String billingCity;
    String billingState;
    String shippingCity;
    String shippingState;
    String billingZipCode;
    String billingCountry;
    String shippingZipCode;
    String shippingCountry;
    String description;
    String billingStreet;
    String shippingStreet;
    String type = "Analyst";
    String industry = "Banking";

    public Account(String accountName, String phone, String website, String employees, String billingCity,
                   String billingState, String billingZipCode, String billingCountry, String shippingZipCode,
                   String shippingCountry, String shippingCity, String shippingState, String description,
                   String billingStreet, String shippingStreet) {
        this.accountName = accountName;
        this.phone = phone;
        this.website = website;
        this.employees = employees;
        this.billingCity = billingCity;
        this.billingState = billingState;
        this.billingZipCode = billingZipCode;
        this.billingCountry = billingCountry;
        this.shippingCity = shippingCity;
        this.shippingState = shippingState;
        this.shippingZipCode = shippingZipCode;
        this.shippingCountry = shippingCountry;
        this.description = description;
        this.billingStreet = billingStreet;
        this.shippingStreet = shippingStreet;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public String getEmployees() {
        return employees;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public String getBillingState() {
        return billingState;
    }

    public String getShippingCity() {
        return shippingCity;
    }

    public String getShippingState() {
        return shippingState;
    }

    public String getBillingZipCode() {
        return billingZipCode;
    }

    public String getBillingCountry() {
        return billingCountry;
    }

    public String getShippingZipCode() {
        return shippingZipCode;
    }

    public String getShippingCountry() {
        return shippingCountry;
    }

    public String getDescription() {
        return description;
    }

    public String getBillingStreet() {
        return billingStreet;
    }

    public String getShippingStreet() {
        return shippingStreet;
    }

    public String getType() {
        return type;
    }

    public String getIndustry() {
        return industry;
    }
}
