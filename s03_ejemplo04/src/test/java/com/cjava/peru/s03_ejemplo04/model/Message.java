package com.cjava.peru.s03_ejemplo04.model;

import java.io.Serializable;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;
import javax.persistence.Table;

 
@Entity
@Table(name="message")

public class Message implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="idMessage",nullable = false)
	int idMessage;
	String message;
	String dateMessage;
	
	@ManyToOne
	Campaign campaign;
	
	@OneToOne
	private Files files;

	/*@ManyToMany
	 * 
	@JoinTable(name="dialer.message_liscontact",
			joinColumns=@javax.persistence.JoinColumn(name
					="idmessage"),inverseJoinColumns=@javax.persistence.JoinColumn(
					name="idlistcontact"))
	List<Message> messag;	
	
	@OneToOne
	@JoinTable(name="dialer.message_files",
			joinColumns=@javax.persistence.JoinColumn(name
					="idmessage"),inverseJoinColumns=@javax.persistence.JoinColumn(
					name="idfile"))
	
	@OneToMany (mappedBy="option")
	List<Option>option;*/

	
	public Files getFiles() {
		return files;
	}

	public void setFiles(Files files) {
		this.files = files;
	}

	public String getDateMessage() {
		return dateMessage;
	}
	
	public void setDateMessage(String dateMessage) {
		this.dateMessage = dateMessage;
	}
	public Campaign getCampaign() {
		return campaign;
	}

	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}

	public int getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(int idMessage) {
		this.idMessage = idMessage;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}




}
