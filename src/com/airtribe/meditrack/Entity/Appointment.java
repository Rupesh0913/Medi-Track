package com.airtribe.meditrack.Entity;
import com.airtribe.meditrack.Exception.InvalidDataException;
import com.airtribe.meditrack.Observer.AppointmentObserver;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Appointment implements Cloneable{
    private final String appointmentId;
    private final Doctor doctor;
    private final Patient patient;
    private final LocalDateTime appointmentTime;
    private AppointmentStatus status;
    private final List<AppointmentObserver> observers = new ArrayList<>();

    public void registerObserver(AppointmentObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(AppointmentObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (AppointmentObserver observer : observers) {
            observer.update(this);
        }
    }

    public Appointment(String appointmentId, Doctor doctor, Patient patient, LocalDateTime appointmentTime) {

        if (appointmentId == null || appointmentId.trim().isEmpty()) {
            throw new InvalidDataException("Appointment ID cannot be empty");
        }
        if (doctor == null) {
            throw new InvalidDataException("Doctor cannot be null");
        }
        if (patient == null) {
            throw new InvalidDataException("Patient cannot be null");
        }
        if (appointmentTime == null || appointmentTime.isBefore(LocalDateTime.now())) {
            throw new InvalidDataException("Appointment time must be in the future");
        }

        this.appointmentId = appointmentId;
        this.doctor = doctor;
        this.patient = patient;
        this.appointmentTime = appointmentTime;
        this.status = AppointmentStatus.PENDING;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void confirm() {
        if (this.status == AppointmentStatus.CANCELLED) {
            throw new InvalidDataException("Cancelled appointment cannot be completed");
        }
        this.status = AppointmentStatus.CONFIRMED;
        notifyObservers();
    }

    public void cancel() {
        if (this.status == AppointmentStatus.CANCELLED) {
            throw new InvalidDataException("Appointment already cancelled");
        }
        this.status = AppointmentStatus.CANCELLED;
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id='" + appointmentId + '\'' +
                ", doctor=" + doctor.getName() +
                ", patient=" + patient.getName() +
                ", time=" + appointmentTime +
                ", status=" + status +
                '}';
    }

    @Override
    public Appointment clone() {
        try {
            Appointment cloned = (Appointment) super.clone();

            Patient clonedPatient = this.patient.clone();

            Doctor sameDoctor = this.doctor;

            return new Appointment(
                    this.appointmentId,
                    sameDoctor,
                    clonedPatient,
                    this.appointmentTime
            );

        } catch (Exception e) {
            throw new RuntimeException("Appointment cloning failed", e);
        }
    }

}