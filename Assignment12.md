# TASK 1

Here’s how you can implement a **Service Layer** in your Java-based **Hospital Appointment Scheduling System**, using repositories for persistence and including business logic. This includes:

### ✅ Sample Service: `AppointmentService`

**Use case example:** A patient can’t book more than 3 active appointments at a time.

---

### 📁 Directory Structure
```
/services
  └── AppointmentService.java
/tests
  └── AppointmentServiceTest.java
```

---

### 🧠 AppointmentService.java

```java
package services;

import entities.Appointment;
import entities.Patient;
import repositories.AppointmentRepository;
import repositories.PatientRepository;

import java.util.List;

public class AppointmentService {
    private final AppointmentRepository appointmentRepo;
    private final PatientRepository patientRepo;

    public AppointmentService(AppointmentRepository appointmentRepo, PatientRepository patientRepo) {
        this.appointmentRepo = appointmentRepo;
        this.patientRepo = patientRepo;
    }

    public Appointment bookAppointment(String patientId, Appointment appointment) {
        Patient patient = patientRepo.findById(patientId)
            .orElseThrow(() -> new IllegalArgumentException("Patient not found"));

        List<Appointment> existing = appointmentRepo.findByPatientId(patientId);
        long activeCount = existing.stream()
            .filter(a -> !a.getStatus().equals("Completed"))
            .count();

        if (activeCount >= 3) {
            throw new IllegalStateException("Patient has reached the appointment limit.");
        }

        appointment.setPatientId(patientId);
        appointment.setStatus("Scheduled");

        appointmentRepo.save(appointment);
        return appointment;
    }
}
```

---

### ✅ Sample Unit Test: `AppointmentServiceTest.java`

```java
package tests;

import services.AppointmentService;
import repositories.inmemory.InMemoryAppointmentRepository;
import repositories.inmemory.InMemoryPatientRepository;
import entities.Appointment;
import entities.Patient;

import java.util.UUID;

public class AppointmentServiceTest {
    public static void main(String[] args) {
        var patientRepo = new InMemoryPatientRepository();
        var appointmentRepo = new InMemoryAppointmentRepository();
        var service = new AppointmentService(appointmentRepo, patientRepo);

        String patientId = UUID.randomUUID().toString();
        patientRepo.save(new Patient(patientId, "Alice"));

        // Book 3 appointments
        for (int i = 0; i < 3; i++) {
            service.bookAppointment(patientId, new Appointment(UUID.randomUUID().toString(), "Doctor A", "Pending"));
        }

        // 4th booking should throw error
        try {
            service.bookAppointment(patientId, new Appointment(UUID.randomUUID().toString(), "Doctor A", "Pending"));
            System.out.println("Test failed: Limit not enforced");
        } catch (IllegalStateException e) {
            System.out.println("Test passed: " + e.getMessage());
        }
    }
}
```

---

### 📝 README Justification

> **Used a service layer** to centralize business logic, enforce patient appointment limits, and separate data access via repositories. This improves testability and maintains clean architecture by avoiding logic duplication across UI or controller layers.

Would you like me to generate the full interfaces and entity classes used in this example?

Yes, I can help you create additional service classes for your hospital appointment scheduling system. Here are some key service classes you might need, each corresponding to core domain entities:

---

### ✅ **1. PatientService**
Handles operations related to patients.

```java
public class PatientService {
    private final PatientRepository patientRepo;

    public PatientService(PatientRepository patientRepo) {
        this.patientRepo = patientRepo;
    }

    public void registerPatient(Patient patient) {
        // Add validation logic
        patientRepo.save(patient);
    }

    public Optional<Patient> findPatientById(String id) {
        return patientRepo.findById(id);
    }

    public List<Patient> getAllPatients() {
        return patientRepo.findAll();
    }

    public void deletePatient(String id) {
        patientRepo.delete(id);
    }
}
```

---

### ✅ **2. DoctorService**
Handles logic for doctor availability and profiles.

