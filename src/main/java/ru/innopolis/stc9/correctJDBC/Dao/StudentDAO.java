package ru.innopolis.stc9.correctJDBC.Dao;



import ru.innopolis.stc9.ConnectionManager.ConnectionManager;
import org.apache.log4j.Logger;
import ru.innopolis.stc9.correctJDBC.Pojo.Student;

import java.sql.*;

/** Класс УчительДАО для обработки
 *  данных обьекта студент в БД */
public class StudentDAO {
    private static ConnectionManager connectionManager = ConnectionManager.getInstance();
    final static Logger logger = Logger.getLogger(StudentDAO.class);
    /** Метод добавляющий студента в БД
     * @param student
     * */
    public static boolean addStudent(Student student) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement
                ("INSERT INTO student" +
                        " (id, name, surname, group_id) VALUES (?,?,?,?)");
        statement.setInt(1, student.getId());
        statement.setString(2, student.getName());
        statement.setString(3, student.getSurName());
        statement.setInt(4, student.getGroup_id());
        int res = statement.executeUpdate();
        logger.info("The students was added to the DB");
        connection.close();
        if (res >0) {
            return true;
        }  return false;
    }

    /** Метод получающий студента в БД
     * @param id
     * @return student
     * */
    public static Student getStudent(int id) throws SQLException {
        Connection connection = connectionManager.getConnection();

        PreparedStatement statement = connection.prepareStatement("SELECT * " +
                "FROM student WHERE id = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        Student student = null;
        if (resultSet.next())
        {
            student = new Student(resultSet.getInt("id"),
                    resultSet.getString("Name"),
                    resultSet.getString("SurName"),
                    resultSet.getInt("Group_id"));
        }
        connection.close();
        return student;
    }
    /** Метод обновляющий студента в БД
     * @param student
     *
     * */
    public static boolean updateStudent(Student student) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("UPDATE student SET  " +
                "name = ?, surname = ?, group_id = ? WHERE id = ?");
        statement.setString(1, student.getName());
        statement.setString(2, student.getSurName());
        statement.setInt(3,student.getGroup_id());
        statement.setInt(4, student.getId());
        int res =statement.executeUpdate();
        logger.info("The students was updated to the DB");
        connection.close();
        if(res>0)
        {
            return true;
        }
        return false;
    }
    /** Метод удаляющий студента в БД
     * @param id
     *
     * */
    public static boolean deleteStudent(int id) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement
                ("DELETE FROM student WHERE id = ?");
        statement.setInt(1, id);
        int str = statement.executeUpdate();
        logger.info("The students was deleted to the DB");
        connection.close();
        if (str > 0) {
            return true;
        } else {
            return false;
        }

    }
    public static void main(String[] args) throws SQLException {
        System.out.println(getStudent(1));
    }
}

















