package com.hospital.services;

import com.hospital.models.Doctor;
import com.hospital.repositories.DoctorRepository;
import java.util.List;

public class DoctorService {
    private final DoctorRepository doctorRepo;

    public DoctorService(DoctorRepository doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    public Doctor addDoctor(Doctor doctor) {
        // Business logic to add a new doctor (e.g., check if the doctor already exists)
        List<Doctor> doctors = doctorRepo.findAll();
        if (doctors.stream().anyMatch(d -> d.getLicenseNumber().equals(doctor.getLicenseNumber()))) {
            throw new IllegalArgumentException("Doctor with this license number already exists");
        }
        return doctorRepo.save(doctor);
    }

    public Doctor getDoctorById(String doctorId) {
        return doctorRepo.findById(doctorId)
            .orElseThrow(() -> new RuntimeException("Doctor not found"));
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepo.findAll();
    }
}
