package com.cjava.peru.s03_ejemplo04.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.HibernateException;


import com.cjava.peru.s03_ejemplo04.model.ListContact;

import com.cjava.peru.s03_ejemplo04.service.DataBase;


public class ListContactDAO {
	
	public ListContact create(ListContact listContact)  {
        try {
        	   EntityManager em = DataBase.getInstance().getFactory().createEntityManager();
               em.getTransaction().begin(); 
               em.persist(listContact);
               em.getTransaction().commit();
               em.close();
           } catch (Exception e) {
               e.printStackTrace();
           }
             return listContact;  
    }

    public ListContact delete(ListContact listContact)  {
    	 try {
    	        
      	   EntityManager em = DataBase.getInstance().getFactory().createEntityManager();
             em.getTransaction().begin(); 
             em.remove(listContact);
             em.getTransaction().commit();
             em.close();
         } catch (Exception e) {
             e.printStackTrace();
         }
           return listContact;  
        
  }


   
    public ListContact update(ListContact listContact) {
     	ListContact create = null;
        try {
        	 EntityManager em = DataBase.getInstance().getFactory().createEntityManager();
             em.getTransaction().begin();
             create = em.merge(listContact);
             em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
          return create;  
       
 }

    public List findAll() {
        List listContact = null;
        try {
        	EntityManager em = DataBase.getInstance().getFactory().createEntityManager();
             em.getTransaction().begin();   
             listContact  = (List)em.createQuery("from ListContact");
             em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
          return listContact;  
          
          
          
 }
          


}
