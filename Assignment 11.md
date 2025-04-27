# TASK 1 
Got it! Let's do this **step-by-step** based on your **Hospital Appointment Scheduling System**.

---

### 📂 `/repositories/Repository.java`
```java
package repositories;

import java.util.List;
import java.util.Optional;

/**
 * A generic Repository interface for basic CRUD operations.
 * 
 * @param <T> Entity type
 * @param <ID> ID type
 */
public interface Repository<T, ID> {
    void save(T entity);              // Create/Update
    Optional<T> findById(ID id);       // Read (Single)
    List<T> findAll();                 // Read (All)
    void delete(ID id);                // Delete
}
```

---

### 📂 `/repositories/AppointmentRepository.java`
```java
package repositories;

import hospitalappointmentsystem.Appointment;

/**
 * Specific repository interface for Appointment entities.
 */
public interface AppointmentRepository extends Repository<Appointment, String> {
    // No extra methods needed for now
}
```

---

✅ **Deliverables you now have:**
- `/repositories/Repository.java` (generic)
- `/repositories/AppointmentRepository.java` (specific to Appointment)

---

### 📄 README Justification (sample you can use)

> ## Justification
> We created a **generic `Repository<T, ID>` interface** to define standard CRUD operations like **save**, **findById**, **findAll**, and **delete**.
> 
> By using **Java Generics**, we **avoided duplication** across entity repositories.  
> This approach makes it easy to create specific repositories (like `AppointmentRepository`) without rewriting basic CRUD logic for every entity (e.g., if later we add `DoctorRepository`, `PatientRepository`, etc.).
> 
> **Advantages:**
> - Less repetitive code.
> - Consistent structure for all repositories.
> - Easier maintenance and testing.

---

# TASK 2

Perfect — let's continue with the **In-Memory Implementation** for your **Hospital Appointment System** using **Java** (with a `HashMap` just like your Python example).

Here’s everything you need ✅:

---

### 📂 `/repositories/inmemory/InMemoryAppointmentRepository.java`
```java
package repositories.inmemory;

import hospitalappointmentsystem.Appointment;
import repositories.AppointmentRepository;

import java.util.*;

/**
 * In-memory implementation of AppointmentRepository.
 */
public class InMemoryAppointmentRepository implements AppointmentRepository {
    private final Map<String, Appointment> storage = new HashMap<>();

    @Override
    public void save(Appointment appointment) {
        String key = generateKey(appointment);
        storage.put(key, appointment);
    }

    @Override
    public Optional<Appointment> findById(String id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Appointment> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void delete(String id) {
        storage.remove(id);
    }

    private String generateKey(Appointment appointment) {
        // Unique key based on doctor, date, and time
        return appointment.doctorName + "_" + appointment.date + "_" + appointment.time;
    }
}
```

---
### 📄 Note:  
We use `doctorName_date_time` as the **unique key** since in your system, a doctor cannot have two appointments at the same time.

---

### 📂 `/repositories/inmemory/InMemoryAppointmentRepositoryTest.java`
(✅ Simple test cases to verify CRUD operations)

```java
package repositories.inmemory;

import hospitalappointmentsystem.Appointment;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryAppointmentRepositoryTest {

    @Test
    void testCRUDOperations() {
        InMemoryAppointmentRepository repo = new InMemoryAppointmentRepository();

        // Create and Save
        Appointment appointment = new Appointment("John Doe", "Dr. Smith", "2025-05-01", "10:00", "Check-up");
        repo.save(appointment);

        // Read - findById
        String id = "Dr. Smith_2025-05-01_10:00";
        Optional<Appointment> found = repo.findById(id);
        assertTrue(found.isPresent());
        assertEquals("John Doe", found.get().patientName);

        // Read - findAll
        List<Appointment> all = repo.findAll();
        assertEquals(1, all.size());

        // Delete
        repo.delete(id);
        Optional<Appointment> afterDelete = repo.findById(id);
        assertFalse(afterDelete.isPresent());
    }
}
```

---
✅ Now you have:
- `/repositories/inmemory/InMemoryAppointmentRepository.java`
- `/repositories/inmemory/InMemoryAppointmentRepositoryTest.java`

---

### 📄 README Justification (for this part)

> ## In-Memory Repository Justification
> We implemented an **In-Memory Appointment Repository** using a `HashMap<String, Appointment>`.
> 
> - The **key** is generated from the doctor name, date, and time to ensure appointment uniqueness.
> - **HashMap** provides **fast O(1) CRUD operations** (save, find, delete).
> 
> We also created **JUnit 5** test cases to verify that CRUD methods work correctly.

---

✅ This **completes** your "In-Memory Implementation" task.

---

