package ru.innopolis.stc9.sevices;

import ru.innopolis.stc9.correctJDBC.Dao.SubjectDAO;
import ru.innopolis.stc9.correctJDBC.Pojo.Subject;

import java.sql.SQLException;
/** Класс обретка для
 * методов класса SubjectDAO */
public class SubjectSevice {

    /** @see SubjectDAO#
     * addSubject(Subject) */
    public boolean addSubjectSevice(Subject subject) {
        try {
            SubjectDAO.addSubject(subject);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /** @see SubjectDAO#deleteSubject(int)    */
    public static boolean deleteSubjectSevice(int id) {
        try {
            SubjectDAO.deleteSubject(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
