package main.service;

import main.dao.IDao;
import main.dao.impl.PatientDaoH2;
import main.model.Patient;

import java.sql.SQLException;
import java.util.List;

public class PatientService {

    private IDao<Patient> patientIDao;

    public PatientService(){
        patientIDao = new PatientDaoH2();
    }

    // ---
    public IDao<Patient> getPatientIDao() {
        return patientIDao;
    }

    public void setPatientIDao(IDao<Patient> patientIDao) {
        this.patientIDao = patientIDao;
    }

    // ---
    public Patient addPatient(Patient patient) throws SQLException {
        return patientIDao.add(patient);
    }

    public void removePatient(int id){
        patientIDao.remove(id);
    }

    public Patient searchPatient(int id) {
        return patientIDao.search(id);
    }

    public List<Patient> listAll() {
        return patientIDao.listAll();
    }


}
