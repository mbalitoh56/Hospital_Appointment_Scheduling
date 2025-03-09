# Introduction

## Project Title:
Hospital Appointment System

## Domain:
Healthcare

The **Hospital Appointment System** is part of the **Healthcare** field, which focuses on providing medical services and managing things like patient visits, doctor appointments, and hospital operations. This system is designed to help patients book appointments with doctors, let admins manage and cancel appointments, and make sure doctors can see their own schedules. It makes the process of managing appointments smoother and more organized, which helps improve the patient experience and hospital efficiency.

## Problem Statement:
The goal of this **Hospital Appointment System** is to solve problems that hospitals face with scheduling and managing appointments. In many hospitals, it's easy to have double-booked appointments, missed appointments, or patients struggling to find available doctors. This system helps by allowing patients to book appointments directly with doctors, giving admins the ability to manage and cancel appointments, and allowing doctors to view their own appointments. The system also stores appointment data so that information is saved even after closing the program. By making appointments more organized, the system helps hospitals run more smoothly and makes it easier for patients to access care.

## System Overview
The Hospital Appointment System allows patients, doctors, administrators, receptionists, IT support staff, and health insurance providers to manage appointments efficiently. It includes features for booking, canceling, and searching appointments while ensuring that doctors are not double-booked. The system also sends notifications and integrates with health insurance verification to ensure smooth operations.

## Functional Requirements

### User Management
**Login:** Users must log in with a valid username and select a role from the following options:

**ADMIN:** Full access to manage appointments.

**DOCTOR:** Limited access to view appointments and manage availability.

**PATIENT:** Access to book and view their own appointments.

**RECEPTIONIST:** Assist patients with appointment booking, rescheduling, and cancellations.

**IT SUPPORT STAFF:** Maintain the system and ensure it runs smoothly.

**HEALTH INSURANCE PROVIDERS:** Verify patient eligibility and insurance coverage.

### Appointment Management
**Book Appointment:** A patient can book an appointment by providing:
- Patient name (auto-filled for the logged-in patient).
- Doctor’s name.
- Date and time of the appointment.
- Reason for the appointment.

The system checks if the doctor is available.

**Cancel Appointment:** Only admins and receptionists can cancel appointments.

Users can cancel appointments if they are selected from the list.

**Search Appointment:** Users can search for appointments by either patient or doctor name. The search results will be filtered based on the user's role (patients can only see their appointments, and doctors can only see their appointments).

### Appointment Storage

Appointments are stored in a text file (appointments.txt) in the following format:

patientName, doctorName, date, time, reason

### Notifications

After each booking or cancellation, a notification is sent to the respective patient, indicating the appointment status (booked or canceled).

### UI and Interaction

The user interface includes:
- A list displaying the appointments for the logged-in user.
- Buttons to book, cancel, search appointments, and exit the system.
  
The UI is responsive and updates to reflect the current state of appointments.

## System Architecture
### Classes

**Appointment:** Represents an appointment with details such as patient name, doctor name, date, time, and reason for the appointment.

**User:** Represents a user with a username and role (Admin, Doctor, Patient, Receptionist, IT Support Staff, Health Insurance Provider).

**HospitalAppointmentSystem:** Main class that runs the system, handles user login, appointment management, UI creation, and file I/O operations.

#### User Roles

**Admin:** Can book, cancel, and search any appointment.

**Doctor:** Can only view and search appointments for themselves.

**Patient:** Can only book and view their own appointments.

**Receptionist:** Can assist with booking and canceling appointments.

**IT Support Staff:** Ensures the system functions without downtime and handles technical issues.

**Health Insurance Providers:** Can verify the eligibility and coverage of patients for their visits.

## Non-Functional Requirements
**Performance**
The system should load appointments efficiently, even with a large number of records.

The appointment booking process should complete in under 3 seconds.

**Usability**
The system should have an intuitive user interface with minimal steps for booking, searching, and canceling appointments.

