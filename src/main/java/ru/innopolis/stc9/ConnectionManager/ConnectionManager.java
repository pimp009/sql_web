package ru.innopolis.stc9.ConnectionManager;

import java.sql.*;

public class ConnectionManager {
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
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
return connection;
    }



}
