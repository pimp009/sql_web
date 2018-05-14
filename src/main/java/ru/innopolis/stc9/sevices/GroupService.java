package ru.innopolis.stc9.sevices;

import ru.innopolis.stc9.correctJDBC.Dao.GroupDAO;
import ru.innopolis.stc9.correctJDBC.Pojo.Group;
import ru.innopolis.stc9.correctJDBC.Pojo.Student;

import java.sql.SQLException;
import java.util.ArrayList;

/** Класс обретка для
 * методов класса GroupDAO */
public class GroupService {
GroupDAO groupDAO = new GroupDAO();

    /** @see GroupDAO#addGroup(Group)  */
    public boolean addGroudService(Group group)  {
        try {
            groupDAO.addGroup(group);
        } catch (SQLException e) {
            e.printStackTrace();
        }
     return false;
    }

    /** @see GroupDAO#getGroup(int)   )  */
    public  Group  getGroudService(int id)
    {
       return groupDAO.getGroup(id);

    }
    /** @see GroupDAO#deletegroup(int)   */
    public  boolean deletegroupService(int id)  {
        try {
            groupDAO.deletegroup(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /** @see GroupDAO#getStudentGroup(int)   */
  public ArrayList<Student> getStudentfromGroup(int namegroup)
 {
      try {
          return groupDAO.getStudentGroup(namegroup);
      } catch (SQLException e) {
          e.printStackTrace();
      }
      return null;
  }

    public static void main(String[] args) {
        GroupService service = new GroupService();
        System.out.println(service.getStudentfromGroup(103));

    }


}
