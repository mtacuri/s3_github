package com.cjava.peru.s03_ejemplo04.service;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class DataBase {
	
	private  static DataBase instance=null;
	private EntityManagerFactory factory=null;

	public static DataBase getInstance(){
		if(instance==null){
			instance=new DataBase();
		}
		return instance;
	}
public EntityManagerFactory getFactory(){
	try{
		if(factory==null){
			factory=Persistence.createEntityManagerFactory("PrjPersistence3");
	 }	
	}catch (Exception e){
		e.printStackTrace();
	} 
	return factory;
}
}
