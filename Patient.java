/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lenovo
 */
public class Patient extends User {
   public Patient(String userId, String name, String username, String password) {
        super(userId, name, username, password);
    }

    @Override
    public void login() {
        System.out.println("Patient " + username + " logged in.");
    }

    @Override
    public void logout() {
        System.out.println("Patient " + username + " logged out.");
    }

    public void bookAppointment(Appointment appointment) {
        System.out.println("Appointment booked: " + appointment.getAppointmentId());
    }

    public void cancelAppointment(Appointment appointment) {
        System.out.println("Appointment canceled: " + appointment.getAppointmentId());
    }
 
}
