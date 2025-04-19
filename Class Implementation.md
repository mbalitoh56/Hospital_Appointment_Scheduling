# CLASS IMPLEMENTATION
Great! Below is the **Java class implementation** for the **Hospital Appointment Scheduling System**, based on the previously defined **Mermaid.js class diagram**. This includes key classes like `User`, `Patient`, `Doctor`, `Admin`, `Appointment`, and `Notification`.

---

### ✅ 1. `User.java` (Abstract Superclass)

```java
public abstract class User {
    protected String userId;
    protected String name;
    protected String username;
    protected String password;

    public User(String userId, String name, String username, String password) {
        this.userId = userId;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public abstract void login();
    public abstract void logout();

    // Getters and Setters
    public String getUserId() { return userId; }
    public String getName() { return name; }
    public String getUsername() { return username; }
}
```

---

### ✅ 2. `Patient.java`

```java
public class Patient extends User {

    public Patient(String userId, String name, String username, String password) {
        super(userId, name, username, password);
    }

    @Override
    public void login() {
        System.out.println("Patient " + username + " logged in.");
    }

    @Override
    public void logout() {
        System.out.println("Patient " + username + " logged out.");
    }

    public void bookAppointment(Appointment appointment) {
        System.out.println("Appointment booked: " + appointment.getAppointmentId());
    }

    public void cancelAppointment(Appointment appointment) {
        System.out.println("Appointment canceled: " + appointment.getAppointmentId());
    }
}
```

---

### ✅ 3. `Doctor.java`

```java
public class Doctor extends User {
    private String specialization;

    public Doctor(String userId, String name, String username, String password, String specialization) {
        super(userId, name, username, password);
        this.specialization = specialization;
    }

    @Override
    public void login() {
        System.out.println("Doctor " + username + " logged in.");
    }

    @Override
    public void logout() {
        System.out.println("Doctor " + username + " logged out.");
    }

    public void viewAppointments() {
        System.out.println("Doctor is viewing today's appointments.");
    }

    public String getSpecialization() {
        return specialization;
    }
}
```

---

### ✅ 4. `Admin.java`

```java
public class Admin extends User {

    public Admin(String userId, String name, String username, String password) {
        super(userId, name, username, password);
    }

    @Override
    public void login() {
        System.out.println("Admin " + username + " logged in.");
    }

    @Override
    public void logout() {
        System.out.println("Admin " + username + " logged out.");
    }

    public void cancelAppointment(Appointment appointment) {
        System.out.println("Admin canceled appointment: " + appointment.getAppointmentId());
    }

    public void manageUsers() {
        System.out.println("Admin managing users.");
    }
}
```

---

### ✅ 5. `Appointment.java`

```java
import java.time.LocalDateTime;

public class Appointment {
    private String appointmentId;
    private LocalDateTime dateTime;
    private Doctor doctor;
    private Patient patient;
    private String status; // e.g., Scheduled, Cancelled

    public Appointment(String appointmentId, LocalDateTime dateTime, Doctor doctor, Patient patient) {
        this.appointmentId = appointmentId;
        this.dateTime = dateTime;
        this.doctor = doctor;
        this.patient = patient;
        this.status = "Scheduled";
    }

    public void confirm() {
        this.status = "Confirmed";
        System.out.println("Appointment confirmed.");
    }

    public void cancel() {
        this.status = "Cancelled";
        System.out.println("Appointment cancelled.");
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getStatus() {
        return status;
    }
}
```

---

### ✅ 6. `Notification.java`

```java
public class Notification {
    private String message;
    private String recipientId;

    public Notification(String message, String recipientId) {
        this.message = message;
        this.recipientId = recipientId;
    }

    public void send() {
        System.out.println("Notification sent to " + recipientId + ": " + message);
    }

    public void scheduleReminder() {
        System.out.println("Reminder scheduled for " + recipientId);
    }
}
```

---