```java
public class DoctorService {
    private final DoctorRepository doctorRepo;

    public DoctorService(DoctorRepository doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    public void addDoctor(Doctor doctor) {
        doctorRepo.save(doctor);
    }

    public Optional<Doctor> findDoctorById(String id) {
        return doctorRepo.findById(id);
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepo.findAll();
    }

    public void deleteDoctor(String id) {
        doctorRepo.delete(id);
    }
}
```

---

### ✅ **3. AppointmentService**
Implements business rules like checking doctor availability.

```java
public class AppointmentService {
    private final AppointmentRepository appointmentRepo;
    private final DoctorRepository doctorRepo;

    public AppointmentService(AppointmentRepository appointmentRepo, DoctorRepository doctorRepo) {
        this.appointmentRepo = appointmentRepo;
        this.doctorRepo = doctorRepo;
    }

    public void bookAppointment(Appointment appointment) {
        Doctor doctor = doctorRepo.findById(appointment.getDoctorId())
            .orElseThrow(() -> new IllegalArgumentException("Doctor not found"));

        if (!doctor.isAvailable(appointment.getTimeSlot())) {
            throw new IllegalStateException("Doctor is not available at this time");
        }

        appointmentRepo.save(appointment);
    }

    public List<Appointment> getAppointmentsForPatient(String patientId) {
        return appointmentRepo.findByPatientId(patientId);
    }

    public void cancelAppointment(String appointmentId) {
        appointmentRepo.delete(appointmentId);
    }
}
```

---

Would you like me to generate the actual `.java` files or add test cases for these service classes?

// /test/services/PatientServiceTest.java
package services;

import models.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repositories.PatientRepository;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class PatientServiceTest {

    private PatientRepository patientRepository;
    private PatientService patientService;

    @BeforeEach
    void setup() {
        patientRepository = mock(PatientRepository.class);
        patientService = new PatientService(patientRepository);
    }

    @Test
    void shouldRegisterNewPatient() {
        Patient patient = new Patient("p1", "Alice", 30);
        patientService.registerPatient(patient);
        verify(patientRepository).save(patient);
    }

    @Test
    void shouldRetrievePatientById() {
        Patient patient = new Patient("p1", "Alice", 30);
        when(patientRepository.findById("p1")).thenReturn(Optional.of(patient));
        Optional<Patient> result = patientService.getPatient("p1");
        assertTrue(result.isPresent());
        assertEquals("Alice", result.get().getName());
    }
}

// /test/services/DoctorServiceTest.java
package services;

import models.Doctor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repositories.DoctorRepository;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class DoctorServiceTest {

    private DoctorRepository doctorRepository;
    private DoctorService doctorService;

    @BeforeEach
    void setup() {
        doctorRepository = mock(DoctorRepository.class);
        doctorService = new DoctorService(doctorRepository);
    }

    @Test
    void shouldRegisterNewDoctor() {
        Doctor doctor = new Doctor("d1", "Dr. Smith", "Cardiology");
        doctorService.registerDoctor(doctor);
        verify(doctorRepository).save(doctor);
    }

    @Test
    void shouldRetrieveDoctorById() {
        Doctor doctor = new Doctor("d1", "Dr. Smith", "Cardiology");
        when(doctorRepository.findById("d1")).thenReturn(Optional.of(doctor));
        Optional<Doctor> result = doctorService.getDoctor("d1");
        assertTrue(result.isPresent());
        assertEquals("Dr. Smith", result.get().getName());
    }
}

// /test/services/AppointmentServiceTest.java
package services;

