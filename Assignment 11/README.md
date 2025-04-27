# JUSTIFICATION

## TASK 1 

**Deliverables**
- `/repositories/Repository.java` (generic)
- `/repositories/AppointmentRepository.java` (specific to Appointment)

## Justification
I created a **generic `Repository<T, ID>` interface** to define standard CRUD operations like **save**, **findById**, **findAll**, and **delete**.

By using **Java Generics**, I **avoided duplication** across entity repositories.

This approach makes it easy to create specific repositories (like `AppointmentRepository`) without rewriting basic CRUD logic for every entity (e.g., if later we add `DoctorRepository`, `PatientRepository`, etc.).
 
**Advantages:**
- Less repetitive code.
- Consistent structure for all repositories.
- Easier maintenance and testing.

---

# TASK 2

**Deliveries**
- `/repositories/inmemory/InMemoryAppointmentRepository.java`
- `/repositories/inmemory/InMemoryAppointmentRepositoryTest.java`
---

### Justification

## In-Memory Repository Justification
I implemented an **In-Memory Appointment Repository** using a `HashMap<String, Appointment>`.

 - The **key** is generated from the doctor name, date, and time to ensure appointment uniqueness.
 - **HashMap** provides **fast O(1) CRUD operations** (save, find, delete).
 
I also created **JUnit 5** test cases to verify that CRUD methods work correctly.

### 📄 Note:  
I use `doctorName_date_time` as the **unique key** since in your system, a doctor cannot have two appointments at the same time.


---

# TASK 3


**Explanation:**  
- You call `RepositoryFactory.getAppointmentRepository("MEMORY")`
- It gives you the **InMemoryAppointmentRepository**.
- In future, if you add a database, you can simply add a `"DATABASE"` case!


### Justification

## Storage Abstraction Justification
I used the **Factory Pattern** to decouple our service layer from specific storage implementations.

- **Why Factory?**  
Factories allow easy swapping between different storage backends (e.g., Memory, Database) without changing service logic.

- **Current Setup:**  
  `RepositoryFactory` returns an `InMemoryAppointmentRepository`.
  
- **Future-proof:**  
When I add database support, we can extend `RepositoryFactory` with a `"DATABASE"` case without touching the rest of the system.



### How you now use it in the **HospitalAppointmentSystem** class:

Instead of:
```java
private static AppointmentRepository appointmentRepository = new InMemoryAppointmentRepository();
```
You write:
```java
private static AppointmentRepository appointmentRepository = RepositoryFactory.getAppointmentRepository("MEMORY");
```
---

# TASK 4


**Stub is ready:**  
- All methods throw `UnsupportedOperationException`.
- You can fill them in later when you actually connect to a real database!


## Updated Class Diagram 

**What this shows:**
- `Repository<T, ID>` is a generic interface.
- `AppointmentRepository` **extends** `Repository`.
- `InMemoryAppointmentRepository` and `DatabaseAppointmentRepository` **implement** `AppointmentRepository`.
- Very easy for someone reading it to understand the layers and how future storage types plug in.


## 📌 Final README Update

## Future-Proofing Strategy

I created a **DatabaseAppointmentRepository** stub to prepare for future storage options.
Using the **Repository Interface** and **Factory Pattern**, the system can easily swap between:
- In-memory storage (for development and testing)
- Database storage (for production)
- Other storage like File System or Cloud Storage.

This design ensures **scalability**, **flexibility**, and **minimal code changes** when upgrading the backend.
