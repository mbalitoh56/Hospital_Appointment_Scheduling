# USER STORY

| **Story ID** | **User Story** | **Acceptance Criteria** | **Priority** |  
|-------------|--------------|------------------------|-------------|  
| **US001** | As a patient, I want to book an appointment with a doctor so that I can receive medical consultation. | The system allows a patient to select a doctor, date, and time; confirms availability; and saves the appointment. | High |  
| **US002** | As an admin, I want to cancel an appointment so that I can manage scheduling conflicts. | The system allows admins to select and remove an appointment, notifying the patient. | High |  
| **US003** | As a doctor, I want to view my upcoming appointments so that I can prepare for my consultations. | The system displays a list of all appointments scheduled for the doctor. | High |  
| **US004** | As a patient, I want to search for my scheduled appointments so that I can verify my booking details. | The system provides a search function where patients can enter their name and see a list of their appointments. | Medium |  
| **US005** | As an admin, I want to manage user authentication so that only authorized users can access the system. | Users must log in with valid credentials and select a role before accessing features. | High |  
| **US006** | As a patient, I want to receive a notification when my appointment is booked or canceled so that I stay informed. | The system displays a confirmation message after booking or canceling an appointment. | High |  
| **US007** | As an admin, I want to load and save appointments persistently so that data is not lost when the system restarts. | Appointment data is saved to a file and loaded correctly upon startup. | High |  
| **US008** | As a doctor, I want to check my availability before a patient books an appointment so that I am not double-booked. | The system verifies and prevents overlapping bookings for the same doctor, date, and time. | High |  
| **US009** | As a patient, I want to filter available doctors by specialty so that I can find the right medical professional. | The system provides a dropdown to filter doctors by specialty before booking an appointment. | Medium |  
| **US010** | As a system admin, I want user data encrypted with AES-256 so that security compliance is met. | All user credentials and sensitive data are encrypted before storage. | High |  
