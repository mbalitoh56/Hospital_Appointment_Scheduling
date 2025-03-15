# Hospital Appointment System - Use Case Diagram

## Use Case Diagram

```mermaid
graph TD;
    %% Actors %%
    Patient["👤 Patient"]
    Doctor["👤 Doctor"]
    Admin["👤 Admin"]
    Receptionist["👤 Receptionist"]
    IT_Support["👤 IT Support Staff"]
    Insurance_Provider["👤 Health Insurance Provider"]

    %% Use Cases %%
    Appointment_Booking["📅 Book Appointment"]
    Appointment_Cancellation["❌ Cancel Appointment"]
    Search_Appointment["🔍 Search Appointment"]
    Manage_Availability["🕒 Manage Availability"]
    View_Schedule["📋 View Schedule"]
    Notifications["📢 Receive Notifications"]
    User_Authentication["🔑 User Authentication"]
    Insurance_Verification["💳 Verify Insurance"]
    System_Maintenance["🛠 Maintain System"]

    %% Relationships %%
    Patient -->|Books| Appointment_Booking
    Patient -->|Cancels| Appointment_Cancellation
    Patient -->|Searches| Search_Appointment
    Patient -->|Receives| Notifications

    Doctor -->|Views| View_Schedule
    Doctor -->|Manages| Manage_Availability
    Doctor -->|Receives| Notifications

    Admin -->|Manages| Appointment_Booking
    Admin -->|Manages| Appointment_Cancellation
    Admin -->|Handles| User_Authentication

    Receptionist -->|Assists with| Appointment_Booking
    Receptionist -->|Checks| Manage_Availability
    Receptionist -->|Handles| Search_Appointment

    IT_Support -->|Maintains| System_Maintenance
    IT_Support -->|Ensures| User_Authentication
    IT_Support -->|Manages| Notifications

    Insurance_Provider -->|Verifies| Insurance_Verification

## Key Actors and Their Roles
Patients – Book, search, and cancel appointments, and receive notifications.

Doctors – Manage availability, view their schedules, and receive notifications.

Admins – Manage all appointments and oversee user authentication.

Receptionists – Assist with booking, search for appointments, and check doctor availability.

IT Support Staff – Maintain the system, handle security, and ensure notifications function properly.

Health Insurance Providers – Verify patient insurance before the appointment.

## Relationships Between Actors and Use Cases
Generalization: Admins have the highest privileges, as they can manage all appointment-related actions.
Inclusion: The Search Appointment feature includes filters like date, doctor name, and patient name.
Exclusion: Doctors do not book appointments but only manage availability.
How the Diagram Addresses Stakeholder Concerns
Patients: The system provides easy booking and cancellation, doctor availability checks, and timely reminders to reduce missed appointments.
Doctors: Doctors can view schedules, manage their availability, and receive notifications to prevent scheduling conflicts.
Admins: Admins can manage all appointments, reducing manual work.
Receptionists: They get quick access to doctor schedules, reducing errors during peak hours.
IT Support: Ensures the system remains secure and operational.
Insurance Providers: Integrate insurance verification to speed up billing.
