package ru.innopolis.stc9.correctJDBC.Pojo;

public class Subject {
    private int id;
    private String Name_Subject;

    public Subject(int id, String name_Subject) {
        this.id = id;
        Name_Subject = name_Subject;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName_Subject(String name_Subject) {
        Name_Subject = name_Subject;
    }

    public int getId() {
        return id;
    }

    public String getName_Subject() {
        return Name_Subject;
    }
    public String toString() {
        return "номер: " + this.id + ", имя: " + this.Name_Subject;

    }
}
