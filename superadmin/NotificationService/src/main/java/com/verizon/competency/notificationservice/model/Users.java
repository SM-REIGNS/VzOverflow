package com.verizon.competency.notificationservice.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "users")
public class Users implements Serializable {
    public Users() {}

    @Id
    private String id;

    private String empFirstName;

    private String empMiddleName;

    private String empLastName;

    private String role;

    private String password;

    private String designation;

    private String qualification;

    private String dob;

    private String doj;

    private String department;

    private Address address;

    private Contact contact;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmpFirstName() {
        return empFirstName;
    }

    public void setEmpFirstName(String empFirstName) {
        this.empFirstName = empFirstName;
    }

    public String getEmpMiddleName() {
        return empMiddleName;
    }

    public void setEmpMiddleName(String empMiddleName) {
        this.empMiddleName = empMiddleName;
    }

    public String getEmpLastName() {
        return empLastName;
    }

    public void setEmpLastName(String empLastName) {
        this.empLastName = empLastName;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Users(String id, String empFirstName, String empMiddleName, String empLastName, String role, String password, String designation, String qualification, String dob, String doj, String department, Address address, Contact contact) {
        this.id = id;
        this.empFirstName = empFirstName;
        this.empMiddleName = empMiddleName;
        this.empLastName = empLastName;
        this.role = role;
        this.password = password;
        this.designation = designation;
        this.qualification = qualification;
        this.dob = dob;
        this.doj = doj;
        this.department = department;
        this.address = address;
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Users{" +
                "empId='" + id + '\'' +
                ", empFirstName='" + empFirstName + '\'' +
                ", empMiddleName='" + empMiddleName + '\'' +
                ", empLastName='" + empLastName + '\'' +
                '}';
    }
}
