
# complex workflows

### Workflows
- User Registration

- Patient Books Appointment

- Doctor Updates Availability

- Admin Cancels Appointment

- Appointment Reminder Notification

- Patient Views Appointment History

- Insurance Eligibility Verification

- System Exit with Auto-Save

  # Activity Diagrams

### 1. User Authentication & Role Management Workflow
```mermaid
flowchart TD
    %% Swimlanes: User and System
    subgraph User
        A[Start: Initiate Login]
        B[Enter Credentials]
    end
    subgraph System
        C[Validate Credentials]
        D{Are credentials valid?}
        E[Prompt for Role Selection]
        F[Display Dashboard]
        G[Show Error Message]
    end
    A --> B
    B --> C
    C --> D
    D -- Yes --> E
    D -- No --> G
    E --> F
    F --> H[End]

```

### Explanation:

**Key Actions & Decisions:**

The user starts by entering credentials.

The system validates the credentials and checks their validity.

If valid, the system prompts the user to select a role (Patient, Doctor, or Admin) and then displays the appropriate dashboard.

If not valid, an error message is shown.

**Stakeholder Concerns Addressed:**

Patients and Doctors: Ensure secure access to personalized features, meeting usability and security requirements.

IT Support: Easy identification and handling of invalid login attempts.

### 2. Appointment Booking Workflow
```mermaid
flowchart TD
    %% Swimlanes: Patient and System
    subgraph Patient
        A[Start: Initiate Appointment Booking]
        B[Select Doctor & Preferred Time Slot]
    end
    subgraph System
        C[Receive Booking Request]
        D[Check Doctor Availability]
        E{Is Doctor Available?}
        F[Confirm Appointment]
        G[Send Confirmation Notification]
        H[Display Unavailability/Error Message]
    end
    A --> B
    B --> C
    C --> D
    D --> E
    E -- Yes --> F
    E -- No --> H
    F --> G
    G --> I[End]
```
### Explanation:

**Key Actions & Decisions:**

The patient selects a doctor and a time slot.

The system receives the booking request and checks the doctor’s availability.

A decision node determines if the doctor is available:

If yes, the appointment is confirmed and a notification is sent.

If no, an error or unavailability message is displayed.

**Stakeholder Concerns Addressed:**

Patients: Quick and error-free appointment booking (< 3 minutes per appointment).

Doctors & Administrators: Prevents double bookings and scheduling conflicts.

### 3. Appointment Cancellation Workflow
```mermaid
flowchart TD
    %% Swimlanes: Patient and System
    subgraph Patient
        A[Start: Request Cancellation]
    end
    subgraph System
        B[Receive Cancellation Request]
        C[Confirm Cancellation Intent]
        D[Update Appointment Status to 'Canceled']
        E[Send Cancellation Notifications to Doctor & Patient]
    end
    A --> B
    B --> C
    C -- Yes --> D
    C -- No --> F[Abort Cancellation]
    D --> E
    E --> G[End]
```
### Explanation:

**Key Actions & Decisions:**

The patient initiates a cancellation request.

The system confirms the cancellation intent with the user.

If confirmed, the appointment status is updated to “Canceled” and notifications are sent to both the doctor and patient.

**Stakeholder Concerns Addressed:**

Patients and Doctors: Allows cancellations as per their need (addressing FR-003 and associated pain points).

Administrators: Ensures up-to-date scheduling records to reduce manual tracking efforts.

### 4. Doctor's Confirmation Workflow
```mermaid
flowchart TD
    %% Swimlanes: Doctor and System
    subgraph Doctor
        A[Start: View Pending Appointments]
        B[Select Appointment for Action]
        C{Confirm Appointment?}
    end
    subgraph System
        D[Receive Doctor’s Decision]
        E[Update Appointment Status 'Confirm/Reject']
        F[Notify Patient of Decision]
    end
    A --> B
    B --> C
    C -- Confirm --> D
    C -- Reject --> D
    D --> E
    E --> F
    F --> G[End]
```
### Explanation:

**Key Actions & Decisions:**

The doctor reviews pending appointments and selects one to act upon.

A decision is made: confirm or reject the appointment.

The system updates the appointment’s status accordingly and notifies the patient.

**Stakeholder Concerns Addressed:**

Doctors: Streamlined process to manage appointments and prevent overbooking.

Patients: Receive timely updates on their appointment status, improving satisfaction.

### 5. Appointment Search Workflow
```mermaid
flowchart TD
    %% Swimlanes: User and System
    subgraph User
        A[Start: Initiate Appointment Search]
        B[Enter Search Criteria]
    end
    subgraph System
        C[Validate Search Input]
        D[Query Appointment Records]
        E[Display Search Results]
        F[Display 'No Results Found' Message]
    end
    A --> B
    B --> C
    C --> D
    D -- Results Found --> E
    D -- No Results --> F
    E --> G[End]
    F --> G
```
### Explanation:

