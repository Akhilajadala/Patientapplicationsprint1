package com.anp.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


//the patientAPP class serves as the main entry point of the application
//demonstrating the usage of patientDAO to interact with the database.

public class PatientAPP {
	
// the main method demonstrating database interactions using patientDAO.
	
	public static void main(String[] args) {
        // Create an EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ak");
        EntityManager em = emf.createEntityManager();

        try {
            // Patient operations
            PatientDAO patientDAO = new PatientDAO(em);

            // Save a new patient
            PatientEntity newPatient = new PatientEntity(0, "Akhila", "Akhi", "Female", "A+", "2024-01-20");
            patientDAO.save(newPatient);

            // Find and display a patient by ID
            Optional<PatientEntity> foundPatient = patientDAO.findById(newPatient.getPatientId());
            foundPatient.ifPresent(System.out::println);

            // Update the patient's information
            patientDAO.updatePatient(newPatient.getPatientId(), "Keerthana", "Sweety", "Female", "B+", "2024-01-21");

            // Display all patients
            List<PatientEntity> allPatients = patientDAO.findAll();
            allPatients.forEach(System.out::println);

            // Doctor operations
            DoctorDAO doctorDAO = new DoctorDAO(em);

            // Save a new doctor
            DoctorEntity newDoctor = new DoctorEntity(0, "Dr. Akhi", null);
            doctorDAO.save(newDoctor);

            // Find and display a doctor by ID
            Optional<DoctorEntity> foundDoctor = doctorDAO.findById(newDoctor.getDoctorId());
            foundDoctor.ifPresent(System.out::println);

            // Update the doctor's information
            doctorDAO.updateDoctor(newDoctor.getDoctorId(), "Dr. Harsha");

            // Display all doctors
            List<DoctorEntity> allDoctors = doctorDAO.findAll();
            allDoctors.forEach(System.out::println);

            // Appointment operations
            AppointmentDAO appointmentDAO = new AppointmentDAO(em);

            // Save a new appointment
            AppointmentEntity newAppointment = new AppointmentEntity(0, newPatient, newDoctor, LocalDateTime.now());
            appointmentDAO.save(newAppointment);

            // Find and display an appointment by ID
            Optional<AppointmentEntity> foundAppointment = appointmentDAO.findById(newAppointment.getAppointmentId());
            foundAppointment.ifPresent(System.out::println);

            // Update the appointment's information
            appointmentDAO.updateAppointment(newAppointment.getAppointmentId(), LocalDateTime.now().plusHours(1));

            // Display all appointments
            List<AppointmentEntity> allAppointments = appointmentDAO.findAll();
            allAppointments.forEach(System.out::println);

        } finally {
            // Close the EntityManager and EntityManagerFactory
            if (em != null && em.isOpen()) {
                em.close();
            }
            if (emf != null && emf.isOpen()) {
                emf.close();
            }
        }
    }
}

