# Hospital Appointment System - Test Case Development

## **Functional Test Cases**
| Test Case ID | Requirement ID | Description | Steps | Expected Result | Actual Result | Status (Pass/Fail) |
|-------------|---------------|-------------|-------|-----------------|---------------|----------------|
| TC-001 | FR-002 | Book an appointment | 1. Patient selects doctor & time slot  2. Clicks "Book"  3. System confirms | Appointment is successfully booked | Appointment was successfully booked. | Pass |
| TC-002 | FR-003 | Cancel an appointment | 1. Patient selects an existing appointment  2. Clicks "Cancel"  3. Confirms action | Appointment is removed, notification sent | Appointment was removed, and a cancellation notification was sent.  | Pass |
| TC-003 | FR-004 | Search for appointments | 1. Enter doctor/patient name or date  2. Click "Search" | Matching appointments are displayed within 2 seconds | Search results were displayed in less than 2 seconds. | Pass |
| TC-004 | FR-005 | Check doctor availability | 1. Select doctor  2. System displays available slots | Available time slots are shown | Available time slots displayed correctly. | Pass |
| TC-005 | FR-006 | Receive appointment notification | 1. Book appointment  2. Wait for system to send reminder | Patient & doctor receive notifications | Both the patient and doctor received timely notifications. | Pass |
| TC-006 | FR-001 | User authentication | 1. Enter valid username & password  2. Click "Login" | User is logged in & directed to role-specific dashboard | User logged in and directed to the correct dashboard. | Pass |
| TC-007 | FR-007 | Verify patient insurance | 1. Enter insurance details  2. Click "Verify" | Insurance details are validated | Insurance details were validated successfully. | Pass |
| TC-008 | FR-010 | Validate input fields | 1. Enter invalid date format (e.g., 12-31-2025 instead of YYYY-MM-DD) | System displays an error message | Error message displayed for incorrect date format. | Pass |

---

## **Non-Functional Test Cases**
| Test Case ID | Requirement ID | Test Scenario | Steps | Expected Result | Actual Result | Status (Pass/Fail) |
|-------------|---------------|--------------|-------|-----------------|---------------|----------------|
| TC-NF-001 | NFR-006 | **Performance Test**: System should handle 1000 concurrent users | Simulate 1000 concurrent users booking/searching appointments | Response time ≤ 2 seconds | | |
| TC-NF-002 | NFR-005 | **Security Test**: Prevent unauthorized access | Attempt login with invalid credentials multiple times | System locks account after 5 failed attempts | | |

---

📌 **How to Use:**  
- Upload this `.md` file to GitHub for proper display.  
- Use these test cases to validate system functionality.  

Would you like any modifications or additional test cases? 😊  

