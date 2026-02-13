package com.airtribe.meditrack.Util;

import com.airtribe.meditrack.Entity.Appointment;
import com.airtribe.meditrack.Entity.AppointmentStatus;
import com.airtribe.meditrack.Entity.Bill;
import com.airtribe.meditrack.Exception.InvalidDataException;

public class BillFactory {
    private BillFactory() {
    }

    public static Bill createBill(Appointment appointment) {

        String billId = IdGenerator.getInstance().nextBillId();

        if (appointment == null) {
            throw new InvalidDataException("Appointment cannot be null");
        }

        if (appointment.getStatus() != AppointmentStatus.CONFIRMED) {
            throw new InvalidDataException(
                    "Bill can only be generated for CONFIRMED appointments"
            );
        }

        return new Bill(billId, appointment);
    }
}
