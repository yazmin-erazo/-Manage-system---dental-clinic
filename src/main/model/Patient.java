package main.model;

import java.io.Serializable;

public class Patient implements Serializable {

    private Integer id;
    private String firstName;
    private String lastName;
    private String dni;
    private String address;
    private String dischargeDate;

    public Patient() {
    }

    public Patient(String firstName, String lastName, String dni, String address, String dischargeDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dni = dni;
        this.address = address;
        this.dischargeDate = dischargeDate;
    }

    public Patient(Integer id, String firstName, String lastName, String dni, String address, String dischargeDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dni = dni;
        this.address = address;
        this.dischargeDate = dischargeDate;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(String dischargeDate) {
        this.dischargeDate = dischargeDate;
    }


    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dni='" + dni + '\'' +
                ", address='" + address + '\'' +
                ", dischargeDate='" + dischargeDate + '\'' +
                '}';
    }
}
