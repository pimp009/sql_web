package ru.innopolis.stc9.correctJDBC.Pojo;

public class Group {
    private int id;
    private int Name_Group;

    public int getId() {
        return id;
    }

    public int getName_Group() {
        return Name_Group;
    }

    public Group(int id, int name_Group) {
        this.id = id;
        Name_Group = name_Group;

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName_Group(int name_Group) {
        Name_Group = name_Group;
    }

    public String toString() {
        return "номер: " + this.id + ", имя: " + this.Name_Group;

    }
}