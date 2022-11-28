package main.dao.impl;

import main.dao.DataBase;
import main.dao.IDao;
import main.model.Patient;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDaoH2 implements IDao<Patient> {

    private static final Logger LOGGER = Logger.getLogger(PatientDaoH2.class);
    private  static  final  String SQL_INSERT_PATIENT = "INSERT INTO PATIENT (FIRSTNAME, LASTNAME, DNI, ADDRESS, DISCHARGEDATE) VALUES (?,?,?,?,?)";
    private static final String SQL_DELETE_PATIENT = "DELETE FROM PATIENT WHERE ID = ?";
    private static final String SQL_SELECT_PATIENT = "SELECT * FROM PATIENT WHERE ID = ?";
    private static final String SQL_SELECT_ALLPATIENTS = "SELECT * FROM PATIENT";


    @Override
    public Patient add(Patient patient) throws SQLException {
        LOGGER.info("Iniciando solicitud de ingreso de paciente");

        Connection connection = null;

        try{
            connection = DataBase.getConnection();

            connection.setAutoCommit(false);

            PreparedStatement psInsertPatient = connection.prepareStatement(SQL_INSERT_PATIENT, Statement.RETURN_GENERATED_KEYS);

            //psInsertPatient.setInt(1, patient.getId());
            psInsertPatient.setString(1, patient.getFirstName());
            psInsertPatient.setString(2, patient.getLastName());
            psInsertPatient.setString(3, patient.getDni());
            psInsertPatient.setString(4, patient.getAddress());
            psInsertPatient.setString(5, patient.getDischargeDate());

            psInsertPatient.execute();
            ResultSet keys = psInsertPatient.getGeneratedKeys();

            if (keys.next()){
                patient.setId(keys.getInt(1));
            }


            LOGGER.info("🟢 Paciente " + patient.getId() + " ingresado a DataBase");
            psInsertPatient.close();

            connection.commit();
            connection.setAutoCommit(true);

        }catch (Exception e){
            e.printStackTrace();
            connection.rollback();
            LOGGER.error("🔻 Error conexion addPatient()\n" + e.getMessage());
        }finally {
            try {
                connection.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return patient;
    }


    @Override
    public void remove(int id) {
        Connection connection = null;

        try{
            LOGGER.info("Eliminando paciente con id: " + id);

            connection = DataBase.getConnection();

            PreparedStatement psDeletePatient = connection.prepareStatement(SQL_DELETE_PATIENT);

            psDeletePatient.setInt(1, id);
            psDeletePatient.execute();

            LOGGER.info("🟢 Paciente eliminado de DataBase");

        }catch (Exception e){
            LOGGER.error("🔻 Error removePatient()\n" + e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }


    @Override
    public Patient search(int id) {

        Connection connection = null;
        Patient patient = null;

        // Levantando driver y conectando
        try {

            LOGGER.info("Buscando paciente con id: " + id);
            connection = DataBase.getConnection();

            // Creando sentencia
            PreparedStatement psSelectPatient = connection.prepareStatement(SQL_SELECT_PATIENT);
            psSelectPatient.setInt(1,id);

            // Ejecutando la sentencia
            ResultSet rs = psSelectPatient.executeQuery();

            // Evaluando resultados

            while (rs.next()){
                patient = new Patient(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));

            }

            LOGGER.info("🟢 Paciente encontrado en DataBase");

        }catch (Exception e){
            LOGGER.error("🔻 Error searchPatient()\n" + e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return patient;
    }


    @Override
    public List<Patient> listAll() {
        Connection connection = null;
        Patient patient = null;
        List<Patient> patients = new ArrayList<>();

        // Levantando driver y conectando
        try {
            LOGGER.info("Listando todos los paciente");
            connection = DataBase.getConnection();

            // Creando sentencia
            PreparedStatement psSelectAllPatients = connection.prepareStatement(SQL_SELECT_ALLPATIENTS);

            // Ejecutando la sentencia
            ResultSet rs = psSelectAllPatients.executeQuery();

            while (rs.next()){
                patient = new Patient(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)
                );
                patients.add(patient);
                LOGGER.info(patient.getFirstName() + " " + patient.getLastName());
           }

            LOGGER.info("🟢 Pacientes listados");


        }catch (Exception e){
            LOGGER.error("🔻 Error listAllPatients()\n" + e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return patients;
    }
}
