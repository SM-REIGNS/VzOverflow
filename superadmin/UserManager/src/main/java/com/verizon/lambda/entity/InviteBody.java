package com.verizon.lambda.entity;

import java.io.Serializable;

public class InviteBody {
    String email;
    String password;
    String firstName;

    public InviteBody(String email, String password, String firstName) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public InviteBody(){}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
