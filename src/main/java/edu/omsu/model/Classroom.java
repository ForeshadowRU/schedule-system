package edu.omsu.model;

public class Classroom {
    private String numberClass;
    private int capacity;
    private int parameter;

    public Classroom() {
    }

    public String getNumberClass() {
        return numberClass;
    }

    public void setNumberClass(String numberClass) {
        this.numberClass = numberClass;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getParameter() {
        return parameter;
    }

    public void setParameter(int parameter) {
        this.parameter = parameter;
    }
}
