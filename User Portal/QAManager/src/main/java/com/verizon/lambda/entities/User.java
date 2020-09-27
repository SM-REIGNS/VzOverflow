package com.verizon.lambda.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/** This is the entity class for the respective document in mongoDB */


@Document("users_data")
public class User {

	/** entity properties */
	@Id
	private String id;

	private String role;
	private String password;
	private String designation;
	private String qualification;
	private String date_of_birth;
	private String date_of_joining;
	private String department;
	private Address address;
	private String first_name;
	private String middle_name;
	private String last_name;
	private String reportingManager;
	private Contact contact;



	/** Default constructor */
	public User() {

	}

	/** respective getter setters for the properties */

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getDate_of_joining() {
		return date_of_joining;
	}

	public void setDate_of_joining(String date_of_joining) {
		this.date_of_joining = date_of_joining;
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

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getReportingManager() {
		return reportingManager;
	}

	public void setReportingManager(String reportingManager) {
		this.reportingManager = reportingManager;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public User(String id, String role, String password, String designation, String qualification, String date_of_birth, String date_of_joining, String department, Address address, String first_name, String middle_name, String last_name, String reportingManager, Contact contact) {
		this.id = id;
		this.role = role;
		this.password = password;
		this.designation = designation;
		this.qualification = qualification;
		this.date_of_birth = date_of_birth;
		this.date_of_joining = date_of_joining;
		this.department = department;
		this.address = address;
		this.first_name = first_name;
		this.middle_name = middle_name;
		this.last_name = last_name;
		this.reportingManager = reportingManager;
		this.contact = contact;
	}
}

