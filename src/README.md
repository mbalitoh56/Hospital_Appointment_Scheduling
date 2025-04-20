### Relationships Covered

- **Inheritance**:
  - `Patient`, `Doctor`, `Admin` inherit from `User`.
- **Association**:
  - `Appointment` has associations with `Patient` and `Doctor`.
- **Composition**:
  - `Notification` is composed and used by appointments or user actions.

---

### Language Choice: **Java**

**Why Java?**
-  **Platform-independent:** Java runs on any OS with a JVM (Windows, Linux, macOS), supporting the deployability requirement.
-  **Object-Oriented Design:** Perfect for modeling real-world hospital roles like Patients, Doctors, and Admins using inheritance and encapsulation.
-  **Strong Typing and Error Handling:** Reduces bugs and ensures better input validation, aligned with security and validation requirements.
-  **Rich Libraries:** Java provides built-in support for date/time (`LocalDateTime`), file handling, and GUI components (Swing), supporting features like reminders, persistence, and a future GUI.
-  **Community and Support:** Java is well-supported for both academic and enterprise-grade applications.

---

### Key Design Decisions

#### 1. **Object-Oriented Structure**
- Used **inheritance** by creating a base `User` class and extending it to `Patient`, `Doctor`, and `Admin` to reduce code duplication.
- Each subclass overrides methods like `login()` and has its own role-specific operations (e.g., booking/canceling appointments).

#### 2. **Encapsulation**
- All class attributes are marked `private` or `protected`, with getters and setters where needed to enforce encapsulation and secure data handling.

#### 3. **Appointment Management**
- `Appointment` class includes composition with `Doctor` and `Patient`, ensuring direct association during creation.
- Methods like `confirm()` and `cancel()` manage appointment state transitions aligned with use cases and behavioral models.

#### 4. **Notifications**
- `Notification` class sends or schedules reminders to patients and doctors, directly supporting functional requirements related to timely communication.

#### 5. **Domain Alignment**
- The class design mirrors domain entities like Patient, Doctor, Admin, and Appointment identified during domain modeling.
- Every use case (e.g., "Book Appointment", "Cancel Appointment") maps to a method or relationship in the class structure.
- State transitions (e.g., Appointment status: Scheduled → Confirmed → Cancelled) are modeled using simple string state variables for extensibility.

#### 6. **Scalability and Modularity**
- The modular architecture makes it easy to add new features (e.g., `MedicalHistory`, `Billing`, `AvailabilityCheck`) without modifying existing code drastically.

#### 7. **Future-Ready**
- Classes are designed with extensibility in mind — for instance:
  - Notifications could later support email/SMS integration.
  - File-based persistence could evolve into database storage.
  - CLI interactions can be upgraded to a full Java Swing GUI or JavaFX interface.

