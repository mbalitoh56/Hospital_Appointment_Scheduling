# CHANGELOG

## [v1.0.0] - 2025-04-19

### Added
- Implemented all six creational design patterns:
  - Singleton: Ensured thread-safe instance for DatabaseConnection.
  - Simple Factory: Created AppointmentFactory to generate various appointment types.
  - Factory Method: Used NotificationFactory to delegate email and SMS instantiation.
  - Abstract Factory: Designed UserUIFactory to return GUI elements based on user roles.
  - Builder: Developed DoctorBuilder for customizable Doctor profiles.
  - Prototype: Built AppointmentPrototypeRegistry for cloning appointment templates.

### Testing
- Added BookingWorkflowTest to simulate the appointment lifecycle.
- Implemented test coverage for all patterns.
- Verified thread safety, invalid input handling, and attribute initialization.

### Changed
- Refactored file structure under `/creational_patterns`.
- Grouped pattern implementations with appropriate Java classes.

### Known Issues
- Need better error handling in DoctorBuilder for null specialties.
- Prototype pattern lacks support for deep cloning nested objects.

### Upcoming
- File-based persistence (appointments.txt) to be added.
- UI integration planned for demonstration of pattern interactions.

