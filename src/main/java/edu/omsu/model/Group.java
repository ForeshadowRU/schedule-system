package edu.omsu.model;

import java.util.Objects;
import java.util.Set;

public class Group {
    private String code;
    private int number;
    private boolean fullTime;
    private int quantityPeople;
    private Set<Subject> subjects;

    public Group() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isFullTime() {
        return fullTime;
    }

    public void setFullTime(boolean fullTime) {
        this.fullTime = fullTime;
    }

    public int getQuantityPeople() {
        return quantityPeople;
    }

    public void setQuantityPeople(int quantityPeople) {
        this.quantityPeople = quantityPeople;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Group{" +
                "code='" + code + '\'' +
                ", number=" + number +
                ", fullTime=" + fullTime +
                ", quantityPeople=" + quantityPeople +
                ", subjects=" + subjects +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return number == group.number &&
                fullTime == group.fullTime &&
                quantityPeople == group.quantityPeople &&
                Objects.equals(code, group.code) &&
                Objects.equals(subjects, group.subjects);
    }

    @Override
    public int hashCode() {

        return Objects.hash(code, number, fullTime, quantityPeople, subjects);
    }
}
