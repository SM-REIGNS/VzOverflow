package com.verizon.competency.notificationservice.model;

public class ResetPasswordBody {
    String password;
    String confirmPassword;
    ResetPasswordBody(){}

    public ResetPasswordBody(String password, String confirmPassword) {
        this.password = password;
        this.confirmPassword = confirmPassword;
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
}
