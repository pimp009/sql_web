package ru.innopolis.stc9;

import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import ru.innopolis.stc9.correctJDBC.Dao.TeacherDAO;
import ru.innopolis.stc9.correctJDBC.Pojo.Teacher;
import java.sql.SQLException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;



public class TeacherDAOTest {

    private TeacherDAO teacherDAO;
    @Parameterized.Parameters
    public static Teacher teacherData()
    {
        return new Teacher(9,"Иван", "Петров");
    }


    @Before
    public void Before(){
        this.teacherDAO = new TeacherDAO();

    }

    @Test
    public void addTeacherTest() throws SQLException {
        assertTrue(teacherDAO.addSTeacher(teacherData()));
    }
    @Test
    public void getTeacherTest() throws SQLException {
        assertEquals(teacherData(), teacherDAO.getTeacher(9));

    }
      @Test
    public void deleteTeacherTest() throws SQLException {
        assertTrue(teacherDAO.deleteTecher(9));

    }
}

