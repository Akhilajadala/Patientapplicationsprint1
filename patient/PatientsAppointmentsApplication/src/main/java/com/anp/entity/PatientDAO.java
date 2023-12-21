package com.anp.entity;
import java.util.List;
import java.util.Optional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
// the patientDAO class serves as a data access object(DAO) to perform CRUD operations.
// related to the patient entity using Jakarta.persistence API and EntityManager.

public class PatientDAO {
	private EntityManager em; //the entitymanager used for database interaction.

	public PatientDAO(final EntityManager em) {

		this.em = em;
}

	public void save(final PatientEntity p1) {
		// method implementation to persist a new patient entity in the database.
		
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();//return the resource-level entityTransaction object 

			if (!tx.isActive()) // Indicate whether a resource transaction is in progress.
			{
				tx.begin();
			}
	        PatientEntity mergedPatient = em.merge(p1);
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public Optional<PatientEntity> findById(int id) {
// method implementation to retrive a patient entity by ID from the database.
//returns an optional containing the retrieved entitry or an empty optional if not found.
		
		PatientEntity P1 = em.find(PatientEntity.class, id);

		if (P1 != null) {
			return Optional.of(P1);
		} else {
			return Optional.empty();
		}

	}
	
	public List<PatientEntity> findAll() {
// method implementation to retrive all patient entities from the databse
// returns a List<patientEntity> containing all entities.
		List<PatientEntity> t1 = em.createQuery("from PatientEntity", PatientEntity.class).getResultList();

		return t1;

	}
	public void updatePatient( int id, String newFirstName, String newLastName, String newGender,String newbloodgroup, String newappointmentdate) {
		// Updates an existing patient entity in the database based on the provided ID
		// with new attribute values.
		EntityTransaction tx = null; 
		try {
			tx = em.getTransaction();
			// returns the resource-level entityTransaction objects.

			if (!tx.isActive())
				// Indicates whether a resource transaction is in progress.
			{
				tx.begin();
			}
			PatientEntity P1 = em.find(PatientEntity.class, id) ;
			if(P1!=null) {
				P1.setPatientFirstName(newFirstName);
				P1.setPatientLastName(newLastName);
				P1.setGender(newGender);
				P1.setBloodGroup(newbloodgroup);

				P1.setAppointmentDate(newappointmentdate);
				
				em.merge(P1); //merger the changes
				tx.commit(); 
			}	
			
		} catch (Exception e) {
			 e.printStackTrace();
		}
			
	}
	
	
	public void remove(int id) { //removing based on id
		//method implementation to remove a patient entity by ID from the database.
		EntityTransaction tx = null; 
		
		PatientEntity P1 = em.find(PatientEntity.class, id);  
		
		try {
			tx = em.getTransaction(); //return the resource-level entutytransaction object

			if (!tx.isActive())//indicate whether a resource transaction is in progress. 
			{
				tx.begin();
			}
			em.remove(P1);
			tx.commit();
		}
		catch (Exception e) {
			 e.printStackTrace();
		  }
	     }
       }
