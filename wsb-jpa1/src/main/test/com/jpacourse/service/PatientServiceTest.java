package com.jpacourse.service;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.persistence.entity.DoctorEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import com.jpacourse.persistence.enums.Gender;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class PatientServiceTest {

    @Autowired
    private PatientService patientService;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void shouldShowTOs() {
        Long patientId = 1L;

        PatientTO patient = patientService.findById(patientId);

        assertThat(patient).isNotNull();
        assertThat(patient.getId()).isEqualTo(patientId);
        assertThat(patient.getGender()).isEqualTo(Gender.MALE);
        assertThat(patient.getVisits()).isInstanceOf(List.class);

    }
    @Test
    public void shouldDeleteVisit() {
        Long patientId = 1L;
        Long visitId = 1L;
        Long doctorId = 1L;

        patientService.deletePatient(patientId);

        PatientTO patient = patientService.findById(patientId);
        assertThat(patient).isNull();

        VisitEntity visit = entityManager.find(VisitEntity.class, visitId);
        assertThat(visit).isNull();

        DoctorEntity doctor = entityManager.find(DoctorEntity.class, doctorId);
        assertThat(doctor).isNotNull();

    }
    @Test
    public void shouldReturnAllVisits()
    {
        Long patientId = 1L;
        List<VisitEntity> visits = patientService.findVisits(patientId);

        assertThat(visits).isNotNull();
        assertThat(visits).isNotEmpty();
        assertThat(visits.size()).isEqualTo(2);
    }
}
