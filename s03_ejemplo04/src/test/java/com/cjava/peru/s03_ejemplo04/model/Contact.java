package com.cjava.peru.s03_ejemplo04.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.ManyToOne;

@Entity
@Table(name="contact")

public class Contact implements Serializable {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column (name="idcontact",nullable = false)
	int idcontact;
	String firstname;
	String lastname;
	double phone;
	String country;
	String email;
	
	@ManyToOne
	ListContact listContact;
	
	
	public Contact(String firstname, String lastname,
			double phone, String country, String email) {
		
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.country = country;
		this.email = email;
	}


	public Contact() {
		// TODO Auto-generated constructor stub
	}

	public ListContact getListContact() {
		return listContact;
	}

	public void setListContact(ListContact listContact) {
		this.listContact = listContact;
	}

	public int getIdContact() {
		return idcontact;
	}

	public void setIdContact(int idContact) {
		this.idcontact = idContact;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public double getPhone() {
		return phone;
	}

	public void setPhone(double phone) {
		this.phone = phone;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}