import models.Appointment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repositories.AppointmentRepository;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class AppointmentServiceTest {

    private AppointmentRepository appointmentRepository;
    private AppointmentService appointmentService;

    @BeforeEach
    void setup() {
        appointmentRepository = mock(AppointmentRepository.class);
        appointmentService = new AppointmentService(appointmentRepository);
    }

    @Test
    void shouldBookAppointment() {
        Appointment appointment = new Appointment("a1", "p1", "d1", LocalDateTime.now());
        appointmentService.bookAppointment(appointment);
        verify(appointmentRepository).save(appointment);
    }

    @Test
    void shouldGetAppointmentById() {
        Appointment appointment = new Appointment("a1", "p1", "d1", LocalDateTime.now());
        when(appointmentRepository.findById("a1")).thenReturn(Optional.of(appointment));
        Optional<Appointment> result = appointmentService.getAppointment("a1");
        assertTrue(result.isPresent());
        assertEquals("p1", result.get().getPatientId());
    }
}


Here are the additional service and unit test files for `PatientService`, `DoctorService`, and `UserService`, using the in-memory repository for testing.

### **PatientService.java** (in `/services` directory)
```java
package com.hospital.services;

import com.hospital.models.Patient;
import com.hospital.repositories.PatientRepository;
import java.util.Optional;

public class PatientService {
    private final PatientRepository patientRepo;

    public PatientService(PatientRepository patientRepo) {
        this.patientRepo = patientRepo;
    }

    public Patient addPatient(Patient patient) {
        // Business logic for adding a new patient (e.g., validate age)
        if (patient.getAge() < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        return patientRepo.save(patient);
    }

    public Patient getPatientById(String patientId) {
        return patientRepo.findById(patientId)
            .orElseThrow(() -> new RuntimeException("Patient not found"));
    }

    public void removePatient(String patientId) {
        Patient patient = patientRepo.findById(patientId)
            .orElseThrow(() -> new RuntimeException("Patient not found"));
        patientRepo.delete(patientId);
    }
}
```

### **DoctorService.java** (in `/services` directory)
```java
package com.hospital.services;

import com.hospital.models.Doctor;
import com.hospital.repositories.DoctorRepository;
import java.util.List;

public class DoctorService {
    private final DoctorRepository doctorRepo;

    public DoctorService(DoctorRepository doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    public Doctor addDoctor(Doctor doctor) {
        // Business logic to add a new doctor (e.g., check if the doctor already exists)
        List<Doctor> doctors = doctorRepo.findAll();
        if (doctors.stream().anyMatch(d -> d.getLicenseNumber().equals(doctor.getLicenseNumber()))) {
            throw new IllegalArgumentException("Doctor with this license number already exists");
        }
        return doctorRepo.save(doctor);
    }

    public Doctor getDoctorById(String doctorId) {
        return doctorRepo.findById(doctorId)
            .orElseThrow(() -> new RuntimeException("Doctor not found"));
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepo.findAll();
    }
}
```

### **UserService.java** (in `/services` directory)
```java
package com.hospital.services;

import com.hospital.models.User;
import com.hospital.repositories.UserRepository;
import java.util.Optional;

public class UserService {
    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public User createUser(User user) {
        // Business logic for user creation
        if (userRepo.findById(user.getId()).isPresent()) {
            throw new IllegalArgumentException("User with this ID already exists");
        }
        return userRepo.save(user);
    }

    public User getUserById(String userId) {
        return userRepo.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUser(String userId) {
        userRepo.delete(userId);
    }
}
```

### **PatientServiceTest.java** (Unit Test for `PatientService`)
```java
package com.hospital.services;

import com.hospital.models.Patient;
import com.hospital.repositories.inmemory.InMemoryPatientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatientServiceTest {
    private PatientService patientService;
    private InMemoryPatientRepository patientRepo;

    @BeforeEach
    void setUp() {
        patientRepo = new InMemoryPatientRepository();
        patientService = new PatientService(patientRepo);
    }

    @Test
    void testAddPatient() {
        Patient patient = new Patient("1", "John Doe", 30);
        Patient savedPatient = patientService.addPatient(patient);

        assertEquals(patient, savedPatient);
    }

    @Test
    void testAddPatientWithNegativeAge() {
        Patient patient = new Patient("2", "Jane Doe", -5);
        
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            patientService.addPatient(patient);
        });
        assertEquals("Age cannot be negative", thrown.getMessage());
    }

    @Test
    void testGetPatientById() {
        Patient patient = new Patient("3", "John Smith", 25);
        patientService.addPatient(patient);

        Patient fetchedPatient = patientService.getPatientById("3");
        assertEquals(patient, fetchedPatient);
    }

    @Test
    void testRemovePatient() {
        Patient patient = new Patient("4", "Lisa White", 28);
        patientService.addPatient(patient);

        patientService.removePatient("4");
        assertThrows(RuntimeException.class, () -> patientService.getPatientById("4"));
    }
}
```

