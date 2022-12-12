package com.managesystem.dentalclinic.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto implements Serializable {

    private Integer id;
//  private String fullName;
    private String firstName;
    private String lastName;
    private String dni;
    private Address address;

    public PatientDto(String firstName, String lastName, String dni, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dni = dni;
        this.address = address;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
