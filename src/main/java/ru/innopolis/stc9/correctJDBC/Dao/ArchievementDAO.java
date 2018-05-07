package ru.innopolis.stc9.correctJDBC.Dao;



import ru.innopolis.stc9.ConnectionManager.ConnectionManager;
import ru.innopolis.stc9.correctJDBC.Pojo.Achievement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ArchievementDAO {
    private static ConnectionManager connectionManager = ConnectionManager.getInstance();

    public static boolean addPoint(Achievement a) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO  achievement" +
                " (id, subject_id, student_id,teacher_id, point,data) VALUES (?,?,?,?,?,?)");
        statement.setInt(1, a.getId());
        statement.setInt(2, a.getStudent_id());
        statement.setInt(3, a.getSubject_id());
        statement.setInt(4, a.getTeacher_id());
        statement.setInt(5, a.getPoint());
        statement.setInt(6, a.getDate());
        int res = statement.executeUpdate();
        connection.close();
        if(res>0)
        {        return true;}
        else return false;

    }
    public static boolean updatePoint(Achievement a) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("UPDATE achievement SET  " +
                "id = ?, student_id = ?, point = ? WHERE ( data = ? AND subject_id = ?  ");
        statement.setInt(1, a.getId());
        statement.setInt(2, a.getStudent_id());
        statement.setInt(3,a.getPoint());
        statement.setInt(4, a.getDate());
        statement.setInt(5, a.getSubject_id());
        int res =statement.executeUpdate();
        connection.close();
        if(res>0)
        {
            return true;
        }
        return false;
    }

    public static ArrayList<Achievement> getPointStudent(int id, int subject_id) throws SQLException {
        ArrayList<Achievement> list=new ArrayList<>();
        Connection connection = connectionManager.getConnection();

        PreparedStatement statement = connection.prepareStatement("SELECT * " +
                "FROM achievement WHERE student_id = ? AND subject_id =?");
        statement.setInt(1, id);
        statement.setInt(2, subject_id);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next())
        {
             list.add(new Achievement(resultSet.getInt("id"), resultSet.getInt("subject_id"),
                     resultSet.getInt("student_id"),resultSet.getInt("teacher_id"),
                     resultSet.getInt("point"),resultSet.getInt("data")));
        }
        connection.close();
        return list;
    }

    public ArchievementDAO() {
    }
/*
    public static ArrayList<Achievement> getpointfromsubject(int studentId, int subjectId) throws SQLException {
     ArrayList<Achievement> resultpPoint =new ArrayList<>();
     Connection connection = connectionManager.getConnection();
     PreparedStatement statement = connection.prepareStatement("SELECT  s2.name, s2.surname, s3.name_subject, point, date, t.surname_teacher\n" +
             "FROM achievement INNER JOIN student s2 on achievement.student_id = s2.id INNER JOIN subject s3 on achievement.subject_id = s3.id\n" +
             "INNER JOIN teacher t on achievement.teacher_id = t.id WHERE student_id = ? AND s3.id = ?" );
     statement.setInt(1, studentId);
     statement.setInt(2, subjectId);
     ResultSet resultSet = statement.executeQuery();
     while (resultSet.next())
     {
         Achievement achievement =new Achievement(resultSet.getString("name"),
                 resultSet.getString("surname"),
                 resultSet.getInt("point"),
                 resultSet.getInt("date"),
                 resultSet.getString("surname_teacher"));


         resultpPoint.add(achievement);
         }
     connection.close();
     return resultpPoint;
 }
*/
}
