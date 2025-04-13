# DOMAIN MODELLING

## Domain Model

| **Entity** | **Attributes** | **Methods** | **Relationships** |
|------------|----------------|-------------|-------------------|
| **User** *(Abstract)* | userID, username, password, role | login(), logout() | Parent of Patient, Doctor, Admin |
| **Patient** | patientID, name, contactInfo, dateOfBirth | bookAppointment(), cancelAppointment(), viewAppointments() | Inherits from User; Creates Appointment(s) |
| **Doctor** | doctorID, name, specialization, availabilitySchedule | viewAppointments(), updateAvailability() | Inherits from User; Receives Appointment(s) |
| **Admin** | adminID, name | viewAllAppointments(), cancelAnyAppointment(), manageUsers() | Inherits from User |
| **Appointment** | appointmentID, patientID, doctorID, date, time, status | confirm(), cancel(), notify() | Linked to Patient and Doctor |
| **Notification** | notificationID, userID, message, timestamp | send(), scheduleReminder() | Sent to Patient and Doctor |
| **SystemSession** | sessionID, userID, loginTime, logoutTime | trackSession(), endSession() | Logs system activity for Users |


### Relationships Summary

- Patient books Appointment
- Doctor receives Appointment
- Admin manages Appointments and Users
- Appointment involves Patient and Doctor
- Notification sent to Patient and Doctor
- User has SystemSession
- User superclass inherited by Patient, Doctor, Admin


### Business Rules

1. A **doctor** cannot be booked for more than one appointment at the same time.
2. **Patients** can only view or cancel their own appointments.
3. **Admins** can cancel or create any appointment.
4. **Reminders** must be sent 24 hours before appointments.
5. **Appointment data** must be saved on system exit and available after restart.
6. A **user must select a role** when logging in.
7. **Input validation** is required for all user entries (e.g., date/time formats).
8. **Notifications** must be sent after every booking or cancellation.

---

# CLASS DIAGRAM

``` mermaid
classDiagram
    %% Abstract Base Class
    class User {
        -userID: String
        -username: String
        -password: String
        -role: String
        +login()
        +logout()
    }

    %% Subclasses
    class Patient {
        -patientID: String
        -name: String
        -contactInfo: String
        -dateOfBirth: String
        +bookAppointment()
        +cancelAppointment()
        +viewAppointments()
    }

    class Doctor {
        -doctorID: String
        -name: String
        -specialization: String
        -availabilitySchedule: Map
        +viewAppointments()
        +updateAvailability()
    }

    class Admin {
        -adminID: String
        -name: String
        +viewAllAppointments()
        +cancelAnyAppointment()
        +manageUsers()
    }

    class Appointment {
        -appointmentID: String
        -date: String
        -time: String
        -status: String
        +confirm()
        +cancel()
        +notify()
    }

    class Notification {
        -notificationID: String
        -message: String
        -timestamp: String
        +send()
        +scheduleReminder()
    }

    class SystemSession {
        -sessionID: String
        -loginTime: String
        -logoutTime: String
        +trackSession()
        +endSession()
    }

    %% Inheritance
    Patient --|> User
    Doctor --|> User
    Admin --|> User

    %% Relationships
    Patient "1" --> "0..*" Appointment : books
    Doctor "1" --> "0..*" Appointment : receives
    Admin "1" --> "0..*" Appointment : manages
    Appointment "1" --> "1" Doctor : assignedTo
    Appointment "1" --> "1" Patient : scheduledBy
    Notification "0..*" --> "1" User : sentTo
    User "1" --> "0..*" SystemSession : initiates
```

### Key Design Decisions
**Inheritance:** User is abstract and generalized into Patient, Doctor, and Admin, which reflects role-based access and behavior.

**Composition:** Appointment must be linked to both a Patient and a Doctor, hence 1..1 multiplicity for both.

**Multiplicity:** Each Patient and Doctor can be involved in multiple appointments (0..*), while each Appointment is always associated with exactly one of each.

**Separation of Concerns:** Notification and SystemSession are independent support entities linked to User for reminders and login tracking respectively.
