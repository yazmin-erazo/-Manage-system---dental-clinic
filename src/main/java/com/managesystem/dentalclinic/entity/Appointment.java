package com.managesystem.dentalclinic.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor @NoArgsConstructor
@Getter
@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "patient_id", nullable = false)
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"}) // permite a Jackson ignorar la basura creada por Hibernate
    private Patient patient;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "dentist_id", nullable = false)
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"}) // permite a Jackson ignorar la basura creada por Hibernate
    private Dentist dentist;
    private LocalDate date;


    public Appointment(Patient patient, Dentist dentist, LocalDate date) {
        this.patient = patient;
        this.dentist = dentist;
        this.date = date;
    }

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
