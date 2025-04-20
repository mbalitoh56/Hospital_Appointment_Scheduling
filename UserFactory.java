/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lenovo
 */

// UserFactory.java
public class UserFactory {

    static User createUser(String patient, String john) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public User createUser(String role) {
        switch (role.toLowerCase()) {
            case "patient": return new Patient();
            case "doctor": return new Doctor();
            case "admin": return new Admin();
            default: throw new IllegalArgumentException("Invalid role: " + role);
        }
    }


// User.java
public interface User {
    void accessSystem();
}

// Patient.java
public class Patient implements User {
    public void accessSystem() {
        System.out.println("Patient accessing the appointment system.");
    }
}

// Doctor.java
public class Doctor implements User {
    public void accessSystem() {
        System.out.println("Doctor accessing appointment schedule.");
    }
}

// Admin.java
public class Admin implements User {
    public void accessSystem() {
        System.out.println("Admin managing the hospital system.");
    }
}
}