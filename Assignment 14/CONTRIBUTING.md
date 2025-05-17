# CONTRIBUTING


# 🏥 Contributing to the Hospital Appointment Scheduling System

Thank you for considering contributing to our project! Your involvement helps improve the system for users and developers alike.



## 📦 Setup Instructions

### Prerequisites

- **Java 17** or higher
- **Maven 3.8+**
- A GitHub account

### Installation

1. **Fork the Repository**  
   Click the **Fork** button at the top right of the [repository page](https://github.com/yourusername/hospital_appointment_scheduling) to create your own copy.

2. **Clone Your Fork**  
   Open your terminal and run:

   ```bash
   git clone https://github.com/yourusername/hospital_appointment_scheduling.git
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

We appreciate your contributions and look forward to collaborating with you!


---


# TAGS ISSUES for CONTRIBUTORS




## Navigating Labeled Issues

Welcome to the Hospital Appointment Scheduling System project! This guide will help you find and understand issues labeled for contribution.

## 🔍 Finding Labeled Issues

To discover issues by label:

1. **Navigate to the Issues Tab**:

   * Go to the repository's main page.
   * Click on the **"Issues"** tab.

2. **Filter by Labels**:

   * On the right sidebar, locate the **"Labels"** section.
   * Click on a label (e.g., `good first issue` or `feature-request`) to filter issues accordingly.

3. **Use the Search Bar**:

   * At the top of the Issues page, use the search bar to input queries like:

     * `is:issue is:open label:"good first issue"`
     * `is:issue is:open label:"feature-request"`

   * To filter issues that have both labels:

     * `is:issue is:open label:"good first issue" label:"feature-request"`

   * To filter issues that have either label:

     * `is:issue is:open label:"good first issue","feature-request"`

   *Note*: Using a comma between labels applies a logical OR, while separating labels with spaces applies a logical AND.&#x20;

## 🏁 Understanding Common Labels

* **`good first issue`**: Ideal for newcomers; these issues are well-defined and don't require deep knowledge of the codebase.

* **`feature-request`**: Suggestions for new features or enhancements to the project.

## 🤝 Getting Started

1. **Choose an Issue**:

   * Browse through the labeled issues and select one that interests you.

2. **Express Interest**:

   * Comment on the issue to let others know you're working on it.

3. **Fork the Repository**:

   * Click on the **"Fork"** button at the top-right corner of the repository page.

4. **Clone Your Fork**:

   * Use `git clone` to clone your forked repository to your local machine.

5. **Create a New Branch**:

   * Use `git checkout -b your-branch-name` to create and switch to a new branch.

6. **Make Your Changes**:

   * Implement the necessary changes or additions.

7. **Commit and Push**:

   * Commit your changes with a descriptive message and push them to your forked repository.

8. **Submit a Pull Request**:

   * Navigate to the original repository and click on **"New Pull Request"**.
   * Provide a clear description of your changes and reference the issue number.

## 📘 Additional Resources

* [GitHub Docs: Managing Labels](https://docs.github.com/en/issues/using-labels-and-milestones-to-track-work/managing-labels)
* [GitHub Docs: Filtering and Searching Issues](https://docs.github.com/en/issues/tracking-your-work-with-issues/using-issues/filtering-and-searching-issues-and-pull-requests)


