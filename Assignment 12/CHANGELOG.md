# CHANGELOG

## [v1.0.0] - 2025-05-03

### Features
- Added RESTful API endpoints for core entities:
  - `GET /api/patients` - Fetch all patients
  - `POST /api/patients` - Register a new patient
  - `PUT /api/patients/{id}` - Update patient details
  - `GET /api/doctors` - List all doctors
  - `POST /api/appointments` - Book a new appointment
  - `POST /api/appointments/{id}/cancel` - Cancel an appointment
- Integrated Swagger (OpenAPI) UI at `/swagger-ui.html` for documentation and testing
- Implemented in-memory storage for all repositories
- Business logic added to service layer:
  - Validate patient input
  - Prevent booking if doctor is unavailable
  - Limit patients to one appointment at a time slot

### Fixes
- **#20**: Fixed `NullPointerException` when email is missing during patient registration
- **#21**: AppointmentService now validates doctor availability before booking
- **#22**: Refactored `bookAppointment()` method to improve code readability and maintainability

### Improvements
- Unit tests added for `PatientService`, `DoctorService`, and `AppointmentService`
- Created Factory pattern to abstract repository instantiation for future support (e.g., file system, database)
- Added support for linking tasks to GitHub Issues using `git commit -m "Close #XX: ..."`


