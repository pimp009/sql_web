package ru.innopolis.stc9.ConnectionManager;

import org.apache.log4j.Logger;

import java.sql.*;

/** @author Azat
 * VERSION 1.0 */

/** Класс реализует паттерн семафор, создает  экземпляр
 * ConnectionManager для подключения к базе данных */
public class ConnectionManager {
    final static Logger logger = Logger.getLogger(ConnectionManager.class);
    private static ConnectionManager connectionManager;
    public static ConnectionManager getInstance(){
        if (connectionManager==null)
        {
            connectionManager =new ConnectionManager();
        }
        return connectionManager;
    }
    private ConnectionManager(){}

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres",
                    "postgres",
                    "2015");
            logger.info("Successful connection");
        } catch (ClassNotFoundException e) {
           logger.error(e.getMessage());
           } catch (SQLException e) {
        }
return connection;
    }



}
