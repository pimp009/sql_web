package ru.innopolis.stc9.sevices;

import ru.innopolis.stc9.correctJDBC.Dao.SubjectDAO;
import ru.innopolis.stc9.correctJDBC.Pojo.Subject;

import java.sql.SQLException;

public class SubjectSevice {


    public boolean addSubjectSevice(Subject subject) {
        try {
            SubjectDAO.addSubject(subject);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean deleteSubjectSevice(int id) {
        try {
            SubjectDAO.deleteSubject(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
