package services;

import entities.Appointment;
import entities.Patient;
import repositories.AppointmentRepository;
import repositories.PatientRepository;

import java.util.List;

public class AppointmentService {
    private final AppointmentRepository appointmentRepo;
    private final PatientRepository patientRepo;

    public AppointmentService(AppointmentRepository appointmentRepo, PatientRepository patientRepo) {
        this.appointmentRepo = appointmentRepo;
        this.patientRepo = patientRepo;
    }

    public Appointment bookAppointment(String patientId, Appointment appointment) {
        Patient patient = patientRepo.findById(patientId)
            .orElseThrow(() -> new IllegalArgumentException("Patient not found"));

        List<Appointment> existing = appointmentRepo.findByPatientId(patientId);
        long activeCount = existing.stream()
            .filter(a -> !a.getStatus().equals("Completed"))
            .count();

        if (activeCount >= 3) {
            throw new IllegalStateException("Patient has reached the appointment limit.");
        }

        appointment.setPatientId(patientId);
        appointment.setStatus("Scheduled");

        appointmentRepo.save(appointment);
        return appointment;
    }
}
