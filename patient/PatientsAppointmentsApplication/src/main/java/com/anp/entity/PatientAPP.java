package com.anp.entity;
import java.util.List;

import java.util.Optional;
import org.hibernate.HibernateException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

//the patientAPP class serves as the main entry point of the application
//demonstrating the usage of patientDAO to interact with the database.

public class PatientAPP {
	
// the main method demonstrating database interactions using patientDAO.
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = null;
				
				
		try { 
	//connecting to database using persistence unit "ak".				
			factory  = Persistence.createEntityManagerFactory("ak");
					
			EntityManager em = factory.createEntityManager();
								
		System.out.println("------WELCOME TO PatientManagementSystem------");
// creating instances of patient and adding them to the database.
		
PatientEntity P1 = new PatientEntity (1, "Sanvi", "shree", "Female","B-Positive",  "06-12-2023");
PatientEntity P2 = new PatientEntity(2, "Akshay", "kumar", "Male","O-Positive",  "12-12-2023");
PatientEntity P3 = new PatientEntity(3, "Sindhu", "sing", "Female","A-Negative", "20-12-2023");	

					PatientDAO tDAO = new PatientDAO(em);
					tDAO.save(P1);
					tDAO.save(P2);
					tDAO.save(P3);
					System.out.println("Data added successfully");

					System.out.println("--------------------------");
//retrieving patient details based on ID and displaying them.
					
					System.out.println(" Patient  details based on the id :");
					Optional<PatientEntity> PatientById = tDAO.findById(1);
					System.out.println(PatientById);
					 
					
					System.out.println("--------------------------");
// retrieving details of all the books.	
					System.out.println(" All Details of Patient ");	 
					List<PatientEntity> alltr = tDAO.findAll();
					System.out.println(alltr);
					
					
					
					System.out.println("------------------");
				
					
					int  newid = 3;
					String newFirstName ="Sindhu" ;
					String newLastName = "sing" ;
					String newgender = "Female"  ;
					String newbloodGroup = "A-Negative";
					String newAppointmentdate  ="20-12-2023";
					
tDAO.updatePatient(newid, newFirstName, newLastName,newgender, newbloodGroup, newAppointmentdate);
					
					System.out.println("Data updated sucessfully");
					
					
					System.out.println("------------------"); 
		//removing a record based on ID			
					System.out.println("Removeing based on the id :");
					
					
					
					System.out.println("2nd record is removed");
					
					
				}
				catch (HibernateException e) {
					 e.printStackTrace();
				}
				catch (Exception e) {
				 e.printStackTrace();
				}
	           }
              }
