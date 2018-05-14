package ru.innopolis.stc9.correctJDBC.Dao;

import ru.innopolis.stc9.ConnectionManager.ConnectionManager;
import org.apache.log4j.Logger;
import ru.innopolis.stc9.correctJDBC.Pojo.Subject;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/** Класс УчительДАО для обработки
 *  данных обьекта предмет в БД */
public class SubjectDAO {

    private static ConnectionManager connectionManager=ConnectionManager.getInstance();
    final static Logger logger = Logger.getLogger(SubjectDAO.class);
    /** Метод добавляющий предмет в БД
     * @param subject
     * */
    public static boolean addSubject(Subject subject) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement
                ("INSERT INTO subject (id, name_subject) VALUES (?,?)");
        statement.setInt(1, subject.getId());
        statement.setString(2, subject.getName_Subject());
        int res=statement.executeUpdate();
        logger.info("The subject was added to the DB");
        connection.close();
        if(res>0)
            return true;
        else return false;
    }
    /** Метод удаляющий предмет из БД
     * @param id
     * */
    public static boolean deleteSubject(int id) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM subject WHERE id=?");
        statement.setInt(1, id);
        int res = statement.executeUpdate();
        logger.info("The subject was deleted to the DB");
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
