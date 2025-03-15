%% Hospital Appointment System Use Case Diagram (Vertical Layout)
graph TB;
  %% Actors
  Admin["🧑‍💼 Admin"];
  Doctor["👨‍⚕️ Doctor"];
  Patient["🧑‍🦰 Patient"];
  Receptionist["💁 Receptionist"];
  System["💻 System"];
  ITSupport["🛠 IT Support"];
  InsuranceProvider["🏥 Health Insurance Provider"];

  %% Use Cases
  UC1["User Authentication & Role Management"];
  UC2["Book Appointment"];
  UC3["Cancel Appointment"];
  UC4["Search Appointment"];
  UC5["Manage Users"];
  UC6["View Schedule"];
  UC7["Send Notifications & Reminders"];
  UC8["Verify Insurance Details"];
  UC9["Generate Reports"];
  UC10["System Maintenance & Security"];

  %% Relationships
  Admin -->|Manages| UC1;
  Admin -->|Oversees| UC5;
  Admin -->|Generates| UC9;
  Doctor -->|Checks| UC4;
  Doctor -->|Views| UC6;
  Doctor -->|Receives| UC7;
  Patient -->|Requests| UC2;
  Patient -->|Cancels| UC3;
  Patient -->|Verifies| UC8;
  Receptionist -->|Assists in| UC2;
  Receptionist -->|Assists in| UC3;
  System -->|Automates| UC7;
  ITSupport -->|Maintains| UC10;
  InsuranceProvider -->|Verifies| UC8;
```

## **Explanation**
### **Key Actors and Their Roles**
- **Patients**: Book, cancel, and verify appointments.
- **Doctors**: View schedules, check appointments, and receive notifications.
- **Hospital Administrators**: Manage users, oversee operations, and generate reports.
- **Receptionists**: Assist with appointment booking and cancellations.
- **IT Support Staff**: Maintain system security, ensure uptime, and troubleshoot issues.
- **Health Insurance Providers**: Verify patient insurance details.
- **System**: Automates notifications and reminders.

### **Relationships Between Actors and Use Cases**
- **Generalization**: Admin manages user authentication, ensuring role-based access.
- **Inclusion**: The appointment booking use case includes insurance verification.
- **Automation**: The system automatically handles reminders and notifications.

### **Alignment with Stakeholder Concerns**
1. **Patients**: Booking, cancellations, doctor availability, and reminders.
2. **Doctors**: Efficient scheduling, access to patient details, and no double bookings.
3. **Administrators**: Managing appointments, tracking operations, and reducing paperwork.
4. **Receptionists**: Fast appointment handling, easy schedule access, and reduced workload.
5. **IT Support**: Ensuring uptime, security, and data safety.
6. **Insurance Providers**: Quick insurance verification to prevent delays.

This diagram ensures that all functional and non-functional requirements are addressed effectively. 🚀
