package ru.innopolis.stc9;

import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import ru.innopolis.stc9.correctJDBC.Dao.SubjectDAO;
import ru.innopolis.stc9.correctJDBC.Pojo.Subject;
import java.sql.SQLException;
import static org.junit.Assert.assertTrue;



public class SubjectDAOTest {

    private SubjectDAO subjectDAO;
    @Parameterized.Parameters
    public static Subject subjectData()
    {
        return new Subject(22,"Физика");
    }

    @Before
    public void before(){
        this.subjectDAO = new SubjectDAO();

    }

    @Test
    public void addTeacherTest() throws SQLException {
        assertTrue(subjectDAO.addSubject(subjectData()));

    }

    @Test
    public void addgetdeleteTeacherTest() throws SQLException {
        assertTrue(subjectDAO.deleteSubject(subjectData().getId()));

    }
}

