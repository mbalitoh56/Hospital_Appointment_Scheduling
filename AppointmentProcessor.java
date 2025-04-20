/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lenovo
 */
// AppointmentProcessor.java
public interface AppointmentProcessor {
    void processAppointment();


// RegularAppointment.java
public class RegularAppointment implements AppointmentProcessor {
    public void processAppointment() {
        System.out.println("Processing regular appointment.");
    }
}

// EmergencyAppointment.java
public class EmergencyAppointment implements AppointmentProcessor {
    public void processAppointment() {
        System.out.println("Processing emergency appointment.");
    }
}

// AppointmentCreator.java
public abstract class AppointmentCreator {
    public abstract AppointmentProcessor createAppointment();
}

// RegularAppointmentCreator.java
public class RegularAppointmentCreator extends AppointmentCreator {
    public AppointmentProcessor createAppointment() {
        return new RegularAppointment();
    }
}

// EmergencyAppointmentCreator.java
public class EmergencyAppointmentCreator extends AppointmentCreator {
    public AppointmentProcessor createAppointment() {
        return new EmergencyAppointment();
    }
}}
