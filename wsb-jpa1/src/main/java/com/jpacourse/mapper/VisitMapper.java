package com.jpacourse.mapper;

import com.jpacourse.dto.AddressTO;
import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistence.entity.AddressEntity;
import com.jpacourse.persistence.entity.DoctorEntity;
import com.jpacourse.persistence.entity.VisitEntity;

import java.util.List;
import java.util.stream.Collectors;

public final class VisitMapper
{

    public static VisitTO mapToTO(final VisitEntity visitEntity)
    {
        if (visitEntity == null)
        {
            return null;
        }
        final VisitTO visitTO = new VisitTO();
        visitTO.setTime(visitEntity.getTime());

        DoctorEntity doctorEntity = visitEntity.getDoctor();

        if (doctorEntity != null)
        {
            visitTO.setDoctorFirstName(doctorEntity.getFirstName());
            visitTO.setDoctorLastName(doctorEntity.getLastName());
        }

        if (visitEntity.getTreatments() != null)
        {
            List<String> treatments = visitEntity.getTreatments().stream()
                    .map(treatment -> treatment.getType().name())
                    .collect(Collectors.toList());
            visitTO.setMedicalTreatments(treatments);
        }
        return visitTO;
    }
}
