## Creational Patterns

### Language Choice: Java
Java was chosen for this implementation because:
- It supports **object-oriented principles** critical to design patterns.
- It offers robust support for **interfaces, abstract classes**, and **modular design**.
- It integrates easily with **Swing** for GUI and **file-based persistence**, which aligns with our non-functional requirements.


### Pattern Justifications and Use Cases

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

### Summary

These patterns promote:
- **Scalability** — Adding new roles or notification types without major rewrites.
- **Maintainability** — Encapsulated logic for object creation.
- **Extensibility** — Future integration with billing, electronic health records (EHR), or cloud storage.
