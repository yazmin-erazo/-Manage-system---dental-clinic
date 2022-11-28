package main.dao.impl;

import main.dao.DataBase;
import main.dao.IDao;
import main.model.Dentist;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DentistDaoH2 implements IDao<Dentist> {

    private static final Logger LOGGER = Logger.getLogger(DataBase.class);

    private  static  final  String SQL_INSERT_DENTIST = "INSERT INTO DENTIST (FIRSTNAME, LASTNAME, DENTISTLICENSE) VALUES (?,?,?)";
    private static final String SQL_DELETE_DENTIST = "DELETE FROM DENTIST WHERE ID = ?";
    private static final String SQL_SELECT_DENTIST = "SELECT * FROM DENTIST WHERE ID = ?";
    private static final String SQL_SELECT_ALLDENTISTS = "SELECT * FROM DENTIST";



    @Override
    public Dentist add(Dentist dentist) throws SQLException {

        LOGGER.info("Iniciando solicitud de ingreso de ODONTOLOGO");

        Connection connection = null;

        try{
            connection = DataBase.getConnection();

            connection.setAutoCommit(false);

            PreparedStatement psInsertDentist = connection.prepareStatement(SQL_INSERT_DENTIST , Statement.RETURN_GENERATED_KEYS);

            //psInsertDentist.setInt(1, dentist.getId());
            psInsertDentist.setString(1, dentist.getFirstName());
            psInsertDentist.setString(2, dentist.getLastName());
            psInsertDentist.setString(3, dentist.getDentistLicense());

            psInsertDentist.execute();
            ResultSet keys = psInsertDentist.getGeneratedKeys();

            if (keys.next()){
                dentist.setId(keys.getInt(1));
            }
            LOGGER.info("🟢 Odontologo " + dentist.getId() + " ingresado con Exito!");

            psInsertDentist.close();


            connection.commit();
            connection.setAutoCommit(true);

        }catch (Exception e){
            connection.rollback();
            LOGGER.error("🔻 Error conexion addDentist()\n" + e.getMessage());
        }finally {
            try {
                connection.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return dentist ;
    }

    @Override
    public void remove(int id) {
        Connection connection = null;

        try{
            LOGGER.info("Eliminando ODONTOLOGO con id: " + id);

            connection = DataBase.getConnection();

            PreparedStatement psDeleteDentist = connection.prepareStatement(SQL_DELETE_DENTIST);

            psDeleteDentist.setInt(1, id);
            psDeleteDentist.execute();

            LOGGER.info("🟢 Odontologo eliminado");

        }catch (Exception e){
            LOGGER.error("🔻 Error removeDentist()\n" + e.getMessage());
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
    public Dentist search(int id) {
        Connection connection = null;
        Dentist dentist = null;

        // Levantando driver y conectando
        try {

            LOGGER.info("Buscando ODONTOLOGO con id: " + id);
            connection = DataBase.getConnection();

            // Creando sentencia
            PreparedStatement psSelectDentist = connection.prepareStatement(SQL_SELECT_DENTIST);
            psSelectDentist.setInt(1,id);

            // Ejecutando la sentencia
            ResultSet rs = psSelectDentist.executeQuery();

            // Evaluando resultados
            while (rs.next()){
                dentist = new Dentist(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
            LOGGER.info("🟢 Odontologo encontrado");

        }catch (Exception e){
            LOGGER.error("🔻 Error searchDentist()\n" + e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return dentist;
    }

    @Override
    public List<Dentist> listAll() {
        Connection connection = null;
        Dentist dentist = null;
        List<Dentist> dentists = new ArrayList<>();

        // Levantando driver y conectando
        try {
            LOGGER.info("Listando todos los ODONTOLOGOS");
            connection = DataBase.getConnection();

            // Creando sentencia
            PreparedStatement psSelectAllDentists = connection.prepareStatement(SQL_SELECT_ALLDENTISTS);

            // Ejecutando la sentencia
            ResultSet rs = psSelectAllDentists.executeQuery();

            while (rs.next()){
                dentist = new Dentist(
                        rs.getInt("id"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("dentistLicense")
                );
                dentists.add(dentist);

                LOGGER.info("Dentista: " + dentist.getId() + " | Odontologo: " + dentist.getFirstName() + " " + dentist.getLastName() + "| Licencia: " + dentist.getDentistLicense());

            }

            LOGGER.info("🟢 Se obtuvo listado de odontologos!");

        }catch (Exception e){
            LOGGER.error("🔻 Error listAllDentists()\n" + e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return dentists;
    }
}