# TASK 3

Alright, let’s smash through this task too! 🚀  
We’ll use the **Factory Pattern** for your **Hospital Appointment System**.

---

Here’s everything you need:

---

### 📂 `/factories/RepositoryFactory.java`
```java
package factories;

import repositories.AppointmentRepository;
import repositories.inmemory.InMemoryAppointmentRepository;

public class RepositoryFactory {

    public static AppointmentRepository getAppointmentRepository(String storageType) {
        switch (storageType.toUpperCase()) {
            case "MEMORY":
                return new InMemoryAppointmentRepository();
            // case "DATABASE":
            //     return new DatabaseAppointmentRepository(); // Future implementation
            default:
                throw new IllegalArgumentException("Invalid storage type: " + storageType);
        }
    }
}
```
✅ **Explanation:**  
- You call `RepositoryFactory.getAppointmentRepository("MEMORY")`
- It gives you the **InMemoryAppointmentRepository**.
- In future, if you add a database, you can simply add a `"DATABASE"` case!

---

### 📄 README Update (for this part)

> ## Storage Abstraction Justification
> We used the **Factory Pattern** to decouple our service layer from specific storage implementations.
>
> - **Why Factory?**  
>   Factories allow easy swapping between different storage backends (e.g., Memory, Database) without changing service logic.
>
> - **Current Setup:**  
>   `RepositoryFactory` returns an `InMemoryAppointmentRepository`.
>   
> - **Future-proof:**  
>   When we add database support, we can extend `RepositoryFactory` with a `"DATABASE"` case without touching the rest of the system.

---

### 📌 How you now use it in your **HospitalAppointmentSystem** class:

Instead of:
```java
private static AppointmentRepository appointmentRepository = new InMemoryAppointmentRepository();
```
You write:
```java
private static AppointmentRepository appointmentRepository = RepositoryFactory.getAppointmentRepository("MEMORY");
```
✅ Cleaner, more scalable, more professional.

---

**Summary:**
- `/factories/RepositoryFactory.java` created ✅
- README updated with justification ✅
- Your code is now fully **decoupled** and **future-proof** ✅

---

# TASK 4

Perfect — you’re almost at the finish line! 🏁  
Let’s tackle **Future-Proofing** carefully and neatly.

---

## 📂 `/repositories/database/DatabaseAppointmentRepository.java` (Stub)

```java
package repositories.database;

import models.Appointment;
import repositories.AppointmentRepository;

import java.util.List;
import java.util.Optional;

public class DatabaseAppointmentRepository implements AppointmentRepository {

    @Override
    public void save(Appointment entity) {
        // TODO: Implement saving to database (e.g., SQL INSERT)
        throw new UnsupportedOperationException("Database storage not yet implemented.");
    }

    @Override
    public Optional<Appointment> findById(String id) {
        // TODO: Implement finding by ID from database (e.g., SQL SELECT)
        throw new UnsupportedOperationException("Database storage not yet implemented.");
    }

    @Override
    public List<Appointment> findAll() {
        // TODO: Implement fetching all appointments from database
        throw new UnsupportedOperationException("Database storage not yet implemented.");
    }

    @Override
    public void delete(String id) {
        // TODO: Implement deleting from database
        throw new UnsupportedOperationException("Database storage not yet implemented.");
    }
}
```
✅ **Stub is ready:**  
- All methods throw `UnsupportedOperationException`.
- You can fill them in later when you actually connect to a real database!

---

## 📄 Updated Class Diagram (Simple Text)

```
Repository<T, ID> (interface)
 ├── AppointmentRepository (extends Repository<Appointment, String>)
      ├── InMemoryAppointmentRepository (implements AppointmentRepository)
      ├── DatabaseAppointmentRepository (implements AppointmentRepository)
```

> **Bonus tip**: In a real diagram tool, you can show this with arrows:  
> - Dotted arrow from `AppointmentRepository` to `Repository`
> - Solid arrows from `InMemoryAppointmentRepository` and `DatabaseAppointmentRepository` to `AppointmentRepository`

---

## 📌 Final README Update

> ## Future-Proofing Strategy
> We created a **DatabaseAppointmentRepository** stub to prepare for future storage options.
> Using the **Repository Interface** and **Factory Pattern**, the system can easily swap between:
> - In-memory storage (for development and testing)
> - Database storage (for production)
> - Other storage like File System or Cloud Storage.
>
> This design ensures **scalability**, **flexibility**, and **minimal code changes** when upgrading the backend.

---

✅ **Deliverables you now have:**
- `/repositories/database/DatabaseAppointmentRepository.java` stub ✔️
- Updated simple **class diagram** ✔️
- README updated for **future-proofing** ✔️

---