**Reliability**
The system should maintain appointments reliably across sessions using file storage.

Appointment data should persist even if the application is closed and reopened.

**Security**
The system should ensure only authorized users (Admin, Doctor, Patient, Receptionist, IT Support Staff, Health Insurance Provider) can perform their respective actions.

User credentials (username) are not stored; only the role selection is used for access control.

### System Constraints
**Storage**

The system relies on a text file (appointments.txt) for storing appointments. This file should not exceed a size of 100MB.

**Dependencies**

The system is built using Java Swing for the user interface, Java IO for file operations, and standard Java libraries for other functionalities.

### Data Flow
**Login:** The user provides a username and selects a role.

**Appointment Management:**

- **Book Appointment:** Checks doctor availability, adds the appointment, and sends notifications.
- **Cancel Appointment:** Removes the selected appointment and sends notifications.
- **Search Appointment:** Filters and displays appointments based on search criteria (patient or doctor name).
- **Exit:** Saves the appointments to the file before exiting the system.

### Stakeholder Analysis
**Patients**

Role: Users who book appointments with doctors.

Key Concerns: 
- Easy appointment booking and cancellation.
- Access to doctors' availability.
- Timely notifications about upcoming appointments.

Pain Points:
- Difficulty in finding available doctors.
- No reminder system for scheduled appointments.
- Long waiting times at the hospital due to overbooking.

Success Metrics:
- 30% reduction in missed appointments.
- Faster booking process (< 3 minutes per appointment).

**Doctors**

Role: Provide medical consultation based on scheduled appointments.

Key Concerns:
- Efficient scheduling to avoid double bookings.
- Access to patient details before appointments.
- Ability to manage availability and appointment times.
  
Pain Points:
- No centralized system to track daily appointments.
- Patients missing appointments without prior cancellation.
- Overbooked time slots causing delays.

Success Metrics:
- 40% fewer scheduling conflicts.
- 25% improvement in doctor-patient consultation time.

**Hospital Administrators**

Role: Manage hospital operations and ensure smooth scheduling.

Key Concerns:
- Effective monitoring of doctor schedules.
- Proper record-keeping of all patient appointments.
- Ensuring the system reduces manual work.
  
Pain Points:
- Heavy reliance on paperwork for tracking appointments.
- Difficulty in managing last-minute appointment changes.
- No real-time insights into doctor availability.

Success Metrics:
- 50% reduction in administrative workload.
- Real-time tracking of appointments for better hospital efficiency.

**Receptionists**

Role: Assist patients with booking, rescheduling, and canceling appointments.

Key Concerns:
- Fast and efficient appointment handling.
- Easy access to doctor schedules.
- Reducing errors in appointment scheduling.

Pain Points:
- Manual tracking of doctor availability.
- High workload during peak hours.
- No automated confirmation messages for patients.

Success Metrics:
- 30% decrease in appointment booking errors.
- Faster processing of appointment requests.

**IT Support Staff**

Role: Maintain and troubleshoot the appointment scheduling system.

Key Concerns:
- Ensuring the system runs without downtime.
- Secure handling of patient data.
- Regular updates and maintenance.

Pain Points:
- Frequent system crashes due to increased user load.
- Lack of an automated backup system.
- Security vulnerabilities in patient data storage.

Success Metrics:
- 99% system uptime.
- Zero data breaches within a year.

**Health Insurance Providers**

Role: Verify patient eligibility and coverage for hospital visits.

Key Concerns:
- Integration with hospital billing systems.
- Quick verification of patient insurance details.
- Reducing fraudulent claims.

Pain Points:
- Delayed insurance verification processes.
- Patients unsure of their coverage before appointments.
- Poor communication between hospitals and insurance companies.

Success Metrics:
- 50% faster insurance verification process.
- Reduced number of rejected claims due to miscommunication.

### File Format
Appointments are stored in a comma-separated format:

patientName,doctorName,date,time,reason
