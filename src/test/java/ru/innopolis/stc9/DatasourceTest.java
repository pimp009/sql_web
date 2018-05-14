package ru.innopolis.stc9;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ru.innopolis.stc9.correctJDBC.Dao.GroupDAO;
import ru.innopolis.stc9.correctJDBC.Pojo.Group;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DatasourceTest {

    @InjectMocks
    GroupDAO groupDAO;
    @Mock
    Connection connection;
    @Mock
    PreparedStatement statement;
    @Before
    public void setUp() throws SQLException {
        when(connection.prepareStatement(eq("INSERT INTO group (id,name_group)VALUES (?,?)"))).thenReturn(statement);
        when(statement.executeUpdate()).thenReturn(1);


    }

    @Test
    public void testInsertTable() throws SQLException {
        Group group = new Group(1,201);
        Assert.assertEquals(group,groupDAO.getGroup(201));

    }
}