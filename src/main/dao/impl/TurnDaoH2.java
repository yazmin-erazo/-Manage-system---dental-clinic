package main.dao.impl;

import main.dao.DataBase;
import main.dao.IDao;
import main.model.Dentist;
import main.model.Patient;
import main.model.Turn;
import org.apache.log4j.Logger;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.format.DateTimeFormatter;

public class TurnDaoH2 implements IDao<Turn> {

    private static final Logger LOGGER = Logger.getLogger(TurnDaoH2.class);

    private  static  final  String SQL_INSERT_TURN= "INSERT INTO TURN (ID_PATIENT, ID_DENTIST, DATETIME) VALUES (?,?,?)";
    private static final String SQL_DELETE_TURN = "DELETE FROM TURN WHERE ID = ?";
    private static final String SQL_SELECT_TURN = "SELECT * FROM TURN WHERE ID = ?";
    private static final String SQL_SELECT_ALLTURNS = "SELECT * FROM TURN";


    @Override
    public Turn add(Turn turn) throws SQLException {
        LOGGER.info("Iniciando solicitud de TURNO");

        Connection connection = null;

        try{
            connection = DataBase.getConnection();

            connection.setAutoCommit(false);

            PreparedStatement psInsertTurn = connection.prepareStatement(SQL_INSERT_TURN, Statement.RETURN_GENERATED_KEYS);

                //psInsertTurn.setInt(1, turn.getId());
                psInsertTurn.setInt(1, turn.getPatient().getId());
                psInsertTurn.setInt(2, turn.getDentist().getId());
                psInsertTurn.setString(3, turn.getDateTime().toString());

                psInsertTurn.executeUpdate();
                ResultSet keys = psInsertTurn.getGeneratedKeys();

                 if (keys.next()){
                     turn.setId(keys.getInt(1));
                }

                LOGGER.info("🟢 Turno registrado");
                psInsertTurn.close();

            connection.commit();
            connection.setAutoCommit(true);

        }catch (Exception e){
            connection.rollback();
            LOGGER.error("🔻 Error conexion addTurn()\n" + e);
        }finally {
            try {
                assert connection != null;
                connection.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return turn ;
    }

    @Override
    public void remove(int id) {
        Connection connection = null;

        try{
            LOGGER.info("Eliminando TURNO con id: " + id);

            connection = DataBase.getConnection();

            PreparedStatement psRemoveTurn = connection.prepareStatement(SQL_DELETE_TURN);

            psRemoveTurn.setInt(1, id);
            psRemoveTurn.execute();

        }catch (Exception e){
            LOGGER.error("🔻 Error removeTurn()\n" + e.getMessage());
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
    public Turn search(int id) {
        Connection connection = null;
        Turn turn = null;

        // Levantando driver y conectando
        try {
            LOGGER.info("Buscando TURNO con id: " + id);
            connection = DataBase.getConnection();

            // Creando sentencia
            PreparedStatement psSelectTurn = connection.prepareStatement(SQL_SELECT_TURN);
            psSelectTurn.setInt(1,id);

            // Ejecutando la sentencia
            ResultSet rs = psSelectTurn.executeQuery();

            // Evaluando resultados
            while (rs.next()){
                turn = new Turn (rs.getInt(1), rs.getObject(2, Patient.class),rs.getObject(3, Dentist.class),rs.getObject(4, Date.class));
            }

        }catch (Exception e){
            LOGGER.error("🔻 Error searchTurn()\n" + e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return turn;
    }

    @Override
    public List<Turn> listAll() {
        Connection connection = null;
        Turn turn = null;
        List<Turn> turns = new ArrayList<>();

        // Levantando driver y conectando
        try {
            LOGGER.info("Listando todos los turnos");
            connection = DataBase.getConnection();

            // Creando sentencia
            PreparedStatement psSelectAllTurns = connection.prepareStatement(SQL_SELECT_ALLTURNS);

            // Ejecutando la sentencia
            ResultSet rs = psSelectAllTurns.executeQuery();

           // turns.forEach(System.out::println);

            //TODO pendiente listar Turnos
            while (rs.next()) {

                Integer turnId = rs.getInt(1);
                String id_patient = rs.getString(2);
                String id_dentist = rs.getString(3);
                String datetime = (String) rs.getObject(4);

                turn = new Turn();
                turn.setId(turnId);
                turns.add(turn);

                System.out.println();
                System.out.println("Id turno: " + turnId);
                System.out.println("Id paciente: " + id_patient);
                System.out.println("Id odontologo: " + id_dentist);
                System.out.println("Fecha: " + datetime);

                LOGGER.info(turn.getId() + " " + turn.getPatient() + " " + turn.getDentist() + " " + turn.getDateTime());
               }


            psSelectAllTurns.close();

            LOGGER.info("🟢 Turnos listados");

        }catch (Exception e){
            LOGGER.error("🔻 Error listAllTurns()\n" + e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return turns;
    }

}
