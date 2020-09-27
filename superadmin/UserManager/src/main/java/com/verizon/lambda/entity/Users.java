package com.verizon.lambda.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@Document("users")
public class Users implements Serializable {

	public Users() {

	}

	public Users(@NotNull String id, @NotNull String firstName, String middleName, @NotNull String lastName, @NotNull String role, @NotNull String password, @NotNull String designation, @NotNull String qualification, @NotNull String dob, @NotNull String doj, @NotNull String department, @NotNull Address address, @NotNull Contact contact) {
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
		this.address = address;
		this.contact = contact;
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

	@NotNull
	@JsonProperty("address")
	private Address address;

	@NotNull
	@JsonProperty("contact")
	private Contact contact;

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (obj == null || !(obj instanceof Users)) {
			return false;
		}
		Users u = (Users) obj;
		return u.id.equals(this.id);
	}

	@Override
	public int hashCode() {
		if (id == null) {
			return 0;
		}
		return id.hashCode();
	}

}
