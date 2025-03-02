# C4 Architecture Diagrams
## Context Diagram (Level 1)
The Context Diagram shows the overall system and its interactions with external entities.


![Untitled Workspace](https://github.com/user-attachments/assets/3a726816-b11e-4224-a799-07f43937149a)

## Container Diagram (Level 2)
The Container Diagram outlines the software's high-level structure, showing the main containers (applications, databases, etc.) that make up the system.

![C2](https://github.com/user-attachments/assets/25629140-9228-4906-ae6f-93d3aeab9885)

## Component Diagram (Level 3)
The Component Diagram breaks down the key components inside each container. Here, we show how the Java Swing app connects to the Appointment Manager and how the system handles data.

![C3](https://github.com/user-attachments/assets/52ffdb4b-d815-4f0f-977e-39cf22c403e6)

## Dynamic Diagram (Level 4)
The Dynamic Diagram describes how the components interact during key operations such as booking an appointment.

**Booking an Appointment:**
- Step 1: The Patient enters their details (name, doctor, date, etc.) in the Java Swing Interface.
- Step 2: The Appointment Manager checks if the doctor is available.
- Step 3: If available, the appointment is saved in the Appointment Data (text file).
- Step 4: The Patient and Doctor receive a confirmation via Notification Alerts.
