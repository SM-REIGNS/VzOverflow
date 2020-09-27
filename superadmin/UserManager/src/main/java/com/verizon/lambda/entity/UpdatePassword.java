package com.verizon.lambda.entity;

public class UpdatePassword {
    String password;
    String confirmPassword;
    String token;
    public UpdatePassword(){}

    public UpdatePassword(String password, String confirmPassword, String token) {
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.token = token;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
