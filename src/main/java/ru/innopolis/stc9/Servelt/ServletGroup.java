package ru.innopolis.stc9.Servelt;

import com.sun.org.apache.xerces.internal.impl.io.UTF8Reader;
import ru.innopolis.stc9.correctJDBC.Pojo.Student;
import ru.innopolis.stc9.sevices.GroupService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ServletGroup extends HttpServlet {
    private GroupService groupService = new GroupService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String namegroup = req.getParameter("namegroup");

        if (namegroup != null) {
            ArrayList<Student> group = groupService.getStudentfromGroup(Integer.parseInt(namegroup));
            for (Student student : group) {
                resp.setContentType("text/html;charset=utf-8");
                resp.getWriter().println(student.getId() + " " + student.getName()+ " "
                        + student.getSurName()+ " " );

            }
        } else {
            resp.getWriter().println("Nothing");
        }

    }

}
