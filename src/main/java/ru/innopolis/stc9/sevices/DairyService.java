package ru.innopolis.stc9.sevices;


import ru.innopolis.stc9.correctJDBC.Dao.DairyDAO;
import ru.innopolis.stc9.correctJDBC.Pojo.Dairy;

import java.sql.SQLException;
import java.util.ArrayList;

/** Класс обретка для
 * методов класса DairyDAO */
public class DairyService {

    DairyDAO archievementDAO = new DairyDAO();

    /** @see DairyDAO#addPoint(Dairy)  */
    public boolean addPointService(Dairy dairy)  {
        try {
            DairyDAO.addPoint(dairy);
        } catch (SQLException e) {
            e.printStackTrace();
        }
 return false;
    }

    /** @see DairyDAO#updatePoint(Dairy)   */
    public  boolean updatePointService(Dairy dairy) {
        try {
            DairyDAO.updatePoint(dairy);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /** @see DairyDAO#updatePoint(Dairy)   */
    public ArrayList<Dairy> getPointStudentService(int id, int subject_id) throws SQLException {
       return DairyDAO.getpointfromsubject(id,subject_id);
    }
}