### **DoctorServiceTest.java** (Unit Test for `DoctorService`)
```java
package com.hospital.services;

import com.hospital.models.Doctor;
import com.hospital.repositories.inmemory.InMemoryDoctorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoctorServiceTest {
    private DoctorService doctorService;
    private InMemoryDoctorRepository doctorRepo;

    @BeforeEach
    void setUp() {
        doctorRepo = new InMemoryDoctorRepository();
        doctorService = new DoctorService(doctorRepo);
    }

    @Test
    void testAddDoctor() {
        Doctor doctor = new Doctor("1", "Dr. Smith", "ABC123");
        Doctor savedDoctor = doctorService.addDoctor(doctor);

        assertEquals(doctor, savedDoctor);
    }

    @Test
    void testAddDoctorWithDuplicateLicense() {
        Doctor doctor1 = new Doctor("1", "Dr. Smith", "ABC123");
        Doctor doctor2 = new Doctor("2", "Dr. Lee", "ABC123");
        doctorService.addDoctor(doctor1);

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            doctorService.addDoctor(doctor2);
        });
        assertEquals("Doctor with this license number already exists", thrown.getMessage());
    }

    @Test
    void testGetDoctorById() {
        Doctor doctor = new Doctor("3", "Dr. Jones", "XYZ789");
        doctorService.addDoctor(doctor);

        Doctor fetchedDoctor = doctorService.getDoctorById("3");
        assertEquals(doctor, fetchedDoctor);
    }
}
```

### **UserServiceTest.java** (Unit Test for `UserService`)
```java
package com.hospital.services;

import com.hospital.models.User;
import com.hospital.repositories.inmemory.InMemoryUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    private UserService userService;
    private InMemoryUserRepository userRepo;

    @BeforeEach
    void setUp() {
        userRepo = new InMemoryUserRepository();
        userService = new UserService(userRepo);
    }

    @Test
    void testCreateUser() {
        User user = new User("1", "John Doe", "patient");
        User savedUser = userService.createUser(user);

        assertEquals(user, savedUser);
    }

    @Test
    void testCreateUserWithExistingId() {
        User user1 = new User("1", "John Doe", "patient");
        userService.createUser(user1);

        User user2 = new User("1", "Jane Doe", "doctor");
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            userService.createUser(user2);
        });
        assertEquals("User with this ID already exists", thrown.getMessage());
    }

    @Test
    void testGetUserById() {
        User user = new User("2", "Alice Brown", "doctor");
        userService.createUser(user);

        User fetchedUser = userService.getUserById("2");
        assertEquals(user, fetchedUser);
    }

    @Test
    void testDeleteUser() {
        User user = new User("3", "Bob Green", "admin");
        userService.createUser(user);

        userService.deleteUser("3");
        assertThrows(RuntimeException.class, () -> userService.getUserById("3"));
    }
}
```

### Summary:
- I have created service classes for `PatientService`, `DoctorService`, and `UserService`.
- The business logic ensures rules are followed (e.g., age validation, duplicate doctor license numbers).
- Each service has corresponding unit tests using in-memory repositories to verify CRUD operations and business rules.

Would you like me to create additional services or provide more tests for specific cases?


# TASK 2

To implement RESTful endpoints for your hospital appointment scheduling system using Java and Spring Boot, here's a step-by-step breakdown and sample code for core components:

---

### ✅ **1. Setup: `/api` Directory with Spring Boot**

Structure your project like:

