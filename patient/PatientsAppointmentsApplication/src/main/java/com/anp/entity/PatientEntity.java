package com.anp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
//@Table(name= "patient_details")
public class PatientEntity {
  //entity class: It is JPA defines an entity classes, which are java classes that 
	// represents database tables.
	@Id 
	// It specifies primary key of an entity.
    @GeneratedValue(strategy = GenerationType.AUTO)
	// This annotation is used to specify the persistence provider used to generate primary key
	// value of entites.
	private int patientId;
	
	@Column(name= "PATIENT_FRST_NAME")
	private String patientFirstName;
	
	@Column(name= "PATIENT_LAST_NAME")
	private String patientLastName;
	
	@Column(name= "GENDER")
	private String gender;
	
	@Column(name= "BLOOD_GROUP")
	private String bloodGroup;
	
	@Column(name= "APPOINTMENT_DATE")
	private String appointmentDate;

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientFirstName() {
		return patientFirstName;
	}

	public void setPatientFirstName(String patientFirstName) {
		this.patientFirstName = patientFirstName;
	}

	public String getPatientLastName() {
		return patientLastName;
	}

	public void setPatientLastName(String patientLastName) {
		this.patientLastName = patientLastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	@Override
	public String toString() {
		return "PatientEntity [patientId=" + patientId + ", patientFirstName=" + patientFirstName + ", patientLastName="
				+ patientLastName + ", gender=" + gender + ", bloodGroup=" + bloodGroup + ", appointmentDate="
				+ appointmentDate + ", getPatientId()=" + getPatientId() + ", getPatientFirstName()="
				+ getPatientFirstName() + ", getPatientLastName()=" + getPatientLastName() + ", getGender()="
				+ getGender() + ", getBloodGroup()=" + getBloodGroup() + ", getAppointmentDate()="
				+ getAppointmentDate() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	public PatientEntity(int patientId, String patientFirstName, String patientLastName, String gender,
			String bloodGroup, String appointmentDate) {
		super();
		this.patientId = patientId;
		this.patientFirstName = patientFirstName;
		this.patientLastName = patientLastName;
		this.gender = gender;
		this.bloodGroup = bloodGroup;
		this.appointmentDate = appointmentDate;
	}

	public PatientEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
    }
