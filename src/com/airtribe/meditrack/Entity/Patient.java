package com.airtribe.meditrack.Entity;

import com.airtribe.meditrack.Exception.InvalidDataException;
import com.airtribe.meditrack.Interface.Searchable;

public class Patient extends Person implements Cloneable, Searchable {

    private String disease;

    public Patient(String id, String name, int age, String disease) {
        super(id, name, age);
        if (disease == null || disease.isEmpty()) {
            throw new InvalidDataException("Disease cannot be empty");
        }
        this.disease = disease;
    }

    public String getDisease() {
        return disease;
    }

    public void updateDisease(String newDisease)  {
        if (newDisease == null || newDisease.trim().isEmpty()) {
            throw new InvalidDataException("Disease cannot be empty");
        }
        this.disease = newDisease;
    }


    @Override
    public String getRole() {
        return "Patient";
    }

    @Override
    public String toString() {
        return "Patient{" +
                "disease='" + disease + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public Patient clone() {
        try {
            return (Patient) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning failed", e);
        }
    }

    @Override
    public boolean matches(String keyword) {
        if (keyword == null) return false;

        String lowerKeyword = keyword.toLowerCase();

        return getName().toLowerCase().contains(lowerKeyword)
                || disease.toLowerCase().contains(lowerKeyword);
    }
}
