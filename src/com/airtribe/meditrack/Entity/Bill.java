package com.airtribe.meditrack.Entity;

import com.airtribe.meditrack.Constants.Constants;
import com.airtribe.meditrack.Exception.InvalidDataException;
import com.airtribe.meditrack.Interface.Payable;

import java.time.LocalDateTime;

public class Bill implements Payable {

    private final String billId;
    private final Appointment appointment;
    private final double baseAmount;
    private final double taxAmount;
    private final double totalAmount;
    private final LocalDateTime generatedAt;

    public Bill(String billId, Appointment appointment) {

        if (billId == null || billId.trim().isEmpty()) {
            throw new InvalidDataException("Bill ID cannot be empty");
        }
        if (appointment == null) {
            throw new InvalidDataException("Appointment cannot be null");
        }
        if (appointment.getStatus() != AppointmentStatus.CONFIRMED) {
            throw new InvalidDataException("Bill can be generated only for confirmed appointments");
        }

        this.billId = billId;
        this.appointment = appointment;
        this.baseAmount = appointment.getDoctor().getConsultationFee();
        this.taxAmount = baseAmount * Constants.TAX_RATE;
        this.totalAmount = baseAmount + taxAmount;
        this.generatedAt = LocalDateTime.now();
    }

    @Override
    public double calculateAmount() {
        return totalAmount;
    }

    public String getBillId() {
        return billId;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public double getBaseAmount() {
        return baseAmount;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public LocalDateTime getGeneratedAt() {
        return generatedAt;
    }

    public BillSummary generateSummary() {
        return new BillSummary(
                billId,
                appointment.getPatient().getName(),
                appointment.getDoctor().getName(),
                baseAmount,
                taxAmount,
                totalAmount,
                generatedAt
        );
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billId='" + billId + '\'' +
                ", baseAmount=" + baseAmount +
                ", taxAmount=" + taxAmount +
                ", totalAmount=" + totalAmount +
                ", generatedAt=" + generatedAt +
                '}';
    }
}
