package main;

import main.dao.DataBase;
import main.dao.impl.DentistDaoH2;
import main.dao.impl.PatientDaoH2;
import main.dao.impl.TurnDaoH2;
import main.model.Dentist;
import main.model.Patient;
import main.model.Turn;
import main.service.DentistService;
import main.service.PatientService;
import main.service.TurnService;
import org.apache.log4j.Logger;
import java.sql.SQLException;
import java.util.Date;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {

        DataBase.CREATE_TABLE();
        // INGRESO DE PACIENTE
        Patient patient = new Patient("Daniela", "Ariza", "B345", "Bogota", "02-11-2022");
        PatientService patientService = new PatientService();
        patientService.setPatientIDao(new PatientDaoH2());
        patientService.addPatient(patient);

        //INGRESO DE ODONTOLOGO
        Dentist dentist1 = new Dentist("Yazmin", "Erazo", "ABC-369");
        Dentist dentist2 = new Dentist("Camilo", "Bejarano", "CDE-963");
        DentistService dentistService = new DentistService();
        dentistService.setDentistIDao(new DentistDaoH2());
        dentistService.addDentist(dentist1);
        dentistService.addDentist(dentist2);

        // LISTA DE ODONTOLOGOS
        dentistService.listAll();

        // INGRESO DE TURNO
        TurnService turnService = new TurnService();
        Date dateTime = new Date();
        Turn turn = new Turn(patient,dentist2,dateTime);
        Turn turn1 = new Turn(patient,dentist1,dateTime);
        turnService.setTurnIDao(new TurnDaoH2());
        turnService.addTurn(turn);
        turnService.addTurn(turn1);


        // LISTA DE TURNOS
        turnService.listAll();

    }
}
