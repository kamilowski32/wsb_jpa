package com.jpacourse.mapper;

import com.jpacourse.dto.AddressTO;
import com.jpacourse.dto.PatientTO;
import com.jpacourse.persistence.entity.AddressEntity;
import com.jpacourse.persistence.entity.PatientEntity;

import java.util.ArrayList;
import java.util.stream.Collectors;

public final class PatientMapper
{

    public static PatientTO mapToTO(final PatientEntity patientEntity)
    {
        if (patientEntity == null)
        {
            return null;
        }
        final PatientTO patientTO = new PatientTO();
        patientTO.setId(patientEntity.getId());
        patientTO.setFirstName(patientEntity.getFirstName());
        patientTO.setLastName(patientEntity.getLastName());
        patientTO.setPatientNumber(patientEntity.getPatientNumber());
        patientTO.setDateOfBirth(patientEntity.getDateOfBirth());
        patientTO.setEmail(patientEntity.getEmail());
        patientTO.setGender(patientEntity.getGender());
        patientTO.setTelephoneNumber(patientEntity.getTelephoneNumber());
        patientTO.setVisits(patientEntity.getVisits().stream().map(VisitMapper::mapToTO).collect(Collectors.toList()));
        patientTO.setAddress(AddressMapper.mapToTO(patientEntity.getAddressEntity()));
        return patientTO;
    }

    public static PatientEntity mapToEntity(final PatientTO patientTO)
    {
        if(patientTO == null)
        {
            return null;
        }
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(patientTO.getId());
        patientEntity.setFirstName(patientTO.getFirstName());
        patientEntity.setLastName(patientTO.getLastName());
        patientEntity.setPatientNumber(patientTO.getPatientNumber());
        patientEntity.setDateOfBirth(patientTO.getDateOfBirth());
        patientEntity.setEmail(patientTO.getEmail());
        patientEntity.setGender(patientTO.getGender());
        patientEntity.setTelephoneNumber(patientTO.getTelephoneNumber());
        patientEntity.setAddressEntity(AddressMapper.mapToEntity(patientTO.getAddress()));

        return patientEntity;
    }
}
