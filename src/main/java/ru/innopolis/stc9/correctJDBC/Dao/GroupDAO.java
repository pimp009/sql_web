package ru.innopolis.stc9.correctJDBC.Dao;



import ru.innopolis.stc9.ConnectionManager.ConnectionManager;
import ru.innopolis.stc9.correctJDBC.Pojo.Group;
import ru.innopolis.stc9.correctJDBC.Pojo.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GroupDAO {
    private static ConnectionManager connectionManager = ConnectionManager.getInstance();
    public static boolean addGroud(Group group) throws SQLException {
        Connection connection = connectionManager.getConnection();

            PreparedStatement statement = connection.prepareStatement
                    ("INSERT INTO group (id,name_group)VALUES (?,?)");
            statement.setInt(1, group.getId());
            statement.setInt(2,group.getName_Group());
            int res=statement.executeUpdate();
            connection.close();
            if(res>0)
            {
                return true;
            }
            else return false;

    }
    public static Group  getGroud(int id)
    {
        Connection connection =connectionManager.getConnection();
        Group group = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * " +
                    "FROM group WHERE id = ?");
            statement.setInt(1,id);
            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
         return group;



    }
    public static boolean deletegroup(int id) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement
                ("DELETE FROM group WHERE id = ?");
        statement.setInt(1, id);
        int str = statement.executeUpdate();
        connection.close();
        if(str>0){
            return true;}
        else
            return false;
    }
    public  static ArrayList<Student> getStudentGroup(int namegroup) throws SQLException {
        ArrayList<Student> result = new ArrayList<>();
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT student.id, " +
                "student.name, student.surname, \"group\".namegroup " +
                " FROM student INNER JOIN \"group\"\n" +
                "    on student.group_id = \"group\".id WHERE namegroup=?;");
        statement.setInt(1, namegroup);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next())
        {
          Student student = new Student(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("surname"), resultSet.getInt("namegroup"));
                     result.add(student);
        }
        connection.close();
        return result;
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(getStudentGroup(201));
    }

}
