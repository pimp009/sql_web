package ru.innopolis.stc9.sevices;

import ru.innopolis.stc9.correctJDBC.Dao.TeacherDAO;
import ru.innopolis.stc9.correctJDBC.Pojo.Teacher;

import java.sql.SQLException;

public class TeacherService {
TeacherDAO teacherDAO =new TeacherDAO();
    public boolean addSTeacherService(Teacher teacher)
    {
        try {
            teacherDAO.addSTeacher(teacher);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public  Teacher getTeacherService(int id)
    {
        try {
            return teacherDAO.getTeacher(id);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
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
