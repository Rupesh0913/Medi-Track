package com.airtribe.meditrack.Test;

import com.airtribe.meditrack.Entity.Appointment;
import com.airtribe.meditrack.Entity.Doctor;
import com.airtribe.meditrack.Entity.Patient;
import com.airtribe.meditrack.Entity.Specialization;

import java.time.LocalDateTime;

public class TestRunner {

    public static void main(String[] args) {

        Doctor doctor = new Doctor("D1", "Dr. House", 50,
                Specialization.CARDIOLOGY, 1000);

        Patient patient = new Patient("P1", "John", 30, "Heart Issue");

        Appointment original = new Appointment(
                "A1",
                doctor,
                patient,
                LocalDateTime.now().plusDays(1)
        );

        Appointment cloned = original.clone();

        // Modify original patient
        patient.updateDisease("Severe Heart Issue");

        System.out.println("Original Patient Disease: "
                + original.getPatient().getDisease());

        System.out.println("Cloned Patient Disease: "
                + cloned.getPatient().getDisease());
    }
}
