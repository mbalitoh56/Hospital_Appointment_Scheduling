package com.hospital.services;

import com.hospital.models.Patient;
import com.hospital.repositories.inmemory.InMemoryPatientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatientServiceTest {
    private PatientService patientService;
    private InMemoryPatientRepository patientRepo;

    @BeforeEach
    void setUp() {
        patientRepo = new InMemoryPatientRepository();
        patientService = new PatientService(patientRepo);
    }

    @Test
    void testAddPatient() {
        Patient patient = new Patient("1", "John Doe", 30);
        Patient savedPatient = patientService.addPatient(patient);

        assertEquals(patient, savedPatient);
    }

    @Test
    void testAddPatientWithNegativeAge() {
        Patient patient = new Patient("2", "Jane Doe", -5);
        
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            patientService.addPatient(patient);
        });
        assertEquals("Age cannot be negative", thrown.getMessage());
    }

    @Test
    void testGetPatientById() {
        Patient patient = new Patient("3", "John Smith", 25);
        patientService.addPatient(patient);

        Patient fetchedPatient = patientService.getPatientById("3");
        assertEquals(patient, fetchedPatient);
    }

    @Test
    void testRemovePatient() {
        Patient patient = new Patient("4", "Lisa White", 28);
        patientService.addPatient(patient);

        patientService.removePatient("4");
        assertThrows(RuntimeException.class, () -> patientService.getPatientById("4"));
    }
}
