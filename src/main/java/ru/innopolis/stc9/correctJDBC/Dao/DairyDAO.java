package ru.innopolis.stc9.correctJDBC.Dao;



import ru.innopolis.stc9.ConnectionManager.ConnectionManager;
import ru.innopolis.stc9.correctJDBC.Pojo.Dairy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/** Класс ДневникДАО для обработки
 *  данных обьекта успеваемость студента в БД */
public class DairyDAO {
    private static ConnectionManager connectionManager = ConnectionManager.getInstance();
    final static Logger logger = Logger.getLogger(DairyDAO.class);
    /** Метод добавляющий обьект успеваемость студента в БД
     * @param dairy  */
    public static boolean addPoint(Dairy dairy) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO  achievement" +
                " (id, subject_id, student_id,teacher_id, point,data) VALUES (?,?,?,?,?,?)");
        statement.setInt(1, dairy.getId());
        statement.setInt(2, dairy.getStudent_id());
        statement.setInt(3, dairy.getSubject_id());
        statement.setInt(4, dairy.getTeacher_id());
        statement.setInt(5, dairy.getPoint());
        statement.setString(6, dairy.getDate());
        int res = statement.executeUpdate();
        logger.info("The point was added to the DB");
        connection.close();
        if(res>0)
        {        return true;}
        else return false;

    }
    /** Метод обновлящий обьект успеваемость студента в БД
     * @param dairy  */
    public static boolean updatePoint(Dairy dairy) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("UPDATE achievement SET  " +
                "id = ?, student_id = ?, point = ? WHERE ( date = ? AND subject_id = ?  ");
        statement.setInt(1, dairy.getId());
        statement.setInt(2, dairy.getStudent_id());
        statement.setInt(3,dairy.getPoint());
        statement.setString(4, dairy.getDate());
        statement.setInt(5, dairy.getSubject_id());
        int res =statement.executeUpdate();
        logger.info("The point was updated to the DB");
        connection.close();
        if(res>0)
        {
            return true;
        }
        return false;
    }


    /** Метод получающий список оценок студента, предмету
     *  из БД
     * @param studentId,
     * @param subjectId
     * @return ArrayList<DairyService>*/
    public static ArrayList<Dairy> getpointfromsubject(int studentId, int subjectId) throws SQLException {
     ArrayList<Dairy> resultpPoint =new ArrayList<>();
     Connection connection = connectionManager.getConnection();
     PreparedStatement statement = connection.prepareStatement("SELECT  s2.name, s2.surname, s3.name_subject, point, date, t.surname_teacher\n" +
             "FROM achievement INNER JOIN student s2 on achievement.student_id = s2.id INNER JOIN subject s3 on achievement.subject_id = s3.id\n" +
             "INNER JOIN teacher t on achievement.teacher_id = t.id WHERE student_id = ? AND s3.id = ?" );
     statement.setInt(1, studentId);
     statement.setInt(2, subjectId);
     ResultSet resultSet = statement.executeQuery();
     while (resultSet.next())
     {
         Dairy dairy =new Dairy(resultSet.getString("name"),
                 resultSet.getString("surname"),
                 resultSet.getString("name_subject"),
                 resultSet.getInt("point"),
                 resultSet.getString("date"),
                 resultSet.getString("surname_teacher"));
         resultpPoint.add(dairy);
         }
     connection.close();
     return resultpPoint;
 }

}
