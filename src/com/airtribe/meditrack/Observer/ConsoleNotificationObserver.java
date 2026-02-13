package com.airtribe.meditrack.Observer;

import com.airtribe.meditrack.Entity.Appointment;

public class ConsoleNotificationObserver implements AppointmentObserver {
    @Override
    public void update(Appointment appointment) {
        System.out.println("🔔 Notification: Appointment "
                + appointment.getAppointmentId()
                + " is now "
                + appointment.getStatus());
    }
}
