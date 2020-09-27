package com.verizon.lambda.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

public class Request {

    @Id
    @NotNull
    @JsonProperty("id")
    private String id;

    @JsonProperty("firstName")
    @NotNull
    private String firstName;

    @JsonProperty("middleName")
    private String middleName;

    @NotNull
    @JsonProperty("lastName")
    private String lastName;

    @NotNull
    @JsonProperty("role")
    private String role;

    @NotNull
    @JsonProperty("password")
    private String password;

    @NotNull
    @JsonProperty("designation")
    private String designation;

    @NotNull
    @JsonProperty("qualification")
    private String qualification;

    @NotNull
    @JsonProperty("dateOfBirth")
    private String dob;

    @NotNull
    @JsonProperty("dateOfJoining")
    private String doj;

    @NotNull
    @JsonProperty("department")
    private String department;

    @JsonProperty("email")
    private String email;

    @JsonProperty("phoneNo")
    private String phoneNo;

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

    public Request() {
//        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

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

    public Request(@NotNull String id, @NotNull String firstName, String middleName, @NotNull String lastName, @NotNull String role, @NotNull String password, @NotNull String designation, @NotNull String qualification, @NotNull String dob, @NotNull String doj, @NotNull String department, String email, String phoneNo, String addressLine1, String addressLine2, String city, String pincode, String country) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.role = role;
        this.password = password;
        this.designation = designation;
        this.qualification = qualification;
        this.dob = dob;
        this.doj = doj;
        this.department = department;
        this.email = email;
        this.phoneNo = phoneNo;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.pincode = pincode;
        this.country = country;
    }
}