**Key Actions & Decisions:**

The user starts a search by entering criteria such as patient name, doctor name, or date.

The system validates the input and queries the appointment records.

Depending on the query results, either matching appointments are displayed or a "No Results Found" message is shown.

**Stakeholder Concerns Addressed:**

Receptionists and Administrators: Quickly retrieve appointment details, supporting efficient scheduling and reducing manual errors.

Patients: Easy access to personal appointment information.

### 6. Notification & Reminder Dispatch Workflow
```mermaid
flowchart TD
    %% Swimlanes: System and Notification Service
    subgraph System
        A[Start: Trigger Appointment Reminder]
        B[Identify Appointments within 24 Hours]
    end
    subgraph NotificationService
        C[Prepare Email Notification]
        D[Prepare SMS Notification]
        E[Send Email Notification]
        F[Send SMS Notification]
    end
    A --> B
    B --> C
    B --> D
    C --> E
    D --> F
    E --> G[End]
    F --> G
```
### Explanation:

**Key Actions & Decisions:**

The system triggers a reminder process for appointments scheduled within the next 24 hours.

It identifies the relevant appointments and then, in parallel, prepares both email and SMS notifications.

Both notifications are sent concurrently.

**Stakeholder Concerns Addressed:**

Patients and Doctors: Receive timely reminders to reduce no-shows, addressing concerns related to missed appointments.

Administrators: Automated notifications reduce manual communication efforts.

### 7. Admin Appointment Management Workflow
```mermaid
flowchart TD
    %% Swimlanes: Admin and System
    subgraph Admin
        A[Start: Access Appointment Management Interface]
        B[Select an Appointment]
        C[Choose Action: Cancel or Reschedule]
    end
    subgraph System
        D[Process Admin Request]
        E[Update Appointment Record]
        F[Send Notifications to Patient & Doctor]
    end
    A --> B
    B --> C
    C --> D
    D --> E
    E --> F
    F --> G[End]
```
### Explanation:

**Key Actions & Decisions:**

The admin accesses the management interface, selects a specific appointment, and chooses whether to cancel or reschedule it.

The system processes this request, updates the appointment record accordingly, and sends notifications to both the patient and doctor.

**Stakeholder Concerns Addressed:**

Hospital Administrators: Improve operational efficiency and reduce the workload associated with manual scheduling.

Receptionists: Support smoother handling of last-minute changes and reduce scheduling conflicts.

### 8. System Exit & Auto-Save Workflow
```mermaid
flowchart TD
    %% Single Swimlane: System
    subgraph System
        A[Start: User Initiates Exit]
        B[Trigger Auto-Save Process]
        C[Save Appointment Data to File]
        D[Confirm Successful Save]
        E[Terminate Session]
    end
    A --> B
    B --> C
    C --> D
    D --> E
    E --> F[End]
```
### Explanation:

**Key Actions & Decisions:**

When a user chooses to exit the system, an auto-save process is immediately triggered.

The system saves all current appointment data to a file (e.g., appointments.txt) in a structured format, confirms that the save was successful, and then terminates the session.

**Stakeholder Concerns Addressed:**

Patients, Doctors, and Administrators: Ensures that no data is lost during system shutdown, supporting the non-functional requirement for data persistence and reliability.

IT Support: Minimizes risk of data corruption and maintains system integrity.

Each diagram maps directly to specific functional requirements and stakeholder pain points mentioned in your System Requirements Document. These workflows help ensure that the system is both user-friendly and robust in handling various scenarios from authentication to data persistence.



---

### ✅ Step-by-Step Plan:

---

#### **1. Traceability Table Format**
Create a simple table in your markdown file or README like this:

```markdown
### 🔗 Traceability Matrix

| Diagram Name                    | Functional Requirement(s)      | User Story / Sprint Task        |
|----------------------------------|--------------------------------|----------------------------------|
| Appointment State Diagram       | FR-002, FR-003, FR-006         | US-5: Book appointment, US-7: Cancel appointment |
| User Registration Activity      | NFR-1 (Usability), FR-001      | US-1: Register as a new user     |
| Doctor Availability State       | FR-005                         | US-9: Update availability        |
| Admin Cancel Activity           | FR-003, FR-004                 | US-8: Admin cancels appointment  |
| Appointment Reminder Activity   | FR-006                         | US-10: Receive appointment reminders |
| Insurance Verification Activity | FR-008                         | US-12: Check insurance           |
```

---

#### **2. Add to `README.md` on GitHub**

Here’s a sample block you can include in your README file:

