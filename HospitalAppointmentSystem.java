/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hospitalappointmentsystem;

import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;


class Appointment {
    String patientName;
    String doctorName;
    String date;
    String time;
    String reason;

    public Appointment(String patientName, String doctorName, String date, String time, String reason) {
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.date = date;
        this.time = time;
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Patient: " + patientName + " | Doctor: " + doctorName + " | Date: " + date + " | Time: " + time + " | Reason: " + reason;
    }
}

enum UserRole {
    ADMIN, DOCTOR, PATIENT
}

class User {
    String username;
    UserRole role;

    public User(String username, UserRole role) {
        this.username = username;
        this.role = role;
    }
}

public class HospitalAppointmentSystem {
    static List<Appointment> appointments = new ArrayList<>();
    static final String FILE_NAME = "appointments.txt";
    static JFrame frame;
    static DefaultListModel<String> appointmentListModel;
    static User currentUser;

    public static void main(String[] args) {
        login();
        loadAppointments();
        SwingUtilities.invokeLater(HospitalAppointmentSystem::createGUI);
    }

    public static void login() {
        String username = JOptionPane.showInputDialog("Enter Username:");
        String[] roles = {"ADMIN", "DOCTOR", "PATIENT"};
        String roleInput = (String) JOptionPane.showInputDialog(null, "Select Role:", "Login", JOptionPane.QUESTION_MESSAGE, null, roles, roles[0]);
        if (roleInput != null) {
            currentUser = new User(username, UserRole.valueOf(roleInput));
        } else {
            System.exit(0);
        }
    }

    public static void createGUI() {
        frame = new JFrame("Hospital Appointment Scheduling System - " + currentUser.role);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        appointmentListModel = new DefaultListModel<>();
        updateAppointmentList();
        JList<String> appointmentList = new JList<>(appointmentListModel);
        panel.add(new JScrollPane(appointmentList), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton bookButton = new JButton("Book Appointment");
        JButton cancelButton = new JButton("Cancel Appointment");
        JButton searchButton = new JButton("Search Appointment");
        JButton exitButton = new JButton("Exit");

        if (currentUser.role == UserRole.ADMIN || currentUser.role == UserRole.PATIENT) {
            buttonPanel.add(bookButton);
            bookButton.addActionListener(e -> bookAppointment());
        }
        if (currentUser.role == UserRole.ADMIN) {
            buttonPanel.add(cancelButton);
            cancelButton.addActionListener(e -> cancelAppointment(appointmentList.getSelectedIndex()));
        }
        buttonPanel.add(searchButton);
        searchButton.addActionListener(e -> searchAppointment());
        buttonPanel.add(exitButton);
        exitButton.addActionListener(e -> {
            saveAppointments();
            System.exit(0);
        });

        panel.add(buttonPanel, BorderLayout.SOUTH);
        frame.add(panel);
        frame.setVisible(true);
    }

    public static void bookAppointment() {
        if (currentUser.role == UserRole.DOCTOR) {
            JOptionPane.showMessageDialog(frame, "Doctors cannot book appointments.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String patientName = currentUser.role == UserRole.PATIENT ? currentUser.username : JOptionPane.showInputDialog("Enter Patient Name:");
        String doctorName = JOptionPane.showInputDialog("Enter Doctor Name:");
        String date = JOptionPane.showInputDialog("Enter Date (YYYY-MM-DD):");
        String time = JOptionPane.showInputDialog("Enter Time (HH:MM):");
        String reason = JOptionPane.showInputDialog("Enter Reason for Appointment:");

        if (isDoctorAvailable(doctorName, date, time)) {
            appointments.add(new Appointment(patientName, doctorName, date, time, reason));
            updateAppointmentList();
            sendNotification(patientName, "Your appointment with Dr. " + doctorName + " is confirmed on " + date + " at " + time);
        } else {
            JOptionPane.showMessageDialog(frame, "Doctor is not available at this time.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void cancelAppointment(int index) {
        if (index >= 0 && index < appointments.size()) {
            Appointment removed = appointments.remove(index);
            updateAppointmentList();
            sendNotification(removed.patientName, "Your appointment with Dr. " + removed.doctorName + " on " + removed.date + " at " + removed.time + " has been cancelled.");
        } else {
            JOptionPane.showMessageDialog(frame, "Invalid appointment selection.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void searchAppointment() {
        String searchKey = JOptionPane.showInputDialog("Enter Patient or Doctor Name:");
        if (searchKey == null || searchKey.trim().isEmpty()) return;

        List<String> results = new ArrayList<>();
        for (Appointment app : appointments) {
            if ((currentUser.role == UserRole.PATIENT && !app.patientName.equals(currentUser.username)) ||
                (currentUser.role == UserRole.DOCTOR && !app.doctorName.equals(currentUser.username))) {
                continue;
            }
            if (app.patientName.equalsIgnoreCase(searchKey) || app.doctorName.equalsIgnoreCase(searchKey)) {
                results.add(app.toString());
            }
        }

        JOptionPane.showMessageDialog(frame, results.isEmpty() ? "No matching appointments found." : String.join("\n", results), "Search Results", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void updateAppointmentList() {
        appointmentListModel.clear();
        for (Appointment app : appointments) {
            if ((currentUser.role == UserRole.PATIENT && !app.patientName.equals(currentUser.username)) ||
                (currentUser.role == UserRole.DOCTOR && !app.doctorName.equals(currentUser.username))) {
                continue;
            }
            appointmentListModel.addElement(app.toString());
        }
    }

   public static void loadAppointments() {
    appointments.clear();
    try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            if (data.length == 5) {
                appointments.add(new Appointment(data[0], data[1], data[2], data[3], data[4]));
            }
        }
    } catch (IOException e) {
        System.out.println("No existing appointments found.");
    }
}


  public static void saveAppointments() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
        for (Appointment app : appointments) {
            writer.write(app.patientName + "," + app.doctorName + "," + app.date + "," + app.time + "," + app.reason);
            writer.newLine();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}


  public static boolean isDoctorAvailable(String doctorName, String date, String time) {
    for (Appointment app : appointments) {
        if (app.doctorName.equalsIgnoreCase(doctorName) && app.date.equals(date) && app.time.equals(time)) {
            return false; // Doctor is already booked at this time
        }
    }
    return true;
}


  public static void sendNotification(String recipient, String message) {
    JOptionPane.showMessageDialog(frame, "Notification to " + recipient + ": " + message, "Notification", JOptionPane.INFORMATION_MESSAGE);
}

}
