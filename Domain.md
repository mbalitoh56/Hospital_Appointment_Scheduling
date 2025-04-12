Here’s the **Domain Model** for your **Hospital Appointment Scheduling System**, structured clearly in markdown format and aligned with your prior requirements, use cases, and behavioral models:

---

## 🏥 Domain Model

| **Entity** | **Attributes** | **Methods** | **Relationships** |
|------------|----------------|-------------|-------------------|
| **User** *(Abstract)* | userID, username, password, role | login(), logout() | Parent of Patient, Doctor, Admin |
| **Patient** | patientID, name, contactInfo, dateOfBirth | bookAppointment(), cancelAppointment(), viewAppointments() | Inherits from User; Creates Appointment(s) |
| **Doctor** | doctorID, name, specialization, availabilitySchedule | viewAppointments(), updateAvailability() | Inherits from User; Receives Appointment(s) |
| **Admin** | adminID, name | viewAllAppointments(), cancelAnyAppointment(), manageUsers() | Inherits from User |
| **Appointment** | appointmentID, patientID, doctorID, date, time, status | confirm(), cancel(), notify() | Linked to Patient and Doctor |
| **Notification** | notificationID, userID, message, timestamp | send(), scheduleReminder() | Sent to Patient and Doctor |
| **SystemSession** | sessionID, userID, loginTime, logoutTime | trackSession(), endSession() | Logs system activity for Users |

---

## 🔁 Relationships Summary

- **Patient books Appointment**
- **Doctor receives Appointment**
- **Admin manages Appointments and Users**
- **Appointment involves Patient and Doctor**
- **Notification sent to Patient and Doctor**
- **User has SystemSession**
- **User superclass inherited by Patient, Doctor, Admin**

---

## 📜 Business Rules

1. A **doctor** cannot be booked for more than one appointment at the same time.
2. **Patients** can only view or cancel their own appointments.
3. **Admins** can cancel or create any appointment.
4. **Reminders** must be sent 24 hours before appointments.
5. **Appointment data** must be saved on system exit and available after restart.
6. A **user must select a role** when logging in.
7. **Input validation** is required for all user entries (e.g., date/time formats).
8. **Notifications** must be sent after every booking or cancellation.

---

If you’d like, I can convert this into a UML Class Diagram using Mermaid, or provide a version with composition and inheritance arrows included. Just say the word!
