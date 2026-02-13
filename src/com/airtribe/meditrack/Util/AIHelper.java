package com.airtribe.meditrack.Util;

import com.airtribe.meditrack.Entity.Specialization;

import java.time.LocalDateTime;

public class AIHelper {
    private AIHelper() {}

    public static Specialization recommendSpecialization(String symptom) {

        if (symptom == null || symptom.trim().isEmpty()) {
            return Specialization.GENERAL_MEDICINE;
        }

        String lower = symptom.toLowerCase();

        if (lower.contains("heart") || lower.contains("chest")) {
            return Specialization.CARDIOLOGY;
        }

        if (lower.contains("skin") || lower.contains("rash")) {
            return Specialization.DERMATOLOGY;
        }

        if (lower.contains("bone") || lower.contains("joint") || lower.contains("fracture")) {
            return Specialization.ORTHOPEDICS;
        }

        return Specialization.GENERAL_MEDICINE;
    }

    public static LocalDateTime suggestAppointmentTime() {

        LocalDateTime now = LocalDateTime.now();

        return now.plusDays(1).withHour(10).withMinute(0).withSecond(0).withNano(0);
    }

}
