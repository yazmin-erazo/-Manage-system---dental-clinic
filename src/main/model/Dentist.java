package main.model;

import java.io.Serializable;

public class Dentist implements Serializable {
    private Integer id;
    private String firstName;
    private String lastName;
    private String dentistLicense;

    public Dentist() {
    }

    public Dentist(String firstName, String lastName, String dentistLicense) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dentistLicense = dentistLicense;
    }

    public Dentist(Integer id, String firstName, String lastName, String dentistLicense) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dentistLicense = dentistLicense;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDentistLicense() {
        return dentistLicense;
    }

    public void setDentistLicense(String dentistLicense) {
        this.dentistLicense = dentistLicense;
    }


    @Override
    public String toString() {
        return "Dentist{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dentistLicense='" + dentistLicense + '\'' +
                '}';
    }
}
