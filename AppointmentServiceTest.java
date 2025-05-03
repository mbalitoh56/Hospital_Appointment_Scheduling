package tests;

import services.AppointmentService;
import repositories.inmemory.InMemoryAppointmentRepository;
import repositories.inmemory.InMemoryPatientRepository;
import entities.Appointment;
import entities.Patient;

import java.util.UUID;

public class AppointmentServiceTest {
    public static void main(String[] args) {
        var patientRepo = new InMemoryPatientRepository();
        var appointmentRepo = new InMemoryAppointmentRepository();
        var service = new AppointmentService(appointmentRepo, patientRepo);

        String patientId = UUID.randomUUID().toString();
        patientRepo.save(new Patient(patientId, "Alice"));

        // Book 3 appointments
        for (int i = 0; i < 3; i++) {
            service.bookAppointment(patientId, new Appointment(UUID.randomUUID().toString(), "Doctor A", "Pending"));
        }

        // 4th booking should throw error
        try {
            service.bookAppointment(patientId, new Appointment(UUID.randomUUID().toString(), "Doctor A", "Pending"));
            System.out.println("Test failed: Limit not enforced");
        } catch (IllegalStateException e) {
            System.out.println("Test passed: " + e.getMessage());
        }
    }
}
