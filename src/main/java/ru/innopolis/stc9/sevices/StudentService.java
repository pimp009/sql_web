package ru.innopolis.stc9.sevices;

import ru.innopolis.stc9.correctJDBC.Dao.StudentDAO;
import ru.innopolis.stc9.correctJDBC.Pojo.Student;

import java.sql.SQLException;
import java.util.List;

public class StudentService {
StudentDAO studentDAO = new StudentDAO();

   public boolean addStudent(Student student)  {
       try {
           studentDAO.addStudent(student);
           }
           catch (SQLException e) {
           e.printStackTrace();
       }
       return false;
   }
    public  Student getStudentById(int id)
    {
        try {
            return studentDAO.getStudent(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public  boolean updateStudentService(Student student)
    {
        try {
            studentDAO.updateStudent(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public  boolean deleteStudent(int id){
        try {
            studentDAO.deleteStudent(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
