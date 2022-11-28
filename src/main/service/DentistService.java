package main.service;

import main.dao.IDao;
import main.model.Dentist;

import java.sql.SQLException;
import java.util.List;

public class DentistService {

    private IDao<Dentist> dentistIDao;

    // --
    public IDao<Dentist> getDentistIDao() {
        return dentistIDao;
    }

    public void setDentistIDao(IDao<Dentist> dentistIDao) {
        this.dentistIDao = dentistIDao;
    }

    // --
    public Dentist addDentist(Dentist dentist) throws SQLException {
        return dentistIDao.add(dentist);
    }

    public void deleteDentist(int id) {
        dentistIDao.remove(id);
    }

    public Dentist searchDentist(int id) {
        return dentistIDao.search(id);
    }

    public List<Dentist> listAll() {
        return dentistIDao.listAll();
    }


}
