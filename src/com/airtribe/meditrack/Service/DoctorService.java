package com.airtribe.meditrack.Service;

import com.airtribe.meditrack.Entity.Doctor;
import com.airtribe.meditrack.Entity.Specialization;
import com.airtribe.meditrack.Exception.InvalidDataException;
import com.airtribe.meditrack.Util.DataStore;
import com.airtribe.meditrack.Util.IdGenerator;

import java.util.Collection;
import java.util.List;

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

    public List<Doctor> searchDoctors(String keyword) {
        return doctorStore.search(keyword);
    }

    public void updateDoctorFee(String id, double newFee) {
        Doctor doctor = doctorStore.findById(id);

        if (doctor == null) {
            throw new InvalidDataException("Doctor not found: " + id);
        }

        doctor.updateConsultationFee(newFee);
    }

    public void updateSpecialization(String id, Specialization specialization) {
        Doctor doctor = doctorStore.findById(id);

        if (doctor == null) {
            throw new InvalidDataException("Doctor not found: " + id);
        }

        doctor.changeSpecialization(specialization);
    }

    public void deleteDoctor(String id) {

        if (!doctorStore.exists(id)) {
            throw new InvalidDataException("Doctor not found: " + id);
        }

        doctorStore.delete(id);
    }
}
