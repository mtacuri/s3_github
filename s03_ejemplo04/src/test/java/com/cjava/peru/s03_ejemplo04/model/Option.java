package com.cjava.peru.s03_ejemplo04.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="option")

public class Option {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="idOption",nullable = false)	
	int idOption;
	String option;
	
	@OneToOne
	private Message message;
	
	public int getIdOption() {
		return idOption;
	}
	public void setIdOption(int idOption) {
		this.idOption = idOption;
	}

	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	
	
}
