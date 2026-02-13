package com.airtribe.meditrack.Service;

import com.airtribe.meditrack.Entity.Doctor;
import com.airtribe.meditrack.Entity.Specialization;
import com.airtribe.meditrack.Util.DataStore;
import com.airtribe.meditrack.Util.IdGenerator;

import java.util.Collection;

public class DoctorService {

    private final DataStore<Doctor> doctorStore = new DataStore<>();

    public Doctor addDoctor(String name, int age,
                            Specialization specialization, double fee) {

        String id = IdGenerator.getInstance().nextDoctorId();
        Doctor doctor = new Doctor(id, name, age, specialization, fee);
        doctorStore.save(id, doctor);
        return doctor;
    }

    public Doctor getDoctorById(String id) {
        return doctorStore.findById(id);
    }

    public Collection<Doctor> getAllDoctors() {
        return doctorStore.findAll();
    }
}
