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
