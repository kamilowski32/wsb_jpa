package com.jpacourse.persistence.dao;


import com.jpacourse.persistence.entity.DoctorEntity;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import com.jpacourse.persistence.enums.Specialization;
import com.jpacourse.persistence.enums.Gender;
import com.jpacourse.service.PatientService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class PatientDaoTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private PatientDao patientDao;

    @Autowired
    PatientService patientService;

    private PatientEntity patient;
    private VisitEntity visit;
    private DoctorEntity doctor;

    @BeforeEach
    void setUp() {
        patient = new PatientEntity();
        patient.setFirstName("Pati");
        patient.setLastName("Japan");
        patient.setPatientNumber("15212512");
        patient.setTelephoneNumber("5123051235");
        patient.setEmail("test@test.com");
        patient.setGender(Gender.FEMALE);
        patient.setDateOfBirth(LocalDate.of(2001,2,6));

        doctor = new DoctorEntity();
        doctor.setFirstName("Doctor");
        doctor.setLastName("Japan");
        doctor.setEmail("doctor@test.com");
        doctor.setSpecialization(Specialization.OCULIST);
        doctor.setTelephoneNumber("15261126126");
        doctor.setDoctorNumber("2151");

        entityManager.persist(patient);
        entityManager.persist(doctor);

    }

    @Test
    void shouldAddVisit() {
        LocalDateTime time = LocalDateTime.now();
        String description = "Regular check-up";

        patientDao.addVisit(patient.getId(), doctor.getId(), time, description);

        assertNotNull(patient.getVisits());
        assertEquals(1, patient.getVisits().size());

        VisitEntity visitEntity = patient.getVisits().get(0);
        assertEquals(time, visitEntity.getTime());
        assertEquals(patient, visitEntity.getPatient());
        assertEquals(doctor, visitEntity.getDoctor());
    }

    @Test
    void shouldFindPatientByLastName() {
        List<PatientEntity> patients = patientDao.getPatientsByLastName("Japan");

        assertNotNull(patients);
        assertEquals(1, patients.size());
    }

    @Test
    void shouldFindAllPatientsWithMoreVisits() {
        List<PatientEntity> patients = patientDao.getPatientsWithMoreVisits(1);
        assertNotNull(patients);
        assertEquals(1, patients.size());

    }

    @Test
    void shouldFindAllPatientsWithGender() {
        List<PatientEntity> patientsF = patientDao.getPatientsWithGender(Gender.FEMALE);
        assertNotNull(patientsF);
        assertEquals(3, patientsF.size());

        List<PatientEntity> patientsM = patientDao.getPatientsWithGender(Gender.MALE);
        assertNotNull(patientsM);
        assertEquals(1, patientsM.size());
    }

}
