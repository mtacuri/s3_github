package com.cjava.peru.s03_ejemplo04.model;


import java.io.Serializable;
import java.util.List;
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
@Table(name="service")

public class Service implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="idService",nullable = false)
	int idService;
	String nombre;
	String description;
	
	 @OneToMany
	   (mappedBy="service")
		 private Set<Campaign>campaign;
	
	/*@ManyToOne
	@JoinTable(name="dialer.service_liscontact",
			joinColumns=@javax.persistence.JoinColumn(name="service_id"),
			inverseJoinColumns=@javax.persistence.JoinColumn(name="listcont_id"))
			List<ListContact>listcontact;*/
	
	public int getIdService() {
		return idService;
	}

	public void setIdService(int idService) {
		this.idService = idService;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Campaign> getCampaign() {
		return campaign;
	}

	public void setCampaign(Set<Campaign> campaign) {
		this.campaign = campaign;
	}

	/*public List<ListContact> getListcontact() {
		return listcontact;
	}

	public void setListcontact(List<ListContact> listcontact) {
		this.listcontact = listcontact;
	}*/


}
