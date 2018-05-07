package ru.innopolis.stc9.correctJDBC.Pojo;

import java.util.Date;
import java.util.Objects;

public class Achievement {
    private int id;
    private int subject_id;
    private int student_id;
    private int teacher_id;
    private int point;
    private int date;


    public Achievement(int id, int subject_id, int student_id, int teacher_id, int point, int date) {
        this.id = id;
        this.subject_id = subject_id;
        this.student_id = student_id;
        this.teacher_id = teacher_id;
        this.point = point;
        this.date = date;
    }

    public Achievement(String name, String surname, int point, int date, String surname_teacher) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        subject_id = subject_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        student_id = student_id;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        teacher_id = teacher_id;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String toString() {
        return "номер: " + this.id + ", предмет: " + this.subject_id + ", студент: " + this.student_id
                + ", преподователь: " + this.teacher_id +  " оценка" + this.point + " дата:" + this.date;
    }

}
