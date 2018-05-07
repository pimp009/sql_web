package ru.innopolis.stc9.correctJDBC.Dao;

import ru.innopolis.stc9.ConnectionManager.ConnectionManager;
import ru.innopolis.stc9.correctJDBC.Pojo.Teacher;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherDAO {
    private static ConnectionManager connectionManager = ConnectionManager.getInstance();

    public static boolean addSTeacher(Teacher teacher) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;
        statement = connection.prepareStatement
                ("INSERT INTO teacher" +
                        " (id, Name_Teacher, surname_teacher) VALUES (?,?,?)");
        statement.setInt(1, teacher.getId());
        statement.setString(2, teacher.getName_Teacher());
        statement.setString(3,  teacher.getSurName_Teacher());
        int res = statement.executeUpdate();
        connection.close();
        if (res > 0) {
            return true;
        } else return false;
    }

    public static Teacher getTeacher(int id) throws SQLException {
        Connection connection = connectionManager.getConnection();

        PreparedStatement statement = connection.prepareStatement("SELECT * " +
                "FROM teacher WHERE id = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        Teacher teacher = null;
        if (resultSet.next())
        {
            teacher = new Teacher(resultSet.getInt("id"),
                    resultSet.getString("name_teacher"),
                    resultSet.getString("surname_teacher"));
        }
        connection.close();
        return teacher;

    }


    public static boolean deleteTecher(int id) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement
                ("DELETE FROM teacher WHERE id = ?");
        statement.setInt(1, id);
        int str = statement.executeUpdate();
        connection.close();
        if (str > 0) {
            return true;
        } else {
            return false;
        }

    }


}

