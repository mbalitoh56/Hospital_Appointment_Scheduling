
# **Service Layer Implementation**

### **Why Service Classes Were Created**

Service classes like `AppointmentService`, `PatientService`, and `DoctorService` separate **business logic** from **persistence logic** (repositories) and **presentation logic** (API controllers).
This promotes **Separation of Concerns (SoC)** — making the system modular, testable, and maintainable.

### **Why Repositories Are Injected**

Repositories are passed into service classes through constructor injection:

```java
public AppointmentService(AppointmentRepository repo) {
    this.repo = repo;
}
```

This allows services to remain **decoupled** from the actual storage implementation (in-memory, file-based, database), making unit testing easier.

### **Why Business Rules Are Handled in Services**

Example: Preventing double-booking, checking doctor availability, or validating appointment times are core rules enforced in the service layer.

**Justification:**
Keeping this logic centralized avoids duplicating rules in multiple controllers or repositories and ensures consistency across the system.

---

# **REST API Development**

### **Why RESTful Endpoints Were Used**

Endpoints like `/api/patients`, `/api/doctors`, and `/api/appointments` follow REST principles and standard HTTP methods (GET, POST, PUT, DELETE).

**Justification:**

* Aligns with modern web API design.
* Enables frontend apps or external systems to interact easily with the backend.
* Standard HTTP status codes improve client-side error handling.

### **Why Spring Boot Was Used**

Spring Boot simplifies dependency management, routing, and server startup, making it ideal for building robust, scalable REST APIs.

**Justification:**
It reduces boilerplate and includes built-in support for Swagger/OpenAPI, validation, and exception handling.

### **Why We Used Separate Controller Classes**

Each controller (e.g., `AppointmentController`) maps to its domain entity and delegates calls to the service layer.

**Justification:**
This modular approach makes the API easier to maintain, test, and document.

---

# **API Documentation**

### **Why OpenAPI/Swagger Was Used**

Swagger auto-generates API docs based on Spring annotations like `@RestController`, `@GetMapping`, and `@RequestBody`.

**Justification:**

* Provides a UI at `/swagger-ui.html` for testing endpoints interactively.
* Helps developers and testers understand available endpoints, parameters, and responses without reading source code.
* Reduces onboarding time for new developers or frontend collaborators.

### **Why We Included YAML/JSON Schema Files**

Generated YAML or JSON defines the API contract and supports client SDK generation or integration testing tools like Postman.