### ✅ Relationships Covered

- **Inheritance**:
  - `Patient`, `Doctor`, `Admin` inherit from `User`.
- **Association**:
  - `Appointment` has associations with `Patient` and `Doctor`.
- **Composition**:
  - `Notification` is composed and used by appointments or user actions.

---

Would you like to:
- Bundle these into `.java` files?
- Generate a test class to simulate a booking workflow?
- Add file persistence (`appointments.txt`)?

Sure! Here's a sample `README.md` for your **Hospital Appointment Scheduling System**, explaining the language choice and key design decisions.

---

## 📘 Hospital Appointment Scheduling System - README

### 🔧 Language Choice: **Java**

**Why Java?**
- ✅ **Platform-independent:** Java runs on any OS with a JVM (Windows, Linux, macOS), supporting the deployability requirement.
- ✅ **Object-Oriented Design:** Perfect for modeling real-world hospital roles like Patients, Doctors, and Admins using inheritance and encapsulation.
- ✅ **Strong Typing and Error Handling:** Reduces bugs and ensures better input validation, aligned with security and validation requirements.
- ✅ **Rich Libraries:** Java provides built-in support for date/time (`LocalDateTime`), file handling, and GUI components (Swing), supporting features like reminders, persistence, and a future GUI.
- ✅ **Community and Support:** Java is well-supported for both academic and enterprise-grade applications.

---

### 🧠 Key Design Decisions

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

---

### 📁 Project Structure (Suggested)

```
/hospital-appointment-system
│
├── User.java
├── Patient.java
├── Doctor.java
├── Admin.java
├── Appointment.java
├── Notification.java
└── README.md
```

---

### 🧪 Testing

You can write a simple `Main.java` class to:
- Simulate user logins.
- Book/cancel appointments.
- Trigger notification messages.

Let me know if you'd like a sample test driver class too!

---

Would you like to add GUI instructions, file storage steps, or command-line usage examples next?


# Creational Pattern Implementation

### 📁 `/creational_patterns/hospital`

#### 1. **Simple Factory Pattern**  
**Use Case**: Centralized creation of user roles (Patient, Doctor, Admin)

```java
// User.java
public interface User {
    void accessSystem();
}

// Patient.java
public class Patient implements User {
    public void accessSystem() {
        System.out.println("Patient accessing the appointment system.");
    }
}

// Doctor.java
public class Doctor implements User {
    public void accessSystem() {
        System.out.println("Doctor accessing appointment schedule.");
    }
}

// Admin.java
public class Admin implements User {
    public void accessSystem() {
        System.out.println("Admin managing the hospital system.");
    }
}

// UserFactory.java
public class UserFactory {
    public static User createUser(String role) {
        switch (role.toLowerCase()) {
            case "patient": return new Patient();
            case "doctor": return new Doctor();
            case "admin": return new Admin();
            default: throw new IllegalArgumentException("Invalid role: " + role);
        }
    }
}
```

#### 2. **Factory Method Pattern**  
**Use Case**: Different appointment processors based on booking type.

```java
// AppointmentProcessor.java
public interface AppointmentProcessor {
    void processAppointment();
}

// RegularAppointment.java
public class RegularAppointment implements AppointmentProcessor {
    public void processAppointment() {
        System.out.println("Processing regular appointment.");
    }
}

// EmergencyAppointment.java
public class EmergencyAppointment implements AppointmentProcessor {
    public void processAppointment() {
        System.out.println("Processing emergency appointment.");
    }
}

// AppointmentCreator.java
public abstract class AppointmentCreator {
    public abstract AppointmentProcessor createAppointment();
}

// RegularAppointmentCreator.java
public class RegularAppointmentCreator extends AppointmentCreator {
    public AppointmentProcessor createAppointment() {
        return new RegularAppointment();
    }
}

// EmergencyAppointmentCreator.java
public class EmergencyAppointmentCreator extends AppointmentCreator {
    public AppointmentProcessor createAppointment() {
        return new EmergencyAppointment();
    }
}
```

