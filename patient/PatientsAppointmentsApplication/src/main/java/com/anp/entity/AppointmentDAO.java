package com.anp.entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class AppointmentDAO {
	private EntityManager em;

    public AppointmentDAO(EntityManager em) {
        this.em = em;
    }

    public void save(AppointmentEntity appointment) {
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            if (!tx.isActive()) {
                tx.begin();
            }
            em.persist(appointment);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public Optional<AppointmentEntity> findById(int id) {
        AppointmentEntity appointment = em.find(AppointmentEntity.class, id);
        return Optional.ofNullable(appointment);
    }

    public List<AppointmentEntity> findAll() {
        return em.createQuery("from AppointmentEntity", AppointmentEntity.class).getResultList();
    }

    public void updateAppointment(int id, LocalDateTime newAppointmentDateTime) {
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            if (!tx.isActive()) {
                tx.begin();
            }
            AppointmentEntity appointment = em.find(AppointmentEntity.class, id);
            if (appointment != null) {
                appointment.setAppointmentDateTime(newAppointmentDateTime);
                em.merge(appointment);
                tx.commit();
            }
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public void remove(int id) {
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            if (!tx.isActive()) {
                tx.begin();
            }
            AppointmentEntity appointment = em.find(AppointmentEntity.class, id);
            if (appointment != null) {
                em.remove(appointment);
                tx.commit();
            }
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }
}

