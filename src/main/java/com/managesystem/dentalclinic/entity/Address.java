package com.managesystem.dentalclinic.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "address")
public class Address {

    @Id
    @SequenceGenerator(name = "address_sequence", sequenceName = "address_sequence", allocationSize = 1) // permite definir el nombre del generador, el nombre y el esquema de la secuencia de la base de datos y el tamaño de asignación de la secuencia
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_sequence")
    private Integer id;
    private String streetName;
    private int streetNumber;
    @OneToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public Address(String streetName, int streetNumber, Patient patient) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.patient = patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }
}
