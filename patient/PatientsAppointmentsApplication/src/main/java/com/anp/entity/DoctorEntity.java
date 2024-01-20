package com.anp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "doctors")
public class DoctorEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int doctorId;

    @Column(name = "DOCTOR_NAME")
    private String doctorName;

    // One doctor can have multiple appointments
    @OneToMany(mappedBy = "doctor")
    private List<AppointmentEntity> appointments;

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public List<AppointmentEntity> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<AppointmentEntity> appointments) {
		this.appointments = appointments;
	}

	@Override
	public String toString() {
		return "DoctorEntity [doctorId=" + doctorId + ", doctorName=" + doctorName + ", appointments=" + appointments
				+ "]";
	}

	public DoctorEntity(int doctorId, String doctorName, List<AppointmentEntity> appointments) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.appointments = appointments;
	}

	public DoctorEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


    // getters, setters, and other methods

    // constructors
}
