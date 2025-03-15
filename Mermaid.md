%% Hospital Appointment System Use Case Diagram
graph TD
  %% Actors
  Admin["🧑‍💼 Admin"]
  Doctor["👨‍⚕️ Doctor"]
  Patient["🧑‍🦰 Patient"]
  Receptionist["💁 Receptionist"]
  System["💻 System"]
  Nurse["👩‍⚕️ Nurse"]

  %% Use Cases
  UC1["Manage Appointments"]
  UC2["Book Appointment"]
  UC3["Cancel Appointment"]
  UC4["Search Appointment"]
  UC5["Manage Users"]
  UC6["View Schedule"]
  UC7["Send Notifications"]
  UC8["Generate Reports"]

  %% Relationships
  Admin -->|Manages| UC1
  Admin -->|Manages| UC5
  Admin -->|Generates| UC8
  Doctor -->|Checks| UC4
  Doctor -->|Views| UC6
  Patient -->|Requests| UC2
  Patient -->|Cancels| UC3
  Receptionist -->|Assists in| UC2
  Receptionist -->|Assists in| UC3
  System -->|Automates| UC7
  Nurse -->|Assists Doctor in| UC6

