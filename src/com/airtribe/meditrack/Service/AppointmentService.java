package com.airtribe.meditrack.Service;

import com.airtribe.meditrack.Entity.Appointment;
import com.airtribe.meditrack.Entity.Bill;
import com.airtribe.meditrack.Entity.Doctor;
import com.airtribe.meditrack.Entity.Patient;
import com.airtribe.meditrack.Exception.InvalidDataException;
import com.airtribe.meditrack.Util.BillFactory;
import com.airtribe.meditrack.Util.DataStore;
import com.airtribe.meditrack.Util.IdGenerator;

import java.time.LocalDateTime;
import java.util.Collection;

public class AppointmentService {

    private final DataStore<Appointment> appointmentStore = new DataStore<>();

    public Appointment createAppointment(Doctor doctor,
                                         Patient patient,
                                         LocalDateTime time) {

        String id = IdGenerator.getInstance().nextAppointmentId();
        Appointment appointment = new Appointment(id, doctor, patient, time);
        appointmentStore.save(id, appointment);
        return appointment;
    }

    public void confirmAppointment(String appointmentId) {
        Appointment appointment = getAppointmentOrThrow(appointmentId);
        appointment.confirm();
    }

    public void cancelAppointment(String appointmentId) {
        Appointment appointment = getAppointmentOrThrow(appointmentId);
        appointment.cancel();
    }

    public Bill generateBill(String appointmentId) {
        Appointment appointment = getAppointmentOrThrow(appointmentId);
        return BillFactory.createBill(appointment);
    }

    public Appointment getAppointmentById(String id) {
        return appointmentStore.findById(id);
    }

    public Collection<Appointment> getAllAppointments() {
        return appointmentStore.findAll();
    }

    private Appointment getAppointmentOrThrow(String id) {
        Appointment appointment = appointmentStore.findById(id);
        if (appointment == null) {
            throw new InvalidDataException("Appointment not found: " + id);
        }
        return appointment;
    }

}
