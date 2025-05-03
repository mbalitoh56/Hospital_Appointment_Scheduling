package com.hospital.services;

import com.hospital.models.Doctor;
import com.hospital.repositories.inmemory.InMemoryDoctorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoctorServiceTest {
    private DoctorService doctorService;
    private InMemoryDoctorRepository doctorRepo;

    @BeforeEach
    void setUp() {
        doctorRepo = new InMemoryDoctorRepository();
        doctorService = new DoctorService(doctorRepo);
    }

    @Test
    void testAddDoctor() {
        Doctor doctor = new Doctor("1", "Dr. Smith", "ABC123");
        Doctor savedDoctor = doctorService.addDoctor(doctor);

        assertEquals(doctor, savedDoctor);
    }

    @Test
    void testAddDoctorWithDuplicateLicense() {
        Doctor doctor1 = new Doctor("1", "Dr. Smith", "ABC123");
        Doctor doctor2 = new Doctor("2", "Dr. Lee", "ABC123");
        doctorService.addDoctor(doctor1);

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            doctorService.addDoctor(doctor2);
        });
        assertEquals("Doctor with this license number already exists", thrown.getMessage());
    }

    @Test
    void testGetDoctorById() {
        Doctor doctor = new Doctor("3", "Dr. Jones", "XYZ789");
        doctorService.addDoctor(doctor);

        Doctor fetchedDoctor = doctorService.getDoctorById("3");
        assertEquals(doctor, fetchedDoctor);
    }
}
