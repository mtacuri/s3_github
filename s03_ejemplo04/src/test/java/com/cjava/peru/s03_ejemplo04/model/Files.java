package com.cjava.peru.s03_ejemplo04.model;

import java.io.Serializable;
import java.sql.Blob;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="files")

public class Files implements Serializable {
@Id 	
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column (name="idfiles", columnDefinition = "serial", nullable = false)
	int idfiles;
	String name;
	Blob type;

//@OneToOne
//private Message message;  
	
	public Files() {	
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Blob getType() {
		return type;
	}
	public void setType(Blob type) {
		this.type = type;
	}

}
