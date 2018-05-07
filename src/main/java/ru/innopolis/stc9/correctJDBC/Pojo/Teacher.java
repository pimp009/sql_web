package ru.innopolis.stc9.correctJDBC.Pojo;

public class Teacher {
    private int id;
    private String Name_Teacher;
    private String SurName_Teacher;

    public Teacher(int id, String name_Teacher, String surName_Teacher) {
        this.id = id;
        Name_Teacher = name_Teacher;
        SurName_Teacher = surName_Teacher;
    }

    public int getId() {
        return id;
    }

    public String getName_Teacher() {
        return Name_Teacher;
    }

    public String getSurName_Teacher() {
        return SurName_Teacher;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName_Teacher(String name_Teacher) {
        Name_Teacher = name_Teacher;
    }

    public void setSurName_Teacher(String surName_Teacher) {
        SurName_Teacher = surName_Teacher;
    }

    public String toString() {
        return "номер: " + this.id + ", имя: " + this.Name_Teacher
                + ", фамилия: " + this.SurName_Teacher;
    }
}
