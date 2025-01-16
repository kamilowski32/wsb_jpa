package com.jpacourse.persistence.dao;

import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import com.jpacourse.persistence.enums.Gender;

import java.time.LocalDateTime;
import java.util.List;

public interface PatientDao extends Dao<PatientEntity, Long>
{
    void addVisit(Long patientId, Long doctorId, LocalDateTime time, String description);
    List<PatientEntity> getPatientsByLastName(String LastName);
    List<VisitEntity> getVisitsByPatientId(Long patientId);
    List<PatientEntity> getPatientsWithMoreVisits(int numberOfVisits);
    List<PatientEntity> getPatientsWithGender(Gender gender);
}
