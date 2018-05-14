package ru.innopolis.stc9.correctJDBC.Dao;

import ru.innopolis.stc9.ConnectionManager.ConnectionManager;
import org.apache.log4j.Logger;
import ru.innopolis.stc9.correctJDBC.Pojo.Teacher;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/** Класс УчительДАО для обработки данных обьекта учителя в БД */
public class TeacherDAO {

    /** Создание экземпляра класса
     * ConnectionManager*/
        private static ConnectionManager connectionManager = ConnectionManager.getInstance();

    /** Создание экземпляра
     *  класса Logger для обьектов лога*/
    final static Logger logger = Logger.getLogger(ConnectionManager.class);

    /** Метод добавляющий учителя в БД
     * @param teacher
     * */
    public static boolean addSTeacher(Teacher teacher)  {
        /** Создание соединения с БД*/
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = null;
        int res=0;
        try {
            statement = connection.prepareStatement
                    ("INSERT INTO teacher" +
                            " (id, Name_Teacher, surname_teacher) VALUES (?,?,?)");
            statement.setInt(1, teacher.getId());
            statement.setString(2, teacher.getName_Teacher());
            statement.setString(3,  teacher.getSurName_Teacher());
             res = statement.executeUpdate();
            logger.info("The teacher was added to the DB");
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (res > 0) {
            return true;}
         else return false;
    }
    /** Метод получающий обьект учитель из БД
     * @param id
     * @return Возвращает обьект учитель
     * */
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

    /** Метод удаляющий учителя в БД
     * @param id
     * */

    public static boolean deleteTecher(int id) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement
                ("DELETE FROM teacher WHERE id = ?");
        statement.setInt(1, id);
        int str = statement.executeUpdate();
        logger.info("The teacher was deleted from the DB");
        connection.close();
        if (str > 0) {
            return true;
        } else {
            return false;
        }

    }



}

