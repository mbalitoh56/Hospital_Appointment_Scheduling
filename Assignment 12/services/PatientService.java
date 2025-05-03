package com.hospital.services;

import com.hospital.models.Patient;
import com.hospital.repositories.PatientRepository;
import java.util.Optional;

public class PatientService {
    private final PatientRepository patientRepo;

    public PatientService(PatientRepository patientRepo) {
        this.patientRepo = patientRepo;
    }

    public Patient addPatient(Patient patient) {
        // Business logic for adding a new patient (e.g., validate age)
        if (patient.getAge() < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        return patientRepo.save(patient);
    }

    public Patient getPatientById(String patientId) {
        return patientRepo.findById(patientId)
            .orElseThrow(() -> new RuntimeException("Patient not found"));
    }

    public void removePatient(String patientId) {
        Patient patient = patientRepo.findById(patientId)
            .orElseThrow(() -> new RuntimeException("Patient not found"));
        patientRepo.delete(patientId);
    }
}
