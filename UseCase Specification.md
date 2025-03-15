# Hospital Appointment System - Use Case Specifications

## **1. Book Appointment**
**Actor:** Patient, Receptionist, Admin  
**Description:** Allows a patient to schedule an appointment with an available doctor.  
### **Preconditions**
- Patient must be registered in the system.
- Doctor must have available time slots.  

### **Postconditions**
- Appointment is successfully saved in the system.
- Patient and doctor receive a confirmation notification.  

### **Basic Flow**
1. Patient selects a doctor and available time slot.
2. System checks for availability.
3. System saves the appointment.
4. Patient and doctor receive a confirmation message.

### **Alternative Flows**
- **Doctor unavailable** → System displays an error and suggests alternative time slots.
- **Patient not registered** → System prompts for registration before proceeding.

---

## **2. Cancel Appointment**
**Actor:** Patient, Admin  
**Description:** Allows a patient or admin to cancel an existing appointment.  

### **Preconditions**
- The appointment must exist in the system.  

### **Postconditions**
- The appointment is removed from the schedule.
- A cancellation notification is sent to the doctor and patient.  

### **Basic Flow**
1. Patient selects the appointment.
2. System confirms the cancellation request.
3. System removes the appointment from the schedule.
4. System sends a notification to relevant parties.

### **Alternative Flows**
- **Appointment does not exist** → System displays an error message.
- **Late cancellation** → System notifies patient of possible penalties.

---

## **3. Search Appointment**
**Actor:** Patient, Doctor, Receptionist, Admin  
**Description:** Enables users to search for appointments by doctor, patient, or date.  

### **Preconditions**
- User must be logged in.  

### **Postconditions**
- Search results are displayed based on filters.  

### **Basic Flow**
1. User enters search criteria.
2. System retrieves matching appointments.
3. Results are displayed.

### **Alternative Flows**
- **No matches found** → System displays a "No results found" message.

---

## **4. Manage Doctor Availability**
**Actor:** Doctor, Admin  
**Description:** Doctors can update their availability for scheduling appointments.  

### **Preconditions**
- The doctor must be logged into the system.  

### **Postconditions**
- Availability is updated and reflected in the booking system.  

### **Basic Flow**
1. Doctor logs in and selects "Manage Availability."
2. Doctor updates available time slots.
3. System saves the changes.

### **Alternative Flows**
- **System error** → Doctor receives an error message and must retry.

---

## **5. Receive Notifications**
**Actor:** Patient, Doctor  
**Description:** Sends notifications for upcoming appointments and cancellations.  

### **Preconditions**
- The user has a scheduled appointment.  

### **Postconditions**
- Notifications are delivered via email/SMS.  

### **Basic Flow**
1. System checks appointment schedule.
2. System sends reminders 24 hours before the appointment.
3. Users receive and acknowledge notifications.

### **Alternative Flows**
- **Notification delivery failure** → System retries or provides an alternative notification method.

---

## **6. User Authentication**
**Actor:** Patient, Doctor, Admin, Receptionist, IT Support  
**Description:** Allows users to log in with role-based access.  

### **Preconditions**
- User must have valid login credentials.  

### **Postconditions**
- User is granted access based on their role.  

### **Basic Flow**
1. User enters username and password.
2. System verifies credentials.
3. System grants access based on the role.

### **Alternative Flows**
- **Invalid credentials** → System denies access and prompts for re-entry.

---

## **7. Verify Insurance**
**Actor:** Health Insurance Provider  
**Description:** Verifies a patient’s insurance coverage before an appointment.  

### **Preconditions**
- Patient’s insurance details must be entered in the system.  

### **Postconditions**
- Insurance coverage is confirmed, or alternative payment is required.  

### **Basic Flow**
1. Patient provides insurance details.
2. System checks the insurance provider’s database.
3. System confirms or denies coverage.

### **Alternative Flows**
- **Invalid insurance details** → System prompts for correction or alternative payment.

---

## **8. System Maintenance**
**Actor:** IT Support  
**Description:** Ensures system uptime, security, and troubleshooting.  

### **Preconditions**
- IT staff must have administrative access.  

### **Postconditions**
- System remains operational without downtime.  

### **Basic Flow**
1. IT staff logs into the admin panel.
2. System diagnostics are run.
3. Issues are resolved if detected.

### **Alternative Flows**
- **System failure** → IT staff escalates issue for further resolution.

---

