package com.jpacourse.persistence.dao.impl;


import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.entity.DoctorEntity;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import com.jpacourse.persistence.enums.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao
{
    @Autowired
    EntityManager entityManager;

    @Transactional
    @Override
    public void addVisit(Long patientId, Long doctorId, LocalDateTime time, String description)
    {
        PatientEntity patient = entityManager.find(PatientEntity.class, patientId);
        DoctorEntity doctor = entityManager.find(DoctorEntity.class, doctorId);

        VisitEntity visitEntity = new VisitEntity();
        visitEntity.setPatient(patient);
        visitEntity.setDoctor(doctor);
        visitEntity.setTime(time);
        visitEntity.setDescription(description);
        if (patient.getVisits() == null)
        {
            patient.setVisits(new ArrayList<VisitEntity>());
        }
        patient.getVisits().add(visitEntity);
        entityManager.merge(patient);
    }

    @Transactional
    @Override
    public List<PatientEntity> getPatientsByLastName(String LastName) {
        String jpql = "SELECT p FROM PatientEntity p WHERE p.lastName = :LastName";
        TypedQuery<PatientEntity> query = entityManager.createQuery(jpql, PatientEntity.class);
        query.setParameter("LastName", LastName);
        return query.getResultList();
    }

    @Transactional
    @Override
    public List<VisitEntity> getVisitsByPatientId(Long patientId) {
        String jpql = "SELECT v FROM VisitEntity v WHERE v.patient.id = :patientId";
        TypedQuery<VisitEntity> query = entityManager.createQuery(jpql, VisitEntity.class);
        query.setParameter("patientId", patientId);
        return query.getResultList();
    }

    @Transactional
    @Override
    public List<PatientEntity> getPatientsWithMoreVisits(int numberOfVisits) {
        String jpql="SELECT p FROM PatientEntity p WHERE SIZE(p.visits) > :numberOfVisits";
        TypedQuery<PatientEntity> query = entityManager.createQuery(jpql, PatientEntity.class);
        query.setParameter("numberOfVisits", numberOfVisits);
        return query.getResultList();
    }

    @Transactional
    @Override
    public List<PatientEntity> getPatientsWithGender(Gender gender) {
        String jpql="SELECT p FROM PatientEntity p WHERE p.gender = :gender";
        TypedQuery<PatientEntity> query = entityManager.createQuery(jpql, PatientEntity.class);
        query.setParameter("gender", gender);
        return query.getResultList();
    }

}
