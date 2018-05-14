package ru.innopolis.stc9;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import ru.innopolis.stc9.correctJDBC.Dao.GroupDAO;
import ru.innopolis.stc9.correctJDBC.Dao.StudentDAO;
import ru.innopolis.stc9.correctJDBC.Pojo.Group;
import ru.innopolis.stc9.correctJDBC.Pojo.Student;

import java.sql.SQLException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertSame;
import static junit.framework.TestCase.assertTrue;

public class StudentDAOTest {
    private StudentDAO studentDAO;
    private GroupDAO groupDAO;
    Student student;
    Student studentUpdate;
    Group group;

    @Parameterized.Parameters
    public static Student StudentData()
    {

        return new Student(1, "Иван", "Bdfyjd", 2);
    }
    @Parameterized.Parameters
    public static Group GroupData()
    {

        return new Group(2,103);
    }
    @Parameterized.Parameters
    public static Student UpdateStudent()
    {

        return new Student(1, "Иван", "Петров", 2);
    }
    @Before
    public void Before() throws SQLException {
        this.studentDAO = new StudentDAO();
        groupDAO = new GroupDAO();
        groupDAO.addGroup(GroupData());

    }

    @Test
    public void addStudentTest() throws SQLException {
       assertTrue(studentDAO.addStudent(StudentData()));
    }
    @Test
    public void UpdateStudentTest() throws SQLException {
        assertTrue(studentDAO.updateStudent(StudentData()));
    }
    @Test
    public void GetStudentTest() throws SQLException {
        assertSame(UpdateStudent(), studentDAO.getStudent(1));
    }
    @Test
    public void DeleteStudentTest() throws SQLException {
        assertTrue(studentDAO.deleteStudent(StudentData().getId()));
    }
   @After
   public void CreateTable() throws SQLException {
        groupDAO.deletegroup(1);
        studentDAO.deleteStudent(1);
    }
}

