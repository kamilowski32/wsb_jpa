package com.jpacourse.persistence.dao;

import com.jpacourse.persistence.entity.AddressEntity;

import java.time.LocalDateTime;

public interface PatientDao extends Dao<AddressEntity, Long>
{
    void addVisit(Long patientId, Long doctorId, LocalDateTime time, String description);
}
