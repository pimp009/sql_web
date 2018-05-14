package ServiceTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import ru.innopolis.stc9.correctJDBC.Pojo.Teacher;
import ru.innopolis.stc9.sevices.TeacherService;
import static org.junit.Assert.*;

public class ServiceTeacherTest {
    TeacherService service;
    @Parameterized.Parameters
    public static Teacher teacherData()
    {
       return new Teacher(1,"Иван","Bdfyjd00");
    }
    @Before
    public void Before()
    {
        this.service =new TeacherService();
    }
    @Test
    public void addSTeacherServiceTest()
    {
        assertTrue(service.addSTeacherService(teacherData()));
    }

    @Test
    public void getSTeacherServiceTest()
    {
        assertEquals(teacherData(),service.getTeacherService(teacherData().getId()));
    }
    @Test
    public void deleteSTeacherServiceTest()
    {
        assertEquals(teacherData(),service.deleteTecher(teacherData().getId()));
    }

}
