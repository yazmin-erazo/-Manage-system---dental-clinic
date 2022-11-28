package main.model;

import java.io.Serializable;
import java.util.Date;

public class Turn implements Serializable {

    private Integer id;
    private Patient patient;
    private Dentist dentist;
    private Date dateTime;

    public Turn() {
    }

    public Turn(Patient patient, Dentist dentist, Date dateTime) {
        this.patient = patient;
        this.dentist = dentist;
        this.dateTime = dateTime;
    }

    public Turn(Integer id, Patient patient, Dentist dentist, Date dateTime) {
        this.id = id;
        this.patient = patient;
        this.dentist = dentist;
        this.dateTime = dateTime;
    }

    public Turn(Integer id, String s, String s1, String s2) {
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }


    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }


    @Override
    public String toString() {
        return "Turn{" +
                "id=" + id +
                ", patient=" + patient +
                ", dentist=" + dentist +
                ", dateTime=" + dateTime +
                '}';
    }
}
