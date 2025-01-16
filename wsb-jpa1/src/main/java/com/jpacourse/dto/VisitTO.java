package com.jpacourse.dto;


import com.jpacourse.persistence.enums.TreatmentType;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class VisitTO implements Serializable
{
    private LocalDateTime time;
    private String doctorFirstName;
    private String doctorLastName;
    private List<TreatmentType> treatments;

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getDoctorFirstName() {
        return doctorFirstName;
    }

    public void setDoctorFirstName(String doctorFirstName) {
        this.doctorFirstName = doctorFirstName;
    }

    public String getDoctorLastName() {
        return doctorLastName;
    }

    public void setDoctorLastName(String doctorLastName) {
        this.doctorLastName = doctorLastName;
    }

    public List<TreatmentType> getTreatments() {
        return treatments;
    }

    public void setTreatments(List<TreatmentType> treatments) {
        this.treatments = treatments;
    }
}
