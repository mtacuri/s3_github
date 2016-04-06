package com.cjava.peru.s03_ejemplo04.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="return")

public class Return {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="idReturn",nullable = false)
	int idReturn;
	String date;

	
	@OneToOne
	private Message message;
	
	@OneToOne
	//(cascade={CascadeType.PERSIST,CascadeType.REMOVE})
	private Option option;
	

	/*@OneToOne
	@JoinTable(name="dialer.return_option", joinColumns=@javax.persistence.JoinColumn(name
			="idreturn"),inverseJoinColumns=@javax.persistence.JoinColumn(name
					="idoption"))
	List<Return> ret;
	
	
	@JoinTable(name="dialer.return_message", joinColumns=@javax.persistence.JoinColumn(name
			="idreturn"),inverseJoinColumns=@javax.persistence.JoinColumn(name
					="idmessage"))
					
	List<Message> message;*/


	public int getIdReturn() {
		return idReturn;
	}


	public void setIdReturn(int idReturn) {
		this.idReturn = idReturn;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public Message getMessage() {
		return message;
	}


	public void setMessage(Message message) {
		this.message = message;
	}


	public Option getOption() {
		return option;
	}


	public void setOption(Option option) {
		this.option = option;
	}
	
}
