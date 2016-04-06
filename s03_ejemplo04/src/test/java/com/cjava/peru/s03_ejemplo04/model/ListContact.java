package com.cjava.peru.s03_ejemplo04.model;

import java.io.Serializable;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="listcontact")

public class ListContact implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JoinColumn (name="idlistcontact",nullable = false)
	int idlistcontact;
	String name;
	String description;
	
    @OneToMany
   (mappedBy="listContact")
	 private Set<Contact>contact;
    
	@ManyToOne
	Campaign campaign;

	public ListContact(String string, String string2) {
		// TODO Auto-generated constructor stub
	}

	public ListContact(String name, String description,
			Set<Contact> contact) {
		this.name = name;
		this.description = description;
		this.contact = contact;
	}
	public ListContact() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<Contact> getContact() {
		return contact;
	}
	public void setContact(Set<Contact> contact) {
		this.contact = contact;
	}

	public int getIdlistcontact() {
		return idlistcontact;
	}

	public void setIdlistcontact(int idlistcontact) {
		this.idlistcontact = idlistcontact;
	}

	public Campaign getCampaign() {
		return campaign;
	}

	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}
	
}
