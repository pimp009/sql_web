package ru.innopolis.stc9.sevices;

import ru.innopolis.stc9.correctJDBC.Dao.StudentDAO;
import ru.innopolis.stc9.correctJDBC.Pojo.Student;

import java.sql.SQLException;

/** Класс обретка для
 * методов класса StudentDAO */
public class StudentService {
StudentDAO studentDAO = new StudentDAO();

    /** @see StudentDAO#addStudent(Student)  */
   public boolean addStudent(Student student)  {
       try {
           studentDAO.addStudent(student);
           }
           catch (SQLException e) {
           e.printStackTrace();
       }
       return false;
   }
    /** @see StudentDAO#getStudent(int)   */
    public  Student getStudentById(int id)
    {
        try {
            return studentDAO.getStudent(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    /** @see StudentDAO#updateStudent(Student) */
    public  boolean updateStudentService(Student student)
    {
        try {
            studentDAO.updateStudent(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    /** @see StudentDAO#deleteStudent(int)  */
    public  boolean deleteStudent(int id){
        try {
            studentDAO.deleteStudent(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static void main(String[] args) throws SQLException {
        StudentService service =new StudentService();
        System.out.println(service.getStudentById(1));
    }
}
