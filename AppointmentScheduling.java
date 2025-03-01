/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.util.ArrayList;
import java.util.Scanner;

class Appointment {
    String patientName;
    String doctorName;
    String appointmentDate;

    public Appointment(String patientName, String doctorName, String appointmentDate) {
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.appointmentDate = appointmentDate;
    }

    @Override
    public String toString() {
        return "Patient: " + patientName + ", Doctor: " + doctorName + ", Date: " + appointmentDate;
    }
}

public class AppointmentScheduling {

    private ArrayList<Appointment> appointments;
    private Scanner scanner;

    public AppointmentScheduling() {
        appointments = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Method to schedule an appointment
    public void scheduleAppointment() {
        System.out.println("Enter patient name:");
        String patientName = scanner.nextLine();

        System.out.println("Enter doctor name:");
        String doctorName = scanner.nextLine();

        System.out.println("Enter appointment date (dd/MM/yyyy):");
        String appointmentDate = scanner.nextLine();

        Appointment appointment = new Appointment(patientName, doctorName, appointmentDate);
        appointments.add(appointment);
        System.out.println("Appointment scheduled successfully!");
    }

    // Method to view all appointments
    public void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments scheduled.");
        } else {
            System.out.println("Scheduled Appointments:");
            for (Appointment appointment : appointments) {
                System.out.println(appointment);
            }
        }
    }

    // Method to cancel an appointment
    public void cancelAppointment() {
        System.out.println("Enter the patient name to cancel the appointment:");
        String patientName = scanner.nextLine();

        boolean found = false;
        for (Appointment appointment : appointments) {
            if (appointment.patientName.equalsIgnoreCase(patientName)) {
                appointments.remove(appointment);
                found = true;
                System.out.println("Appointment canceled successfully!");
                break;
            }
        }
        if (!found) {
            System.out.println("No appointment found for the given patient name.");
        }
    }

    // Main menu to interact with the system
    public void menu() {
        while (true) {
            System.out.println("\nHospital Appointment System");
            System.out.println("1. Schedule Appointment");
            System.out.println("2. View Appointments");
            System.out.println("3. Cancel Appointment");
            System.out.println("4. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    scheduleAppointment();
                    break;
                case 2:
                    viewAppointments();
                    break;
                case 3:
                    cancelAppointment();
                    break;
                case 4:
                    System.out.println("Exiting system...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        AppointmentScheduling system = new AppointmentScheduling();
        system.menu();
    }
}


