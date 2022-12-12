package com.managesystem.dentalclinic.entity;

import lombok.Getter;

@Getter
public class DentistDto {

    private Integer id;
    private String firstName;
    private String lastName;
    private String dentistLicense;


    public DentistDto(String firstName, String lastName, String dentistLicense) {
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
}
