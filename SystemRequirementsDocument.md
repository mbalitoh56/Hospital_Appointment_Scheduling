# STAKEHOLDER ANALYSIS

### 1. Patients

** Role: **  Users who book appointments with doctors.
Key Concerns: 
•	Easy appointment booking and cancellation.
•	Access to doctors' availability.
•	Timely notifications about upcoming appointments.
Pain Points: 
•	Difficulty in finding available doctors.
•	No reminder system for scheduled appointments.
•	Long waiting times at the hospital due to overbooking.
Success Metrics: 
•	30% reduction in missed appointments.
•	Faster booking process (< 3 minutes per appointment).
2. Doctors
Role: Provide medical consultation based on scheduled appointments.
Key Concerns: 
•	Efficient scheduling to avoid double bookings.
•	Access to patient details before appointments.
•	Ability to manage availability and appointment times.
Pain Points: 
•	No centralized system to track daily appointments.
•	Patients missing appointments without prior cancellation.
•	Overbooked time slots causing delays.
Success Metrics: 
•	40% fewer scheduling conflicts.
•	25% improvement in doctor-patient consultation time.
3. Hospital Administrators
•	Role: Manage hospital operations, ensure smooth scheduling.
•	Key Concerns: 
o	Effective monitoring of doctor schedules.
o	Proper record-keeping of all patient appointments.
o	Ensuring the system reduces manual work.
•	Pain Points: 
o	Heavy reliance on paperwork for tracking appointments.
o	Difficulty in managing last-minute appointment changes.
o	No real-time insights into doctor availability.
•	Success Metrics: 
o	50% reduction in administrative workload.
o	Real-time tracking of appointments for better hospital efficiency.
4. Receptionists
•	Role: Assist patients with booking, rescheduling, and canceling appointments.
•	Key Concerns: 
o	Fast and efficient appointment handling.
o	Easy access to doctor schedules.
o	Reducing errors in appointment scheduling.
•	Pain Points: 
o	Manual tracking of doctor availability.
o	High workload during peak hours.
o	No automated confirmation messages for patients.
•	Success Metrics: 
o	30% decrease in appointment booking errors.
o	Faster processing of appointment requests.
5. IT Support Staff
•	Role: Maintain and troubleshoot the appointment scheduling system.
•	Key Concerns: 
o	Ensuring the system runs without downtime.
o	Secure handling of patient data.
o	Regular updates and maintenance.
•	Pain Points: 
o	Frequent system crashes due to increased user load.
o	Lack of an automated backup system.
o	Security vulnerabilities in patient data storage.
•	Success Metrics: 
o	99% system uptime.
o	Zero data breaches within a year.
6. Health Insurance Providers
•	Role: Verify patient eligibility and coverage for hospital visits.
•	Key Concerns: 
o	Integration with hospital billing systems.
o	Quick verification of patient insurance details.
o	Reducing fraudulent claims.
•	Pain Points: 
o	Delayed insurance verification processes.
o	Patients unsure of their coverage before appointments.
o	Poor communication between hospitals and insurance companies.
•	Success Metrics: 
o	50% faster insurance verification process.
o	Reduced number of rejected claims due to miscommunication.

FUNCTIONAL REQUIREMENTS
1. User Authentication & Role Management
•	Requirement: The system shall allow users to log in using a username and select a role (Admin, Doctor, or Patient).
•	Acceptance Criteria: 
o	Users must be able to select their role during login.
o	Incorrect logins must prompt an error message.
2. Appointment Booking
•	Requirement: The system shall allow patients and admins to book appointments with doctors.
•	Acceptance Criteria: 
o	The system must prevent double bookings for the same doctor at the same time.
o	Patients should receive a confirmation message upon successful booking.
3. Appointment Cancellation
•	Requirement: The system shall allow admins to cancel any appointment and patients to cancel their own.
•	Acceptance Criteria: 
o	Users must confirm cancellation before finalizing it.
o	A notification must be sent to the doctor and patient upon cancellation.
4. Search for Appointments
•	Requirement: The system shall allow users to search for appointments by patient name, doctor name, or date.
•	Acceptance Criteria: 
o	The search results must display relevant appointment details.
o	The system must return results in less than 2 seconds for a typical query.
5. Doctor Availability Check
•	Requirement: The system shall prevent booking if the doctor is already scheduled for an appointment at the requested time.
•	Acceptance Criteria: 
o	If a doctor is unavailable, the system must display an error message.
o	Available time slots should be visible before booking.
6. Notifications & Reminders
•	Requirement: The system shall send notifications to patients and doctors for upcoming appointments and cancellations.
•	Acceptance Criteria: 
o	Notifications must be displayed immediately after booking or cancellation.
o	Reminders must be sent at least 24 hours before the appointment.
7. Data Storage & Persistence
•	Requirement: The system shall store all appointment details in a file (appointments.txt).
•	Acceptance Criteria: 
o	Appointment data must be retrievable after system restart.
o	Data must be saved in a structured format (e.g., CSV).
8. Role-Based Access Control
•	Requirement: The system shall restrict actions based on user roles.
•	Acceptance Criteria: 
o	Patients can only view their own appointments.
o	Doctors can only view appointments assigned to them.
o	Admins can view, book, and cancel all appointments.
9. Exit & Auto-Save
•	Requirement: The system shall save all appointments before closing.
•	Acceptance Criteria: 
o	Upon clicking "Exit," the system must automatically save data.
o	No appointment data should be lost after restarting.
10. Error Handling & Validation
•	Requirement: The system shall validate user inputs to prevent invalid data entry.
•	Acceptance Criteria: 
o	Users must enter dates in the format YYYY-MM-DD.
o	Time must be entered in HH:MM format.
o	If incorrect data is entered, the system must display a clear error message.




NON-FUNCTIONAL REQUIREMENTS
1. Usability
•	Requirement: The system shall provide a simple and intuitive graphical user interface (GUI) for easy navigation.
•	Requirement: The system shall ensure text readability and button accessibility for all users, including those with visual impairments.
•	Requirement: Error messages shall be clear and provide guidance on how to correct input mistakes.
2. Deployability
•	Requirement: The system shall be deployable on Windows and Linux operating systems.
•	Requirement: The system shall require Java 11 or later for execution.
•	Requirement: The system shall run as a standalone desktop application with no external database dependencies.
3. Maintainability
•	Requirement: The system shall include a developer guide with instructions for future enhancements and debugging.
•	Requirement: The source code shall follow clean coding practices with proper comments and documentation.
•	Requirement: The system shall support modular architecture, making it easy to add new features such as automated reminders or patient medical history tracking.
4. Scalability
•	Requirement: The system shall support at least 100 concurrent users without performance degradation.
•	Requirement: The system shall handle up to 10,000 appointment records efficiently.
•	Requirement: Future enhancements should allow integration with cloud-based storage solutions for scalability.
5. Security
•	Requirement: All stored appointment data shall be encrypted using AES-256 encryption.
•	Requirement: User authentication must include role-based access control (RBAC) to prevent unauthorized access.
•	Requirement: The system shall implement input validation to prevent SQL injection and other security threats.
6. Performance
•	Requirement: Appointment searches shall return results within 2 seconds.
•	Requirement: The system shall load and display the main dashboard within 5 seconds after login.
•	Requirement: The system shall automatically save appointment data within 1 second before closing.


