package com.cjava.peru.s03_ejemplo04.dao;

import java.util.List;

import javax.persistence.EntityManager;
import org.hibernate.HibernateException;

import com.cjava.peru.s03_ejemplo04.model.Option;
import com.cjava.peru.s03_ejemplo04.service.DataBase;


public class OptionDAO {
	
	
	public Option create(Option option)  {
        try {
        	   EntityManager em = DataBase.getInstance().getFactory().createEntityManager();
               em.getTransaction().begin(); 
               em.persist(option);
               em.getTransaction().commit();
               em.close();
           } catch (Exception e) {
               e.printStackTrace();
           }
             return option;  
    }

    public Option delete(Option option)  {
    	 try {
    	        
      	   EntityManager em = DataBase.getInstance().getFactory().createEntityManager();
             em.getTransaction().begin(); 
             em.remove(option);
             em.getTransaction().commit();
             em.close();
         } catch (Exception e) {
             e.printStackTrace();
         }
           return option;  
        
  }

    }