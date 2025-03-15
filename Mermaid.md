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
