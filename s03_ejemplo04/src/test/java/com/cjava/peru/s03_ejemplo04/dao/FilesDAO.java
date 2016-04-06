package com.cjava.peru.s03_ejemplo04.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import org.hibernate.HibernateException;


import com.cjava.peru.s03_ejemplo04.model.Files;
import com.cjava.peru.s03_ejemplo04.service.DataBase;

public class FilesDAO {
	
	

	
	public Files create(Files files)  {
        try {
        	   EntityManager em = DataBase.getInstance().getFactory().createEntityManager();
               em.getTransaction().begin(); 
               em.persist(files);
               em.getTransaction().commit();
               em.close();
           } catch (Exception e) {
               e.printStackTrace();
           }
             return files;  
    }

    public Files delete(Files files)  {
    	 try {
    	        
      	   EntityManager em = DataBase.getInstance().getFactory().createEntityManager();
             em.getTransaction().begin(); 
             em.remove(files);
             em.getTransaction().commit();
             em.close();
         } catch (Exception e) {
             e.printStackTrace();
         }
           return files;  
        
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
    
    public Files find(int id)  {
    	Files files = null;
        try {
        	EntityManager em = DataBase.getInstance().getFactory().createEntityManager();
            em.getTransaction().begin();
            files = (Files) em.find(Files.class, id);
            em.getTransaction().commit();
        } catch (HibernateException e) {
        }
        return files;
    }

    public Files update(Files files) {
     	Files create = null;
        try {
        	 EntityManager em = DataBase.getInstance().getFactory().createEntityManager();
             em.getTransaction().begin();
             create = em.merge(files);
             em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
          return create;  
       
 }

    public List findAll() {
        List files = null;
        try {
        	EntityManager em = DataBase.getInstance().getFactory().createEntityManager();
             em.getTransaction().begin();   
             files  = (List)em.createQuery("from Files");
             em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
          return files;  
       
 }
    


}
