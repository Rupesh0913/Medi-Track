package com.airtribe.meditrack.Service;

import com.airtribe.meditrack.Entity.Patient;
import com.airtribe.meditrack.Exception.InvalidDataException;
import com.airtribe.meditrack.Util.DataStore;
import com.airtribe.meditrack.Util.IdGenerator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

    public void deletePatient(String id) {
        if (!patientStore.exists(id)) {
            throw new InvalidDataException("Patient not found: " + id);
        }
        patientStore.delete(id);
    }

    public void updateDisease(String id, String newDisease) {
        Patient patient = patientStore.findById(id);
        if (patient == null) {
            throw new InvalidDataException("Patient not found: " + id);
        }
        patient.updateDisease(newDisease);
    }

    public Patient searchPatient(String id) {
        return patientStore.findById(id);
    }

    public List<Patient> searchPatientByName(String name) {
        List<Patient> results = new ArrayList<>();

        for (Patient patient : patientStore.findAll()) {
            if (patient.getName().equalsIgnoreCase(name)) {
                results.add(patient);
            }
        }

        return results;
    }

    public List<Patient> searchPatient(int age) {
        List<Patient> results = new ArrayList<>();

        for (Patient patient : patientStore.findAll()) {
            if (patient.getAge() == age) {
                results.add(patient);
            }
        }

        return results;
    }


    public List<Patient> searchPatients(String keyword) {
        return patientStore.search(keyword);
    }

}
