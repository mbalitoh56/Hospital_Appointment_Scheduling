/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lenovo
 */
import java.time.LocalDateTime;

public class Appointment {
    private String appointmentId;
    private LocalDateTime dateTime;
    private Doctor doctor;
    private Patient patient;
    private String status; // e.g., Scheduled, Cancelled

    public Appointment(String appointmentId, LocalDateTime dateTime, Doctor doctor, Patient patient) {
        this.appointmentId = appointmentId;
        this.dateTime = dateTime;
        this.doctor = doctor;
        this.patient = patient;
        this.status = "Scheduled";
    }

    public void confirm() {
        this.status = "Confirmed";
        System.out.println("Appointment confirmed.");
    }

    public void cancel() {
        this.status = "Cancelled";
        System.out.println("Appointment cancelled.");
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getStatus() {
        return status;
    }
}