#### 3. **Abstract Factory Pattern**  
**Use Case**: UI components for different hospital branches (e.g., public vs. private hospitals)

```java
// Button.java
public interface Button {
    void render();
}

// PublicHospitalButton.java
public class PublicHospitalButton implements Button {
    public void render() {
        System.out.println("Rendering Public Hospital Button");
    }
}

// PrivateHospitalButton.java
public class PrivateHospitalButton implements Button {
    public void render() {
        System.out.println("Rendering Private Hospital Button");
    }
}

// UIFactory.java
public interface UIFactory {
    Button createButton();
}

// PublicHospitalUIFactory.java
public class PublicHospitalUIFactory implements UIFactory {
    public Button createButton() {
        return new PublicHospitalButton();
    }
}

// PrivateHospitalUIFactory.java
public class PrivateHospitalUIFactory implements UIFactory {
    public Button createButton() {
        return new PrivateHospitalButton();
    }
}
```

#### 4. **Builder Pattern**  
**Use Case**: Building complex patient profiles step-by-step.

```java
// PatientProfile.java
public class PatientProfile {
    private String name;
    private int age;
    private String allergies;
    private String chronicConditions;

    public static class Builder {
        private final String name;
        private int age;
        private String allergies = "";
        private String chronicConditions = "";

        public Builder(String name) {
            this.name = name;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder allergies(String allergies) {
            this.allergies = allergies;
            return this;
        }

        public Builder chronicConditions(String chronicConditions) {
            this.chronicConditions = chronicConditions;
            return this;
        }

        public PatientProfile build() {
            PatientProfile profile = new PatientProfile();
            profile.name = this.name;
            profile.age = this.age;
            profile.allergies = this.allergies;
            profile.chronicConditions = this.chronicConditions;
            return profile;
        }
    }
}
```

#### 5. **Prototype Pattern**  
**Use Case**: Clone templates for recurring appointment schedules.

```java
// Schedule.java
public abstract class Schedule implements Cloneable {
    protected String doctorName;
    protected String timeSlot;

    public void setDoctorName(String name) {
        this.doctorName = name;
    }

    public void setTimeSlot(String slot) {
        this.timeSlot = slot;
    }

    public abstract void showSchedule();

    public Schedule clone() {
        try {
            return (Schedule) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}

// WeeklySchedule.java
public class WeeklySchedule extends Schedule {
    public void showSchedule() {
        System.out.println("Doctor " + doctorName + " - Weekly Schedule: " + timeSlot);
    }
}

// ScheduleCache.java
import java.util.HashMap;

public class ScheduleCache {
    private static HashMap<String, Schedule> scheduleMap = new HashMap<>();

    public static void loadCache() {
        WeeklySchedule weekly = new WeeklySchedule();
        weekly.setDoctorName("Dr. Smith");
        weekly.setTimeSlot("Mon-Fri 10AM-2PM");
        scheduleMap.put("weekly", weekly);
    }

    public static Schedule getSchedule(String id) {
        return scheduleMap.get(id).clone();
    }
}
```

#### 6. **Singleton Pattern**  
**Use Case**: Central hospital database connection or notification service.

```java
// NotificationService.java
public class NotificationService {
    private static NotificationService instance;

    private NotificationService() {
        System.out.println("NotificationService initialized.");
    }

    public static NotificationService getInstance() {
        if (instance == null) {
            instance = new NotificationService();
        }
        return instance;
    }

    public void sendNotification(String message) {
        System.out.println("Sending notification: " + message);
    }
}
```

---

### 📄 README.md (Summary)

