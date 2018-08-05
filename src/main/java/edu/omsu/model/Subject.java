package edu.omsu.model;

import java.util.Objects;

public class Subject {
    private String name;
    private int hours;
    private int difficulty;

    public Subject() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                ", hours=" + hours +
                ", difficulty=" + difficulty +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return hours == subject.hours &&
                difficulty == subject.difficulty &&
                Objects.equals(name, subject.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, hours, difficulty);
    }
}
