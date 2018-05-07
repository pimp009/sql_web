package ru.innopolis.stc9.sevices;

import ru.innopolis.stc9.correctJDBC.Dao.GroupDAO;
import ru.innopolis.stc9.correctJDBC.Pojo.Group;
import ru.innopolis.stc9.correctJDBC.Pojo.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public class GroupService {
GroupDAO groupDAO = new GroupDAO();
    public boolean addGroudService(Group group)  {
        try {
            groupDAO.addGroud(group);
        } catch (SQLException e) {
            e.printStackTrace();
        }
     return false;
    }

    public  Group  getGroudService(int id)
    {
       return groupDAO.getGroud(id);

    }
    public  boolean deletegroupService(int id)  {
        try {
            groupDAO.deletegroup(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
  public ArrayList<Student> getStudentfromGroup(int namegroup)
  {
      try {
          return groupDAO.getStudentGroup(namegroup);
      } catch (SQLException e) {
          e.printStackTrace();
      }
      return null;
  }


}
