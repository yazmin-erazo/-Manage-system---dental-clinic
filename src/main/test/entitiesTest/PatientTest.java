package main.test.entitiesTest;

import main.model.Patient;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class PatientTest {

    @Test
    public void theNameIsCorrect(){
        String fecha = new Date().toString();
        Patient patient = new Patient(1,"Yazmin","Erazo","A123","Bogota",fecha);

        boolean nameNotEqual = patient.getFirstName() != "Yazmin";

        assertEquals("Yazmin", patient.getFirstName());
        assertFalse(nameNotEqual);
        assertNotNull(patient.getFirstName());

    }
}
