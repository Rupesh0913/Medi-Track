package com.airtribe.mediTrack.Entity;

import com.airtribe.mediTrack.Exception.InvalidDataException;

public class Patient extends Person{

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
        if (newDisease == null || newDisease.isEmpty()) {
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
                '}';
    }
}
