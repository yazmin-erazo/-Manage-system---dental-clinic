package com.managesystem.dentalclinic.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "dentists")
public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "license")
    private String dentistLicense;
    @JsonIgnore
    @OneToMany(mappedBy = "dentist", fetch = FetchType.LAZY)// No va a cargar los turnos asociados hasta que no haga uso de ellos
    private Set<Appointment> appointmentSet = new HashSet<>();


    public Dentist(String firstName, String lastName, String dentistLicense) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dentistLicense = dentistLicense;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDentistLicense(String dentistLicense) {
        this.dentistLicense = dentistLicense;
    }

    public void setAppointmentSet(Set<Appointment> appointmentSet) {
        this.appointmentSet = appointmentSet;
    }

}
