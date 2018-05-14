package ru.innopolis.stc9.correctJDBC.Pojo;

/** Класс дневник*/
public class Dairy {
    private int id;
    private int subject_id;
    private int student_id;
    private int teacher_id;
    private int point;
    private String date;
    private String name;
    private String surname;

    @Override
    public String toString() {
        return  "name = " + name +  " surname = "  + surname +
                " point = " + point + " date= " + date
                +  " name_subject = " + name_subject + " surname_teacher = " + surname_teacher;

    }

    public Dairy(int id, int subject_id, int student_id, int teacher_id, int point, String date) {
      this.id = id;
        this.subject_id = subject_id;
       this.student_id = student_id;
        this.teacher_id = teacher_id;
        this.point = point;
        this.date = date;
    }

    public Dairy(String name, String surname, String name_subject, int point, String date, String surname_teacher) {
        this.name = name;
        this.surname = surname;
        this.point = point;
        this.date = date;
        this.name_subject = name_subject;
        this.surname_teacher = surname_teacher;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName_subject(String name_subject) {
        this.name_subject = name_subject;
    }

    public void setSurname_teacher(String surname_teacher) {
        this.surname_teacher = surname_teacher;
    }

    private String name_subject;
    private String surname_teacher;
  /** Функция получения значения поля {@link Dairy#name}*/
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getName_subject() {
        return name_subject;
    }

    public String getSurname_teacher() {
        return surname_teacher;
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
        this.subject_id = subject_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }



}
