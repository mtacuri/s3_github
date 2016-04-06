package com.cjava.peru.s03_ejemplo04.dao;

import java.util.List;

import javax.persistence.EntityManager;
import org.hibernate.HibernateException;
import com.cjava.peru.s03_ejemplo04.model.Service;

import com.cjava.peru.s03_ejemplo04.service.DataBase;


public class ServiceDAO {

	
	public Service create(Service service)  {
        try {
        	   EntityManager em = DataBase.getInstance().getFactory().createEntityManager();
               em.getTransaction().begin(); 
               em.persist(service);
               em.getTransaction().commit();
               em.close();
           } catch (Exception e) {
               e.printStackTrace();
           }
             return service;  
    }

    public Service delete(Service service)  {
    	 try {
    	        
      	   EntityManager em = DataBase.getInstance().getFactory().createEntityManager();
             em.getTransaction().begin(); 
             em.remove(service);
             em.getTransaction().commit();
             em.close();
         } catch (Exception e) {
             e.printStackTrace();
         }
           return service;  
        
  }

    public Service find(int id)  {
    	Service service = null;
        try {
        	 EntityManager em = DataBase.getInstance().getFactory().createEntityManager();
             em.getTransaction().begin(); 
             service = (Service) em.find(Service.class, id);
            em.getTransaction().commit();
        } catch (HibernateException e) {
           
        } finally {
            //HibernateFactory.close(session);
        }
        return service;
    }

    public Service update(Service service) {
     	Service create = null;
        try {
        	 EntityManager em = DataBase.getInstance().getFactory().createEntityManager();
             em.getTransaction().begin();
             create = em.merge(service);
             em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
          return create;  
       
 }

    public List findAll() {
        List service = null;
        try {
        	EntityManager em = DataBase.getInstance().getFactory().createEntityManager();
             em.getTransaction().begin();   
             service  = (List)em.createQuery("from Service");
             em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
          return service;  
       
 }
    
    }