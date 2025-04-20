/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lenovo
 */
public class Admin extends User {

    public Admin(String userId, String name, String username, String password) {
        super(userId, name, username, password);
    }

    @Override
    public void login() {
        System.out.println("Admin " + username + " logged in.");
    }

    @Override
    public void logout() {
        System.out.println("Admin " + username + " logged out.");
    }

    public void cancelAppointment(Appointment appointment) {
        System.out.println("Admin canceled appointment: " + appointment.getAppointmentId());
    }

    public void manageUsers() {
        System.out.println("Admin managing users.");
    }
}
