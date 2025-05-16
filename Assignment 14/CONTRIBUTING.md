# CONTRIBUTING


# 🏥 Contributing to the Hospital Appointment Scheduling System

Thank you for considering contributing to our project! Your involvement helps improve the system for users and developers alike.

---

## 📦 Setup Instructions

### Prerequisites

- **Java 17** or higher
- **Maven 3.8+**
- A GitHub account

### Installation

1. **Fork the Repository**  
   Click the **Fork** button at the top right of the [repository page](https://github.com/mbalitoh56/hospital_appointment_scheduling) to create your own copy.

2. **Clone Your Fork**  
   Open your terminal and run:

   ```bash
   git clone https://github.com/mbalitoh56/hospital_appointment_scheduling.git
   cd hospital_appointment_scheduling


3. **Build the Project**
   Compile the project and download dependencies:

   ```bash
   mvn clean install
   ```

4. **Run the Application**
   Start the application using:

   ```bash
   mvn spring-boot:run
   ```

   Access the application at `http://localhost:8080`.

---

## 🧹 Coding Standards

To maintain code quality and consistency, please adhere to the following standards:

* **Code Formatting**: Use [Google Java Format](https://github.com/google/google-java-format) for consistent code styling. You can integrate it with your IDE or run it via Maven using the [Spotless plugin](https://github.com/diffplug/spotless).

* **Linting**: Utilize [Checkstyle](https://checkstyle.sourceforge.io/) to enforce coding standards. Run the following command to check for style violations:

  ```bash
  mvn checkstyle:check
  ```

* **Testing**: Write unit and integration tests for your code. Ensure all tests pass before submitting a pull request:

  ```bash
  mvn test
  ```

* **Commit Messages**: Follow the [Conventional Commits](https://www.conventionalcommits.org/) specification for clear and descriptive commit messages.

---

## 🛠️ How to Contribute

1. **Pick an Issue**
   Browse the [Issues](https://github.com/mbalitoh56/hospital_appointment_scheduling/issues) tab and look for issues labeled `good first issue` for beginner-friendly tasks.

2. **Create a Branch**
   Create a new branch for your work:

   ```bash
   git checkout -b feature/your-feature-name
   ```

3. **Make Changes**
   Implement your feature or fix, adhering to the coding standards mentioned above.

4. **Commit Your Changes**
   Commit your changes with a descriptive message:

   ```bash
   git commit -m "feat: add appointment scheduling feature"
   ```

5. **Push to Your Fork**
   Push your branch to your forked repository:

   ```bash
   git push origin feature/your-feature-name
   ```

6. **Submit a Pull Request**
   Open a pull request against the `master` branch of the original repository. Provide a clear description of your changes and reference any related issues.

---

## 🔍 Need Help?

If you have questions or need assistance:

* Open an issue with the `question` label.
* Join our community discussions on [GitHub Discussions](https://github.com/yourusername/hospital-appointment-scheduling/discussions).

We appreciate your contributions and look forward to collaborating with you!


---

# Tag Issues for Contributors


To enhance your Hospital Appointment Scheduling System repository for contributors, follow these steps to label issues effectively:

---

## 🏷️ 1. Create and Apply Labels

### A. Create Labels

1. **Navigate to the Repository**: Go to your GitHub repository.
2. **Access Labels**:

   * Click on the **Issues** tab.
   * Click on the **Labels** button.
3. **Create New Labels**:

   * Click on **New label**.
   * For a beginner-friendly task, enter:

     * **Label name**: `good first issue`
     * **Description**: `Simple tasks suitable for newcomers.`
   * For feature enhancements, enter:

     * **Label name**: `feature-request`
     * **Description**: `Suggestions for new features or enhancements.`
   * Choose distinct colors for each label to differentiate them visually.
   * Click **Create label** to save.([GitHub Docs][1], [Steve Gordon - Code with Steve][2], [GitHub][3])

### B. Apply Labels to Issues

1. **Select an Issue**: Click on an existing issue or create a new one.
2. **Assign Labels**:

   * On the right sidebar, click on the **Labels** section.
   * Select the appropriate label(s) (`good first issue` or `feature-request`).
   * The label will now appear on the issue, making it easier for contributors to identify.([Stack Overflow][4])

*Note*: Only users with write or triage permissions can create and assign labels. ([GitHub Docs][1])

---

## 📌 2. Labeling Strategy

* **Good First Issues**:

  * Aim to label at least **5 issues** as `good first issue`.
  * These should be straightforward tasks, such as fixing typos, updating documentation, or minor bug fixes.
  * Clearly describe the task and provide guidance to help newcomers get started.

* **Feature Requests**:

  * Label at least **3 issues** as `feature-request`.
  * These should be suggestions for new functionalities or enhancements, like integrating a new calendar view or adding notification features.
  * Provide a clear description of the desired feature and its potential impact.

---

By implementing these labels, you make it easier for contributors to find tasks that match their skill levels and interests, fostering a more collaborative and efficient development environment. If you need assistance with automating this process or integrating it into your workflow, feel free to ask!

[1]: https://docs.github.com/en/issues/using-labels-and-milestones-to-track-work/managing-labels?utm_source=chatgpt.com "Managing labels - GitHub Docs"
[2]: https://www.stevejgordon.co.uk/working-on-your-first-github-issue?utm_source=chatgpt.com "Working on Your First GitHub Issue - Steve Gordon - Code with Steve"
[3]: https://github.com/orgs/community/discussions/53473?utm_source=chatgpt.com "How do I add a label to an issue? · community - GitHub"
[4]: https://stackoverflow.com/questions/13829466/how-to-put-a-label-on-an-issue-in-github-if-you-are-not-a-contributor-owner?utm_source=chatgpt.com "How to put a label on an issue in GitHub if you are not a contributor ..."
