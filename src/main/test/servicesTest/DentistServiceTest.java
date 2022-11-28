package main.test.servicesTest;

import main.dao.DataBase;
import main.dao.impl.DentistDaoH2;
import main.model.Dentist;
import main.service.DentistService;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class DentistServiceTest {

    @Test
    public void fullListOfDentists() throws SQLException {

        DataBase.CREATE_TABLE();

        DentistService dentistService = new DentistService();

        // Sin crear el odontolo que se encuentra en el Main = 2
        Dentist dentist1 = new Dentist(21, "Paola", "Bejarano","CDE-912");
        Dentist dentist2 = new Dentist(22, "Carlos", "González","EFG-151");

        dentistService.setDentistIDao(new DentistDaoH2());
        dentistService.addDentist(dentist1);
        dentistService.addDentist(dentist2);

        int listDentist = dentistService.listAll().size();
        assertEquals(2, listDentist);


    }
}