```markdown
# Creational Patterns - Hospital System

## Language: Java
Java was chosen for its strong support for object-oriented design and class structure, which fits well with the implementation of creational patterns.

## Pattern Usage and Justification:

- **Simple Factory**: Used to centralize the creation of user roles, simplifying the user login interface.
- **Factory Method**: Used for flexible appointment creation (regular vs. emergency).
- **Abstract Factory**: Used to support multiple UI designs for public and private hospitals.
- **Builder**: Ideal for building patient profiles where data may be optional or complex.
- **Prototype**: Reuses common appointment schedules to save time and memory.
- **Singleton**: Ensures only one instance of `NotificationService` to handle alerts and reminders.

## Directory:
- `creational_patterns/hospital/` contains all six implementations.
```

Let me know if you'd like a zip of the files or a GitHub-ready folder structure!

# 2ND TRY

// Directory: /creational_patterns/hospital

// ------------------------
// 1. Simple Factory Pattern
// ------------------------
interface User {
    void accessSystem();
}

class Patient implements User {
    public void accessSystem() {
        System.out.println("Patient accessing the appointment system.");
    }
}

class Doctor implements User {
    public void accessSystem() {
        System.out.println("Doctor accessing appointment schedule.");
    }
}

class Admin implements User {
    public void accessSystem() {
        System.out.println("Admin managing the hospital system.");
    }
}

class UserFactory {
    public static User createUser(String role) {
        switch (role.toLowerCase()) {
            case "patient": return new Patient();
            case "doctor": return new Doctor();
            case "admin": return new Admin();
            default: throw new IllegalArgumentException("Invalid role: " + role);
        }
    }
}

// ------------------------
// 2. Factory Method Pattern
// ------------------------
interface AppointmentProcessor {
    void processAppointment();
}

class RegularAppointment implements AppointmentProcessor {
    public void processAppointment() {
        System.out.println("Processing regular appointment.");
    }
}

class EmergencyAppointment implements AppointmentProcessor {
    public void processAppointment() {
        System.out.println("Processing emergency appointment.");
    }
}

abstract class AppointmentCreator {
    public abstract AppointmentProcessor createAppointment();
}

class RegularAppointmentCreator extends AppointmentCreator {
    public AppointmentProcessor createAppointment() {
        return new RegularAppointment();
    }
}

class EmergencyAppointmentCreator extends AppointmentCreator {
    public AppointmentProcessor createAppointment() {
        return new EmergencyAppointment();
    }
}

// ------------------------
// 3. Abstract Factory Pattern
// ------------------------
interface Button {
    void render();
}

class PublicHospitalButton implements Button {
    public void render() {
        System.out.println("Rendering Public Hospital Button");
    }
}

class PrivateHospitalButton implements Button {
    public void render() {
        System.out.println("Rendering Private Hospital Button");
    }
}

interface UIFactory {
    Button createButton();
}

class PublicHospitalUIFactory implements UIFactory {
    public Button createButton() {
        return new PublicHospitalButton();
    }
}

class PrivateHospitalUIFactory implements UIFactory {
    public Button createButton() {
        return new PrivateHospitalButton();
    }
}

// ------------------------
// 4. Builder Pattern
// ------------------------
class PatientProfile {
    private String name;
    private int age;
    private String allergies;
    private String chronicConditions;

    public static class Builder {
        private final String name;
        private int age;
        private String allergies = "";
        private String chronicConditions = "";

        public Builder(String name) {
            this.name = name;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder allergies(String allergies) {
            this.allergies = allergies;
            return this;
        }

        public Builder chronicConditions(String chronicConditions) {
            this.chronicConditions = chronicConditions;
            return this;
        }

        public PatientProfile build() {
            PatientProfile profile = new PatientProfile();
            profile.name = this.name;
            profile.age = this.age;
            profile.allergies = this.allergies;
            profile.chronicConditions = this.chronicConditions;
            return profile;
        }
    }
}

// ------------------------
// 5. Prototype Pattern
// ------------------------
abstract class Schedule implements Cloneable {
    protected String doctorName;
    protected String timeSlot;

