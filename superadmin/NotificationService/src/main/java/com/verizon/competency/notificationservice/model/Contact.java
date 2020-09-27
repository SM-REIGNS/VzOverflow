package com.verizon.competency.notificationservice.model;

public class Contact {

    private String email;

    private String phoneNo;

    public Contact() {}

    public Contact(String email, String phoneNo) {
        this.email = email;
        this.phoneNo = phoneNo;
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
}
