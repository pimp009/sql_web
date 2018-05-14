package ru.innopolis.stc9;

import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import ru.innopolis.stc9.correctJDBC.Dao.GroupDAO;
import ru.innopolis.stc9.correctJDBC.Pojo.Group;

import java.sql.SQLException;


import static org.junit.Assert.*;

public class GroupDAOTest {
    private GroupDAO groupDAO;

@Before
    public void Before() throws SQLException {
    this.groupDAO =new GroupDAO();
  }
    @Parameterized.Parameters
    public static Group GroupData(){
    return new Group(1,220);
    }

   @Test
    public void addGroupTest() throws SQLException {
    assertTrue(GroupDAO.addGroup(GroupData()));
   }
    @Test
    public void getGroupTest() throws SQLException {
        assertEquals(GroupData(),GroupDAO.getGroup(GroupData().getId()));
    }


    @Test
    public void deleteGroupTest() throws SQLException {
        assertTrue(GroupDAO.deletegroup(GroupData().getId()));
    }






}