```
/api
  └── controller
       └── AppointmentController.java
/services
/repositories
/entities
```

---

### ✅ **2. Example Entity: Appointment**

```java
// /entities/Appointment.java
public class Appointment {
    private String id;
    private String doctorId;
    private String patientId;
    private LocalDateTime dateTime;
    private boolean confirmed;

    // Getters, setters, constructors
}
```

---

### ✅ **3. REST Controller Example**

```java
// /api/controller/AppointmentController.java
@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.findAll();
    }

    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentService.save(appointment);
    }

    @PutMapping("/{id}")
    public Appointment updateAppointment(@PathVariable String id, @RequestBody Appointment updated) {
        return appointmentService.update(id, updated);
    }

    @PostMapping("/{id}/confirm")
    public ResponseEntity<String> confirmAppointment(@PathVariable String id) {
        appointmentService.confirm(id);
        return ResponseEntity.ok("Appointment confirmed");
    }
}
```

---

### ✅ **4. Integration Testing (Example with Spring Boot Test)**

```java
@SpringBootTest
@AutoConfigureMockMvc
public class AppointmentApiTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAppointments() throws Exception {
        mockMvc.perform(get("/api/appointments"))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateAppointment() throws Exception {
        String json = "{ \"doctorId\": \"D1\", \"patientId\": \"P1\", \"dateTime\": \"2025-06-01T10:00\" }";
        mockMvc.perform(post("/api/appointments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk());
    }
}
```

---

### 📄 **README Notes Example**

```markdown
### API Layer

- Built with Spring Boot.
- Endpoints allow full CRUD and business action (e.g., confirming appointment).
- Integrated with service and repository layers using dependency injection.
```

---

Would you like help generating the full code for `AppointmentService`, `AppointmentRepository`, or a Postman collection for testing?

# TASK 3

To complete the **API Documentation (10 Marks)** task for your **Hospital Appointment Scheduling System**, here’s what you need to do using **Spring Boot** and **Swagger/OpenAPI**:

---

### ✅ Step 1: **Add Swagger Dependencies**

In your `pom.xml` (for Maven projects):

```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.5.0</version> <!-- Use latest -->
</dependency>
```

---

### ✅ Step 2: **Annotate Your API Controller**

Example: `/api/controller/AppointmentController.java`

```java
@RestController
@RequestMapping("/api/appointments")
@Tag(name = "Appointments", description = "Manage hospital appointments")
public class AppointmentController {

    @Operation(summary = "Get all appointments", description = "Returns a list of all scheduled appointments")
    @ApiResponse(responseCode = "200", description = "List of appointments")
    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.findAll();
    }

    @Operation(summary = "Create a new appointment")
    @ApiResponse(responseCode = "201", description = "Appointment created successfully")
    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentService.save(appointment);
    }

    @Operation(summary = "Confirm an appointment")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Appointment confirmed"),
        @ApiResponse(responseCode = "404", description = "Appointment not found")
    })
    @PostMapping("/{id}/confirm")
    public ResponseEntity<String> confirmAppointment(@PathVariable String id) {
        appointmentService.confirm(id);
        return ResponseEntity.ok("Appointment confirmed");
    }
}
```

---

### ✅ Step 3: **Access the Swagger UI**

- Run your Spring Boot app
- Visit: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

Take a **screenshot of this page** to include as a deliverable.

---

### ✅ Step 4: **OpenAPI YAML/JSON Export (Optional)**

You can export the OpenAPI definition manually:

- Visit: [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs) for JSON
- Save it in a `/docs` directory as `openapi.json` or convert to YAML

---

### 📁 Deliverables Summary

| File/Asset | Description |
|------------|-------------|
| `/docs/openapi.json` or `/docs/openapi.yaml` | Exported OpenAPI schema |
| `Screenshot` | Swagger UI showing API structure |
| `Annotated Controller` | With `@Operation` and `@ApiResponse` annotations |

Would you like me to generate a sample OpenAPI YAML file for your current API structure?
