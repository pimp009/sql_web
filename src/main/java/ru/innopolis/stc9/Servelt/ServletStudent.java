package ru.innopolis.stc9.Servelt;




import ru.innopolis.stc9.correctJDBC.Pojo.Student;
import ru.innopolis.stc9.sevices.GroupService;
import ru.innopolis.stc9.sevices.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ServletStudent extends HttpServlet {
    final public StudentService studentService = new StudentService();

    /**
     * Метод формирующий запрос в БД
     * Получение сведений студента
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //req.getRequestDispatcher("/studentsgroup.jsp").forward(req, resp);
        String id = req.getParameter("id");
        Student student = null;
        if (id != null) {
            student = studentService.getStudentById(Integer.parseInt(id));

            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write(student.toString()+"\n");
            req.setAttribute("student", student);
            req.getRequestDispatcher("/studentsgroup.jsp").forward(req, resp);
                    }
                    if (student==null){
            resp.getWriter().println("Nothing");
        }

    }

}