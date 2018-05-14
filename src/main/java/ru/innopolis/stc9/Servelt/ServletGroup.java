package ru.innopolis.stc9.Servelt;

import ru.innopolis.stc9.correctJDBC.Pojo.Group;
import ru.innopolis.stc9.correctJDBC.Pojo.Student;
import ru.innopolis.stc9.sevices.GroupService;

import javax.script.ScriptContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ServletGroup extends HttpServlet {
    final public GroupService groupService = new GroupService();

    /**
     * Метод формирующий запрос в БД
     * Получение сведений остудентах определенной группы
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String namegroup = req.getParameter("namegroup");
        ArrayList<Student> group = null;
        if (namegroup != null) {
             group = groupService.getStudentfromGroup(Integer.parseInt(namegroup));
            for (Student student : group) {
                resp.setContentType("text/html;charset=utf-8");
                resp.getWriter().write(student.toString()+"\n");


            }
        } if (group.isEmpty()){
            resp.getWriter().println("Nothing");
        }

    }

}