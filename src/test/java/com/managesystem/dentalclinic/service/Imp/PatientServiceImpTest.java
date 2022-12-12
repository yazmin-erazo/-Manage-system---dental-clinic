package com.managesystem.dentalclinic.service.Imp;

import com.managesystem.dentalclinic.entity.Patient;
import com.managesystem.dentalclinic.entity.PatientDto;
import com.managesystem.dentalclinic.service.IPatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PatientServiceImpTest {

    @Autowired
    IPatientService patientService;

    Patient patient = new Patient("Yazmin", "Erazo");

    @Test
    public void testCreatePatient() {
        PatientDto patientDto = new PatientDto();
        patientDto.setFirstName(patient.getFirstName() + " " + patient.getLastName());
        patientDto.setDni("369");
        patientService.createPatient(patientDto);

        assertEquals("Yazmin Erazo", patientDto.getFirstName());
    }

    @Test
    void readPatient() {
        PatientDto patientDto = new PatientDto();
        patientDto.setFirstName(patient.getFirstName() + " " + patient.getLastName());
        patientService.createPatient(patientDto);
        PatientDto patientYazmin = patientService.readPatient(1);

        assertTrue(patientYazmin != null);
    }

    @Test
    void updatePatient() {
    }

    @Test
    void deletePatient() {
    }

    @Test
    void getAllPatients() {
    }


}