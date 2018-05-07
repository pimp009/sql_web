package ru.innopolis.stc9.correctJDBC.Dao;

import ru.innopolis.stc9.ConnectionManager.ConnectionManager;
import ru.innopolis.stc9.correctJDBC.Pojo.Subject;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SubjectDAO {
    private static ConnectionManager connectionManager=ConnectionManager.getInstance();

    public static boolean addSubject(Subject subject) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement
                ("INSERT INTO subject (id, name_subject) VALUES (?,?)");
        statement.setInt(1, subject.getId());
        statement.setString(2, subject.getName_Subject());
        int res=statement.executeUpdate();
        connection.close();
        if(res>0)
            return true;
        else return false;
    }
    public static boolean deleteSubject(int id) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM subject WHERE id=?");
        statement.setInt(1, id);
        int res = statement.executeUpdate();
        connection.close();
        if (res>0)
        {
            return true;
        }
        else {
            return false;
        }

    }
}
