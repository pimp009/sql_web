package ru.innopolis.stc9.correctJDBC.Dao;

import ru.innopolis.stc9.ConnectionManager.ConnectionManager;
import ru.innopolis.stc9.correctJDBC.Pojo.Group;
import ru.innopolis.stc9.correctJDBC.Pojo.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/** Класс УчительДАО для обработки
 *  данных обьекта группа в БД */
public class GroupDAO {
    private static ConnectionManager connectionManager = ConnectionManager.getInstance();
    final static Logger logger = Logger.getLogger(GroupDAO.class);
    /** Метод добавляющий обьект группа в БД
     * @param group
     * */
        public static boolean addGroup(Group group) throws SQLException {
        Connection connection = connectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement
                    ("INSERT INTO \"group\" (id, namegroup) VALUES (?,?)");
            statement.setInt(1, group.getId());
            statement.setInt(2, group.getNameGroup());
            int res = statement.executeUpdate();
           logger.info("The students was updated to the DB");
           connection.close();
           if(res>0)           {
                return true;
           }
            else return false;

    }

    /** Метод получающий обьект группа в БД
     * @param id
     * */
    public static Group getGroup(int id)
    {
        Connection connection =connectionManager.getConnection();
        Group group = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM \"group\" WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next())
            {
                group = new Group(resultSet.getInt("id"), resultSet.getInt("namegroup"));
                          }
            connection.close();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
         return group;

    }
    /** Метод удаляющий обьект группа в БД
     * @param namegroup
     * */

    public  static ArrayList<Student> getStudentGroup(int namegroup) throws SQLException {
        ArrayList<Student> result = new ArrayList<>();
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT student.id, " +
                "student.name, student.surname, \"group\".namegroup " +
                " FROM student INNER JOIN \"group\"\n" +
                "    on student.group_id = \"group\".id WHERE namegroup=?;");
        statement.setInt(1, namegroup);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next())
        {
          Student student = new Student(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("surname"), resultSet.getInt("namegroup"));
                     result.add(student);
        }
        connection.close();
        return result;
    }
    public static boolean deletegroup(int id) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement
                ("DELETE FROM \"group\" WHERE id = ?");
        statement.setInt(1, id);
        int str = statement.executeUpdate();
        logger.info("The students was deleted to the DB");
        connection.close();
        if(str>0){
            return true;}
        else
            return false;
        /** Метод получающий обьект группа в БД
         * @param id
         * @return список студентов в группе
         * */
    }
   /** public  static String getStudentGroup11(int namegroup) throws SQLException {
        ArrayList<Student> result = new ArrayList<>();
        String s1="";
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT student.id, " +
                "student.name, student.surname, \"group\".namegroup " +
                " FROM student INNER JOIN \"group\"\n" +
                "    on student.group_id = \"group\".id WHERE namegroup=?;");
        statement.setInt(1, namegroup);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next())
        {
            Student student = new Student(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("surname"), resultSet.getInt("namegroup"));
            result.add(student);
            connection.close();

        }
        if (result==null) return "nfgnll";
        for(Student s: result)
        {
            String res = s.toString() +"\r\n";
            s1+=res;

        }

        return s1;
    }*/


   }

