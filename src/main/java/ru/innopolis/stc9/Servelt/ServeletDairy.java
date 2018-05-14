package ru.innopolis.stc9.Servelt;



import ru.innopolis.stc9.correctJDBC.Pojo.Dairy;
import ru.innopolis.stc9.sevices.DairyService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServeletDairy extends HttpServlet {
    final private DairyService dairyService = new DairyService();
    /** Метод формирующий запрос в БД
     * Получение сведений об оценках студента за определенный предмет*/
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String id = req.getParameter("id");
        String subject_id = req.getParameter("subject_id");
        if (id != null && subject_id != null) {
            ArrayList<Dairy> dairystudent = null;
            try {
                dairystudent = dairyService.getPointStudentService(Integer.parseInt(id), Integer.parseInt(subject_id));
            } catch (SQLException e) {
                e.printStackTrace();
            }

            for (Dairy dairy : dairystudent) {
                resp.setContentType("text/plain;charset=utf-8");
                resp.getWriter().write(dairy.getName() + " " + dairy.getSurname() + " "
                        + dairy.getName_subject() + " оценка " + dairy.getPoint() + " дата " + dairy.getDate() +
                        " преподователь " + dairy.getSurname_teacher() + "\r\n");


            }
        } else {
            resp.getWriter().write("Nothing");
        }


    }
}



