# USER STORY TABLE


| **User Story ID** | **User Story** | **Acceptance Criteria** | **Priority** |
|-------------------|----------------|--------------------------|-------------|
| **US-001** | As a patient, I want to register for an account so I can book and manage appointments. | Registration is confirmed via email, and the patient can log in immediately | **High** |
| **US-002** | As a patient, I want to log in to the system so I can access my appointments. | Patient logs in using username and password, with access to the appointment dashboard | **High** |
| **US-003** | As a patient, I want to book an appointment with a doctor so I can receive medical attention. | Appointment is successfully booked, and patient receives confirmation | **High** |
| **US-004** | As a patient, I want to cancel my appointment so I can free up a slot for someone else. | Appointment cancellation is confirmed and the slot is released | **High** |
| **US-005** | As a doctor, I want to set my availability so patients can book appointments only when I am free. | Doctor’s availability is updated, and unavailable slots are blocked for booking | **High** |
| **US-006** | As a doctor, I want to view my appointment schedule so I can prepare for patient visits. | Doctor’s schedule displays all upcoming appointments in a clear, organized manner | **High** |
| **US-007** | As an admin, I want to manage doctor and patient accounts so I can ensure correct access control. | Admin can add, edit, or delete doctor and patient profiles with role-based permissions | **High** |
| **US-008** | As an admin, I want to view system usage stats so I can monitor activity and performance. | Admin can generate reports on system usage, including appointments, cancellations, and errors | **Medium** |
| **US-009** | As a system, I want to notify patients and doctors about appointment changes so they stay informed. | Notifications (email/SMS) are sent to both patients and doctors for appointment changes | **High** |
| **US-010** | As a system, I want to check for doctor availability before booking an appointment so I avoid double booking. | System checks real-time doctor availability before finalizing a booking | **High** |
| **US-011** | As a system, I want to store appointment data securely so that all sensitive information is protected. | Appointment data is encrypted and stored in compliance with privacy standards | **High** |
| **US-012** | As a system, I want to allow users to reset their passwords so they can regain access if they forget it. | Password reset process via email works correctly, allowing users to set a new password | **Medium** |

### Non-Functional User Story

| **User Story ID** | **User Story** | **Acceptance Criteria** | **Priority** |
|-------------------|----------------|--------------------------|-------------|
| **US-013** | As a system admin, I want to ensure user data is encrypted with AES-256 so that security compliance standards are met. | All user data is encrypted with AES-256 encryption | **High** |

---

# PRODUCT BACKLOG

| **Story ID** | **User Story** | **Priority (MoSCoW)** | **Effort Estimate** | **Dependencies** |
|--------------|----------------|-----------------------|---------------------|------------------|
| **US-001** | As a patient, I want to register for an account so I can book and manage appointments. | Must-have | 5 | None |
| **US-002** | As a patient, I want to log in to the system so I can access my appointments. | Must-have | 3 | US-001 |
| **US-003** | As a patient, I want to book an appointment with a doctor so I can receive medical attention. | Must-have | 5 | US-002, US-005 |
| **US-004** | As a patient, I want to cancel my appointment so I can free up a slot for someone else. | Must-have | 4 | US-003 |
| **US-005** | As a doctor, I want to set my availability so patients can book appointments only when I am free. | Must-have | 4 | None |
| **US-006** | As a doctor, I want to view my appointment schedule so I can prepare for patient visits. | Should-have | 3 | US-003 |
| **US-007** | As an admin, I want to manage doctor and patient accounts so I can ensure correct access control. | Must-have | 4 | None |
| **US-008** | As an admin, I want to view system usage stats so I can monitor activity and performance. | Should-have | 3 | US-007 |
| **US-009** | As a system, I want to notify patients and doctors about appointment changes so they stay informed. | Must-have | 4 | US-003, US-006 |
| **US-010** | As a system, I want to check for doctor availability before booking an appointment so I avoid double booking. | Must-have | 5 | US-005 |
| **US-011** | As a system, I want to store appointment data securely so that all sensitive information is protected. | Must-have | 5 | None |
| **US-012** | As a system, I want to allow users to reset their passwords so they can regain access if they forget it. | Should-have | 3 | US-002 |
| **US-013** | As a system admin, I want to ensure user data is encrypted with AES-256 so that security compliance standards are met. | Must-have | 4 | None |

