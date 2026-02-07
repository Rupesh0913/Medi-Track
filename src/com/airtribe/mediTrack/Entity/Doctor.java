package com.airtribe.mediTrack.Entity;

import com.airtribe.mediTrack.Exception.InvalidDataException;

public class Doctor extends Person {

    private Specialization specialization;
    private double consultationFee;

    public Doctor(String id, String name, int age, Specialization specialization, double consultationFee) {
        super(id, name, age);
        if (specialization == null) {
            throw new InvalidDataException("Specialization cannot be null");
        }
        if (consultationFee <= 0) {
            throw new InvalidDataException("Consultation fee must be positive");
        }
        this.specialization = specialization;
        this.consultationFee = consultationFee;
    }

    public void updateConsultationFee(double newFee) {
        if (newFee <= 0) {
            throw new InvalidDataException("Consultation fee must be positive");
        }
        this.consultationFee = newFee;
    }

    public void changeSpecialization(Specialization newSpecialization)  {
        if (newSpecialization == null) {
            throw new InvalidDataException("Specialization cannot be null");
        }
        this.specialization = newSpecialization;
    }


    @Override
    public String getRole() {
        return "Doctor";
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "specialization=" + specialization +
                ", consultationFee=" + consultationFee +
                '}';
    }
}
