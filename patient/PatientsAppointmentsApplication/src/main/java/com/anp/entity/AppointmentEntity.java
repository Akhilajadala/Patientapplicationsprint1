package com.anp.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
public class AppointmentEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int appointmentId;

    @ManyToOne
    private PatientEntity patient;

    @ManyToOne
    private DoctorEntity doctor;

    @Column(name = "APPOINTMENT_DATE_TIME")
    private LocalDateTime appointmentDateTime;

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public PatientEntity getPatient() {
		return patient;
	}

	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}

	public DoctorEntity getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorEntity doctor) {
		this.doctor = doctor;
	}

	public LocalDateTime getAppointmentDateTime() {
		return appointmentDateTime;
	}

	public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
		this.appointmentDateTime = appointmentDateTime;
	}

	public AppointmentEntity(int appointmentId, PatientEntity patient, DoctorEntity doctor,
			LocalDateTime appointmentDateTime) {
		super();
		this.appointmentId = appointmentId;
		this.patient = patient;
		this.doctor = doctor;
		this.appointmentDateTime = appointmentDateTime;
	}

	public AppointmentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AppointmentEntity [appointmentId=" + appointmentId + ", doctor=" + doctor + ", appointmentDateTime="
				+ appointmentDateTime + "]";
	}

    // getters, setters, and other methods

    // constructors
}
