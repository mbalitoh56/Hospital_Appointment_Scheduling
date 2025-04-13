# DOMAIN MODEL REFLECTION

### Reflection on Designing the Domain Model and Class Diagram

Designing the domain model and class diagram for the Hospital Appointment Scheduling System was both a rewarding and challenging process. As the system touches on multiple user roles (patients, doctors, admins), integrates functional interactions (booking, canceling, notifications), and must adhere to both functional and non-functional requirements, it required careful planning to translate textual requirements into structured design.


#### **1. Challenges Faced**

One of the major challenges was abstracting the correct set of domain entities while ensuring the model remained both comprehensive and manageable. Initially, it was tempting to define too many classes (e.g., for each feature like `Reminder`, `ScheduleManager`, or `MessageService`). However, I realized that bloating the model could make it unnecessarily complex and hard to maintain.

Another difficulty was identifying appropriate relationships and multiplicities between classes. For example, understanding that an `Appointment` should always link to exactly one `Doctor` and one `Patient`, while a `Doctor` or `Patient` could have many appointments, required reviewing both real-world logic and the use case scenarios. Implementing inheritance also posed a challenge — deciding which attributes and methods should belong in the `User` superclass versus what should be specialized in subclasses like `Doctor` or `Patient`.

Defining methods for each class also involved deep consideration. Some responsibilities could be spread across multiple classes (e.g., canceling an appointment could be allowed by both patients and admins), so ensuring that the methods matched each class's role without redundancy required a few iterations.

#### **2. Alignment with Previous Assignments**

The class diagram and domain model closely reflect prior work, including the requirements document, use case definitions, and state diagrams. Each core function in the functional requirements — such as appointment booking, cancellation, login, availability check, and notifications — is represented by corresponding classes and methods.

For example:
- The **Use Case: Book Appointment** translates into the `bookAppointment()` method in the `Patient` class.
- The **State Diagram: Appointment Lifecycle** aligns with the `Appointment` class methods like `confirm()` and `cancel()`.
- The **Functional Requirement: Notifications** is captured by the `Notification` class and its `send()` and `scheduleReminder()` methods.

Additionally, the non-functional requirements like **role-based access**, **data persistence**, and **usability** informed the inclusion of a clear hierarchy (`User` inheritance), modular responsibilities, and a separation of concerns (e.g., notifications separated from appointment logic).

#### **3. Trade-offs Made**

Some trade-offs were made to maintain clarity and reduce complexity. For instance, instead of deeply modeling internal systems like `FileManager`, `AvailabilityManager`, or `ReminderService`, we focused on high-level domain entities and their primary responsibilities. This made the diagram easier to understand while leaving room for future expansion.

In terms of composition vs. inheritance, I chose to use inheritance for user roles (`Patient`, `Doctor`, `Admin`) to reflect shared behaviors like login/logout, rather than embedding them within `User` as composed objects. This simplified role-based behavior modeling and aligned with object-oriented best practices.

Another trade-off involved leaving out fine-grained control logic (e.g., checking if an appointment is within working hours), which would typically be handled in the business logic layer, not the domain model.

#### **4. Lessons Learned**

This project taught me the importance of thinking abstractly but practically when designing systems. Object-oriented design isn’t just about representing objects but also about responsibility assignment and ensuring cohesion within classes and low coupling between them.

I learned that creating a solid domain model early on serves as a blueprint for later development phases — including coding, testing, and UI design. Properly defining responsibilities and relationships helps avoid logic duplication and paves the way for easier maintenance and future enhancements.

Most importantly, I learned that **clear design decisions** backed by requirement traceability improve the system’s coherence. Aligning diagrams with previous artifacts, such as use cases and state diagrams, ensures that every part of the system is justified and purposeful.
