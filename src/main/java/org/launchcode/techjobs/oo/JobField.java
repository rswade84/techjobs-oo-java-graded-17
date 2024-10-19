package org.launchcode.techjobs.oo;

import java.util.Objects;

public abstract class JobField {

    private int id;
    private static int nextId = 1;
    private String value;

    // Constructor that initializes a uniquie id...
    public JobField() {
        this.id = nextId;
        nextId++;
    }

    // Constructor that initializes a value...
    public JobField(String value) {
        this(); // Calls no-arg or default constructor, used to create instance of class without parameters...
        this.value = value;
    }

    // Getters and Setters...
    public int getId() {
        return id;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

    // Custom Methods: equals, hashCode, toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobField jobField = (JobField) o;
        return id == jobField.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return value;
    }

}
