package ru.innopolis.stc9.sevices;

import ru.innopolis.stc9.correctJDBC.Dao.TeacherDAO;
import ru.innopolis.stc9.correctJDBC.Pojo.Teacher;

import java.sql.SQLException;


/** Класс обретка для
 * методов класса TeacherDAO */
public class TeacherService {
TeacherDAO teacherDAO =new TeacherDAO();

/** @see TeacherDAO#addSTeacher(Teacher) */
    public boolean addSTeacherService(Teacher teacher)
    {
        teacherDAO.addSTeacher(teacher);
        return false;
    }
    /** @see TeacherDAO#getTeacher(int)  */
    public  Teacher getTeacherService(int id)
    {
        try {
            return teacherDAO.getTeacher(id);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    /** @see TeacherDAO#deleteTecher(int)   */
    public  boolean deleteTecher(int id)
    {
        try {
            teacherDAO.deleteTecher(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
