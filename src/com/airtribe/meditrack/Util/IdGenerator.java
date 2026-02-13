package com.airtribe.meditrack.Util;

public class IdGenerator {

    private long billCounter = 0;
    private long appointmentCounter = 0;
    private long doctorCounter = 0;
    private long patientCounter = 0;

    private static final IdGenerator INSTANCE = new IdGenerator();

    private IdGenerator() {}

    public static IdGenerator getInstance() {
        return INSTANCE;
    }

    public synchronized String nextBillId() {
        return "BILL-" + (++billCounter);
    }

    public synchronized String nextAppointmentId() {
        return "APT-" + (++appointmentCounter);
    }

    public synchronized String nextDoctorId() {
        return "DOC-" + (++doctorCounter);
    }

    public synchronized String nextPatientId() {
        return "PAT-" + (++patientCounter);
    }
}
