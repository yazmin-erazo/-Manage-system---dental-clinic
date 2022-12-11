package com.managesystem.dentalclinic.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor @NoArgsConstructor
public class AppointmentDto {

    private Integer id;
    private Patient patient;
    private Dentist dentist;
    private LocalDate date;


    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
