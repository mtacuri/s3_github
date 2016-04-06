package com.cjava.peru.s03_ejemplo04.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.HibernateException;

import com.cjava.peru.s03_ejemplo04.service.DataBase;

import com.cjava.peru.s03_ejemplo04.model.Contact;
import com.cjava.peru.s03_ejemplo04.model.Files;

public class ContactDAO {

 public Contact create(Contact contact)  {
        try {
        	   EntityManager em = DataBase.getInstance().getFactory().createEntityManager();
               em.getTransaction().begin(); 
               em.persist(contact);
               em.getTransaction().commit();
               em.close();
           } catch (Exception e) {
               e.printStackTrace();
           }
             return contact;  
    }

    public Contact delete(Contact contact)  {
    	 try {
    	        
      	   EntityManager em = DataBase.getInstance().getFactory().createEntityManager();
             em.getTransaction().begin(); 
             em.remove(contact);
             em.getTransaction().commit();
             em.close();
         } catch (Exception e) {
             e.printStackTrace();
         }
           return contact;  
        
  }

   /* public Contact find(Contact contac) {
    	Contact contact = null;
        try {
        	 EntityManager em = DataBase.getInstance().getFactory().createEntityManager();
             em.getTransaction().begin();
            contact = (Contact)em.find(Contact.class, contac);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
          return contact;  
       
 }*/
    
    public Contact find(int id)  {
    	Contact contact = null;
        try {
        	EntityManager em = DataBase.getInstance().getFactory().createEntityManager();
            em.getTransaction().begin();
            contact = (Contact) em.find(Contact.class, id);
            em.getTransaction().commit();
        } catch (HibernateException e) {
        }
        return contact;
    }

    public Contact update(Contact contact) {
     	Contact contactCreate = null;
        try {
        	 EntityManager em = DataBase.getInstance().getFactory().createEntityManager();
             em.getTransaction().begin();
             contactCreate = em.merge(contact);
             em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
          return contactCreate;  
       
 }

    public List findAll() {
        List contact = null;
        try {
        	EntityManager em = DataBase.getInstance().getFactory().createEntityManager();
             em.getTransaction().begin();   
             contact  = (List)em.createQuery("from Contact");
             em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
          return contact;  
       
 }
    
    public List Count() {
        List contact = null;
        try {
        	EntityManager em = DataBase.getInstance().getFactory().createEntityManager();
             em.getTransaction().begin();   
             contact  = (List)em.createQuery("SELECT COUNT(firstname) AS Cantidad from Contact");
             em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
          return contact;  
          
          
          
    }

}
