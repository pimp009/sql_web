package ru.innopolis.stc9.correctJDBC.Pojo;

import java.util.Objects;

/** Класс группа*/
public class Group {
    private int id;
    private int nameGroup;

    public int getId() {
        return id;
    }

    public int getNameGroup() {
        return nameGroup;
    }

    /** Конструктор*/
    public Group(int id, int name_Group) {
        this.id = id;
        nameGroup = name_Group;

    }
    /** Сетеры*/
    public void setId(int id) {
        this.id = id;
    }

    public void setName_Group(int nameGroup) {
        this.nameGroup = nameGroup;
    }

    public String toString() {
        return "номер: " + this.id + ", имя: " + this.nameGroup;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group)) return false;
        Group group = (Group) o;
        return getId() == group.getId() &&
                getNameGroup() == group.getNameGroup();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getNameGroup());
    }
}