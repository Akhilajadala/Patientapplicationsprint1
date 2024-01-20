package com.anp.entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;
import java.util.Optional;

public class DoctorDAO {
	private EntityManager em;

    public DoctorDAO(EntityManager em) {
        this.em = em;
    }

    public void save(DoctorEntity doctor) {
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            if (!tx.isActive()) {
                tx.begin();
            }
            em.persist(doctor);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public Optional<DoctorEntity> findById(int id) {
        DoctorEntity doctor = em.find(DoctorEntity.class, id);
        return Optional.ofNullable(doctor);
    }

    public List<DoctorEntity> findAll() {
        return em.createQuery("from DoctorEntity", DoctorEntity.class).getResultList();
    }

    public void updateDoctor(int id, String newDoctorName) {
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            if (!tx.isActive()) {
                tx.begin();
            }
            DoctorEntity doctor = em.find(DoctorEntity.class, id);
            if (doctor != null) {
                doctor.setDoctorName(newDoctorName);
                em.merge(doctor);
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
            DoctorEntity doctor = em.find(DoctorEntity.class, id);
            if (doctor != null) {
                em.remove(doctor);
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

