# Hospital_Appointment_Scheduling

## Introduction

This is a **Hospital Appointment System** that I created using Java to manage appointments in a hospital. It allows users to log in as either an **Admin**, **Doctor**, or **Patient**, with each role having different privileges. Patients can book appointments with doctors, while admins can cancel appointments and view all appointments. The system also supports searching for appointments by patient or doctor name. Appointments are stored in a text file, ensuring data persistence between sessions. This application also provides a simple graphical user interface (GUI) for easy interaction.

### LINKS
[specification.md](Documentation/Specification.md)

[Architecture.md](Documentation/Architecture.md)

### Assignment 8 Links

[Assignment 8 folder](https://github.com/mbalitoh56/Hospital_Appointment_Scheduling/tree/6fa67baaa000b23ae6c079d92b74190ac97a6589/Assignment%208)

[Activity Diagram.md](https://github.com/mbalitoh56/Hospital_Appointment_Scheduling/blob/ca2cb1f34e96ded519fc012fd67ae675491467ec/Assignment%208/Activity%20Diagram.md)

[State Transition](https://github.com/mbalitoh56/Hospital_Appointment_Scheduling/blob/df715f1cac7228ee5500872c32c253ae43439727/Assignment%208/State%20transition.md)

### Assignment 9 Links

[Assignment 9 folder](https://github.com/mbalitoh56/Hospital_Appointment_Scheduling/tree/eb04e8930300a51e30b2a347a2fcfd49541683a6/Assignment%209)

[Domain Model](https://github.com/mbalitoh56/Hospital_Appointment_Scheduling/blob/bbd5d8afb74ef453b32148ed81b25ff9001798ff/Assignment%209/Domain%20Model%20Document.md)

[Reflection](https://github.com/mbalitoh56/Hospital_Appointment_Scheduling/blob/8b563be4b929c13a1c8dadef8f4bc70a890aea77/Assignment%209/Reflection.md)

### Assignment 10 Links

[Assignment 10 folder](https://github.com/mbalitoh56/Hospital_Appointment_Scheduling/tree/011a8ba6df0a7dbfe6ce79ef7a7a18742e56f1e0/Assignment%2010)

[Language Choice](https://github.com/mbalitoh56/Hospital_Appointment_Scheduling/blob/4a69b157f26c9a4bed54a3397ab165c9f3289fcc/Assignment%2010/src/README.md)

[Change Log](https://github.com/mbalitoh56/Hospital_Appointment_Scheduling/blob/70f464644a2936c7bcca347cc3009534d4af8620/Assignment%2010/CHANGELOG.md)




---

# Assignment 13

### ✅ How to Run Tests Locally

Providing clear instructions for running tests. For a Java Maven project, include:

````markdown
### Running Tests Locally

Ensure you have Java and Maven installed. Then, execute:

```bash
mvn test
````

This command runs all unit and integration tests.

````
:contentReference[oaicite:8]{index=8}

### ✅ How the CI/CD Pipeline Works

:contentReference[oaicite:10]{index=10}:contentReference[oaicite:12]{index=12}


```markdown
### CI/CD Pipeline Overview

Our GitHub Actions workflow performs the following:

- **On Pull Requests to `master`**:
  - Checks out the code.
  - Sets up the Java environment.
  - Runs unit and integration tests.

- **On Pushes to `master`**:
  - Executes all tests.
  - Builds the JAR artifact.
  - Uploads the artifact to GitHub Releases.
````


---

## 2. Configure Pull Request (PR) Checks

To ensure that tests must pass before merging:

1. Navigate to your repository on GitHub.
2. Click on **Settings** > **Branches**.
3. Under **Branch protection rules**, click **Add rule**.
4. Specify the branch name pattern, typically `main`.
5. Check **Require status checks to pass before merging**.
6. Select the specific checks (e.g., your CI workflow) that must pass.
7. Click **Create** or **Save changes**.

This setup ensures that any PR failing the specified checks cannot be merged.

---

## 3. Screenshot of a PR Blocked by Failing Tests

After setting up the branch protection rules, create a PR with failing tests to verify the enforcement. The PR interface will display a message indicating that merging is blocked due to failing checks.