### Justification for Prioritization:

**Must-have**: These user stories are essential for the hospital appointment system to work. They affect the main functions of the system, like creating accounts, booking appointments, managing availability, and ensuring data security. Without them, the system wouldn't meet user needs. For example, **US-001** (patient registration) and **US-003** (appointment booking) are necessary for the system to operate properly.

**Should-have**: These stories improve the system and make it more convenient for users, but they aren’t absolutely required for the first launch. For instance, **US-006** (doctor's appointment schedule view) is helpful but not essential for the system to work in the beginning; a simpler version could be used at first.

**Could-have**: These stories are additional features that would make the system better but aren't necessary for the first release. They can be added in later updates. 

**Won't-have**: These stories aren't in this backlog because all tasks focus on important features or improvements needed for the first release.

---

# SPRINT PLAN

**Sprint Goal**: 
*"Implement core patient registration, appointment booking, and doctor availability management functionalities."*


## **Sprint Backlog Table**:

| **Task ID** | **Task Description**                                    | **Assigned To**  | **Estimated Hours** | **Status**        |
|-------------|----------------------------------------------------------|------------------|---------------------|-------------------|
| **T-001**   | Develop user registration endpoint                       | Dev Team         | 8                   | To Do            |
| **T-002**   | Design and implement patient registration UI             | UI/UX Team       | 10                  | To Do            |
| **T-003**   | Implement login system for patients                       | Dev Team         | 6                   | To Do            |
| **T-004**   | Develop appointment booking functionality                | Dev Team         | 12                  | To Do            |
| **T-005**   | Create doctor availability management feature            | Dev Team         | 10                  | To Do            |
| **T-006**   | Integrate appointment booking with doctor's schedule     | Dev Team         | 8                   | To Do            |
| **T-007**   | Write unit tests for appointment booking feature         | QA Team          | 5                   | To Do            |

---

This sprint is focused on implementing the core functionality needed for the hospital appointment system. By the end of the sprint, the following will be achieved:
- **Patient Registration**: Patients will be able to create an account and log in.
- **Appointment Booking**: Patients will be able to book appointments based on available slots.
- **Doctor Availability**: Doctors will be able to set their availability for appointments, ensuring no double bookings.

These features are critical for the MVP, allowing the system to perform its primary function of managing appointments and ensuring accessibility for both patients and doctors.

---

# REFLECTION

Being the only stakeholder in this project has made the whole process of prioritizing tasks, estimating time, and aligning Agile with my needs pretty tough. It’s been hard to decide what features are most important, what tasks to focus on first, and how to make sure the work stays on track.

**1. Prioritization Challenges:**
One of the hardest parts was deciding which tasks should come first. It was easy to pick the must-have tasks, like patient registration and booking appointments, because they’re crucial for the system to work. But when it came to other tasks, like adding extra features or improving things that are not urgently needed, it was tricky. Sometimes, I wanted to include lots of cool features, but I had to remind myself that they could be added later. This constant battle between wanting everything now and needing to stick to the basics made it hard to prioritize the tasks properly.

**2. Estimation Problems:**
Another challenge was figuring out how long each task would take. Even though Agile gives room for change, you still need to plan the work, and this is where I had trouble. Sometimes, I thought a task would be quick, but it took me longer than expected, or the other way around. For example, making the login system secure seemed simple at first, but it ended up being a more complex job. It’s hard to estimate accurately when you’re doing everything on your own, and this made me feel uncertain about how long things would actually take.

**3. Aligning Agile with My Needs:**
The biggest challenge was that Agile usually works best with more than one person. Normally, with Agile, you get feedback from others regularly, but since I was the only one involved, I had to make all the decisions on my own. This made me question whether I was choosing the right things for the system or if I was just focusing on what I wanted. Without any other opinions to guide me, I sometimes felt unsure if I was working on the right features and if the product would meet future users' needs.

**Conclusion:**
Overall, these challenges helped me learn a lot about how Agile works and how hard it can be to manage a project on your own. It’s much easier to work with others and get their feedback to help make decisions. Even though it was tough to make these choices alone, the experience taught me valuable lessons about prioritizing, estimating, and sticking to a clear goal. In the future, I would definitely prefer to work with a team and get feedback from more people.
