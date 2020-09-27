package com.verizon.lambda.entities;

import java.util.ArrayList;

public class Address {

	
	private String city;
	
	private String zipcode;
	
	private String country;
	
	
	private ArrayList<String> phonenums;


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getZipcode() {
		return zipcode;
	}


	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public ArrayList<String> getPhonenums() {
		return phonenums;
	}


	public void setPhonenums(ArrayList<String> phonenums) {
		this.phonenums = phonenums;
	}


	public Address(String city, String zipcode, String country, ArrayList<String> phonenums) {
		super();
		this.city = city;
		this.zipcode = zipcode;
		this.country = country;
		this.phonenums = phonenums;
	}




	
	 
	
	
	
	
	
	
}