```markdown
## 📊 UML Diagrams for Hospital Appointment Scheduling System

This repository contains the UML models for our Java-based Hospital Appointment Scheduling System.

### 🔗 Diagram Index

| Type               | Name                            | Link                           |
|--------------------|----------------------------------|--------------------------------|
| State Diagram      | Appointment                     | [View](./diagrams/appointment_state.md) |
| Activity Diagram   | User Registration               | [View](./diagrams/user_registration_activity.md) |
| Activity Diagram   | Admin Cancels Appointment       | [View](./diagrams/admin_cancel_activity.md) |

### 🔄 Traceability to Requirements

See [Traceability Matrix](./docs/traceability_matrix.md) for how diagrams map to functional requirements and user stories from previous assignments.
```

---

Would you like me to help **generate a full traceability matrix** based on the state/activity diagrams you've done so far — and draft the README markdown structure for GitHub?



Awesome! Let's do it step by step. Here's a complete **Traceability Matrix** and a **GitHub `README.md` section** that maps your **UML diagrams** to:

- **Functional Requirements (Assignment 4)**  
- **User Stories & Sprint Tasks (Assignment 6)**

---

## ✅ Traceability Matrix (Markdown Table)

```markdown
### 🔄 Traceability Matrix

| Diagram Name                        | Diagram Type       | Functional Requirement(s)         | User Story / Sprint Task                           |
|------------------------------------|--------------------|-----------------------------------|----------------------------------------------------|
| Appointment                        | State Diagram      | FR-002, FR-003, FR-006            | US-5: Book Appointment, US-7: Cancel Appointment    |
| User Account                       | State Diagram      | FR-001, FR-008                    | US-1: Register/Login, US-2: Role-based Access       |
| Doctor Availability                | State Diagram      | FR-005                            | US-9: Doctor Updates Availability                   |
| Notification                       | State Diagram      | FR-006                            | US-10: Send Appointment Reminders                   |
| System Session                     | State Diagram      | FR-009                            | US-15: Exit System with Auto-save                   |
| Booking Request                    | State Diagram      | FR-002, FR-004                    | US-5: Book Appointment, US-8: Admin Cancels         |
| Patient Profile                    | State Diagram      | NFR-1, FR-001                     | US-13: View/Edit Profile                            |
| Admin Action                       | State Diagram      | FR-004, FR-008                    | US-11: Admin Manages Appointments                   |
| User Registration                  | Activity Diagram   | FR-001, NFR-1                     | US-1: Register New User                             |
| Patient Books Appointment          | Activity Diagram   | FR-002, FR-005                    | US-5: Book Appointment                              |
| Doctor Updates Availability        | Activity Diagram   | FR-005                            | US-9: Doctor Updates Availability                   |
| Admin Cancels Appointment          | Activity Diagram   | FR-003, FR-004                    | US-8: Admin Cancels Appointment                     |
| Appointment Reminder Notification  | Activity Diagram   | FR-006                            | US-10: Notification Sent to Users                   |
| Patient Views Appointment History  | Activity Diagram   | FR-007                            | US-14: Patient Views Appointment History            |
| Insurance Eligibility Verification | Activity Diagram   | FR-008                            | US-12: Check Insurance Coverage                     |
| System Exit with Auto-Save         | Activity Diagram   | FR-009                            | US-15: Exit System with Auto-save                   |
```

---

## 📝 GitHub `README.md` Section

```markdown
# 🏥 Hospital Appointment Scheduling System - UML Models

This repository includes UML diagrams created to support the development and design of the Hospital Appointment Scheduling System, aligning with the functional and non-functional requirements from Assignment 4 and user stories from Assignment 6.

---

## 📁 UML Diagram Index

| Type             | Diagram Name                        | File Link                                      |
|------------------|--------------------------------------|------------------------------------------------|
| State Diagram    | Appointment                         | [/diagrams/appointment_state.md](./diagrams/appointment_state.md) |
| State Diagram    | User Account                        | [/diagrams/user_account_state.md](./diagrams/user_account_state.md) |
| State Diagram    | Doctor Availability                 | [/diagrams/doctor_availability_state.md](./diagrams/doctor_availability_state.md) |
| Activity Diagram | User Registration                   | [/diagrams/user_registration_activity.md](./diagrams/user_registration_activity.md) |
| Activity Diagram | Patient Books Appointment           | [/diagrams/book_appointment_activity.md](./diagrams/book_appointment_activity.md) |
| Activity Diagram | Admin Cancels Appointment           | [/diagrams/admin_cancel_activity.md](./diagrams/admin_cancel_activity.md) |

---

## 🔄 Requirements Traceability

The [Traceability Matrix](./docs/traceability_matrix.md) maps each diagram to relevant system requirements and sprint user stories, ensuring end-to-end alignment between design artifacts and implementation goals.

```

---

✅ **Next Steps (Optional Help I Can Offer):**
- Help you generate `.md` files with the actual Mermaid diagrams.
- Create a folder structure for your GitHub repo (`/diagrams`, `/docs`, etc.).
- Suggest filenames and commit message structure for pushing to GitHub.

Want me to help set up those diagram `.md` files next?

