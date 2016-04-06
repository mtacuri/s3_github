package com.cjava.peru.s03_ejemplo04.model;

import java.io.Serializable;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;


@Entity
@Table(name="campaign")

public class Campaign implements Serializable{
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="idCampaign",nullable = false)
	int idCampaign;
	String name;
	String date;

	
	@ManyToOne
	Service service;
	
	
	@OneToMany
	   (mappedBy="campaign")
		 private Set<ListContact>listContact;
	 
	@OneToMany
	   (mappedBy="campaign")
		 private Set<Message>message;

	public Set<Message> getMessage() {
		return message;
	}
	public void setMessage(Set<Message> message) {
		this.message = message;
	}
	public String getName() {
		return name;
	}
	public Set<ListContact> getListContact() {
		return listContact;
	}
	public void setListContact(Set<ListContact> listContact) {
		this.listContact = listContact;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public int getIdCampaign() {
		return idCampaign;
	}
	public void setIdCampaign(int idCampaign) {
		this.idCampaign = idCampaign;
	}
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	
	
}
