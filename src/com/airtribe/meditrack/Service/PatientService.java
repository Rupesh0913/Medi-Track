package com.airtribe.meditrack.Service;

import com.airtribe.meditrack.Entity.Patient;
import com.airtribe.meditrack.Util.DataStore;
import com.airtribe.meditrack.Util.IdGenerator;

import java.util.Collection;

public class PatientService {

    private final DataStore<Patient> patientStore = new DataStore<>();

    public Patient addPatient(String name, int age, String disease) {
        String id = IdGenerator.getInstance().nextPatientId();
        Patient patient = new Patient(id, name, age, disease);
        patientStore.save(id, patient);
        return patient;
    }

    public Patient getPatientById(String id) {
        return patientStore.findById(id);
    }

    public Collection<Patient> getAllPatients() {
        return patientStore.findAll();
    }
}
