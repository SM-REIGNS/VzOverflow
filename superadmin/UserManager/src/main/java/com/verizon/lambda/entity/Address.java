package com.verizon.lambda.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {
    @JsonProperty("addressLine1")
    private String addressLine1;

    @JsonProperty("addressLine2")
    private String addressLine2;

    @JsonProperty("city")
    private String city;

    @JsonProperty("pincode")
    private String pincode;

    @JsonProperty("country")
    private String country;

    public Address() {}

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Address(String addressLine1, String addressLine2, String city, String pincode, String country) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.pincode = pincode;
        this.country = country;
    }
}
