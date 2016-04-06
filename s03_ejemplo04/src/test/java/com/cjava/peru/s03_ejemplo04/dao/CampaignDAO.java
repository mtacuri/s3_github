package com.cjava.peru.s03_ejemplo04.dao;


import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.HibernateException;

import com.cjava.peru.s03_ejemplo04.model.Campaign;
import com.cjava.peru.s03_ejemplo04.service.DataBase;




public class CampaignDAO {
	
	public Campaign create(Campaign campaign)  {
        try {
        	   EntityManager em = DataBase.getInstance().getFactory().createEntityManager();
               em.getTransaction().begin(); 
               em.persist(campaign);
               em.getTransaction().commit();
               em.close();
           } catch (Exception e) {
               e.printStackTrace();
           }
             return campaign;  
    }

    public Campaign delete(Campaign campaign)  {
    	 try {
    	        
      	   EntityManager em = DataBase.getInstance().getFactory().createEntityManager();
             em.getTransaction().begin(); 
             em.remove(campaign);
             em.getTransaction().commit();
             em.close();
         } catch (Exception e) {
             e.printStackTrace();
         }
           return campaign;  
        
  }

    public Campaign find(int id)  {
    	Campaign campaign = null;
        try {
        	 EntityManager em = DataBase.getInstance().getFactory().createEntityManager();
             em.getTransaction().begin(); 
             campaign = (Campaign) em.find(Campaign.class, id);
            em.getTransaction().commit();
        } catch (HibernateException e) {
           
        } finally {
            //HibernateFactory.close(session);
        }
        return campaign;
    }

    public Campaign update(Campaign campaign) {
     	Campaign create = null;
        try {
        	 EntityManager em = DataBase.getInstance().getFactory().createEntityManager();
             em.getTransaction().begin();
             create = em.merge(campaign);
             em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
          return create;  
       
 }

    public List findAll() {
        List campaign = null;
        try {
        	EntityManager em = DataBase.getInstance().getFactory().createEntityManager();
             em.getTransaction().begin();   
             campaign  = (List)em.createQuery("from Campaign");
             em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
          return campaign;  
       
 }
    public List findName() {
        List campaign = null;
        try {
        	EntityManager em = DataBase.getInstance().getFactory().createEntityManager();
             em.getTransaction().begin();   
             campaign  = (List)em.createQuery("select name from campaign");
             em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
          return campaign;  
       
 }

}
