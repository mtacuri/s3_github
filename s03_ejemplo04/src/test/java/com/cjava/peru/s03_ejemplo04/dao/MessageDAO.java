package com.cjava.peru.s03_ejemplo04.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.HibernateException;
import com.cjava.peru.s03_ejemplo04.model.Message;

import com.cjava.peru.s03_ejemplo04.service.DataBase;


public class MessageDAO {

	
	public Message create(Message message)  {
        try {
        	   EntityManager em = DataBase.getInstance().getFactory().createEntityManager();
               em.getTransaction().begin(); 
               em.persist(message);
               em.getTransaction().commit();
               em.close();
           } catch (Exception e) {
               e.printStackTrace();
           }
             return message;  
    }

    public Message delete(Message message)  {
    	 try {
    	        
      	   EntityManager em = DataBase.getInstance().getFactory().createEntityManager();
             em.getTransaction().begin(); 
             em.remove(message);
             em.getTransaction().commit();
             em.close();
         } catch (Exception e) {
             e.printStackTrace();
         }
           return message;  
        
  }

  

    public Message update(Message message) {
     	Message create = null;
        try {
        	 EntityManager em = DataBase.getInstance().getFactory().createEntityManager();
             em.getTransaction().begin();
             create = em.merge(message);
             em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
          return create;  
       
 }

  }