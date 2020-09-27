package com.verizon.competency.notificationservice.model;

public class ResetPasswordRequest {
    String email;

    String token;

    public ResetPasswordRequest(String email, String token) {
        this.email = email;
        this.token = token;
    }

    public ResetPasswordRequest(){}

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