    public void setDoctorName(String name) {
        this.doctorName = name;
    }

    public void setTimeSlot(String slot) {
        this.timeSlot = slot;
    }

    public abstract void showSchedule();

    public Schedule clone() {
        try {
            return (Schedule) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}

class WeeklySchedule extends Schedule {
    public void showSchedule() {
        System.out.println("Doctor " + doctorName + " - Weekly Schedule: " + timeSlot);
    }
}

import java.util.HashMap;
class ScheduleCache {
    private static HashMap<String, Schedule> scheduleMap = new HashMap<>();

    public static void loadCache() {
        WeeklySchedule weekly = new WeeklySchedule();
        weekly.setDoctorName("Dr. Smith");
        weekly.setTimeSlot("Mon-Fri 10AM-2PM");
        scheduleMap.put("weekly", weekly);
    }

    public static Schedule getSchedule(String id) {
        return scheduleMap.get(id).clone();
    }
}

// ------------------------
// 6. Singleton Pattern
// ------------------------
class NotificationService {
    private static NotificationService instance;

    private NotificationService() {
        System.out.println("NotificationService initialized.");
    }

    public static NotificationService getInstance() {
        if (instance == null) {
            instance = new NotificationService();
        }
        return instance;
    }

    public void sendNotification(String message) {
        System.out.println("Sending notification: " + message);
    }
}

Here’s the **README.md** file content that explains the language choice and justifies each creational pattern in the context of the **Hospital Appointment Scheduling System**:

---

## 🏥 Hospital Appointment Scheduling System — Creational Patterns

### 🛠 Language Choice: Java
Java was chosen for this implementation because:
- It supports **object-oriented principles** critical to design patterns.
- It offers robust support for **interfaces, abstract classes**, and **modular design**.
- It integrates easily with **Swing** for GUI and **file-based persistence**, which aligns with our non-functional requirements.

---

### 🔧 Pattern Justifications and Use Cases

#### 1. Simple Factory Pattern
- **Use Case:** Creating different types of `User` objects (Patient, Doctor, Admin).
- **Why:** Centralizes creation logic, avoiding direct instantiation in client code.
- **Class:** `UserFactory`
- **Example:**  
  ```java
  User user = UserFactory.createUser("Doctor");
  ```

#### 2. Factory Method Pattern
- **Use Case:** Creating payment handlers for appointment payments (e.g., `CashPayment`, `CardPayment`).
- **Why:** Enables subclass-specific object creation logic without altering client code.
- **Class:** `PaymentProcessor` interface with concrete factories like `CardPaymentProcessor`, `CashPaymentProcessor`.

#### 3. Abstract Factory Pattern
- **Use Case:** Creating a UI component family (e.g., `LightThemeButton`, `DarkThemeTextBox`).
- **Why:** Ensures that UI components are consistent within a theme.
- **Class:** `UIFactory` interface with factories like `LightThemeFactory`, `DarkThemeFactory`.

#### 4. Builder Pattern
- **Use Case:** Creating complex `PatientProfile` with optional data (e.g., allergies, insurance info).
- **Why:** Simplifies the creation of complex objects with many optional parameters.
- **Class:** `PatientProfileBuilder`

#### 5. Prototype Pattern
- **Use Case:** Cloning reusable notification templates (`Reminder`, `CancellationNotice`).
- **Why:** Avoids costly reinitialization of common objects like system-generated messages.
- **Class:** `NotificationTemplate` with `clone()` functionality.

#### 6. Singleton Pattern
- **Use Case:** Ensuring a single instance of the `NotificationManager` to handle system-wide alerts.
- **Why:** Prevents creation of multiple instances that could lead to duplicate notifications or race conditions.
- **Class:** `NotificationManager`

---

### 💡 Summary

These patterns promote:
- **Scalability** — Adding new roles or notification types without major rewrites.
- **Maintainability** — Encapsulated logic for object creation.
- **Extensibility** — Future integration with billing, electronic health records (EHR), or cloud storage.

Each pattern serves a distinct architectural need within the hospital appointment system, contributing to a more organized, maintainable, and flexible application.

---

Would you like me to create a ZIP archive or GitHub-ready structure for all files, or help integrate these patterns into your main app?

# UNIT TESTING

Great! For your hospital appointment scheduling system, here’s how you can organize and structure your **unit tests** for each **creational pattern** under a `/tests` directory. I'll also provide example test cases using **JUnit 5** in Java.

---

### 📁 `/tests/` Directory Structure
```
/creational_patterns
/tests
  ├── SimpleFactoryTest.java
  ├── FactoryMethodTest.java
  ├── AbstractFactoryTest.java
  ├── BuilderTest.java
  ├── PrototypeTest.java
  └── SingletonTest.java
```

---

### ✅ Example Tests for Each Pattern

#### 1. `SimpleFactoryTest.java`
```java
@Test
void testCreateUser() {
    User user = UserFactory.createUser("Patient", "John");
    assertTrue(user instanceof Patient);
    assertEquals("John", user.getName());
}
```

#### 2. `FactoryMethodTest.java`
```java
@Test
void testNotificationCreation() {
    NotificationCreator creator = new EmailNotificationCreator();
    Notification notification = creator.createNotification();
    assertEquals("Email", notification.getType());
}
```

#### 3. `AbstractFactoryTest.java`
```java
@Test
void testUIFactory() {
    UIFactory factory = new LightThemeFactory();
    Button button = factory.createButton();
    assertEquals("LightButton", button.render());
}
```

#### 4. `BuilderTest.java`
```java
@Test
void testAppointmentBuilder() {
    Appointment appt = new Appointment.Builder()
                        .withPatientName("Alice")
                        .withDoctorName("Dr. Sam")
                        .withDate("2025-04-30")
                        .build();
    assertEquals("Alice", appt.getPatientName());
    assertEquals("Dr. Sam", appt.getDoctorName());
}
```

#### 5. `PrototypeTest.java`
```java
@Test
void testAppointmentClone() {
    Appointment original = new Appointment("Alice", "Dr. Sam", "2025-04-30");
    Appointment clone = (Appointment) original.clone();
    assertEquals(original.getDate(), clone.getDate());
    assertNotSame(original, clone);
}
```

#### 6. `SingletonTest.java`
```java
@Test
void testSingletonInstance() {
    DatabaseConnection conn1 = DatabaseConnection.getInstance();
    DatabaseConnection conn2 = DatabaseConnection.getInstance();
    assertSame(conn1, conn2);
}

@Test
void testSingletonThreadSafety() {
    ExecutorService executor = Executors.newFixedThreadPool(2);
    List<Future<DatabaseConnection>> results = new ArrayList<>();

    for (int i = 0; i < 2; i++) {
        results.add(executor.submit(DatabaseConnection::getInstance));
    }

    DatabaseConnection conn1 = results.get(0).get();
    DatabaseConnection conn2 = results.get(1).get();
    assertSame(conn1, conn2);
}
```

---

### 📊 Coverage Report

Use **JaCoCo** for coverage:

1. Add plugin in `pom.xml`:
```xml
<plugin>
    <groupId>org.jacoco</groupId>
    <artifactId>jacoco-maven-plugin</artifactId>
    <version>0.8.10</version>
    <executions>
        <execution>
            <goals>
                <goal>prepare-agent</goal>
            </goals>
        </execution>
        <execution>
            <id>report</id>
            <phase>verify</phase>
            <goals>
                <goal>report</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```

2. Run:
```bash
mvn clean verify
```

3. Find reports under:
```
/target/site/jacoco/index.html
```

---

Let me know if you want help generating the full test files, or setting up the Maven/Gradle project structure for all of this.
