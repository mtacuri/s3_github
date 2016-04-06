package com.cjava.peru.s03_ejemplo04.test;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;

import org.hibernate.Hibernate;
import org.junit.Test;

import com.cjava.peru.s03_ejemplo04.dao.CampaignDAO;
import com.cjava.peru.s03_ejemplo04.dao.ContactDAO;
import com.cjava.peru.s03_ejemplo04.dao.FilesDAO;
import com.cjava.peru.s03_ejemplo04.dao.ListContactDAO;
import com.cjava.peru.s03_ejemplo04.dao.MessageDAO;
import com.cjava.peru.s03_ejemplo04.dao.OptionDAO;
import com.cjava.peru.s03_ejemplo04.dao.ReturnDAO;
import com.cjava.peru.s03_ejemplo04.dao.ServiceDAO;
import com.cjava.peru.s03_ejemplo04.model.Campaign;
import com.cjava.peru.s03_ejemplo04.model.Contact;
import com.cjava.peru.s03_ejemplo04.model.Files;
import com.cjava.peru.s03_ejemplo04.model.ListContact;
import com.cjava.peru.s03_ejemplo04.model.Message;
import com.cjava.peru.s03_ejemplo04.model.Option;
import com.cjava.peru.s03_ejemplo04.model.Return;
import com.cjava.peru.s03_ejemplo04.model.Service;
import com.cjava.peru.s03_ejemplo04.util.Excel;



public class EntityTest {


	@Test
	public  void Load() throws IOException{
	
		//Inserta lo del excel
		 Excel xx =new Excel();
         xx.leer();
		
		
	    //Lista
	    ListContactDAO listContactDao=new ListContactDAO();    
		ListContact listContact= new ListContact();
		listContact.setName("Empresa xx");
		listContact.setDescription("Dedicada a---");
		listContactDao.create(listContact);
  
		ListContact listContact2= new ListContact();
		listContact2.setName("Empresa yy");
		listContact2.setDescription("Dedicada a zzz");
		System.out.println("Relacion....");
	
	
	    //Contacto
	    ContactDAO contactDao=new ContactDAO();
		Contact contact1=new Contact();
		contact1.setFirstname("Jorge");
		contact1.setLastname("Beltran");
		contact1.setPhone(234354);
		contact1.setEmail("Peru");
		contact1.setCountry("zzz@hotmail.com");
		contactDao.create(contact1);
		
		Contact contact2=new Contact();
		contact2.setFirstname("Marcelo");
		contact2.setLastname("Martinez");
		contact2.setPhone(234374);
		contact2.setEmail("Peru");
		contact2.setCountry("zzz@hotmail.com");
		System.out.println("Relacion....");
		
		//HibernateUtil.checkData("from Contact");
		
		contact2.setListContact(listContact);
		contactDao.create(contact2);
		System.out.println(new ContactDAO().find(contact2.getIdContact()).getListContact().getDescription());

			//Service 		
		ServiceDAO serviceDao=new ServiceDAO();    
		Service service1=new Service();
		service1.setNombre("Voice Market");
		service1.setDescription("Service event");
		serviceDao.create(service1);
		Service service2=new Service();
		service2.setNombre("Voice Meeting");
		service2.setDescription("Service event2");
		serviceDao.create(service2); 
			 
		 //Campaign
		 CampaignDAO campaignDao=new CampaignDAO();
		 Campaign campaign=new  Campaign();
		 campaign.setName("Evnt xx");
		 campaign.setDate("12/45/12");
		 Campaign campaign2=new  Campaign();
		 campaign2.setName("Evnt zzz");
		 campaign2.setDate("12/45/12");
		campaign.setService(service1); 
		campaign2.setService(service1);
	
		campaignDao.create(campaign2);
		campaignDao.create(campaign);
		listContact2.setCampaign(campaign);
		listContactDao.create(listContact2);
		//System.out.println(new ListContactDAO().find(listContact2.getIdlistcontact()).getCampaign().getName());
		System.out.println(new CampaignDAO().find(campaign.getIdCampaign()).getListContact());
		// List eventList = contactDao.findAll();
	//	List count=contactDao.Count();
	//	System.out.println(count);
		 	
		
		 //Files
		System.out.println("Save Files....");
		FileInputStream fs=null;
		File file=null;
		file = new File("D:\\Alarma1.mp3");
		fs = new FileInputStream(file);
		//Blob typ=Hibernate.createBlob(fs);

		/*FilesDAO filesDao = new FilesDAO();
		Files files1=new Files("aud",typ);
		filesDao.create(files1);*/
	    
	    FilesDAO filesDao=new FilesDAO();
	    Files files=new Files();
	    files.setName("audio1");
	    //files.setType(typ);
	    filesDao.create(files);
	  
		
		 //Message
		 MessageDAO messageDao=new MessageDAO();
		 Message message1=new Message();
		 message1.setMessage("Dia de xxxx");
		 message1.setDateMessage("25/01/12");
	 
		 
		 Message message2=new Message();
		 message2.setMessage("Dia de xxxx");
		 message2.setDateMessage("25/01/12");
		 
		 System.out.println("Relacion....");
		 message1.setCampaign(campaign2);
		 message1.setFiles(files);
		 messageDao.create(message1);
		 
		 message2.setCampaign(campaign2);
		 message2.setFiles(files);
		 messageDao.create(message2);
		 
		

		 //Option
		 OptionDAO optionDao=new OptionDAO();
		 Option option1=new Option();
		 option1.setOption("NO");
		 Option option2=new Option();
		 option2.setOption("SI");
		 optionDao.create(option2);
		 
		 System.out.println("Relacion....");
		 option1.setMessage(message1);
		 optionDao.create(option1);

		 
		 //Return
		 ReturnDAO returnDao=new ReturnDAO();
		 Return ret=new Return();
		 ret.setDate("12/10/12");
		 
		 System.out.println("Relacion....");
		 ret.setMessage(message1);
		 ret.setOption(option2);	 
		 returnDao.create(ret);
		 System.out.println(new ReturnDAO().find(ret.getIdReturn()).getMessage().getIdMessage());
		 


  /* ------ mantenimiento --------
   *   //delete 
    System.out.println("Delet contact");
    contactDao.delete(contact1);

	//update
    System.out.println("Update contact...");
    contact2.setFirstname("New Contact");
    contactDao.update(contact2); 
     
	
	System.out.println("List Contacts...");
	List contactList = contactDao.findAll();
    System.out.println("List contacts " + contactList.size());

    //finDao
    System.out.println("Find Contact...");
    Contact foundContact = contactDao.find(contact1.getIdContact());
    System.out.println("Contact = " + foundContact.getFirstname());*/
  }
}
	
