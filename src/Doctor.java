/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lenovo
 */
public class Doctor extends User {
    private String specialization;

    public Doctor(String userId, String name, String username, String password, String specialization) {
        super(userId, name, username, password);
        this.specialization = specialization;
    }

    @Override
    public void login() {
        System.out.println("Doctor " + username + " logged in.");
    }

    @Override
    public void logout() {
        System.out.println("Doctor " + username + " logged out.");
    }

    public void viewAppointments() {
        System.out.println("Doctor is viewing today's appointments.");
    }

    public String getSpecialization() {
        return specialization;
    }
}
