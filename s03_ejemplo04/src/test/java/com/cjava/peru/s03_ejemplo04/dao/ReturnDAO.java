package com.cjava.peru.s03_ejemplo04.dao;

import java.util.List;

import javax.persistence.EntityManager;
import org.hibernate.HibernateException;
import com.cjava.peru.s03_ejemplo04.model.Return;
import com.cjava.peru.s03_ejemplo04.service.DataBase;


public class ReturnDAO {

	
	public Return create(Return rturn)  {
        try {
        	   EntityManager em = DataBase.getInstance().getFactory().createEntityManager();
               em.getTransaction().begin(); 
               em.persist(rturn);
               em.getTransaction().commit();
               em.close();
           } catch (Exception e) {
               e.printStackTrace();
           }
             return rturn;  
    }

    public Return delete(Return rturn)  {
    	 try {
    	        
      	   EntityManager em = DataBase.getInstance().getFactory().createEntityManager();
             em.getTransaction().begin(); 
             em.remove(rturn);
             em.getTransaction().commit();
             em.close();
         } catch (Exception e) {
             e.printStackTrace();
         }
           return rturn;  
        
  }

    public Return find(int id)  {
    	Return rturn = null;
        try {
        	 EntityManager em = DataBase.getInstance().getFactory().createEntityManager();
             em.getTransaction().begin(); 
             rturn = (Return) em.find(Return.class, id);
            em.getTransaction().commit();
        } catch (HibernateException e) {
           
        } finally {
            //HibernateFactory.close(session);
        }
        return rturn;
    }

    public Return update(Return rturn) {
     	Return create = null;
        try {
        	 EntityManager em = DataBase.getInstance().getFactory().createEntityManager();
             em.getTransaction().begin();
             create = em.merge(rturn);
             em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
          return create;  
       
 }

    public List findAll() {
        List rturn = null;
        try {
        	EntityManager em = DataBase.getInstance().getFactory().createEntityManager();
             em.getTransaction().begin();   
             rturn  = (List)em.createQuery("from Campaign");
             em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
          return rturn;  
       
 }
    
    public List CountAll() {
        List rturn = null;
        try {
        	EntityManager em = DataBase.getInstance().getFactory().createEntityManager();
             em.getTransaction().begin();   
             rturn  = (List)em.createQuery("count * from Contact");
             em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
          return rturn;  
       
    } }