package edu.omsu.model;

public class Lesson {
    private int number;
    private Subject subject;
    private Teacher teacher;
    private Classroom classroom;
    private int day_number;

    public Lesson() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public int getDay_number() {
        return day_number;
    }

    public void setDay_number(int day_number) {
        this.day_number = day_number;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "number=" + number +
                ", subject=" + subject +
                ", teacher=" + teacher +
                ", classroom=" + classroom +
                ", day_number=" + day_number +
                '}';
    }
}
