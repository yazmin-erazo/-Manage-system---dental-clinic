package main.dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DataBase {
    private static final Logger LOGGER = Logger.getLogger(DataBase.class);

    private static final String CREATE_TABLE_PATIENT = "DROP TABLE IF EXISTS PATIENT;" +
            "CREATE TABLE PATIENT (" +
            "ID INT auto_increment PRIMARY KEY," +
            "FIRSTNAME VARCHAR(100) NOT NULL," +
            "LASTNAME VARCHAR(100) NOT NULL," +
            "DNI VARCHAR(100) NOT NULL," +
            "ADDRESS VARCHAR(100) NOT NULL," +
            "DISCHARGEDATE VARCHAR(100) NOT NULL" +
            ")";

    private static final String CREATE_TABLE_DENTIST = "DROP TABLE IF EXISTS DENTIST;" +
            "CREATE TABLE DENTIST (" +
            "ID INT auto_increment PRIMARY KEY," +
            "FIRSTNAME VARCHAR(100) NOT NULL," +
            "LASTNAME VARCHAR(100) NOT NULL," +
            "DENTISTLICENSE VARCHAR(100) NOT NULL" +
            ")";

    private static final String CREATE_TABLE_TURN = "DROP TABLE IF EXISTS TURN;" +
            "CREATE TABLE TURN (" +
            "ID INT auto_increment PRIMARY KEY," +
            "ID_PATIENT INT NOT NULL," +
            "ID_DENTIST INT NOT NULL," +
            "DATETIME VARCHAR(100) NOT NULL" +
            ")";

    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").getDeclaredConstructor().newInstance();
        return DriverManager.getConnection("jdbc:h2:~/h2-dentalclinic", "yazmin", "");
    }

    public static void CREATE_TABLE() {
        LOGGER.info("Creando tablas DataBase dentalClinic");
        Connection connection = null;

        try{
            connection = getConnection();
            Statement statementPatient = connection.createStatement();
            statementPatient.execute(CREATE_TABLE_PATIENT);

            Statement statementDentist = connection.createStatement();
            statementDentist.execute(CREATE_TABLE_DENTIST);

            Statement statementTurn = connection.createStatement();
            statementTurn.execute(CREATE_TABLE_TURN);

            LOGGER.info("🟢 Base de datos creada con Exito ");

        }catch (Exception e){
            LOGGER.info("🔻 Error en DataBase \n" + e);
        }finally {
            try {
                connection.close();
            }catch(Exception ex){
                LOGGER.error("🔻 Error de cierre de conexion en Database \n" + ex);
            }

        }

    }

}
