package ServeletTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import ru.innopolis.stc9.Servelt.ServletGroup;
import ru.innopolis.stc9.correctJDBC.Pojo.Student;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;

public class ServeletGruopTest  {
    //private static final Object ArrayList = ;
    HttpServletRequest request = mock(HttpServletRequest.class);
    HttpServletResponse response = mock(HttpServletResponse.class);
    public String fghgfghf="111";

    @Before


    @Test
    public void Test() throws IOException, ServletException {
      String fg="111";
        //when(request.getParameter("namegroup")).then()
        StringWriter sw = new StringWriter();

        Mockito.when(response.getWriter()).thenReturn(new PrintWriter(sw));
        ServletGroup servletGroup = new ServletGroup();
        servletGroup.doGet(request,response);
        verify(request, atLeast(1)).getParameter("namegroup");
        String s1 = sw.toString();
        System.out.println(s1);
        //sw.flush();
        assertTrue(sw.toString().contains("111"));




    }




}
