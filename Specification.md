# Introduction

## Project Title:
Hospital Appointment System

## Domain:
Healthcare

The **Hospital Appointment System** is part of the **Healthcare** field, which focuses on providing medical services and managing things like patient visits, doctor appointments, and hospital operations. This system is designed to help patients book appointments with doctors, let admins manage and cancel appointments, and make sure doctors can see their own schedules. It makes the process of managing appointments smoother and more organized, which helps improve the patient experience and hospital efficiency.

## Problem Statement:
The goal of this **Hospital Appointment System** is to solve problems that hospitals face with scheduling and managing appointments. In many hospitals, it's easy to have double-booked appointments, missed appointments, or patients struggling to find available doctors. This system helps by allowing patients to book appointments directly with doctors, giving admins the ability to manage and cancel appointments, and allowing doctors to view their own appointments. The system also stores appointment data so that information is saved even after closing the program. By making appointments more organized, the system helps hospitals run more smoothly and makes it easier for patients to access care.

## Individual Scope:
The Hospital Appointment System is a practical and useful solution to the problems that hospitals face with scheduling. The system will allow:

**Patients** to book, view, and search for their appointments.

**Doctors** to manage and see their own schedules.

**Admins** to manage all appointments and cancel them if needed.

This system is built using Java Swing, which makes it easy to use on desktop computers. It saves appointment data in text files, which is simple but works well for this type of system. The system also includes different user roles (Admin, Doctor, Patient) to make sure only the right people can access certain parts of the system.

This system is easy to make and can be done with small teams or limited resources. The main features are simple and easy to maintain, making it a great fit for a small-scale healthcare setting.The Hospital Appointment System is feasible and valuable in addressing the inefficiencies commonly seen in hospitals regarding appointment scheduling.

# Functional Requirements

## Login
**Users:** 
- Must enter a username and select their role (Admin, Doctor, or Patient).
- After logging in, the user is directed to the appropriate part of the system based on their role.
- If no valid input is given, the system exits.

## Appointment Management
**Book Appointment:**
- Patients can book appointments by entering their name, choosing a doctor, and providing the date, time, and reason for the appointment.
- The system checks if the doctor is available before confirming the appointment.

**Cancel Appointment:**
Admins can cancel any appointment in the system.
 
Notifications are sent to both the patient and doctor if an appointment is canceled.

**Search Appointment:**
Users (Admin, Doctor, and Patient) can search for appointments by patient name or doctor name.

Admins can view all appointments, but doctors and patients can only view their own.

## Notifications
After booking or canceling an appointment, notifications are sent to the patient and doctor using JOptionPane to alert them of the changes.

## Data Persistence
Appointment data is saved to a text file (appointments.txt).
 
The system loads appointments from this file when started and saves any changes to the file when closed.

# Non-Functional Requirements

**Performance:** The system must be fast enough to handle a moderate number of appointments without lag.

**Security:** Different users (Admins, Doctors, and Patients) should only be able to access the parts of the system meant for their role.

**Usability:** The system should be easy to use, with a simple interface that is clear and straightforward for all users.

**Reliability:** The system should work correctly, without crashes, and provide error messages when something goes wrong.

# System Architecture

**Client-Server Model:** The system runs on a client-side application (GUI) built with Java Swing.

**Data Management:** The system uses a simple text file for storing appointment data, which makes it easy to load and save appointments.

**Role-Based Access Control:** The system assigns each user a role (Admin, Doctor, Patient), and each role has different permissions.

# User Roles and Permissions

## Admin:
- Can view all appointments.
- Can cancel any appointment.
- Can search for appointments by patient or doctor name.

## Doctor:
- Can view appointments with their name listed as the doctor.
- Can search for appointments by patient or doctor name.
- Cannot book or cancel appointments.

## Patient:
- Can book new appointments with doctors.
- Can view only their own appointments.
- Can search for appointments by their own name or the doctor's name.

# User Interface (UI)

The User Interface (UI) is built using Java Swing and includes the following features:

**Login Screen:** Users enter their username and choose their role.
**Main Screen:** Displays a list of appointments and provides buttons for:
- Book Appointment (for Patients)
- Cancel Appointment (for Admins)
- Search Appointment
- Exit

# System Flow

## Login Process:
- User enters their username and selects their role.
- System validates the role and grants the appropriate permissions.
## Appointment Process:
- Patients can book new appointments, while Admins can cancel appointments.
- Doctors can view their appointments and schedules.
## Data Management:
The system loads and saves appointments from/to the text file.

# Error Handling

- **Invalid Inputs:** If a user enters an incorrect date or time format, the system will ask the user to enter the correct format again.
- **Doctor Availability:** If a doctor is not available at the chosen time, the system will notify the user.
- **Search Results:** If no appointments are found, the system will display a message saying no matching appointments were found.

# Data Format

Appointments are stored in the file appointments.txt in CSV format:
- PatientName,DoctorName,Date,Time,Reason

# Future Enhancements

- **Multiple Doctor Availability:** Allow doctors to have multiple available time slots for booking.
- **Appointment Reminders:** Send reminders to patients and doctors about upcoming appointments.
- **Mobile Version:** Develop a mobile app for better accessibility on the go.
- **Advanced Search:** Include more search filters like appointment date or time.
