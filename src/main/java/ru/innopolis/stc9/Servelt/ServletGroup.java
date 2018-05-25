package ru.innopolis.stc9.Servelt;

import ru.innopolis.stc9.correctJDBC.Pojo.Group;
import ru.innopolis.stc9.correctJDBC.Pojo.Student;
import ru.innopolis.stc9.sevices.GroupService;

import javax.script.ScriptContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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

       req.getRequestDispatcher("/studentsgroup.jsp").forward(req, resp);
        String namegroup = req.getParameter("group");
        ArrayList<Student> group = null;
                if (namegroup != null)
                {groupService.getStudentfromGroup(Integer.parseInt(namegroup));}
        req.setAttribute("group", group);
        req.getRequestDispatcher("/viewstudent.jsp").forward(req, resp);

    }
}

