package ru.innopolis.stc9.correctJDBC.Pojo;

/** Класс студент*/
public class Student {
    private int id;
    private String Name;
    private String SurName;
    private int Group_id;
    private Group group;

    public Student(int id, String name, String surName) {
        this.id = id;
        Name = name;
        SurName = surName;

    }

    public Student(int id, String name, String surName, int group_id) {
        this.id = id;
        Name = name;
        SurName = surName;
        Group_id = group_id;
    }

    public int getId() {
        return id;
    }

    public String getName()
    {
        return Name;
    }

    public String getSurName() {
        return SurName;
    }

    public int getGroup_id() {
        return Group_id;
    }

    public Group getGroup() {
        return group;
    }

    public String toString() {
        return "номер: " + this.id + ", имя: " + this.Name
                + ", фамилия: " + this.SurName + ", группа: "
                + this.Group_id;
    }

}
